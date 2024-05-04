import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class AreaPlus extends JTextArea {
    private Image image;
    public AreaPlus(){
        super();
    }
    public AreaPlus(String text) {
        super(text);
    }
    public void setImage(ImageIcon icon) {
        this.image= icon.getImage();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); 
        }
    }
    
}
