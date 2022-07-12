
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddFood extends JFrame {

    private JPanel panel;
    private JTextField t;
    private JLabel l;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JButton button;
    private JPanel p;
    private JLabel l5;
    private JTextField t5;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public static void main(String[] args) {

        
        AddFood window = new AddFood();
    }

    AddFood() {
        p = new JPanel();
        p.setBackground(Color.DARK_GRAY);
        p.setForeground(Color.DARK_GRAY);
        p.setBounds(0, 0, 1264, 101);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p.setLayout(null);
        getContentPane().add(p);
        
                panel = new JPanel();
                p.add(panel);
                panel.setBackground(Color.WHITE);
                panel.setBounds(103, 100, 1070, 514);
                
                        panel.setLayout(null);
                        
                        
                                l5 = new JLabel("Restaurant Name");
                                l5.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                l5.setBounds(55, 74, 120, 19);
                                panel.add(l5);
                                
                                        t5 = new JTextField();
                                        t5.setColumns(10);
                                        t5.setBounds(282, 75, 216, 20);
                                        panel.add(t5);
                                        
                                        
                                                l = new JLabel("Food Name");
                                                l.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                l.setBounds(55, 114, 80, 19);
                                                panel.add(l);
                                                
                                                        t = new JTextField();
                                                        t.setColumns(10);
                                                        t.setBounds(282, 115, 216, 20);
                                                        panel.add(t);
                                                        
                                                                l1 = new JLabel("Food Type");
                                                                l1.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                l1.setBounds(55, 160, 80, 19);
                                                                panel.add(l1);
                                                                
                                                                        t1 = new JTextField();
                                                                        t1.setColumns(10);
                                                                        t1.setBounds(282, 161, 216, 20);
                                                                        panel.add(t1);
                                                                        
                                                                                l2 = new JLabel("Food ID");
                                                                                l2.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                l2.setBounds(55, 205, 80, 19);
                                                                                panel.add(l2);
                                                                                
                                                                                        t2 = new JTextField();
                                                                                        t2.setColumns(10);
                                                                                        t2.setBounds(282, 206, 216, 20);
                                                                                        panel.add(t2);
                                                                                        
                                                                                        
                                                                                                l3 = new JLabel("Food Price");
                                                                                                l3.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                l3.setBounds(55, 249, 80, 19);
                                                                                                panel.add(l3);
                                                                                                
                                                                                                        t3 = new JTextField();
                                                                                                        t3.setColumns(10);
                                                                                                        t3.setBounds(282, 250, 216, 20);
                                                                                                        panel.add(t3);
                                                                                                        
                                                                                                        
                                                                                                                l4 = new JLabel("Food Description");
                                                                                                                l4.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                                l4.setBounds(53, 297, 122, 19);
                                                                                                                panel.add(l4);
                                                                                                                
                                                                                                                
                                                                                                                        t4 = new JTextField();
                                                                                                                        t4.setColumns(10);
                                                                                                                        t4.setBounds(282, 298, 216, 20);
                                                                                                                        panel.add(t4);
                                                                                                                        
                                                                                                                                button = new JButton("AddFood");
                                                                                                                                button.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                                                button.setBounds(398, 399, 100, 27);
                                                                                                                                panel.add(button);
                                                                                                                                button.addActionListener(new ActionListener() {
                                                                                                                                    @Override
                                                                                                                                    public void actionPerformed(ActionEvent e) {
                                                                                                                                        if(e.getActionCommand().equalsIgnoreCase("Add food")){
                                                                                                                                            ArrayList<Restaurant> arrayList = Restaurant.readAllData();
                                                                                                                                            for(int i =0;i<arrayList.size();i++){
                                                                                                                                                if(t5.getText().equalsIgnoreCase(arrayList.get(i).getName())){
                                                                                                                                
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            }
                                                                                                                                    }
                                                                                                                                });
                                                                                                                                
                                                                                                                                lblNewLabel = new JLabel("");
                                                                                                                                lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\food.png"));
                                                                                                                                lblNewLabel.setBounds(603, 74, 601, 228);
                                                                                                                                panel.add(lblNewLabel);
                                                                                                                                
                                                                                                                                lblNewLabel_1 = new JLabel("");
                                                                                                                                lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
                                                                                                                                lblNewLabel_1.setBounds(103, 28, 312, 61);
                                                                                                                                p.add(lblNewLabel_1);
        setResizable(false);
        setVisible(true);
        setSize(1280, 720);
    }

    }

