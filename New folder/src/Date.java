import java.io.Serializable;

@SuppressWarnings("serial")
public class Date implements Serializable {
    private int day;

    private int month;

    private int year;



    public int getDay() {

        return day;

    }



    public int getMonth() {

        return month;

    }



    public int getYear() {

        return year;

    }



    public void setDay(int d) {

        if (d <= 31 && d > 0)

            this.day = d;

        else {

            System.out.println("Invalid");

        }

    }



    public void setMonth(int m) {

        if (m <= 12 && m > 0)

            this.month = m;

        else

            System.out.println("Invalid");

    }



    public void setYear(int y) {

        if (y > 0)

            this.year = y;

        else

            System.out.println("Invalid format");

    }



    public Date() {

        day = 25;

        month = 10;

        year = 1999;

    }



    public Date(int d, int m, int y) {

        if (d > 0 && d <= 31 && m > 0 && m <= 12 && y > 0){
            day = d;
            month = m;
            year = y;

    }
    }





}

