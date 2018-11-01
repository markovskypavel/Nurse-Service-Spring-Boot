package by.bsuir.markovsky.nursewebapp.model;

import by.bsuir.markovsky.nursewebapp.model.enumeration.RatingType;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name = "Nurse")
@XmlType(propOrder = {"experience","ratingType","webIdentity","responsibility"})
@XmlSeeAlso({WebIdentity.class, RatingType.class, Responsibility.class})
@Entity
@Table(name = "Nurse")
public class Nurse implements Serializable {

    private static final long serialVersionUID = 568107831573889513L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurse_id", unique = true, updatable = false)
    private int id;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating")
    private RatingType ratingType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "webIdentity_id", nullable = false)
    private WebIdentity webIdentity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "responsibility_id", nullable = false)
    private Responsibility responsibility;

    public Nurse() {
    }
    public Nurse(int experience, RatingType ratingType, WebIdentity webIdentity, Responsibility responsibility) {
        this.experience = experience;
        this.ratingType = ratingType;
        this.webIdentity = webIdentity;
        this.responsibility = responsibility;
    }
    public Nurse(Nurse nurse) {
        this.experience = nurse.experience;
        this.ratingType = nurse.ratingType;
        this.webIdentity = nurse.webIdentity;
        this.responsibility = nurse.responsibility;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setRatingType(RatingType ratingType) {
        this.ratingType = ratingType;
    }
    public void setWebIdentity(WebIdentity webIdentity) {
        this.webIdentity = webIdentity;
    }
    public void setResponsibility(Responsibility responsibility) {
        this.responsibility = responsibility;
    }

    //Getters
    @XmlTransient
    public int getId() {
        return id;
    }
    @XmlElement
    public int getExperience() {
        return experience;
    }
    @XmlElement(name = "ratingType")
    public RatingType getRatingType() {
        return ratingType;
    }
    @XmlElement(name = "webIdentity")
    public WebIdentity getWebIdentity() {
        return webIdentity;
    }
    @XmlElement(name = "responsibility")
    public Responsibility getResponsibility() {
        return responsibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return id == nurse.id &&
                experience == nurse.experience &&
                ratingType == nurse.ratingType &&
                Objects.equals(webIdentity, nurse.webIdentity) &&
                Objects.equals(responsibility, nurse.responsibility);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, experience, ratingType, webIdentity, responsibility);
    }
    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", experience=" + experience +
                ", ratingType=" + ratingType +
                ", webIdentity=" + webIdentity +
                ", responsibility=" + responsibility +
                '}';
    }

}
