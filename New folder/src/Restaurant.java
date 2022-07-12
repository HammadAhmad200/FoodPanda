import java.io.*;
import java.util.ArrayList;


public class Restaurant implements Serializable {

    private ArrayList<Food>foods ;
    private String name;
    private int ID;
    private String address;
    private String contact;
    private String email;

    public Restaurant(ArrayList<Food> foods, String name, int ID, String address, String contact, String email) {
        this.foods = foods;
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }

    public Restaurant() {
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void writeObjectToFile(Object input) {
//Code for writing data to file
        Restaurant s = (Restaurant)input;
        ObjectOutputStream outputStream = null;

        try {
            // Read old objects
            ArrayList<Restaurant> RestaurantList = readAllData();

// Append new object into existing list
            RestaurantList.add(s);

            outputStream = new ObjectOutputStream(new FileOutputStream("Restaurant.ser"));


// Write all objects (old and new one) into the file
            for (int i = 0; i < RestaurantList.size(); i++) {
                outputStream.writeObject(RestaurantList.get(i));
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
    public static ArrayList<Restaurant> readAllData() {
        //  ArrayList initialized with size 0
        ArrayList<Restaurant> RestaurantList = new ArrayList<Restaurant>(0);
// Input stream
        ObjectInputStream inputStream = null;
        try {
// open file for reading
            inputStream = new ObjectInputStream(new FileInputStream("Restaurant.ser"));
// End Of File flag
            boolean EOF = false;
// Keep reading file until file ends

            while (!EOF) {
                try {
// read object and type cast into CarDetails object

                    Restaurant myObj = (Restaurant) inputStream.readObject();
// add object into ArrayList
                    RestaurantList.add(myObj);
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
        return RestaurantList;
    }
}
