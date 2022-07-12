import java.util.ArrayList;

public class check {

    public static void main(String[] args) {
        
        Food f=new Food("aloo","asd",1,23,"sd");
        Food f2=new Food("mattar","asd",1,23,"sd");
        Food f3=new Food("gobi","asd",1,23,"sd");
        ArrayList<Food> a=new ArrayList<Food>();
        a.add(f);
        a.add(f2);
        a.add(f3);

        Restaurant restaurant= new Restaurant(a,"e",1,"no where","090078601","chacha@gmail.com");
        restaurant.writeObjectToFile(restaurant);

        ArrayList<Restaurant> r= Restaurant.readAllData();
        System.out.println(r.size());
        System.out.println(r.get(0).getName());
        System.out.println(r.get(0).getAddress());
        System.out.println(r.get(0).getContact());
        System.out.println(r.get(0).getEmail());
        System.out.println(r.get(0).getID());
        System.out.println(r.get(0).getFoods().get(0).getFoodname());
        System.out.println(r.get(0).getFoods().get(1).getFoodname());
        System.out.println(r.get(0).getFoods().get(2).getFoodname());
//        System.out.println(r.get(0).getFoods().get(0).getFoodname());

    }
}
