import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class showRestAdmin extends JFrame {



    private DefaultListModel model;
    private JList list;



    public showRestAdmin(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 1264, 76);

        panel.setLayout(null);

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon("images (2).png"));
        label.setBounds(0, 23, 290, 53);
        panel.add(label);

        JLabel labelshow=new JLabel("ADMIN");
        labelshow.setFont(new Font("Rockwell", Font.BOLD, 42));
        labelshow.setBounds(525,15,350,60);
        labelshow.setForeground(new Color(214, 6, 101));
        panel.add(labelshow);

        getContentPane().add(panel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 125728.png"));
        lblNewLabel_1.setBounds(57, 15, 296, 48);
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.DARK_GRAY);
        panel_1.setBounds(0, 76, 1264, 86);

        panel_1.setLayout(null);

        JLabel restlist = new JLabel("RESTAURANT LIST");
        restlist.setForeground(Color.WHITE);
        restlist.setFont(new Font("Rockwell", Font.BOLD, 26));
        restlist.setBounds(75, 38, 250, 24);
        panel_1.add(restlist);

        JButton button = new JButton("Go back");
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setBounds(1150, 26, 100, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(Color.darkGray);
        panel_1.add(button);
        getContentPane().add(panel_1);
        
        JLabel lblNewLabel = new JLabel("Show Restaurant");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(565, 25, 259, 51);
        panel_1.add(lblNewLabel);


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


        JPanel panel2= new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 160, 1264, 521);

        panel2.add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(panel2);
        setVisible(true);
        setResizable(false);
        setSize(1280, 720);
        setTitle("Show restaurant Admin");
        button.addActionListener(new myAction());
        list.addMouseListener(new myAction());
    }

    public class myAction implements ActionListener, MouseListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("go back")){
                new AdminPanel();
                dispose();
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int A = list.getSelectedIndex();
            ArrayList<Restaurant> restaurants=Restaurant.readAllData();
            for (int i = 0; i <restaurants.size() ; i++) {
                if (restaurants.get(i).getName().equalsIgnoreCase(model.get(A).toString())){
                    new restDetailAdmin(restaurants.get(i));
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
