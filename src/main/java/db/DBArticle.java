package db;

import models.Article;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.util.List;
import java.util.Set;

public class DBArticle {

    private static Transaction transaction;
    private static Session session;

    public static List<Article> returnArticlesinDescOrder(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> sortedArticles = null;
        try {Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("date"));
            sortedArticles = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        } return sortedArticles;
    }
}
