package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException{
        if(i == 0)
            return 1;
        if(i < 0){
            throw new IllegalArgumentException("Must be positive number.");
        }
        int result = i;
        for(int count = i-1; count>0;count--){
            result *= count;
        }
        return result;
    }
}
