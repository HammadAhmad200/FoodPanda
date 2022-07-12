
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class AdminPanel extends JFrame {

    private final ButtonGroup buttonGroup = new ButtonGroup();



    AdminPanel() {

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setBounds(0, 0, 1274, 93);

        panel.setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel main = new JLabel("ADMIN PANEL");
        main.setHorizontalAlignment(SwingConstants.CENTER);
        main.setForeground(Color.WHITE);
        main.setFont(new Font("Rockwell", Font.PLAIN, 30));
        main.setBounds(505, 27, 263, 36);

        JLabel logo = new JLabel("");
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.setIcon(new ImageIcon("images (2).png"));
        logo.setBounds(0, 0, 320, 70);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setBounds(0, 93, 1274, 600);
        p1.setLayout(null);

        JButton button = new JButton("ADD NEW ADMIN");
        buttonGroup.add(button);
        button.setFont(new Font("Rockwell", Font.PLAIN, 15));
        button.setBounds(496, 167, 200, 35);

        JButton addrest = new JButton("ADD RESTAURANT");
        buttonGroup.add(addrest);
        addrest.setFont(new Font("Rockwell", Font.PLAIN, 15));
        addrest.setBounds(496, 227, 200, 35);

        JButton addfood = new JButton("ADD FOOD");
        buttonGroup.add(addfood);
        addfood.setFont(new Font("Rockwell", Font.PLAIN, 15));
        addfood.setBounds(496, 287, 200, 35);

        JButton del = new JButton("DELETE RESTAURANT");
        buttonGroup.add(del);
        del.setFont(new Font("Rockwell", Font.PLAIN, 15));
        del.setBounds(496, 352, 200, 35);

        JButton delfood = new JButton("DELETE FOOD");
        buttonGroup.add(delfood);
        delfood.setFont(new Font("Rockwell", Font.PLAIN, 15));
        delfood.setBounds(496, 419, 200, 35);

        JButton searchrest = new JButton("SHOW RESTAURANTS");
        buttonGroup.add(searchrest);
        searchrest.setFont(new Font("Rockwell", Font.PLAIN, 15));
        searchrest.setBounds(496, 479, 200, 35);


        JButton logout = new JButton("LOGOUT");
        buttonGroup.add(logout);
        logout.setFont(new Font("Rockwell", Font.PLAIN, 15));
        logout.setBounds(496, 539, 200, 35);

        p1.add(logout);
        p1.add(searchrest);
        panel.add(main);
        panel.add(logo);
        p1.add(button);
        p1.add(addrest);
        p1.add(addfood);
        p1.add(del);
        p1.add(delfood);
        p1.setBackground(new Color(214, 6, 101));
        getContentPane().add(panel);
        getContentPane().add(p1);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\foodid.png"));
        lblNewLabel.setBounds(130, 109, 489, 525);
        p1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 120325.png"));
        lblNewLabel_1.setBounds(870, 296, 268, 266);
        p1.add(lblNewLabel_1);
        setResizable(false);
        setVisible(true);
        setSize(1280, 720);
        Action a = new Action();
        button.addActionListener(a);
        addrest.addActionListener(a);
        addfood.addActionListener(a);
        searchrest.addActionListener(a);
        del.addActionListener(a);
        delfood.addActionListener(a);
        logout.addActionListener(a);

    }

    class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("Add new Admin")) {
                new AddAdmin();
                AdminPanel.this.dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("Add RESTAURANT")) {
                new Addrest();
                AdminPanel.this.dispose();
            } else if (e.getActionCommand().equalsIgnoreCase("add food")) {
                new Add();
                AdminPanel.this.dispose();
            }
            else if (e.getActionCommand().equalsIgnoreCase("delete restaurant")) {
               String restname= JOptionPane.showInputDialog(null,"Enter restaurant name","delete restaurant",JOptionPane.QUESTION_MESSAGE);
                ArrayList<Restaurant> restaurants=Restaurant.readAllData();
               boolean check =true;
                for (int i = 0; i < restaurants.size() ; i++) {
                    if(restaurants.get(i).getName().equalsIgnoreCase(restname)){
                        if (JOptionPane.showConfirmDialog(null,"Restaurant Found! Are you sure You want to Delete this restaurant? ","Confirm",JOptionPane.YES_NO_OPTION)==0){
                            check=false;

                            restaurants.remove(i);

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
                            JOptionPane.showMessageDialog(null,"Restaurant deleted Successfully","success",JOptionPane.PLAIN_MESSAGE);
                            break;
                        }
                        else {
                            check=false;
                            break;
                        }
                    }
                }
                if (check){
                    JOptionPane.showMessageDialog(null,"Restaurant Not found","Error",JOptionPane.WARNING_MESSAGE);

                }
            }
            else if(e.getActionCommand().equalsIgnoreCase("delete food")){
                String restname= JOptionPane.showInputDialog(null,"Enter restaurant name","delete restaurant",JOptionPane.QUESTION_MESSAGE);
                String foodName= JOptionPane.showInputDialog(null,"Enter Food name","delete Food",JOptionPane.QUESTION_MESSAGE);
                ArrayList<Restaurant> restaurants= Restaurant.readAllData();

                boolean check=true;
                boolean check2=true;
                for (int i = 0; i < restaurants.size() ; i++) {
                    if (restaurants.get(i).getName().equalsIgnoreCase(restname)){
                        check=false;
                        for (int j = 0; j < restaurants.get(i).getFoods().size() ; j++) {
                            if (restaurants.get(i).getFoods().get(j).getFoodname().equalsIgnoreCase(foodName)){
                                check2=false;
                               if(JOptionPane.showConfirmDialog(null,"Food Found! Are you sure You want to Delete Food from the Restaurant? ","Confirm",JOptionPane.YES_NO_OPTION)==0){
                                   restaurants.get(i).getFoods().remove(j);

                                   ObjectOutputStream outputStream = null;
                                   try {
                                       outputStream = new ObjectOutputStream(new FileOutputStream("Restaurant.ser"));

                                       for (int k = 0; k < restaurants.size(); k++) {
                                           outputStream.writeObject(restaurants.get(k));
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

                                   JOptionPane.showMessageDialog(null,"Food deleted successfully");
                               }

                                break;
                            }

                        }

                        if (check2){
                            JOptionPane.showMessageDialog(null,"Food Not found","Error",JOptionPane.WARNING_MESSAGE);

                        }
                        break;
                    }

                }
                if (check){
                    JOptionPane.showMessageDialog(null,"Restaurant Not found","Error",JOptionPane.WARNING_MESSAGE);

                }
            }
            else if (e.getActionCommand().equalsIgnoreCase("show restaurants")){
                new showRestAdmin();
                dispose();
            }
            else if (e.getActionCommand().equalsIgnoreCase("logout")) {

                if(JOptionPane.showConfirmDialog(null,"Are you sure you want to logout?","Confirm",JOptionPane.YES_NO_OPTION)==0){
                    new Login();
                    AdminPanel.this.dispose();
                }

            }
        }
    }
}
