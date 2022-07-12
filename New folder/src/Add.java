
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class Add extends JFrame {

    private JPanel panel,p;
    private JLabel l,l1,l2,l3,l4,l5,logo;
    private JTextField t,t1,t2,t3,t4,t5;
    private JButton button;
    private JLabel lblNewLabel;
    
    Add() {
        p = new JPanel();
        p.setBackground(Color.DARK_GRAY);
        p.setForeground(Color.DARK_GRAY);
        p.setBounds(0, 0, 1264, 101);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p.setLayout(null);

        logo = new JLabel("");
        logo.setIcon(new ImageIcon("images (2).png"));
        logo.setBounds(454, 0, 320, 113);
        p.add(logo);

        JButton button2 = new JButton("Go back");
        button2.setFont(new Font("Tahoma", Font.BOLD, 17));
        button2.setBounds(15, 26, 119, 36);
        button2.setForeground(new Color(199, 21, 133));
        button2.setBackground(Color.darkGray);
        p.add(button2);
        button2.addActionListener(new myAction());
        getContentPane().add(p);
        panel = new JPanel();
        p.add(panel);
        panel.setBackground(Color.WHITE);
        panel.setBounds(61, 100, 1141, 524);
        
                panel.setLayout(null);
                
                
                        l5 = new JLabel("Restaurant Name");
                        l5.setFont(new Font("Rockwell", Font.PLAIN, 15));
                        l5.setBounds(29, 87, 120, 19);
                        panel.add(l5);
                        
                                t5 = new JTextField();
                                t5.setColumns(10);
                                t5.setBounds(216, 88, 216, 20);
                                panel.add(t5);
                                
                                
                                        l = new JLabel("Food Name");
                                        l.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                        l.setBounds(29, 138, 80, 19);
                                        panel.add(l);
                                        
                                                t = new JTextField();
                                                t.setColumns(10);
                                                t.setBounds(216, 139, 216, 20);
                                                panel.add(t);
                                                
                                                        l1 = new JLabel("Food Type");
                                                        l1.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                        l1.setBounds(29, 189, 80, 19);
                                                        panel.add(l1);
                                                        
                                                                t1 = new JTextField();
                                                                t1.setColumns(10);
                                                                t1.setBounds(216, 190, 216, 20);
                                                                panel.add(t1);
                                                                
                                                                        l2 = new JLabel("Food ID");
                                                                        l2.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                        l2.setBounds(29, 236, 80, 19);
                                                                        panel.add(l2);
                                                                        
                                                                                t2 = new JTextField();
                                                                                t2.setColumns(10);
                                                                                t2.setBounds(216, 237, 216, 20);
                                                                                panel.add(t2);
                                                                                
                                                                                
                                                                                        l3 = new JLabel("Food Price");
                                                                                        l3.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                        l3.setBounds(29, 288, 80, 19);
                                                                                        panel.add(l3);
                                                                                        
                                                                                                t3 = new JTextField();
                                                                                                t3.setColumns(10);
                                                                                                t3.setBounds(216, 289, 216, 20);
                                                                                                panel.add(t3);
                                                                                                
                                                                                                
                                                                                                        l4 = new JLabel("Food Description");
                                                                                                        l4.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                        l4.setBounds(29, 342, 122, 19);
                                                                                                        panel.add(l4);
                                                                                                        
                                                                                                        
                                                                                                                t4 = new JTextField();
                                                                                                                t4.setColumns(10);
                                                                                                                t4.setBounds(216, 343, 216, 20);
                                                                                                                panel.add(t4);
                                                                                                                
                                                                                                                        button = new JButton("ADD");
                                                                                                                        button.setFont(new Font("Rockwell", Font.PLAIN, 15));
                                                                                                                        button.setBounds(332, 425, 100, 27);
                                                                                                                        panel.add(button);
                                                                                                                        button.addActionListener(new myAction());
                                                                                                                        
                                                                                                                        lblNewLabel = new JLabel("");
                                                                                                                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\food.png"));
                                                                                                                        lblNewLabel.setBounds(611, 87, 548, 256);
                                                                                                                        panel.add(lblNewLabel);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
    }

    public class myAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("Add")){
                ArrayList<Restaurant> restaurants = Restaurant.readAllData();
                boolean check=true;
                Food food;
                for(int i =0;i<restaurants.size();i++){
                    if (restaurants.get(i).getName().equalsIgnoreCase(t5.getText())){
                        check=false;
                        if(!(t1.getText().isEmpty() || t.getText().isEmpty()|| t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty())){
                            try{
                                int id=Integer.parseInt(t2.getText());
                                double price=Integer.parseInt(t3.getText());
                                if(id>=0 && price>=0){
                                    food= new Food(t.getText(),t1.getText(),id,price,t4.getText());
                                    restaurants.get(i).getFoods().add(food);
                                }
                                else {
                                    JOptionPane.showMessageDialog(null,"Food id or Food price cannot be negative","Invalid input type",JOptionPane.WARNING_MESSAGE);

                                }
                            }catch (NumberFormatException el){
                                JOptionPane.showMessageDialog(null,"Invalid input in Food id or Food price","Invalid input type",JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Please Fill all given fields","Error",JOptionPane.WARNING_MESSAGE);

                        }
                        ObjectOutputStream outputStream = null;
                        try {
                            outputStream = new ObjectOutputStream(new FileOutputStream("Restaurant.ser"));

                            for (int j = 0; j < restaurants.size(); j++) {
                                outputStream.writeObject(restaurants.get(j));
                            }

                        } catch (IOException exp) {
                            System.out.println("IO Exception while opening file");
                        } finally {

                            try {
                                if (outputStream != null) {
                                    outputStream.close();
                                }

                            } catch (IOException exp) {
                                System.out.println("IO Exception while closing file");
                            }
                        }
                        JOptionPane.showMessageDialog(null," Food Added successfully");
                        dispose();
                        new AdminPanel();
                        break;
                    }
                }


                if(check){
                    JOptionPane.showMessageDialog(null," Restaurant not found");

                }
            }
            else if (e.getActionCommand().equalsIgnoreCase("go back")){
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel adding food for a restaurant? ","confirm",JOptionPane.YES_NO_OPTION)==0){
                    new AdminPanel();
                    dispose();
                }
            }
        }
    }
}
