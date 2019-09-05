package ru.job4j.model;

import lombok.Data;
import java.sql.Timestamp;


@Data
public class Item {
    private int id;
    private String name;
    private Timestamp created;
    private boolean done;
}
