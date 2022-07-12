import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class Login extends JFrame {

    private JTextField login;
    private JPasswordField passwordField;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton r1,r2;



    Login() {


        setSize(500, 500);

        setBackground(new Color(214, 6, 101));
        setTitle("LOGIN");

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1904, 1041);
        panel.setBackground(new Color(214, 6, 101));
        panel.setLayout(null);

        JLabel label1 = new JLabel("");
        label1.setIcon(new ImageIcon("images.png"));
//        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setBounds(462, -12, 1904, 258);

        panel.add(label1);

        JLabel username = new JLabel("Email");
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Rockwell", Font.PLAIN, 20));
        //username.setHorizontalAlignment(SwingConstants.LEFT);
        username.setBounds(560, 344, 92, 24);
        panel.add(username);

        login = new JTextField();
        //login.setHorizontalAlignment(SwingConstants.CENTER);
        login.setBounds(720, 349, 233, 20);
        panel.add(login);
        login.setColumns(10);

        JLabel password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Rockwell", Font.PLAIN, 20));
        //password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setBounds(565, 397, 87, 24);
        panel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(720, 402, 233, 20);
        panel.add(passwordField);

        JCheckBox stay = new JCheckBox("Stay Signed In?");
        // stay.setHorizontalAlignment(SwingConstants.CENTER);
        stay.setFont(new Font("Rockwell", Font.PLAIN, 15));
        stay.setForeground(Color.WHITE);
        stay.setBackground(new Color(214, 6, 101));
        stay.setBounds(560, 479, 133, 27);
        panel.add(stay);


        JLabel label2 = new JLabel("Not A User? Get Registered");
        label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buyer b = new buyer();
                Login.this.dispose();
            }
        });


        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Rockwell", Font.PLAIN, 15));
        label2.setBounds(760, 483, 193, 19);
        panel.add(label2);
        r1 = new JRadioButton("Login As Admin");
        buttonGroup.add(r1);
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(214, 6, 101));
        r1.setFont(new Font("Rockwell", Font.BOLD, 13));
        r1.setBounds(700, 453, 130, 25);
        panel.add(r1);

         r2 = new JRadioButton("Login As Buyer");
        buttonGroup.add(r2);
        //r2.setHorizontalAlignment(SwingConstants.CENTER);
        r2.setForeground(Color.WHITE);
        r2.setFont(new Font("Rockwell", Font.BOLD, 13));
        r2.setBackground(new Color(214, 6, 101));
        r2.setSelected(true);

        r2.setBounds(832, 453, 121, 25);
        panel.add(r2);
        getContentPane().add(panel);

        JButton button = new JButton("Login");
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(199, 21, 133));
        button.setFont(new Font("Rockwell", Font.BOLD, 29));
        button.setBounds(836, 545, 117, 43);
        panel.add(button);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 123833.png"));
        lblNewLabel.setBounds(439, 11, 551, 306);
        panel.add(lblNewLabel);
        button.addActionListener(new myAction());

    setResizable(false);

    setSize(1280,720);

    setVisible(true);
}


public class myAction implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Login")) {
            if (r2.isSelected()) {
                ArrayList<User> people = User.readAllData();
                boolean check=true;
                for (int i = 0; i < people.size(); i++) {

                    if (people.get(i).getEmail().equalsIgnoreCase(login.getText()) && people.get(i).getPassword().equals(passwordField.getText())) {
                        check=false;

                        new Menu(people.get(i),new ArrayList<Food>());
                        dispose();
                        break;
                    }
                }
                if (check){
                    JOptionPane.showMessageDialog(null,"Invalid Email/Password or does not exist","Error",JOptionPane.WARNING_MESSAGE);

                }


            }

            if (r1.isSelected()) {

                if(login.getText().equalsIgnoreCase("admin")&&passwordField.getText().equals("1234")){
                    new AdminPanel();
                    dispose();
                }
                else {

                    ArrayList<Admin> admins=Admin.readAllData();
                    boolean check=true;
                    for (int i = 0; i <admins.size() ; i++) {
                        if (admins.get(i).getEmail().equalsIgnoreCase(login.getText())&&admins.get(i).getPassword().equals(passwordField.getText())){
                            check=false;
                            new AdminPanel();
                            dispose();
                            break;
                        }

                    }
                    if (check){
                        JOptionPane.showMessageDialog(new JFrame("Error"), "Wrong Credentials","Error",JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        }
    }
}
}