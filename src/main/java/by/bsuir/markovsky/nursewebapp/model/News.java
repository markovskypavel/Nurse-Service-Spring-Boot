package by.bsuir.markovsky.nursewebapp.model;

import by.bsuir.markovsky.nursewebapp.model.enumeration.NewsType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@ApiModel(description="News")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@XmlRootElement(name = "News")
@XmlType(propOrder = {"id","title","article","type","date","picture","webIdentity"})
@XmlSeeAlso({WebIdentity.class, NewsType.class})
@Entity
@Table(name = "News")
public class News implements Serializable {

    private static final long serialVersionUID = -2618259653794795434L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id", unique = true, updatable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "article", nullable = false)
    private String article;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private NewsType type = NewsType.SERVICE;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private Date date = new Date();

    @Column(name = "picture")
    private String picture;

    @Valid
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "webIdentity_id", nullable = false)
    private WebIdentity webIdentity;

    public News() {
    }
    public News(String title, String article, NewsType type, Date date, String picture, WebIdentity webIdentity) {
        this.title = title;
        this.article = article;
        this.type = type;
        this.date = date;
        this.picture = picture;
        this.webIdentity = webIdentity;
    }
    public News(News news) {
        this.title = news.title;
        this.article = news.article;
        this.type = news.type;
        this.date = news.date;
        this.picture = news.picture;
        this.webIdentity = news.webIdentity;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArticle(String article) {
        this.article = article;
    }
    public void setType(NewsType type) {
        this.type = type;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setWebIdentity(WebIdentity webIdentity) {
        this.webIdentity = webIdentity;
    }

    //Getters
    @XmlElement
    public int getId() {
        return id;
    }
    @XmlElement
    public String getTitle() {
        return title;
    }
    @XmlElement
    public String getArticle() {
        return article;
    }
    @XmlElement(name = "newsType")
    public NewsType getType() {
        return type;
    }
    @XmlElement
    public Date getDate() {
        return date;
    }
    @XmlElement
    public String getPicture() {
        return picture;
    }
    @XmlElement(name = "webIdentity")
    public WebIdentity getWebIdentity() {
        return webIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                Objects.equals(title, news.title) &&
                Objects.equals(article, news.article) &&
                type == news.type &&
                Objects.equals(date, news.date) &&
                Objects.equals(picture, news.picture) &&
                Objects.equals(webIdentity, news.webIdentity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, title, article, type, date, picture, webIdentity);
    }
    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", type=" + type +
                ", date=" + date +
                ", picture='" + picture + '\'' +
                ", webIdentity=" + webIdentity +
                '}';
    }

}
