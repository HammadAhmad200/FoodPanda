import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class checkout extends JFrame{


    private User user;
    private ArrayList<Food> cart;



    public checkout(User u, ArrayList<Food> cart) {

        this.user=u;
        this.cart=cart;

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 107);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
        lblNewLabel.setBounds(39, 29, 309, 52);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 106, 1264, 86);
        getContentPane().add(panel_1);

        JLabel Bill = new JLabel("Bill");
        Bill.setForeground(Color.WHITE);
        Bill.setFont(new Font("Rockwell", Font.BOLD, 20));
        Bill.setBounds(75, 38, 79, 24);
        panel_1.add(Bill);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 192, 1264, 489);
        getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel Name = new JLabel("Name:");
        Name.setForeground(Color.BLACK);
        Name.setFont(new Font("Rockwell", Font.BOLD, 15));
        Name.setBounds(10, 62, 50, 19);
        panel_2.add(Name);

        JLabel uName = new JLabel(u.getFirstname()+" "+u.getLastname());
        uName.setForeground(Color.BLACK);
        uName.setFont(new Font("Rockwell", Font.PLAIN, 15));
        uName.setBounds(100, 62, 150, 19);
        panel_2.add(uName);

        JLabel Address = new JLabel("Address:");
        Address.setForeground(Color.BLACK);
        Address.setFont(new Font("Rockwell", Font.BOLD, 15));
        Address.setBounds(10, 103, 70, 19);
        panel_2.add(Address);

        JLabel uAddress = new JLabel(u.getAddress());
        uAddress.setForeground(Color.BLACK);
        uAddress.setFont(new Font("Rockwell", Font.PLAIN, 15));
        uAddress.setBounds(100, 103, 400, 19);
        panel_2.add(uAddress);

        JLabel ContactNo = new JLabel("Contact no.");
        ContactNo.setForeground(Color.BLACK);
        ContactNo.setFont(new Font("Rockwell", Font.BOLD, 15));
        ContactNo.setBounds(10, 148, 91, 19);
        panel_2.add(ContactNo);

        JLabel uContactNo = new JLabel(u.getPhoneno());
        uContactNo.setForeground(Color.BLACK);
        uContactNo.setFont(new Font("Rockwell", Font.PLAIN, 15));
        uContactNo.setBounds(110, 148, 150, 19);
        panel_2.add(uContactNo);

        JLabel FoodName = new JLabel("Food Name");
        FoodName.setForeground(Color.BLACK);
        FoodName.setFont(new Font("Rockwell", Font.BOLD, 15));
        FoodName.setBounds(719, 11, 90, 19);
        panel_2.add(FoodName);

        JLabel Price = new JLabel("Price");
        Price.setForeground(Color.BLACK);
        Price.setFont(new Font("Rockwell", Font.BOLD, 15));
        Price.setBounds(930, 11, 47, 19);
        panel_2.add(Price);

        JLabel TotalPrice = new JLabel("Total Price");
        TotalPrice.setForeground(Color.BLACK);
        TotalPrice.setFont(new Font("Rockwell", Font.BOLD, 15));
        TotalPrice.setBounds(472, 372, 87, 19);
        panel_2.add(TotalPrice);

        JLabel line= new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------");
        line.setForeground(Color.BLACK);
        line.setFont(new Font("Rockwell", Font.BOLD, 15));
        line.setBounds(472, 362, 700, 19);
        panel_2.add(line);

        JButton confirmbutton = new JButton("Confirm Order");
        confirmbutton.setFont(new Font("Rockwell", Font.PLAIN, 15));
        confirmbutton.setBackground(Color.DARK_GRAY);
        confirmbutton.setForeground(Color.WHITE);
        confirmbutton.setBounds(572, 412, 162, 27);
        panel_2.add(confirmbutton);

        JLabel []foodname =new JLabel[cart.size()];
        JLabel []foodprice = new JLabel[cart.size()];

        int y=0;
        double totalPrice=0;
        for (int i = 0; i <cart.size() ; i++) {
            foodname[i]= new JLabel(cart.get(i).getFoodname());
            foodprice[i]= new JLabel(""+cart.get(i).getFoodprice()+"PKR.");
            foodname[i].setBounds(710, 30+y, 200, 19);
            foodprice[i].setBounds(929,30+y, 80, 19);
            y=y+20;
            panel_2.add(foodprice[i]);
            panel_2.add(foodname[i]);
            totalPrice=totalPrice+cart.get(i).getFoodprice();
        }
        JLabel totalPriceLabel=new JLabel(totalPrice+" PKR.");
        totalPriceLabel.setBounds(930, 372, 87, 19);
        panel_2.add(totalPriceLabel);

        JButton back= new JButton("Cancel Checkout");
        back.setFont(new Font("Tahoma", Font.BOLD, 20));
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(new Color(199, 21, 133));
        back.setBounds(1000, 26, 199, 36);
        panel_1.add(back);


        confirmbutton.addActionListener(new myAction());
        back.addActionListener(new myAction());

        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        setTitle("Checkout");
        setVisible(true);
    }


    public class myAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equalsIgnoreCase("confirm order")){

                if (cart.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Your cart is empty, please add food to cart");

                }
                else {
                    if (JOptionPane.showConfirmDialog(null,"Are you sure you want to confirm order?","Are you sure",JOptionPane.YES_NO_OPTION)==0){
                        JOptionPane.showMessageDialog(null,"Your order has been confirmed your food will be at your doorsteps within an hour, Thank you for Using Foodpanda :D");
                        cart.clear();
                        new Menu(user,cart);
                        dispose();
                    }
                }
            }
            else if (e.getActionCommand().equalsIgnoreCase("cancel checkout")){
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel checkout?","Are you sure",JOptionPane.YES_NO_OPTION)==0){
                    new Menu(user,cart);
                    dispose();
                }
            }
        }
    }
}
