package obuchenie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;

/**
 * Created by aleksandr on 11/6/14.
 */
public class Date {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();//календарь на текущую дату
        Calendar c2 = new GregorianCalendar(2014, 10, 06);//календарь на 25.11.2013
       // c2.add(Calendar.DAY_OF_YEAR, 1); //увеличиваем дату на 1 день
       // System.out.println(c2.getTime());// 26.11.2013
       // c2.add(Calendar.DAY_OF_YEAR, -1); //уменьшаем дату на 1 день
        //System.out.println(c2.getTime());

        Calendar start_date = new GregorianCalendar(2014, 10, 07);//Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dfm.format(start_date.getTime()));
    }
}
