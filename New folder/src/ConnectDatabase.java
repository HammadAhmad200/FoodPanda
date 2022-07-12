


import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectDatabase{
    Connection con=null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Connection EstablishCon(){
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con=DriverManager.getConnection("jdbc:ucanaccess://src\\database\\invoiceRecord.accdb");
        JOptionPane.showMessageDialog(null, "Connected");    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
     }
    return con;
    }
}