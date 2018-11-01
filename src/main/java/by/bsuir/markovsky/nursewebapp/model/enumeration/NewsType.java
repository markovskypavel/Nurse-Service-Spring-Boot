package by.bsuir.markovsky.nursewebapp.model.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "newsType")
@XmlEnum
public enum NewsType {
    @XmlEnumValue("MEDICINE")
    MEDICINE,
    @XmlEnumValue("OTHER")
    OTHER,
    @XmlEnumValue("SERVICE")
    SERVICE
}
