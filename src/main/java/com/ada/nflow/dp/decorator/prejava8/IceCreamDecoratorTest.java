package com.ada.nflow.dp.decorator.prejava8;

public class IceCreamDecoratorTest {
    public static void main(String s[]) {
        IceCream iceCream =
                new NuttyIceCream(new HoneyIceCream(new SimpleIceCream()));
        System.out.println(iceCream.makeIceCream());
    }
}
