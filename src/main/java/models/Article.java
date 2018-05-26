package models;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articles")
public class Article {
    private int id;
    private Set<Journalist> journalists;
    private String heading;
    private String subHeading;
    private String bodyArticle;
    private GregorianCalendar date;
    private Categorisation categorisation;
    private Approval approval;

    public Article(String heading, String subHeading, String bodyArticle, GregorianCalendar date, Categorisation categorisation) {
        this.heading = heading;
        this.subHeading = subHeading;
        this.bodyArticle = bodyArticle;
        this.date = date;
        this.categorisation = categorisation;
        this.approval = Approval.PENDING;
        journalists = new HashSet<>();
    }

    public Article() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "article_journalist",
            joinColumns = {@JoinColumn(name = "journalist_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn (name ="article_id", nullable = false, updatable = false)})
    public Set<Journalist> getJournalist() {
        return journalists;
    }

    public void setJournalist(Set<Journalist> journalist) {
        this.journalists = journalist;
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

    @Enumerated(EnumType.STRING)
    public Categorisation getCategorisation() {
        return categorisation;
    }

    public void setCategorisation(Categorisation categorisation) {
        this.categorisation = categorisation;
    }

    @Enumerated(EnumType.STRING)
    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    //adds journalist object to journalist hash
    public void addJournalist(Journalist journalist){
        journalists.add(journalist);
    }
}
