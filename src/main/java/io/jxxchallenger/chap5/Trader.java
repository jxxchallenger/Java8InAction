package io.jxxchallenger.chap5;

public class Trader {
    private String name;

    private String city;

    public Trader(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader:"+this.name + " in " + this.city;
    }
    
}