package io.jxxchallenger.chap10;

import java.util.Optional;

public class OptionalMain {

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
    }
}
