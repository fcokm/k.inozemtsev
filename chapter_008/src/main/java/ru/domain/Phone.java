package ru.domain;

import org.springframework.stereotype.Component;

@Component
public class Phone extends AbstractProduct {

    public Phone(String name, int price) {
        super(name, price);
    }

    @Override
    public int calcCostDelivery() {
        return price >= 500 ? 0: 20;
    }

    @Override
    public String toString() {
        return String.format(" %s %d ",name, price);
    }
}
