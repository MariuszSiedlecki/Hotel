package mario.UtilsMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
     private static String dateToString(Date date){
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
         return simpleDateFormat.format(date);
     }
     public static Date stringToDate(String stringDate){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         Date date;
         try {
             date = sdf.parse(stringDate);
         } catch (ParseException e) {
             e.printStackTrace();
             return null;
         }
         return date;
     }

     private static String localDateTimeToString(LocalDateTime date){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM:ss" );
         return sdf.format(date);

     }
     private static String localDateTimeToString2(LocalDateTime dateTime){
         LocalDateTime current = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
         return current.format(formatter);
     }
}
