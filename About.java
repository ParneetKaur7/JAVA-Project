import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame  implements ActionListener {
    About() {
        setTitle("About");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 27));

        JLabel text= new JLabel("<html> Panda Pad- A Text Editor <br> Created By- Parneet Kaur</html> ");
        text.setFont(new Font("SansSerif", Font.PLAIN, 15));
        text.setBorder(BorderFactory.createEmptyBorder(15,35,15,10));

        JButton btn= new JButton("OK");
        btn.setPreferredSize(new Dimension(30,25));
        btn.addActionListener(this);

        panel.add(text, BorderLayout.CENTER);
        panel.add(btn, BorderLayout.SOUTH);
        add(panel);

        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae) {
            this.setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }
}
