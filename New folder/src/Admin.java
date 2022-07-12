import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Admin extends Person implements Serializable  {

    private  String password;


    public Admin(String firstname, String lastname, Date date,String gender, String address, String email, String phoneno, String password) {
        super(firstname, lastname, date,gender, address, email, phoneno);
        this.password = password;
    }

    public Admin(String firstname, String lastname, Date date,String gender, String address, String email, String phoneno) {
        super(firstname, lastname, date,gender, address, email, phoneno);

    }
    public Admin() {
    }


    public Admin(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public void writeObjectToFile(Object input) {
        Admin s = (Admin)input;
        //Code for writing data to file
     
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Admin> AdminList = readAllData();

// Append new object into existing list
            AdminList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("Admin.ser"));


// Write all objects (old and new one) into the file
            for (int i = 0; i < AdminList.size(); i++) {
                outputStream.writeObject(AdminList.get(i));
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
    public static ArrayList<Admin> readAllData() {
        //  ArrayList initialized with size 0
        ArrayList<Admin> AdminList = new ArrayList<Admin>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Admin.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    Admin myObj = (Admin) inputStream.readObject();
// add object into ArrayList
                    AdminList.add(myObj);
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
        return AdminList;
    }



}
