package com.ada.nflow.dp.decorator.prejava8;

public abstract class IceCreamDecorator implements IceCream {
    protected IceCream specialIceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.specialIceCream = iceCream;
    }
}
