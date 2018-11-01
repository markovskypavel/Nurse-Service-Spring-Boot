package by.bsuir.markovsky.nursewebapp.model.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "roleType")
@XmlEnum
public enum RoleType {
    @XmlEnumValue("ADMIN")
    ADMIN,
    @XmlEnumValue("NURSE")
    NURSE,
    @XmlEnumValue("USER")
    USER
}
