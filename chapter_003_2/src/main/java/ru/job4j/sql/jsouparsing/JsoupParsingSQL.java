package ru.job4j.sql.jsouparsing;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** JsoupParsingSQL.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class JsoupParsingSQL {

    /**
     * Class field.
     */
    final static Logger LOGGER = Logger.getLogger(JsoupParsingSQL.class);
    /**
     * Class field.
     */
    private Statement statement;
    /**
     * Class field.
     */
    private Connection connection;
    /**
     * Class field.
     */
    private Properties prop = new Properties();
    /**
     * Class field.
     */
    private Document doc;
    /**
     * Class field.
     */
    private Elements elements;
    /**
     * Class field.
     */
    private boolean goFlag = true;
    /**
     * Class field.
     */
    private long ainchent;
    /**
     * Class field.
     */
    private int authorIndex = 1;
    /**
     * Class field.
     */
    private int vacancyIndex = 1;

    /**
     * linksPageParser method.
     * @param link - parameter.
     * @return - return statement.
     * @throws IOException - exception.
     */
    public List<String> linksPageParser(String link) throws IOException {
        doc = Jsoup.connect(link).get();
        elements = doc.getAllElements();
        Pattern patIN1 = Pattern.compile(this.prop.getProperty("regINclus1"));
        Pattern patIN2 = Pattern.compile(this.prop.getProperty("regINclus2"));
        Pattern patEX = Pattern.compile(this.prop.getProperty("regEXclus"));
        List<String> buffer = new ArrayList<>();
        for (Element element : elements) {
            Matcher matchIN1 = patIN1.matcher(element.ownText());
            Matcher matchIN2 = patIN2.matcher(element.attr("href"));
            Matcher matchEX = patEX.matcher(element.ownText());
            boolean result = (!matchEX.matches() && matchIN1.matches() && matchIN2.matches());
            if (result) {
                StringBuffer sb = new StringBuffer(element.attr("href"));
                sb.insert(31, "-a");
//                System.out.println("href: " + sb);
//                System.out.println(element);
                buffer.add(String.valueOf(sb));
            }
        }
        return buffer;
    }

    /**
     * linksVacancyParser method.
     * @param link - parameter.
     * @return - reaturn statement.
     * @throws IOException - esception.
     * @throws ParseException - exception.
     */
    public Vacancy linksVacancyParser(String link) throws IOException, ParseException {
        doc = Jsoup.connect(link).get();
        elements.clear();
        elements = doc.getElementsByAttributeValue("class", "msgTable");
//        System.out.println("######################################################################################################################################");
        Pattern patIN3 = Pattern.compile(this.prop.getProperty("regINclus3"));
        String dateUpdateVac;
        Element element = elements.last();
//        System.out.println("@@@@@@@@");
//        System.out.println("@@@@@@@@");
//        System.out.println(element);
//        System.out.println("@@@@@@@@");
//        System.out.println("@@@@@@@@");
        dateUpdateVac = this.convertDate(element.childNode(1).childNode(4).childNode(1).childNode(0).toString().trim());
        Elements elementsFirst = elements.get(0).getElementsByAttributeValueMatching("class", patIN3);
        String titleVac;
        String nameAuthorVac;
        String descriptionVac;
        String dateCreationVac;
        Timestamp dateUpdate = new Timestamp(new SimpleDateFormat("dd MMM yy, HH:mm").parse(dateUpdateVac).getTime());
//        System.out.println(dateUpdate);
        Timestamp dateCreation;
        titleVac = elementsFirst.get(0).ownText();
//        System.out.println(titleVac);
        nameAuthorVac = String.valueOf(elementsFirst.get(1).childNodes().get(1).childNode(0)).trim();
//        System.out.println(nameAuthorVac);
        descriptionVac = Jsoup.parse(elementsFirst.get(2).toString()).text();
//        System.out.println(descriptionVac);
        dateCreationVac = Jsoup.parse(elementsFirst.get(3).toString()).text();
        dateCreationVac = this.convertDate(dateCreationVac);
//        System.out.println(dateCreationVac);
        dateCreation = new Timestamp(new SimpleDateFormat("dd MMM yy, HH:mm").parse(dateCreationVac).getTime());
//        System.out.println(dateCreation);
        Vacancy vacancy = new Vacancy(titleVac, nameAuthorVac, descriptionVac, dateCreation, dateUpdate);
        if (this.vacancyIsDuplicate(vacancy)) {
            LOGGER.info("Duplicate! Vacancy not have been created!");
//             System.out.println("DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!DUPLICATE!!!!");
            vacancy = null;
        }
//        System.out.println(Vacancy);
        return vacancy;
    }

    /**
     * vacancyIsDuplicate method.
     * @param vacancy - parameter.
     * @return - return statement.
     */
    public boolean vacancyIsDuplicate(Vacancy vacancy) {
        boolean result = false;
        try {
            ResultSet rs = this.statement.executeQuery(prop.getProperty("hashIndexSelect"));
            while (rs.next()) {
                int hCode = rs.getInt("hash_index");
                if (hCode == vacancy.hashCode()) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * isAinchentVac method.
     * @param vacancy - parameter.
     * @return - return statement.
     */
    public boolean isAinchentVac(Vacancy vacancy) {
//        System.out.println("#######################################");
        long update =  vacancy.getDateUpdate().getTime();
//        System.out.printf("updatetime: %s\n", update);
        long creation =  vacancy.getDateCreation().getTime();
//        System.out.printf("  creatime: %s\n", creation);
//        System.out.println(Vacancy.getTitle());
        long current = System.currentTimeMillis();
//        System.out.printf("   current: %s\n", current);
//        long ainchent = current - 31536000000L;
//        System.out.printf("  ainchent: %s\n", this.ainchent);
//        System.out.println("#######################################");
        boolean result = update > this.ainchent;
        this.goFlag = result;
        return !result;
    }

    /**
     * convertDate method.
     * @param s - parameter.
     * @return - return statement.
     */
    public String convertDate(String s) {
        if (Character.isSpaceChar(s.charAt(1))) {
            s = String.format("0%s", s);
        } else if (Character.isLetter(s.charAt(1))) {
            String regINclus1 = "^сегодня, .+$";
            Pattern patIN1 = Pattern.compile(regINclus1);
            Matcher matchIN1 = patIN1.matcher(s);
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yy", new Locale("ru", "RU"));
            if (matchIN1.matches()) {
                java.util.Date date = new java.util.Date(System.currentTimeMillis());
                String buffer = sdf.format(date);
                s = String.format("%s%s", buffer, s.substring(7));
            } else {
                java.util.Date date = new Date(System.currentTimeMillis() - 86400000);
                String buffer = sdf.format(date);
                s = String.format("%s%s", buffer, s.substring(5));
            }
        }
        return s.substring(0, 16);
    }

    /**
     * authorCheck method.
     * @param name - parameter
     * @return - return statement.
     */
    public int authorCheck(String name) {
        int result = -1;
        try {
            PreparedStatement ps = this.connection.prepareStatement(prop.getProperty("authSelectQ"));
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                System.out.printf("%s%s\n", rs.getInt(1), rs.getString(2));
//            }
            result =  rs.isBeforeFirst() ? rs.getInt("id") : -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * addToDB.
     * @param vacancy - parameter.
     * @throws SQLException - exception.
     */
    private void addToDB(Vacancy vacancy) throws SQLException {
        PreparedStatement ps = this.connection.prepareStatement(prop.getProperty("addAuthor"));
        int checker = this.authorCheck(vacancy.getAuthor());
        if (checker < 0) {
            ps.setInt(1, authorIndex);
            ps.setString(2, vacancy.getAuthor());
            ps.execute();
            checker = authorIndex;
            authorIndex++;
        }
        ps = this.connection.prepareStatement(prop.getProperty("addVacancy"));
        ps.setInt(1, vacancyIndex);
        ps.setString(2, vacancy.getTitle());
        ps.setInt(3, checker);
        ps.setString(4, vacancy.getDescription());
        ps.setTimestamp(5, vacancy.getDateCreation());
        ps.setTimestamp(6, vacancy.getDateUpdate());
        ps.setInt(7, vacancy.hashCode());
        ps.execute();
        vacancyIndex++;
        LOGGER.info("Vacancy sucsess added to Data Base. vacancy.toString: " + vacancy.toString());
        connection.commit();
    }

    /**
     * start method.
     */
    public void start() {
        LOGGER.info("First start");
        int count = 1;
        try {
            if (this.goFlag) {
                this.ainchent = System.currentTimeMillis() - 31536000000L;
//                System.out.println(this.ainchent);
                this.init();
            } else {
                ResultSet rs = this.statement.executeQuery("SELECT MAX(time_update) FROM Vacancies;");
                long lastVacUpTime = rs.getLong(1);
                this.ainchent = lastVacUpTime;
//                System.out.println(this.ainchent);
                this.goFlag = true;
            }
            while (this.goFlag) {
                String link = String.format("%s/%s", this.prop.getProperty("basePageURL"), count);

                List<String> list = this.linksPageParser(link);

                for (int i = 0; i < list.size(); i++) {
                    Vacancy vacancy = this.linksVacancyParser(list.get(i));
                    if (vacancy != null && !this.isAinchentVac(vacancy)) {
                        this.addToDB(vacancy);
//                        System.out.println("ADD SUCSESS!");
                    } else {
//                        System.out.println("NOTHING TO ADD!");
//                        System.out.println(vacancy);
                        if (i == (list.size() - 1)) {
                            this.goFlag = false;
                        }
                    }
                }
                count++;
            }
            this.goFlag = false;
//            86400000
            LOGGER.info("sleep 24 hours.");
            Thread.sleep(5000);
            this.start();
        } catch (IOException | ParseException | SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * init method.
     */
    private void init() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("jsoup.properties");
        try {
            this.prop.load(inputStream);
            JsoupDataBase jsoupDataBase = new JsoupDataBase(this.prop);
            this.statement = jsoupDataBase.getStatement();
            this.connection = jsoupDataBase.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * main method.
     * @param args - cmd line parameters.
     */
    public static void main(String[] args) {
        JsoupParsingSQL jpsql = new JsoupParsingSQL();
        jpsql.start();
    }
}