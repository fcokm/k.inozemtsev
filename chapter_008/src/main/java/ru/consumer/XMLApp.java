package ru.consumer;

import ru.domain.AbstractProduct;

public class XMLApp {

    private AbstractProduct product;

    public void setProduct(AbstractProduct product){
        this.product = product;
    }

    public int processMessage(){
        System.out.println(product +" "+ product.calcCostDelivery());
        return product.calcCostDelivery();
    }
}
