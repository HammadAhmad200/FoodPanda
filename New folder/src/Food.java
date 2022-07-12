import java.io.*;
import java.util.ArrayList;

public class Food implements Serializable {
    private String foodname;
    private String foodtype;
    private int foodid;
    private double foodprice;
    private String description;

    public Food(String foodname, String foodtype, int foodid, double foodprice, String description) {
        this.foodname = foodname;
        this.foodtype = foodtype;
        this.foodid = foodid;
        this.foodprice = foodprice;
        this.description = description;
    }

    public Food() {
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public int getFoodid() {
        return foodid;
    }

    public void setFoodid(int foodid) {
        this.foodid = foodid;
    }

    public double getFoodprice() {
        return foodprice;
    }

    public void setFoodprice(double foodprice) {
        this.foodprice = foodprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(String food){
        return  this.foodname.equalsIgnoreCase(food);
    }

}
