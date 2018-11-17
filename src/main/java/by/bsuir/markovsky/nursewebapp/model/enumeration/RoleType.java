package by.bsuir.markovsky.nursewebapp.model.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "roleType")
public enum RoleType {
    @XmlEnumValue("ROLE_ADMIN")
    ROLE_ADMIN,
    @XmlEnumValue("ROLE_NURSE")
    ROLE_NURSE,
    @XmlEnumValue("ROLE_USER")
    ROLE_USER
}
