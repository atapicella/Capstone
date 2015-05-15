import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class GridComponent extends JComponent
{  
    public void paintComponent(Graphics g)
    {
        Grid grid = new Grid();
        InitialState initial = new InitialState(grid);
        //g.setColor(Color.black);
        //grid.drawPoints(g);
        //g.setColor(Color.blue);
        Evolver evolver = new Evolver(grid);
        evolver.getFinalSolution().drawSolution(g);
        System.out.print ('\f');
        System.out.println("After " + evolver.getGenerationCount() + " generations this is the shortest path between 50 randomly generated \n points and its length is: " + this.toString(evolver.getFinalSolution().getFitness())+" pixels.");
    }
    
    public String toString(double doubleToConvert)
    {
        String doubleAsString = "" + doubleToConvert;
        doubleAsString = doubleAsString.substring(0, doubleAsString.length()-10);
        return doubleAsString;
    }
}
