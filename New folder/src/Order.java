import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    ArrayList<Food> foods = new ArrayList<Food>();
    private double price;
    private final int  deliveryprice = 200;

}
