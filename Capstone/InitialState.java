import java.awt.Point;
import java.awt.Graphics;
public class InitialState
{
    Point[] points;
    PossibleSolution[] initialPopulation = new PossibleSolution[100]; 

    public InitialState(Grid grid)
    {
        this.points = grid.points;
        this.createInitialState();

    }

    //creates a random initial state
    public void createInitialState()
    {

        for (int j = 0; j<this.initialPopulation.length; j++)
        {
            //array of temp points initially equal to this.points
            Point[] tempPoints = new Point[this.points.length];
            //sets temp points equal to this.points
            for (int k = 0; k<this.points.length; k++)
            {
                tempPoints[k] = this.points[k];
            }
            //chooses a random int for starting point
            int randomStarter = (int)(Math.random()*tempPoints.length);
            //assigns random starter point
            Point randomStartingPoint = tempPoints[randomStarter];
            //sets starting point to null in tempPoints so it cannot be sellected again
            tempPoints[randomStarter] = null;
            //consolidates tempPoints ro remove the null from starting point
            tempPoints = this.consolidateArray(tempPoints);
            //loop to fill this.initialPopulation with solutions
            //array of multiple solutions
            PossibleSolution initialSolution = new PossibleSolution();
            //previous point
            Point prevPoint = null;
            //loop to fill solution with paths
            while (tempPoints.length>0)
            {
                //creates a random point
                Point randomPoint;
                //chooses a random int for the index of randomPoint
                int randInt = (int) (Math.random()*tempPoints.length);
                //sets randomPoint equal to randInt index in tempPoints
                randomPoint = tempPoints[randInt];
                //if this is the first loop/if there is no previous point
                if (prevPoint == null)
                {
                    prevPoint = randomPoint;
                    tempPoints[randInt] = null;
                    tempPoints = this.consolidateArray(tempPoints);

                }
                //else if the new randomly chossen point is null or equal to the previous point rastert the loop with no changes
                else if (randomPoint == null || randomPoint.equals(prevPoint))
                {
                    //i--;
                }
                //else create a new path between the previous point and the new randomPoint and add it to the array of initial solutions
                //set the previous point equal to the random point so a new path can be created.  will get a new random point at next loop
                //set the randomPoint in temp array equal to null
                //consolidate tempPoints to remove the null

                else
                {
                    initialSolution.addPath(new Path(prevPoint, randomPoint));
                    prevPoint = randomPoint;
                    tempPoints[randInt] = null;
                    tempPoints = this.consolidateArray(tempPoints);
                }
            }
            //creates a path connecting the last point to the first
            initialSolution.addPath(new Path(prevPoint, randomStartingPoint));

            //add newlly created solution to initialPopulation
            this.initialPopulation[j] = initialSolution;
        }
    }

    public Point[] consolidateArray(Point[] arrayToConsolidate)
    {
        Point[] newArray = new Point[arrayToConsolidate.length-1];
        int current = 0;
        for (int i = 0; i<arrayToConsolidate.length; i++)
        {
            if (arrayToConsolidate[i] != null)
            {
                newArray[current] = arrayToConsolidate[i];
                current++;
            }
        }
        return newArray;
    }
}
