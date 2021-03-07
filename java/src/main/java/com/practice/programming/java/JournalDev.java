package com.practice.programming.java;

import java.util.Objects;

public class JournalDev {

    public static void main(String[] args) {
        //Reverse String
        reverseString("Hiroshima");
        reverseString("");
        //reverseString(null);

        // Swap numbers 
        swapVariables(12, 59);


    }

    /**
     * Reverse a given string
     */
    private static void reverseString(String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException("input can not be null");
        }

        char[] chars = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        for(int index=chars.length-1; index>=0;index--){
                builder.append(chars[index]);
        }
        System.out.printf("Input: %s , Output: %s /n",input, builder.toString());
    }

    /**
     * Swap two variables without using third variables
     */
    private static void swapVariables(int a, int b){
        System.out.printf("a:%d swap with b:%d \n",a,b);
        a = a + b; // sum of both
        b = a - b; // a+b-b
        a = a - b; // a+b-(a+b-b)
        System.out.printf("a:%d swapped with b:%d \n",a,b);

    }
}
