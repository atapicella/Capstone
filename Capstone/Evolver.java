
public class Evolver
{
    
    private int generationCount = 0;
    PossibleSolution[] solutions; 
    private PossibleSolution finalSolution;
    public Evolver(Grid grid)
    {
        InitialState initial = new InitialState(grid);
        this.solutions = initial.initialPopulation;
        while (this.solutions.length>1)
        {
            this.generationCount++;
            this.solutions = this.crossover(solutions);
        }
        this.finalSolution = this.findFittest(this.solutions);
    }

    //crossover 2 parents into 1 child and returns array half the size of parent array given
    public PossibleSolution[] crossover(PossibleSolution[] parentSolutions)
    {
        if (parentSolutions.length<2)
        {
            return parentSolutions;
        }
        PossibleSolution[] childSolutions = new PossibleSolution[solutions.length/2];
        for (int k = 0; k<childSolutions.length; k++)
        {
            childSolutions[k] = new PossibleSolution();
        }
        int childCounter = 0;
        for (int i = 1; i<parentSolutions.length; i+=2)
        {
            PossibleSolution child = new PossibleSolution();
            for (int j = 0; j<parentSolutions[i].paths.length; j++)
            {
                if (parentSolutions[i].paths[j] == null || parentSolutions[i-1].paths[j] == null)
                {
                    return childSolutions;
                }
                else if (parentSolutions[i].paths[j].getLength()<parentSolutions[i-1].paths[j].getLength())
                {
                    childSolutions[childCounter].addPath(parentSolutions[i].paths[j]);
                }
                else
                {
                    childSolutions[childCounter].addPath(parentSolutions[i-1].paths[j]);
                }
                
            }  
            childCounter++;
        }
        return childSolutions;
    }

    
    //evaluates all fitness and returns array of top 5 fittest solutions
    public PossibleSolution[] evaluateFitness(PossibleSolution[] solutions)
    {
        PossibleSolution[] fittestSolutions = new PossibleSolution[10];
        for (int i = 0; i<10; i++)
        {
            int fittestIndex = 0;
            for (int j = 1; j < solutions.length; j++)
            {
                if (solutions[j] == null)
                {
                    break;
                }
                else
                {
                    if (solutions[j].getFitness() < solutions[fittestIndex].getFitness())
                    {
                        fittestIndex = j;
                    }
                }
            }
            fittestSolutions[i] = solutions[fittestIndex];
            solutions[fittestIndex] = null;
        }
        return fittestSolutions;
    }
    
    public PossibleSolution findFittest(PossibleSolution[] solutions)
    {
        int fittestSolutionIndex = 0;
        for (int i = 1; i<solutions.length; i++)
        {
            if (solutions[i].getFitness()<solutions[fittestSolutionIndex].getFitness())
            {
                fittestSolutionIndex = i;
            }
        }
        return solutions[fittestSolutionIndex];
    }
    
    public PossibleSolution getFinalSolution()
    {
        return this.finalSolution;
    }
    
    public int getGenerationCount()
    {
        return this.generationCount;
    }
}
