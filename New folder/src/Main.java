
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {

    private ButtonGroup buttonGroup = new ButtonGroup();


    public static void main(String[] args) throws IOException {

        new Main();
    }
    Main() {
        setTitle("FoodPanda");
        setSize(1280, 720);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1904, 1041);
        panel.setBackground(new Color(204, 0, 102));


        panel.setLayout(null);

        JLabel Welcome = new JLabel("Welcome To Food Panda");
        Welcome.setFont(new Font("Rockwell", Font.BOLD, 45));
        Welcome.setForeground(new Color(255, 255, 255));
        Welcome.setHorizontalAlignment(SwingConstants.CENTER);
        Welcome.setBounds(382, 0, 557, 54);
        panel.add(Welcome);

        JButton b1 = new JButton("Login");
        b1.setFont(new Font("Rockwell", Font.BOLD, 24));
        b1.setBackground(new Color(255, 255, 255));
        b1.setForeground(new Color(199, 21, 133));
        b1.setBounds(502, 596, 125, 37);
        panel.add(b1);

        JButton b2 = new JButton("Sign Up");
        b2.setBackground(new Color(255, 255, 255));
        b2.setForeground(new Color(199, 21, 133));
        b2.setFont(new Font("Rockwell", Font.BOLD, 24));
        b2.setBounds(667, 596, 125, 37);
        panel.add(b2);
        buttonGroup.add(b1);
        buttonGroup.add(b2);

        getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Downloads\\da484a101797519.Y3JvcCw1MTk1LDQwNjMsMTI3Myw2NDI.jpg"));
        lblNewLabel_1.setBounds(239, 46, 895, 612);
        panel.add(lblNewLabel_1);
        setVisible(true);
        setResizable(false);
        Action a = new Action();
        b1.addActionListener(a);
        b2.addActionListener(a);

    }

    class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Login")) {
                new Login();
                Main.this.dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("Sign up")) {
                new buyer();
                Main.this.dispose();
            }
        }
    }
}
