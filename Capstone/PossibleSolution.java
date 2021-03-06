import java.awt.Point;
import java.awt.Graphics;

public class PossibleSolution
{
    private double totalLength;
    private int numberOfPoints = 50;
    private int currentIndex = 0;
    
    
    Path[] paths = new Path[numberOfPoints-1];
    
    public PossibleSolution()
    {
    }
    
    public void addPath(Path path)
    {
        this.paths[this.currentIndex] = path;
        currentIndex++;
    }
    
    public void drawSolution(Graphics g)
    {
        for (int i = 0; i<this.paths.length; i++)
        {
            if (this.paths[i] != null)
            {
                this.paths[i].drawPath(g);
                }
        }
    }
    
    public double getFitness()
    {
        double totalLength = 0;
        for (int i = 0; i < this.paths.length; i++)
        {
            if (paths[i] != null)
            {
                 totalLength += paths[i].getLength();
                }
        }
        return totalLength;
    }
}