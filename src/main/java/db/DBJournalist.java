package db;

import models.Approval;
import models.Article;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
}
