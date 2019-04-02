import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyDate {
    public static void dayDiff(String date1, String date2){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            long d1 = simpleDateFormat.parse(date1).getTime();
            long d2 = simpleDateFormat.parse(date2).getTime();
            long diff = (d2-d1)/1000/60/60/24;
            System.out.println(diff);


        }catch (ParseException e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        dayDiff("2019-12-20 14:20:10","2019-12-31 14:20:35");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(simpleDateFormat.format(date).getClass().getSimpleName());


    }
}
