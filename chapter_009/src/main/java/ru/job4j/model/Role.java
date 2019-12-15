package ru.job4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "role_name")
    private  String name;

}
