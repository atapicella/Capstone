import javax.swing.JFrame;
public class GridViewer
{
    Grid grid = new Grid();
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        
        frame.setSize(800 , 800);
        frame.setTitle("Capstone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridComponent component = new GridComponent();
        frame.add(component);
        
        
        component.repaint();
        frame.setVisible(true);
    }
}
