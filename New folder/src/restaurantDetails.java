import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class restaurantDetails extends JFrame {


   private DefaultListModel model;
   private JList list;
   private User user;
   private ArrayList<Food> cart;
   private Restaurant restaurant;


    public restaurantDetails(Restaurant restaurant,User u,ArrayList<Food> foods){

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 76);

        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon("images (2).png"));
        label.setBounds(0, 23, 290, 53);
        panel.add(label);


        getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 76, 1264, 86);
        panel_1.setLayout(null);

        JButton cart=new JButton("",new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 143758.png"));
        cart.setBounds(1150,15,55,50);
        cart.setBackground(Color.white);

        panel.add(cart);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
        lblNewLabel.setBounds(78, 15, 275, 61);
        panel.add(lblNewLabel);

        JLabel restlist = new JLabel(restaurant.getName().toUpperCase()+" | FOOD LIST");
        restlist.setForeground(Color.WHITE);
        restlist.setFont(new Font("Rockwell", Font.PLAIN, 22));
        restlist.setBounds(75, 38, 400, 24);
        panel_1.add(restlist);

        JLabel addresslabel = new JLabel("Address| "+restaurant.getAddress());
        addresslabel.setForeground(Color.WHITE);
        addresslabel.setFont(new Font("Rockwell", Font.PLAIN, 16));
        addresslabel.setBounds(75, 60, 700, 24);
        panel_1.add(addresslabel);
        JButton button = new JButton("Go back");
        button.setFont(new Font("Tahoma", Font.BOLD, 15));
//        button.setIcon(new ImageIcon(""));
        button.setBounds(1150, 26, 100, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(Color.darkGray);
        panel_1.add(button);
        getContentPane().add(panel_1);
        model = new DefaultListModel();
        for (int i = 0; i < restaurant.getFoods().size(); i++) {

            model.addElement("FOOD NAME: "+restaurant.getFoods().get(i).getFoodname()+"           FOOD PRICE: "+restaurant.getFoods().get(i).getFoodprice()+" PKR.           FOOD DESCRIPTION: "+restaurant.getFoods().get(i).getDescription());

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

        this.user=u;
        this.cart=foods;
        this.restaurant=restaurant;
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
    }

    public class myAction implements MouseListener, ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("go back")){
                new Menu(user,cart);
                dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("cart")) {
                new cart(cart,user);
                dispose();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int A = list.getSelectedIndex();
            String name=(String)model.get(A);
            for (int i = 0; i <restaurant.getFoods().size() ; i++) {
                if (name.contains(restaurant.getFoods().get(i).getFoodname())){
                   if ( JOptionPane.showConfirmDialog(null,"Are you sure you want to add Food to cart","add to cart",JOptionPane.YES_NO_OPTION)==0){
                       cart.add(restaurant.getFoods().get(i));
                    }
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
