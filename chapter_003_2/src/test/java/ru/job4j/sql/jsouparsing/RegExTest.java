package ru.job4j.sql.jsouparsing;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;

/** Class RegTest.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class RegExTest {
    /**
     * Test.
     */
    @Test
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
        list.add("Ведущий Java разработчик (г.Москва)");
        list.add("Открыта вакансия Java-разработчика\t");
        list.add("Java программист на удаленку");
        list.add("Ищем Full Stack Java Developer (удаленно, долгосрочный проект)");

        String wrong = "Java Script";
        String regINclus = "(?i)(^|.+)java(.+|$)";
        String regEXclus = "(?i)(^|.+)script(.+|$)";
        Pattern patIN = Pattern.compile(regINclus);
        Pattern patEX = Pattern.compile(regEXclus);
        for (String s : list) {
            Matcher matchIN = patIN.matcher(s);
            Matcher matchEX = patEX.matcher(s);
            boolean result = (!matchEX.matches() && matchIN.matches());
            Assert.assertThat(result, is(true));
        }

        Matcher matchIN = patIN.matcher(wrong);
        Matcher matchEX = patEX.matcher(wrong);
        boolean result = (!matchEX.matches() && matchIN.matches());
        Assert.assertThat(result, is(false));
    }


    /**
     * Test.
     */
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("http://www.sql.ru/forum/1284926/ishhem-java-razrabotchikov");
        list.add("http://www.sql.ru/forum/1287266/ishhem-full-stack-java-developer-udalenno-dolgosrochnyy-proekt");
        list.add("http://www.sql.ru/forum/1287054/vedushhiy-java-razrabotchik-g-moskva");
        list.add("http://www.sql.ru/forum/1287009/otkryta-vakansiya-java-razrabotchika");
        list.add("http://www.sql.ru/forum/1286858/java-programmist-na-udalenku");

        String wrong = "http://www.sql.ru/forum/memberinfo.aspx?mid=247585";
        String regINclus = "^http://www.sql.ru/forum/[0-9]{5,10}(.+|$)";
        Pattern patIN = Pattern.compile(regINclus);
        for (String s : list) {
            Matcher matchIN = patIN.matcher(s);
            boolean result = matchIN.matches();
            Assert.assertThat(result, is(true));
        }

        Matcher matchIN = patIN.matcher(wrong);
        boolean result = matchIN.matches();
        Assert.assertThat(result, is(false));
    }
}
