package com.ada.nflow.dp.decorator.prejava8;

public class HoneyIceCream extends IceCreamDecorator {
    public HoneyIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String makeIceCream() {
        return specialIceCream.makeIceCream() + addHoney();
    }

    private String addHoney() {
        return " + sweet honey";
    }
}
