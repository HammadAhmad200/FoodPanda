import java.io.*;
import java.util.ArrayList;

public abstract class Person implements Serializable{
    protected String firstname;
    protected String lastname;
    protected String date;
    protected String gender;
    protected String Address;
    protected String email;
    protected String phoneno;

    public Person(String firstname, String lastname,String date,String gender, String address, String email, String phoneno) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date = date;
        this.gender=gender;
        Address = address;
        this.email = email;
        this.phoneno = phoneno;
    }

    public Person() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public abstract void writeObjectToFile(Object s);

    public static boolean validateEmail(String email){
        String check1=email.substring(email.length()-4,email.length());
        if (email.contains("@")&&check1.equalsIgnoreCase(".com")){
            return true;
        }
        else {
            return false;
        }
    }

}

