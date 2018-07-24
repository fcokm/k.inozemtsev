package ru.job4j.jdbc;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.NONE)
 public  class Entry {

    @XmlElement(name = "entry")
    private List<Field> fields = new ArrayList<>();

    public Entry() {
    }

    public Entry(List<Field> values) {
        this.fields = values;
    }

    public List<Field> getValues() {
        return fields;
    }

    public void setValues(List<Field> values) {
        this.fields = values;
    }
}
