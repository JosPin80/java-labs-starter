package edu.course.lab03.dop;

public class PriceCalculator {
    private final DiscountPolicy policy;

    public PriceCalculator(DiscountPolicy policy) {

        this.policy = policy;
    }

    public double calculate(double price) {
        return policy.apply(price);
    }
}
