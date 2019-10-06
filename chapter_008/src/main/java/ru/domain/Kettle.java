package ru.domain;


import org.springframework.stereotype.Component;

@Component
public class Kettle extends AbstractProduct {

    public Kettle(String name, int price) {
        super(name, price);
    }

    @Override
    public int calcCostDelivery() {
        return price >= 100 ? 0: 20;
    }
    @Override
    public String toString() {
        return String.format(" %s %d ",name, price);
    }
}
