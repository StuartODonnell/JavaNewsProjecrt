package db;

import models.Article;
import models.Categorisation;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.HashSet;
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

    public static List<Article> searchArticlesByHeading(String searchText){
        String revisedSearchText = "%" + searchText.toLowerCase() + "%";
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> foundArticles = null;
        try {
            if (searchText.length() >= 1) {
                Criteria cr = session.createCriteria(Article.class);
                cr.addOrder(Order.desc("date"));
                cr.add(Restrictions.like("heading", revisedSearchText));
                foundArticles = cr.list();
            }
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundArticles;
    }


    public static List<Article> searchArticlesBySubHeading(String searchText){
        String revisedSearchText = "%" + searchText.toLowerCase() + "%";
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> foundArticles = null;
        try {
            if (searchText.length() >= 1) {
                Criteria cr = session.createCriteria(Article.class);
                cr.addOrder(Order.desc("date"));
                cr.add(Restrictions.like("subHeading", revisedSearchText));
                foundArticles = cr.list();
            }
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundArticles;
    }

    public static List<Article> searchArticlesByBody(String searchText){
        String revisedSearchText = "%" + searchText.toLowerCase() + "%";
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> foundArticles = null;
        try {
            if (searchText.length() >= 1) {
                Criteria cr = session.createCriteria(Article.class);
                cr.addOrder(Order.desc("date"));
                cr.add(Restrictions.like("bodyArticle", revisedSearchText));
                foundArticles = cr.list();
            }
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundArticles;
    }

    public static List<Article> returnArticlesByCat(Categorisation category){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> foundArticles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("date"));
            cr.add(Restrictions.eq("categorisation", category));
            foundArticles = cr.list();
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundArticles;
    }

}
