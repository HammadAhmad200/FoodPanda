import java.io.*;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User extends Person implements Serializable {
    private int ID;
    private String Password;
   ConnectDatabase con= new ConnectDatabase();
    Connection connect= con.EstablishCon();
    

    public User(String firstname, String lastname, String date,String gender, String address, String email, String phoneno,  int ID, String password) {
        super(firstname, lastname, date,gender, address, email, phoneno);
        this.ID = ID;
        Password = password;
        System.out.println(date);
       
        StoreSignUp(firstname, lastname, date, gender, address, email, phoneno, ID, password);
        
        
    }
    public void StoreSignUp(String fname, String lname, String date,String gender, String address, String email, String phoneno,  int ID, String password){
        try {
            Statement st=connect.createStatement();
            st.executeUpdate("insert into buyer(fname,lname,dob,gender,email,address,phoneno,password) values('"+fname+"','"+lname+"','"+date+"','"+gender+"','"+email+"','"+address+"','"+phoneno+"','"+password+"')");
            System.out.println("Record inserted");
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User(String firstname, String lastname, String date,String gender, String address, String email, String phoneno) {
        super(firstname, lastname, date,gender, address, email, phoneno);
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void writeObjectToFile(Object input) {
//Code for writing data to file
        User s = (User)input;
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<User> UserList = readAllData();

// Append new object into existing list
            UserList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("User.ser"));


// Write all objects (old and new one) into the file
            for (int i = 0; i < UserList.size(); i++) {
                outputStream.writeObject(UserList.get(i));
            }

        } catch (IOException exp) {
            System.out.println("IO Exception while opening file");
        } finally {
// cleanup code which closes output stream if its object was created
            try {
                if (outputStream != null) {
                    outputStream.close();
                    // flag of success

                }

            } catch (IOException exp) {
                System.out.println("IO Exception while closing file");
            }
        }


    }
    public static ArrayList<User> readAllData() {
        //  ArrayList initialized with size 0
        ArrayList<User> UserList = new ArrayList<User>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("User.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    User myObj = (User) inputStream.readObject();
// add object into ArrayList
                    UserList.add(myObj);
//System.out.println("Read: " + myObj.getName());
                } catch (ClassNotFoundException e) {
//System.out.println("Class not found");
                } catch (EOFException end) {
// EOFException is raised when file ends
// set End Of File flag to true so that loop exits
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
//System.out.println("Cannot find file");
        } catch (IOException e) {
//System.out.println("IO Exception while opening stream");
//e.printStackTrace();
        } finally { // cleanup code to close stream if it was opened
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                System.out.println("IO Exception while closing file");
            }
        }
// returns ArrayList
        return UserList;
    }



}



