package com.ada.nflow.dp.decorator.prejava8;

public class NuttyIceCream extends IceCreamDecorator {

    public NuttyIceCream(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public String makeIceCream() {
        return specialIceCream.makeIceCream() + addNuts();
    }

    private String addNuts() {
        return " + cruncy nuts";
    }
}
