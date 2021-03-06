package db;

import controllers.ArticleController;
import models.Approval;
import models.Article;
import models.Categorisation;
import models.Journalist;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBJournalist {


    private static Transaction transaction;
    private static Session session;


    public static List<Article> unapprovedArticlesList() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> unapprovedArticlesList = null;
        try { Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.eq("approval", Approval.PENDING));
            unapprovedArticlesList = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return unapprovedArticlesList;
    }


    public static List<Journalist> searchJournalistByUserName(String searchText){
        String revisedSearchText = "%" + searchText.toLowerCase() + "%";
        session = HibernateUtil.getSessionFactory().openSession();
        List<Journalist> foundJournalists = null;
        try {
            if (searchText.length() >= 1) {
                Criteria cr = session.createCriteria(Journalist.class);
                cr.add(Restrictions.ilike("username", revisedSearchText));
                foundJournalists = cr.list();
            }
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundJournalists;
    }
  
    public static List<Journalist> returnListofActiveJournalists(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Journalist> foundJournalists = null;
        try {
            Criteria cr = session.createCriteria(Journalist.class);
            cr.add(Restrictions.eq("active", true));
            foundJournalists = cr.list();
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return foundJournalists;
    }

  public static Journalist findJournalistByName(String searchName){
     session = HibernateUtil.getSessionFactory().openSession();
     Journalist journalist = null;

       try { transaction = session.beginTransaction();
           Criteria cr = session.createCriteria(Journalist.class);
           cr.add(Restrictions.eq("name", searchName));
           journalist = (Journalist) cr.uniqueResult();
           transaction.commit();
       } catch (HibernateException e ){
           e.printStackTrace();
       } finally {
           session.close();
       }
       return journalist;


}

}
