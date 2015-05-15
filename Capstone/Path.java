import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
public class Path
{
    private double length;
    
    int[] xPointsInPath = new int[2];
    int[] yPointsInPath = new int[2];
    
    public Path(Point point1, Point point2)
    {
        xPointsInPath[0] = (int) point1.getX();
        yPointsInPath[0] = (int) point1.getY();
        xPointsInPath[1] = (int) point2.getX();
        yPointsInPath[1] = (int) point2.getY();
        this.length = Math.sqrt(Math.pow(this.xPointsInPath[1]-this.xPointsInPath[0], 2) +
            Math.pow(this.yPointsInPath[1]-this.yPointsInPath[0], 2));
    }
    
    public double getLength()
    {
        return  this.length;
    }
    
    public void drawPath(Graphics g)
    {
        g.setColor(Color.black);
        g.fillOval(xPointsInPath[0], yPointsInPath[0], 5, 5);
        g.setColor(Color.blue);
        g.drawPolyline(xPointsInPath, yPointsInPath, 2);
        g.setColor(Color.black);
        g.fillOval(xPointsInPath[1], yPointsInPath[1], 5, 5);
    }
        
}
