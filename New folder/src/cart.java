import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class cart extends JFrame {

    private ArrayList<Food> cart;
    private DefaultListModel model;
    private JList list;
    private User user;


    public cart(ArrayList<Food> foods, User u) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 76);


        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon("images (2).png"));
        label.setBounds(10, 11, 290, 53);
        panel.add(label);


        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
        lblNewLabel.setBounds(85, 23, 373, 53);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 76, 1264, 86);
        panel_1.setLayout(null);


        JLabel restlist = new JLabel(" FOOD CART");
        restlist.setForeground(Color.WHITE);
        restlist.setFont(new Font("Rockwell", Font.PLAIN, 22));
        restlist.setBounds(75, 38, 400, 24);
        panel_1.add(restlist);

        JButton button = new JButton("Go back");
        button.setFont(new Font("Tahoma", Font.BOLD, 20));
//        button.setIcon(new ImageIcon(""));
        button.setBounds(1110, 26, 140, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(new Color(255, 255, 255));
        panel_1.add(button);

        JButton checkout = new JButton("Checkout");
        checkout.setFont(new Font("Tahoma", Font.BOLD, 20));
//        button.setIcon(new ImageIcon(""));
        checkout.setBounds(935, 26, 165, 36);
        checkout.setForeground(new Color(199, 21, 133));
        checkout.setBackground(new Color(255, 255, 255));
        panel_1.add(checkout);


        getContentPane().add(panel_1);

        model = new DefaultListModel();
        for (int i = 0; i < foods.size(); i++) {

            model.addElement("FOOD NAME: " + foods.get(i).getFoodname() + "           FOOD PRICE: " + foods.get(i).getFoodprice() + " PKR.           FOOD DESCRIPTION: " + foods.get(i).getDescription());

        }
        list = new JList(model);

        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(0, 160, 1264, 521);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        list.setVisibleRowCount(10);
        list.addMouseListener(new myAction());

        myAction action = new myAction();
        button.addActionListener(action);
        checkout.addActionListener(action);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 160, 1264, 521);

        panel2.add(scrollPane);
        getContentPane().add(panel2);

        this.user = u;
        this.cart = foods;
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);

    }

    class myAction implements MouseListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("go back")) {
                new Menu(user, cart);
                dispose();
            }
            else if (e.getActionCommand().equalsIgnoreCase("checkout")){
                new checkout(user,cart);
                dispose();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int A = list.getSelectedIndex();
            for (int i = 0; i < cart.size(); i++) {
                String name=model.get(A).toString().substring(11,cart.get(i).getFoodname().length()+11);
                if (name.equalsIgnoreCase(cart.get(i).getFoodname())) {
                    if (JOptionPane.showConfirmDialog(null, "Are you sure you want to remove Food from cart", "remove from cart", JOptionPane.YES_NO_OPTION) == 0) {
                        cart.remove(i);
                        dispose();
                        new cart(cart,user);
                        break;
                    }
                    break;
                }
            }
        }
            @Override
            public void mousePressed (MouseEvent e){

            }

            @Override
            public void mouseReleased (MouseEvent e){

            }

            @Override
            public void mouseEntered (MouseEvent e){

            }

            @Override
            public void mouseExited (MouseEvent e){

            }
        }
    }

