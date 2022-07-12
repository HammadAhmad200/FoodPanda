

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Menu extends JFrame {



    private DefaultListModel model;
    private JList list;
    private User user;
    private ArrayList<Food> cart;


    Menu(User u,ArrayList<Food> foods) {
        this.user=u;
        this.cart=foods;
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 76);

        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon("images (2).png"));
        label.setBounds(0, 23, 290, 53);
        panel.add(label);

        JLabel deliverto = new JLabel("DELIVERING TO:");
        deliverto.setFont(new Font("Rockwell", Font.PLAIN, 15));
        deliverto.setBounds(400, 46, 127, 19);
        panel.add(deliverto);
//
        TextField textField = new TextField();
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        textField.setText(u.getFirstname()+" "+u.getLastname()+" | "+u.getAddress());

        textField.setBounds(533, 43, 580, 22);
        panel.add(textField);
        getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 76, 1264, 86);

        panel_1.setLayout(null);

//        textField_1 = new JTextField();
//        textField_1.setBounds(184, 42, 286, 20);
//        panel_1.add(textField_1);
//        textField_1.setColumns(10);
//

        JButton cart=new JButton("",new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 143758.png"));
        cart.setBounds(1150,15,55,50);
        cart.setBackground(Color.white);

       panel.add(cart);
       
       JLabel lblNewLabel = new JLabel("");
       lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
       lblNewLabel.setBounds(44, 15, 281, 49);
       panel.add(lblNewLabel);

        JLabel restlist = new JLabel("RESTAURANT LIST");
        restlist.setForeground(Color.WHITE);
        restlist.setFont(new Font("Rockwell", Font.PLAIN, 22));
        restlist.setBounds(75, 38, 250, 24);
        panel_1.add(restlist);

        JButton button = new JButton("Logout");
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
//        button.setIcon(new ImageIcon(""));
        button.setBounds(1103, 26, 127, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(Color.darkGray);
        panel_1.add(button);
        getContentPane().add(panel_1);


        ArrayList<Restaurant> restaurants = Restaurant.readAllData();
        model = new DefaultListModel();


        for (int i = 0; i < restaurants.size(); i++) {

            model.addElement(restaurants.get(i).getName());

        }
        list = new JList(model);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(0, 160, 1264, 521);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        list.setVisibleRowCount(10);
        list.addMouseListener(new myAction());

        myAction action= new myAction();

        button.addActionListener(action);
        cart.addActionListener(action);


        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 160, 1264, 521);


        panel2.add(scrollPane);
        getContentPane().add(panel2);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
    }


    class myAction implements MouseListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getActionCommand().equalsIgnoreCase("logout")){
                if(JOptionPane.showConfirmDialog(null,"are you sure you want to logout?","Are you sure",JOptionPane.YES_NO_OPTION)==0){
                    new Login();
                    dispose();
                }

            }
            else if (e.getActionCommand().equalsIgnoreCase("cart")){
                new cart(cart,user);
                dispose();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int A = list.getSelectedIndex();
            ArrayList<Restaurant> restaurants=Restaurant.readAllData();
            for (int i = 0; i <restaurants.size() ; i++) {
                if (restaurants.get(i).getName().equalsIgnoreCase(model.get(A).toString())){
                    new restaurantDetails(restaurants.get(i),user,cart);
                    dispose();
                    break;
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
