package by.bsuir.markovsky.nursewebapp.model.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "serviceStatusType")
public enum ServiceStatusType {
    @XmlEnumValue("FREE")
    FREE,
    @XmlEnumValue("CLOSED")
    CLOSED
}
