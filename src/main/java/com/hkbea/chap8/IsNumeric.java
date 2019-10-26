package com.hkbea.chap8;

public class IsNumeric implements ValidationStrategy {

    @Override
    public boolean execute(String str) {
        return str.matches("\\d+");
    }

}
