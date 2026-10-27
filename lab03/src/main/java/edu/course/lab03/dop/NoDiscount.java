package edu.course.lab03.dop;

public class NoDiscount implements DiscountPolicy {
    @Override
    public double apply(double price) {
        return price;
    }
}
