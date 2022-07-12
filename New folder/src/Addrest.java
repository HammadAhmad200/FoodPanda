
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Addrest extends JFrame {

    private JPanel p1,p2;
    private JLabel l,l1,l2,l3,l4,logo;
    private JTextField t1,t2,t3,t4;
    private JButton button;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

     Addrest() {

        p2 = new JPanel();
        p2.setBackground(Color.DARK_GRAY);
        p2.setForeground(Color.DARK_GRAY);
        p2.setBounds(0, 0, 1264, 101);
        p2.setLayout(null);

        logo = new JLabel("");
        logo.setIcon(new ImageIcon("images (2).png"));
        logo.setBounds(454, 0, 320, 113);
        p2.add(logo);

         JButton buttona = new JButton("Go back");
         buttona.setFont(new Font("Tahoma", Font.BOLD, 16));
         buttona.setBounds(1063, 23, 100, 36);
         buttona.setForeground(new Color(199, 21, 133));
         buttona.setBackground(new Color(255, 255, 255));
         p2.add(buttona);
        getContentPane().add(p2);
        
        
                p1 = new JPanel();
                p2.add(p1);
                p1.setBackground(Color.WHITE);
                p1.setBounds(77, 100, 1088, 505);
                p1.setLayout(null);
                
                        l1 = new JLabel("Address");
                        l1.setFont(new Font("Rockwell", Font.PLAIN, 15));
                        l1.setBounds(70, 205, 80, 19);
                        p1.add(l1);
                        
                                t1 = new JTextField();
                                t1.setColumns(10);
                                t1.setBounds(264, 206, 216, 20);
                                p1.add(t1);
                                
                                        l2 = new JLabel("Contact No.");
                                        l2.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                        l2.setBounds(70, 235, 83, 19);
                                        p1.add(l2);
                                        
                                                t2 = new JTextField();
                                                t2.setColumns(10);
                                                t2.setBounds(264, 236, 216, 20);
                                                p1.add(t2);
                                                
                                                        l3 = new JLabel("Email");
                                                        l3.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                        l3.setBounds(70, 265, 40, 19);
                                                        p1.add(l3);
                                                        
                                                        
                                                                t3 = new JTextField();
                                                                t3.setColumns(10);
                                                                t3.setBounds(264, 266, 216, 20);
                                                                p1.add(t3);
                                                                
                                                                        l = new JLabel("Restaurant Name");
                                                                        l.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                        l.setBounds(70, 174, 120, 19);
                                                                        p1.add(l);
                                                                        
                                                                                l4 = new JLabel("ADD RESTAURANT");
                                                                                l4.setForeground(new Color(199, 21, 133));
                                                                                l4.setHorizontalAlignment(SwingConstants.CENTER);
                                                                                l4.setFont(new Font("Rockwell", Font.BOLD, 33));
                                                                                l4.setBounds(45, 55, 363, 36);
                                                                                p1.add(l4);
                                                                                
                                                                                        t4 = new JTextField();
                                                                                        t4.setColumns(10);
                                                                                        t4.setBounds(264, 175, 216, 20);
                                                                                        p1.add(t4);
                                                                                        
                                                                                                button = new JButton("ADD");
                                                                                                button.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                button.setBounds(380, 381, 100, 27);
                                                                                                p1.add(button);
                                                                                                
                                                                                                lblNewLabel = new JLabel("");
                                                                                                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\food.png"));
                                                                                                lblNewLabel.setBounds(599, 67, 629, 270);
                                                                                                p1.add(lblNewLabel);
                                                                                                
                                                                                                lblNewLabel_1 = new JLabel("");
                                                                                                lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
                                                                                                lblNewLabel_1.setBounds(119, 23, 371, 66);
                                                                                                p2.add(lblNewLabel_1);
                                                                                                
                                                                                                        button.addActionListener(new myAction());
        setVisible(true);
        setResizable(false);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttona.addActionListener(new myAction());
    }


    public class myAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


            if (e.getActionCommand().equalsIgnoreCase("add")){
                ArrayList<Food> foods=new ArrayList<Food>();
                if (!(t4.getText().isEmpty()||t1.getText().isEmpty()|| t2.getText().isEmpty()|| t3.getText().isEmpty())){
                    Random x = new Random(1000);
                    int num = x.nextInt();
                    Restaurant restaurant=new Restaurant(foods,t4.getText(),num,t1.getText(),t2.getText(),t3.getText());
                    restaurant.writeObjectToFile(restaurant);
                    JOptionPane.showMessageDialog(null,"Restaurant Added Successfully","Success",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new AdminPanel();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Please fill all given fields");
                }

            }
            else if (e.getActionCommand().equalsIgnoreCase("go back")){
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel Adding Restaurant ","confirm",JOptionPane.YES_NO_OPTION)==0){
                    new AdminPanel();
                    dispose();
                }
            }

        }
    }
}
