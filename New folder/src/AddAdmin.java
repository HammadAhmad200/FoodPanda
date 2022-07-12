
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddAdmin extends JFrame {

    private JTextField t,t1,t4,t5,text;

    private JPasswordField pass,pass2;
    private JCheckBox chk;
    private JComboBox c1,c2,c3,gen;


    AddAdmin() {

        setSize(1280,720);
        setResizable(false);
        setTitle("SIGN UP AS ADMIN");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(214, 6, 101));
        panel.setLayout(null);

        JLabel l1 = new JLabel("First name");
        l1.setForeground(Color.WHITE);
        l1.setBackground(new Color(214, 6, 101));
        l1.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l1.setBounds(747, 201, 74, 19);

        panel.add(l1);

        JButton button = new JButton("Go back");
        button.setFont(new Font("Tahoma", Font.BOLD, 17));
        button.setBounds(15, 26, 133, 36);
        button.setForeground(new Color(199, 21, 133));
        button.setBackground(new Color(255, 255, 255));
        panel.add(button);

        t1 = new JTextField();
        t1.setBounds(995, 202, 259, 20);
        panel.add(t1);
        t1.setColumns(10);

        JLabel l2 = new JLabel("Last name");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l2.setBackground(new Color(214, 6, 101));
        l2.setBounds(750, 236, 71, 19);
        panel.add(l2);

        JLabel l4 = new JLabel("Phone no.");
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l4.setBackground(new Color(214, 6, 101));
        l4.setBounds(747, 441, 133, 19);
        panel.add(l4);

        t4 = new JTextField();
        t4.setColumns(10);
        t4.setBounds(995, 442, 259, 20);
        panel.add(t4);

        JLabel p1 = new JLabel("Password");
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Rockwell", Font.PLAIN, 15));
        p1.setBackground(new Color(214, 6, 101));
        p1.setBounds(747, 489, 133, 19);
        panel.add(p1);

        pass = new JPasswordField();
        pass.setBounds(995, 490, 259, 20);
        panel.add(pass);

        JLabel p2 = new JLabel("Confirm Password");
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Rockwell", Font.PLAIN, 15));
        p2.setBackground(new Color(214, 6, 101));
        p2.setBounds(747, 533, 133, 19);
        panel.add(p2);

        pass2 = new JPasswordField();
        pass2.setBounds(995, 534, 259, 20);
        panel.add(pass2);

        chk = new JCheckBox("I Agree With The Terms And Conditions");
        chk.setForeground(Color.WHITE);
        chk.setBackground(new Color(214, 6, 101));
        chk.setFont(new Font("Rockwell", Font.PLAIN, 15));
        chk.setBounds(945, 587, 309, 27);
        panel.add(chk);

        JButton b1 = new JButton("Sign Up!");
        b1.setBackground(new Color(214, 6, 101));
        b1.setForeground(new Color(199, 21, 133));
        b1.setFont(new Font("Rockwell", Font.BOLD, 20));
        b1.setBounds(995, 643, 259, 27);
        panel.add(b1);

        t = new JTextField();
        t.setColumns(10);
        t.setBounds(995, 237, 259, 20);

        panel.add(t);

        JLabel l5 = new JLabel("Address");
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l5.setBackground(new Color(214, 6, 101));
        l5.setBounds(747, 395, 95, 19);
        panel.add(l5);

        t5 = new JTextField();
        t5.setColumns(10);
        t5.setBounds(995, 396, 259, 20);
        panel.add(t5);

        JLabel l6 = new JLabel("DOB");
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l6.setBackground(new Color(214, 6, 101));
        l6.setBounds(747, 279, 71, 19);
        panel.add(l6);

        JLabel l7 = new JLabel("Gender");
        l7.setForeground(Color.WHITE);
        l7.setFont(new Font("Rockwell", Font.PLAIN, 15));
        l7.setBackground(new Color(214, 6, 101));
        l7.setBounds(750, 309, 71, 19);
        panel.add(l7);

        gen= new JComboBox();
        gen.setFont(new Font("Rockwell", Font.PLAIN, 15));
        gen.setModel(new DefaultComboBoxModel(new String[]{"MALE","FEMALE","OTHER"}));
        gen.setMaximumRowCount(3);
        gen.setEditable(false);
        gen.setBackground(Color.WHITE);
        gen.setBounds(995, 309, 259, 20);

        panel.add(gen);

        c1 = new JComboBox();
        c1.setFont(new Font("Rockwell", Font.PLAIN, 15));
        c1.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        c1.setMaximumRowCount(31);
        c1.setEditable(false);
        c1.setBackground(Color.WHITE);
        c1.setBounds(995, 278, 91, 20);

        panel.add(c1);

        c2 = new JComboBox();

        c2.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
        c2.setMaximumRowCount(12);
        c2.setFont(new Font("Rockwell", Font.PLAIN, 15));

        c2.setEditable(false);
        c2.setBackground(Color.WHITE);
        c2.setBounds(1096, 278, 74, 20);
        panel.add(c2);

        c3 = new JComboBox();
        c3.setModel(new DefaultComboBoxModel(new String[]{"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"}));
        c3.setMaximumRowCount(113);
        c3.setFont(new Font("Rockwell", Font.PLAIN, 15));
        c3.setEditable(false);
        c3.setBackground(Color.WHITE);
        c3.setBounds(1180, 278, 74, 20);
        panel.add(c3);

        JLabel ref = new JLabel("dd/mm/yy");
        ref.setForeground(Color.WHITE);
        ref.setBackground(new Color(214, 6, 101));
        ref.setFont(new Font("Rockwell", Font.PLAIN, 11));
        ref.setBounds(995, 266, 74, 14);
        panel.add(ref);

        JLabel em = new JLabel("Email");
        em.setForeground(Color.WHITE);
        em.setFont(new Font("Rockwell", Font.PLAIN, 15));
        em.setBackground(new Color(214, 6, 101));
        em.setBounds(747, 351, 133, 19);
        panel.add(em);

        text = new JTextField();
        text.setColumns(10);
        text.setBounds(995, 352, 259, 20);
        panel.add(text);
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mirha\\Pictures\\Screenshot 2022-06-29 123833.png"));
        lblNewLabel.setBounds(59, 175, 610, 306);
        panel.add(lblNewLabel);
        setVisible(true);
        b1.addActionListener(new myAction());
        button.addActionListener(new myAction());

    }

    public class myAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equalsIgnoreCase("sign up!")) {

                if (chk.isSelected()) {
                    if (t.getText().isEmpty() || t1.getText().isEmpty() || t4.getText().isEmpty() || t5.getText().isEmpty() || text.getText().isEmpty() || pass.getText().isEmpty() || pass2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame("Error"), "Please Fill All The Given Fields");

                    } else {
                        if (pass.getText().equals(pass2.getText())) {

                            if (Person.validateEmail(text.getText())){
                                Date d = new Date(Integer.parseInt(c1.getModel().getSelectedItem().toString()),Integer.parseInt(c2.getModel().getSelectedItem().toString()),Integer.parseInt(c3.getModel().getSelectedItem().toString()));
                                Random x = new Random(1000);
                                int num = x.nextInt();
                                Admin p = new Admin(t1.getText(), t.getText(), d,gen.getModel().getSelectedItem().toString(), t5.getText(), text.getText(), t4.getText(), pass.getText());
                                p.writeObjectToFile(p);
                                JOptionPane.showMessageDialog(new JFrame("Success"), "Admin added successfully");
                                AddAdmin.this.dispose();
                                new Main();
                            }
                            else{
                                JOptionPane.showMessageDialog(new JFrame(), "Invalid Email format","Error",JOptionPane.WARNING_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(new JFrame(), "Password does not match");

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame("Error"), "Please Agree To Terms And Conditions To Be A Admin Of Food Panda");
                }
            }
            else if (e.getActionCommand().equalsIgnoreCase("go back")){
                if (JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel Admin Sign up? ","confirm",JOptionPane.YES_NO_OPTION)==0){
                    new AdminPanel();
                    dispose();
                }
            }



        }
    }
}

