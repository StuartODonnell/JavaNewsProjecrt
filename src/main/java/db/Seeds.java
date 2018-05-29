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

        DBHelper.save(journalist1);
        DBHelper.save(journalist2);
        DBHelper.save(journalist3);

        Article article1 = new Article("heading1", "subheading1", "bodytext1", new GregorianCalendar(2018, 6, 11), Categorisation.CURRENT_AFFAIRS, journalist1);
        Article article2 = new Article("heading2", "subheading2", "bodytext2", new GregorianCalendar(2018, 7, 12), Categorisation.SPORT, journalist1);
        Article article3 = new Article("heading3", "subheading3", "bodytext3", new GregorianCalendar(2016, 7, 12), Categorisation.FINANCE, journalist1);
        Article article4 = new Article("heading4", "subheading4", "bodytext4", new GregorianCalendar(2016, 7, 12), Categorisation.FINANCE, journalist1);
        Article article5 = new Article("heading5", "subheading5", "bodytext5", new GregorianCalendar(2016, 7, 12), Categorisation.FINANCE, journalist1);


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
