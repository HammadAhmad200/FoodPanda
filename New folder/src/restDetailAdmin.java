import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class restDetailAdmin extends JFrame {

    private DefaultListModel model;
    private JList list;

    public restDetailAdmin(Restaurant restaurant){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 76);

        panel.setLayout(null);

        JLabel labelshow=new JLabel("ADMIN");
        labelshow.setFont(new Font("Rockwell",Font.BOLD,25));
        labelshow.setBounds(525,15,450,60);
        labelshow.setForeground(new Color(214, 6, 101));
        panel.add(labelshow);

        getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
        lblNewLabel_1.setBounds(47, 15, 282, 46);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 76, 1264, 86);
        panel_1.setLayout(null);

        JLabel restlist = new JLabel(restaurant.getName().toUpperCase()+" | FOOD LIST");
        restlist.setForeground(Color.WHITE);
        restlist.setFont(new Font("Rockwell", Font.PLAIN, 22));
        restlist.setBounds(75, 38, 400, 24);
        panel_1.add(restlist);

        JButton button = new JButton("Go back");
        button.setFont(new Font("Tahoma", Font.BOLD, 14));

        button.setBounds(1150, 26, 100, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(Color.darkGray);
        panel_1.add(button);
        getContentPane().add(panel_1);
        
        JLabel lblNewLabel = new JLabel("Restaurant Details");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(514, 11, 464, 50);
        panel_1.add(lblNewLabel);
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


    myAction action= new myAction();
        button.addActionListener(action);



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

    public class myAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("go back")) {
                new showRestAdmin();
                dispose();
            }

        }
    }
}
