package ru.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class Kettle extends AbstractProduct {


    public Kettle(@Value("${kettle.name}")String name,
                  @Value("${kettle.price}")int price) {
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
