package by.bsuir.markovsky.nursewebapp.model;

import by.bsuir.markovsky.nursewebapp.model.enumeration.ServiceStatusType;
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

@ApiModel(description="NurseOrder")
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
@XmlRootElement(name = "NurseOrder")
@XmlType(propOrder = {"id","expireDate","description","status","nurse","webIdentity"})
@XmlSeeAlso({WebIdentity.class, Nurse.class, ServiceStatusType.class})
@Entity
@Table(name = "NurseOrder")
public class NurseOrder implements Serializable {

    private static final long serialVersionUID = -9166808964898547686L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nurseOrder_id", unique = true, updatable = false)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "expireDate", nullable = false)
    private Date expireDate = new Date();

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ServiceStatusType status = ServiceStatusType.FREE;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST})
    @JoinColumn(name = "nurse_id", nullable = false)
    private Nurse nurse;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.PERSIST})
    @JoinColumn(name = "webIdentity_id")
    private WebIdentity webIdentity;

    public NurseOrder() {
    }
    public NurseOrder(Date expireDate, String description, ServiceStatusType status, Nurse nurse, WebIdentity webIdentity) {
        this.expireDate = expireDate;
        this.description = description;
        this.status = status;
        this.nurse = nurse;
        this.webIdentity = webIdentity;
    }
    public NurseOrder(NurseOrder nurseOrder) {
        this.expireDate = nurseOrder.expireDate;
        this.description = nurseOrder.description;
        this.status = nurseOrder.status;
        this.nurse = nurseOrder.nurse;
        this.webIdentity = webIdentity;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(ServiceStatusType status) {
        this.status = status;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
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
    public Date getExpireDate() {
        return expireDate;
    }
    @XmlElement
    public String getDescription() {
        return description;
    }
    @XmlElement(name = "serviceStatusType")
    public ServiceStatusType getStatus() {
        return status;
    }
    @XmlElement(name = "nurse")
    public Nurse getNurse() {
        return nurse;
    }
    @XmlElement(name = "webIdentity")
    public WebIdentity getWebIdentity() {
        return webIdentity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NurseOrder that = (NurseOrder) o;
        return id == that.id &&
                Objects.equals(expireDate, that.expireDate) &&
                Objects.equals(description, that.description) &&
                status == that.status &&
                Objects.equals(nurse, that.nurse) &&
                Objects.equals(webIdentity, that.webIdentity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, expireDate, description, status, nurse, webIdentity);
    }
    @Override
    public String toString() {
        return "NurseOrder{" +
                "id=" + id +
                ", expireDate=" + expireDate +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", nurse=" + nurse +
                ", webIdentity=" + webIdentity +
                '}';
    }

}
