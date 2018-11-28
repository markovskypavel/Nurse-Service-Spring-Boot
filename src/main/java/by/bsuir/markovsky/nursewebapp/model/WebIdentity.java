package by.bsuir.markovsky.nursewebapp.model;

import by.bsuir.markovsky.nursewebapp.constant.RegExConstant;
import by.bsuir.markovsky.nursewebapp.model.enumeration.RoleType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Objects;

@ApiModel(description="WebIdentity")
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
@XmlRootElement(name = "WebIdentity")
@XmlType(propOrder = {"id","username","unencryptedPassword","password","email","telephone","roleType","picture","address","identity"})
@XmlSeeAlso({Identity.class, RoleType.class})
@Entity
@Table(name = "WebIdentity")
public class WebIdentity implements Serializable {

    private static final long serialVersionUID = 3276480509050536113L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "webIdentity_id", unique = true, updatable = false)
    private int id;

    @Pattern(regexp = RegExConstant.USERNAME)
    @Column(name = "username", nullable = false)
    private String username;

    @Transient
    @Pattern(regexp = RegExConstant.PASSWORD)
    private String unencryptedPassword;

    @Size(min = 5)
    @Column(name = "password", nullable = false)
    private String password;

    @Pattern(regexp = RegExConstant.EMAIL)
    @Column(name = "email", nullable = false)
    private String email;

    @Pattern(regexp = RegExConstant.TELEPHONE_ALTERNATIVE)
    @Column(name = "telephone")
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleType roleType = RoleType.ROLE_ADMIN;

    @Column(name = "picture")
    private String picture;

    @Pattern(regexp = RegExConstant.ADDRESS)
    @Column(name = "address", nullable = false)
    private String address;

    @Valid
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "identity_id", nullable = false)
    private Identity identity = new Identity();

    public WebIdentity() {
    }
    public WebIdentity(String username, String unencryptedPassword, String email, String telephone, RoleType roleType, String picture, String address, Identity identity) {
        this.username = username;
        this.unencryptedPassword = unencryptedPassword;
        this.email = email;
        this.telephone = telephone;
        this.roleType = roleType;
        this.picture = picture;
        this.address = address;
        this.identity = identity;
    }
    public WebIdentity(WebIdentity webIdentity) {
        this.username = webIdentity.username;
        this.unencryptedPassword = webIdentity.unencryptedPassword;
        this.email = webIdentity.email;
        this.telephone = webIdentity.telephone;
        this.roleType = webIdentity.roleType;
        this.picture = webIdentity.picture;
        this.address = webIdentity.address;
        this.identity = webIdentity.identity;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUnencryptedPassword(String unencryptedPassword) {
        this.unencryptedPassword = unencryptedPassword;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    //Getters
    @XmlElement
    public int getId() {
        return id;
    }
    @XmlElement
    public String getUsername() {
        return username;
    }
    @XmlElement
    public String getUnencryptedPassword() {
        return unencryptedPassword;
    }
    @XmlElement
    public String getPassword() {
        return password;
    }
    @XmlElement
    public String getEmail() {
        return email;
    }
    @XmlElement
    public String getTelephone() {
        return telephone;
    }
    @XmlElement(name = "identity")
    public Identity getIdentity() {
        return identity;
    }
    @XmlElement(name = "roleType")
    public RoleType getRoleType() {
        return roleType;
    }
    @XmlElement
    public String getPicture() {
        return picture;
    }
    @XmlElement
    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebIdentity that = (WebIdentity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(unencryptedPassword, that.unencryptedPassword) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone) &&
                roleType == that.roleType &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(address, that.address) &&
                Objects.equals(identity, that.identity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, username, unencryptedPassword, password, email, telephone, roleType, picture, address, identity);
    }
    @Override
    public String toString() {
        return "WebIdentity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", unencryptedPassword='" + unencryptedPassword + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", roleType=" + roleType +
                ", picture='" + picture + '\'' +
                ", address='" + address + '\'' +
                ", identity=" + identity +
                '}';
    }

}
