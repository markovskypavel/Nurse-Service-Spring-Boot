package by.bsuir.markovsky.nursewebapp.model.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ratingType")
@XmlEnum
public enum RatingType {
    @XmlEnumValue("FIVE")
    FIVE,
    @XmlEnumValue("FOUR")
    FOUR,
    @XmlEnumValue("THREE")
    THREE,
    @XmlEnumValue("TWO")
    TWO,
    @XmlEnumValue("ONE")
    ONE
}
