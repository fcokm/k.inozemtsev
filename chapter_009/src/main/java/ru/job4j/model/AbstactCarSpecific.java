package ru.job4j.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstactCarSpecific {
    @Id
    @GeneratedValue
    @Column(name = "id")
     protected int id;
     protected String name;
}
