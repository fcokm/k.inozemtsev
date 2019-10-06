package ru.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



@Component
public class AnnotationApp {

    @Autowired
    @Qualifier("phone")
    private AbstractProduct product;

    public int processOrder(){
        return product.calcCostDelivery();
    }
}
