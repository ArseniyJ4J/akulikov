package ru.job4j.sql.jsouparsing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Class RegTest.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class RegExTest {

    /**
     * main method.
     * @param args - cmd line parameters.
     */
    public static void main(String[] args) {
        RegExTest regExTest = new RegExTest();
//        regExTest.test1();
//        regExTest.test2();
//        regExTest.test3();
        regExTest.test4();

    }

    /**
     * Test.
     */
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("java");
        list.add(" Java ");
        list.add(" java ");
        list.add(" Java");
        list.add("Java ");
        list.add("JAVA");
        list.add("Ищем java-разработчиков (1,2,3,все)");
        list.add("Ищем Full Stack Java Developer (удаленно, долгосрочный проект)");
        list.add("Ведущий Java разработчик (г.Москва)");
        list.add("Открыта вакансия Java-разработчика\t");
        list.add("Java программист на удаленку");
        list.add("Java Script");
//        list.add("");
        String regINclus = "(?i)(^|.+)java(.+|$)";
        String regEXclus = "(?i)(^|.+)script(.+|$)";
        Pattern patIN = Pattern.compile(regINclus);
        Pattern patEX = Pattern.compile(regEXclus);
        for (String s : list) {
            Matcher matchIN = patIN.matcher(s);
            Matcher matchEX = patEX.matcher(s);
            boolean result = (!matchEX.matches() && matchIN.matches());
            System.out.printf("String: \"%s\" BY:\"%s\"\nRESULT:%s\n", s, regEXclus, result);
        }
    }

    /**
     * Test.
     */
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("http://www.sql.ru/forum/1284926/ishhem-java-razrabotchikov");
        list.add("http://www.sql.ru/forum/memberinfo.aspx?mid=247585");
        list.add("http://www.sql.ru/forum/1287266/ishhem-full-stack-java-developer-udalenno-dolgosrochnyy-proekt");
        list.add("http://www.sql.ru/forum/1287054/vedushhiy-java-razrabotchik-g-moskva");
        list.add("http://www.sql.ru/forum/1287009/otkryta-vakansiya-java-razrabotchika");
        list.add("http://www.sql.ru/forum/1286858/java-programmist-na-udalenku");

        String regINclus = "^http://www.sql.ru/forum/[0-9]{5,10}(.+|$)";
        Pattern patIN = Pattern.compile(regINclus);
        for (String s : list) {
            Matcher matchIN = patIN.matcher(s);
            boolean result = matchIN.matches();
            System.out.printf("String: \"%s\" BY:\"%s\"\nRESULT:%s\n", s, regINclus, result);
        }
    }

    /**
     * Test.
     */
    public void test3() {
        String s = "ASDF";
        Integer i = null;
        String f = s + i + ".";
        System.out.println(f);
    }

    /**
     * Test.
     */
    public void test4() {
        String[] months = {"янв", "фев", "мар", "апр", "май", "июн", "июл", "авг", "сен", "окт", "ноя", "дек"};
        String source = "26 фев 18, 17:18 [21219629] Ответить | Цитировать Сообщить модератору";
        char[] chars = source.toCharArray();
        String[] date = new String[5];
        int index = 0;
        date[index] = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                date[index] = String.format("%s%s", date[index], String.valueOf(chars[i]));
            } else if (Character.isLetter(chars[i])) {
                date[index] = String.format("%s%s", date[index], String.valueOf(chars[i]));
            } else if (Character.isSpaceChar(chars[i]) || chars[i] == ':') {
                if (index >= 4) {
                    break;
                }
                index++;
                date[index] = "";
            }
        }
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(date[1])) {
                date[1] = String.valueOf(i + 1);
                break;
            }
        }
        for (String s : date) {
            System.out.println(s);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        String example = "26-2-18 17:18";
        LocalDateTime milisecond = LocalDateTime.parse(example, dtf);
        System.out.println(milisecond);
    }
}
