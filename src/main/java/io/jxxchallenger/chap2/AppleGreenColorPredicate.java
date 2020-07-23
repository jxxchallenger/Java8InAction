package io.jxxchallenger.chap2;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }

}

