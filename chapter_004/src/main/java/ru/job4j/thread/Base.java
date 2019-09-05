package ru.job4j.thread;

import java.util.Objects;

public class Base {
    private int id;
    private  int version = 1;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public Base(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public Base nextVersion() {
        this.version++;
        for (int i = 0; i < 1_000; i++) {
            double r = Math.tan(Double.valueOf(i));
        }

        return this;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getVersion() {
        return version;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Base base = (Base) o;
        return id == base.id &&
                version == base.version &&
                Objects.equals(name, base.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, version, name);
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %d, Version: %d, Name: %s",
                id,  version , name);
    }
}