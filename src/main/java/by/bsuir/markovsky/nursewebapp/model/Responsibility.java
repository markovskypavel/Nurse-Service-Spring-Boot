package by.bsuir.markovsky.nursewebapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Objects;

@XmlRootElement(name = "Responsibility")
@XmlType(propOrder = {"name"})
@Entity
@Table(name = "Responsibility")
public class Responsibility implements Serializable {

    private static final long serialVersionUID = -5791649674467717879L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "responsibility_id", unique = true, updatable = false)
    private int id;
    @Column(name = "name", unique = true)
    private String name;

    public Responsibility() {
    }
    public Responsibility(String name) {
        this.name = name;
    }
    public Responsibility(Responsibility responsibility) {
        this.name = responsibility.name;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    @XmlTransient
    public int getId() {
        return id;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsibility that = (Responsibility) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override
    public String toString() {
        return "Responsibility{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
