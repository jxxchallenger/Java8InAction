package com.hkbea.chap8;

import java.util.function.Predicate;

public class StrategyMain {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        System.out.println(numericValidator.validate("abc"));
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        System.out.println(lowerCaseValidator.validate("abc"));
        
        Predicate<String> numericPredicate = str -> str.matches("[a-z]+");
        System.out.println(numericPredicate.test("abc"));
        
    }
    
    private static class Validator{
        
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            super();
            this.strategy = strategy;
        }
        
        public boolean validate(String str) {
            return strategy.execute(str);
        }
    }

}
