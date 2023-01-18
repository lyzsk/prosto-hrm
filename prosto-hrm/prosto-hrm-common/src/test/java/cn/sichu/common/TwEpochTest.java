package cn.sichu.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sichu
 * @date 2023/01/03
 **/
public class TwEpochTest {
    public static void main(String[] args) {
        String targetDate = "01-01-2023 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        try {
            Date date = sdf.parse(targetDate);
            long milliseconds = date.getTime();
            System.out.println(milliseconds);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
