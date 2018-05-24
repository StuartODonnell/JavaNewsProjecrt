package models;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {

    private int id;
    private Set<String> journalist;
    private String heading;
    private String subHeading;
    private String bodyArticle;
    private GregorianCalendar date;
    private Categorisation categorisation;
    private Approval approval;

    public Article() {
    }

    public Article(String heading, String subHeading, String bodyArticle, GregorianCalendar date, Categorisation categorisation, Approval approval) {
        this.heading = heading;
        this.subHeading = subHeading;
        this.bodyArticle = bodyArticle;
        this.date = date;
        this.categorisation = categorisation;
        this.approval = approval;
    }
@Id
@GeneratedValue
@Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<String> getJournalist() {
        return journalist;
    }

    public void setJournalist(Set<String> journalist) {
        this.journalist = journalist;
    }
@Column(name = "journalist")
    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }
@Column(name = "sub_heading")
    public String getSubHeading() {
        return subHeading;
    }

    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
    }
@Column(name="body_article")
    public String getBodyArticle() {
        return bodyArticle;
    }

    public void setBodyArticle(String bodyArticle) {
        this.bodyArticle = bodyArticle;
    }
@Column(name = "article_date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Categorisation getCategorisation() {
        return categorisation;
    }

    public void setCategorisation(Categorisation categorisation) {
        this.categorisation = categorisation;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }
}
