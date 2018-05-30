package db;

import models.*;
import db.DBHelper;
import sun.jvm.hotspot.ui.Editor;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

public class Seeds {


    public static void seedData() {


        Journalist journalist1 = new Journalist("Stuart","journalist1");
        Journalist journalist2 = new Journalist("Kelsie", "journalist2");
        Journalist journalist3 = new Journalist("Upul", "journalist3");
        Journalist journalist4 = new Journalist("Alan", "journalist4");
        Journalist journalist5 = new Journalist("Ally", "journalist5");
        Journalist journalist6 = new Journalist("Alistair", "journalist6");


        DBHelper.save(journalist1);
        DBHelper.save(journalist2);
        DBHelper.save(journalist3);
        DBHelper.save(journalist4);
        DBHelper.save(journalist5);
        DBHelper.save(journalist6);

        Article article1 = new Article("Dolphin 'happiness' measured by scientists in France", "Scientists working with dolphins at a marine park near Paris have attempted to measure how the animals feel about aspects of their lives in captivity.", "In what researchers say is the first project to examine captivity from the animals' perspective, the team assessed what activities dolphins looked forward to most.They found that the marine mammals most keenly anticipated interacting with a familiar human.The results, they say, show that better human-animal bonds equals better welfareThe study, published in the journal Applied Animal Behaviour Science, was part of a three-year project to measure dolphin welfare in a captive setting.Lead researcher Dr Isabella Clegg worked at Parc Astérix, a theme park with one of France's largest dolphinariums. With colleagues at the University of Paris animal behaviour lab, she designed experiments to decode dolphin behaviour - essentially looking for physical postures that indicate how the animals were feeling.", new GregorianCalendar(2018, 6, 11), Categorisation.SCIENCE_NATURE, journalist1);
        Article article2 = new Article("GUMTREE BUY BAZAAR", "Revolutionary new website Bazaar bought by global giant gumtree", "Codeclan students Sarah and Ed wrote a much better version of gumtree in a week and gumtree out of shame have bought it", new GregorianCalendar(2018, 7, 12), Categorisation.FINANCE, journalist1);
        Article article3 = new Article("Super Upul set to return to Glasgow", "Students revolt and bring to bring back super Upul", "Super Upul is set to make a comeback to the Glasgow Campus of CodeClan following an uproar from Glasgow's G5 class. The decision was made to bring him back after instructors Alan, Ally and Alistair got sick of the Super Upul emoji on Slack", new GregorianCalendar(2016, 7, 12), Categorisation.CURRENT_AFFAIRS, journalist1);
        Article article4 = new Article("Welsh Women with Migrane wakes up with Chinese Accent", "Doctors are baffled", "Kelsie is baffled because she didn't know this is a thing. Stuart says this is remarkably common.", new GregorianCalendar(2016, 7, 12), Categorisation.CURRENT_AFFAIRS, journalist1);
        Article article5 = new Article("Dragon sighted in Glasgow", "Rumors have emerged that a Dragon has been sighted in Glasgow city centre. ", "Don't worry though, the dragon has been slayed by nobel steed Scott.", new GregorianCalendar(2016, 7, 12), Categorisation.CURRENT_AFFAIRS, journalist1);


        DBHelper.save(article1);
        DBHelper.save(article2);
        DBHelper.save(article3);
        DBHelper.save(article4);
        DBHelper.save(article5);






//        List<Article> articlesbyJournalist = DBHelper.findArticlesByJournalist(journalist2);
//        List<Journalist> journalistsbyArticle = DBHelper.findJournalistforArticles(article1);

//        List<Article> sortedArticles = DBArticle.returnArticlesinDescOrder();
//        List<Article>  unapprovedArticles = DBJournalist.unapprovedArticlesList();
//        List<Article> testSearchArticles = DBArticle.searchArticlesByHeading("head");
//        List<Article> testSearchArticlesCapitalised = DBArticle.searchArticlesByHeading("Head");
//        List<Journalist> testSearchJounalists = DBJournalist.searchJournalistByUserName("jour");
//        List<Journalist> testSearchJounalistsCapitalised = DBJournalist.searchJournalistByUserName("Jour");
//
//
//        List<Article> testSearchArticlesBySubHeading = DBArticle.searchArticlesBySubHeading("sub");
//        List<Article> testSearchArticlesBySubHeadingCaps = DBArticle.searchArticlesBySubHeading("Sub");
//
//
//        List<Article> testSearchArticlesByBody = DBArticle.searchArticlesByBody("ody");
//        List<Article> testSearchArticlesByBodyCaps = DBArticle.searchArticlesByBody("Ody");
//
//        List<Article> currentAffairsArticles = DBArticle.returnArticlesByCat(Categorisation.CURRENT_AFFAIRS);
//        List<Article> sportArticles = DBArticle.returnArticlesByCat(Categorisation.SPORT);
//        List<Article> scienceandNatureArticles = DBArticle.returnArticlesByCat(Categorisation.SCIENCE_NATURE);
//        List<Article> financeArticles = DBArticle.returnArticlesByCat(Categorisation.FINANCE);
//        List<Article> politicsArticles = DBArticle.returnArticlesByCat(Categorisation.POLITICS);


    }

}
