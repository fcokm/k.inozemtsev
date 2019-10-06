package ru.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Pizza extends AbstractProduct {
  private short size;

    public Pizza(String name, int price, short size) {
        super(name, price);
        this.size = size;
    }


    public Pizza(String name, int price) {
        super(name, price);
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    @Override
    public int calcCostDelivery() {
        return this.size > 50 ? 0 :10;
    }

    @Override
    public String toString() {
        return String.format(" %s %d %d", name, size, price);
    }
}
