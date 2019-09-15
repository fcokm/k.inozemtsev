package ru.job4j.model.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import javax.persistence.*;


@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
@JsonIgnoreProperties({"cars"})
@Entity
@Table(name = "years")
public class Year {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

}