import java.awt.Point;
import java.awt.Graphics;
public class Grid
{
    private int width = 750;
    private int height = 750;
    private int numberOfPoints = 50;
    Point[] points = new Point[numberOfPoints];
    
    public Grid()
    {
        for (int i = 0; i<this.points.length; i++)
        {
            points[i] = new Point();
        }
        this.generatePoints(numberOfPoints);
    }
    
    public void generatePoints(int numberOfPoints)
    {
        for (int i = 0; i < this.points.length; i++)
        {
            Point newPoint = createRandomPoint();
            this.points[i] = newPoint;
        }
    }
    
    public void drawPoints(Graphics g)
    {
        for (int i = 0; i < this.points.length; i++)
        {
            g.fillOval((int) this.points[i].getX(), (int) this.points[i].getY(), 5, 5);
        }
    }
    
    
    public Point createRandomPoint()
    {
        double tempX = Math.random()*750;
        double tempY = Math.random()*750;
        Point tempPoint = new Point();
        tempPoint.setLocation(tempX, tempY);
        
        for (int i = 0; i<this.points.length; i++)
        {
            if (tempPoint.equals(this.points[i]))
            {
                return createRandomPoint();
            }
        }
        
        return tempPoint;
    }

}
