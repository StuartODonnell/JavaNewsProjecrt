package db;

import models.*;
import db.DBHelper;

import java.util.GregorianCalendar;

public class Seeds {


    public static void seedData() {

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user2");

        DBHelper.save(user1);
        DBHelper.save(user2);
        DBHelper.save(user3);

        Journalist journalist1 = new Journalist("journalist1");
        Journalist journalist2 = new Journalist("journalist2");
        Journalist journalist3 = new Journalist("journalist3");

        DBHelper.save(journalist1);
        DBHelper.save(journalist2);
        DBHelper.save(journalist3);

        Editor editor1 = new Editor("editor1");
        Editor editor2 = new Editor("editor2");
        Editor editor3 = new Editor("editor3");

        DBHelper.save(editor1);
        DBHelper.save(editor2);
        DBHelper.save(editor3);


        Article article1 = new Article("heading1", "subheading1", new GregorianCalendar(2018, 6, 11), Categorisation.CURRENT_AFFAIRS, Approval.APPROVED);
        Article article2 = new Article("heading2", "subheading2", new GregorianCalendar(2018, 7, 12), Categorisation.SPORT, Approval.DENIED);
        Article article3 = new Article("heading3", "subheading3", new GregorianCalendar(2016, 7, 12), Categorisation.FINANCE, Approval.PENDING);

        DBHelper.save(article1);
        DBHelper.save(article2);
        DBHelper.save(article3);

    }

}