package ru.job4j.sql.jsouparsing;

import org.junit.Test;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Class VacancyTest.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class VacancyTest {

    /**
     * Test.
     */
    @Test
    public void testTime() {
//        String time = "01 мар 18, 12:48 [21228074] Ответить | Цитировать Сообщить модератору";
        String time = "01 мар 18, 12:48";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yy, HH:mm",
                new Locale("ru", "RU"));
        LocalDateTime date = LocalDateTime.parse(time, format);
//        Timestamp ts = new Timestamp(date.);
//        long wtf = LocalDateTime.parse(time, format);
        System.out.println(date);
//        System.out.println(ts);
    }

    /**
     * Test.
     */
    @Test
    public void testTime3() {
        String[] dates = {"01 янв 18, 12:48",
                "01 фев 18, 12:48",
                "01 мар 18, 12:48",
                "01 апр 18, 12:48",
                "01 май 18, 12:48",
                "01 июн 18, 12:48",
                "01 июл 18, 12:48",
                "01 авг 18, 12:48",
                "01 сен 18, 12:48",
                "01 окт 18, 12:48",
                "01 ноя 18, 12:48",
                "01 дек 18, 12:48"};
        for (String date : dates) {
            try {
                Timestamp ts = new Timestamp(new SimpleDateFormat("dd MMM yy, HH:mm").parse(date).getTime());
                System.out.println(ts);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
//        String time = "01 мар 18, 12:48";
    }

    /**
     * Test.
     */
    @Test
    public void testParser() {
        String today = "сегодня, 16:50 [21256233] Ответить | Цитировать Сообщить модератору";
        String yesturday = "вчера, 16:50 [21256233] Ответить | Цитировать Сообщить модератору";
        String a = "3 мар 18, 17:27 [21234976] Ответить | Цитировать Сообщить модератору";
        String b = "27 фев 18, 13:46 [21221824] Ответить | Цитировать Сообщить модератору";
        System.out.println(this.result(today));
        System.out.println(this.result(yesturday));
        System.out.println(this.result(a));
        System.out.println(this.result(b));

    }

    /**
     * Test.
     * @param s - parameter.
     * @return - resturn statement.
     */
    public String result(String s) {
        if (Character.isSpaceChar(s.charAt(1))) {
            s = String.format("0%s", s);
        } else if (Character.isLetter(s.charAt(1))) {
            String regINclus1 = "^сегодня, .+$";
            Pattern patIN1 = Pattern.compile(regINclus1);
            Matcher matchIN1 = patIN1.matcher(s);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy", new Locale("ru", "RU"));
            if (matchIN1.matches()) {
                Date date = new Date(System.currentTimeMillis());
                String buffer = sdf.format(date);
                s = String.format("%s%s", buffer, s.substring(7));
            } else {
                Date date = new Date(System.currentTimeMillis() - 86400000);
                String buffer = sdf.format(date);
                s = String.format("%s%s", buffer, s.substring(5));
            }
        }
        return s.substring(0, 16);
    }
}