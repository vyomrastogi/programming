package com.practice.programming.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JournalDev {

    public static void main(String[] args) {
        printLineBreak();
        // Reverse String
        reverseString("Hiroshima");
        reverseString("");
        // reverseString(null);
        printLineBreak();
        // Swap numbers
        swapVariables(12, 59);
        printLineBreak();
        // match vowel
        checkVowels("random string");
        checkVowels("tmz");
        printLineBreak();
        // prime check
        checkPrime(12343);
        checkPrime(15);
        checkPrime(19);
        checkPrime(41);
        checkPrime(7865429);
        printLineBreak();
        // fibonacci
        printFibonacci(10);
        printFibonacci(20);
        printLineBreak();
        // fibonacci using stream
        printFibonacciUsingStream(13);
        printFibonacciUsingStream(25);
        printLineBreak();
        //check palindrome
        checkPalindrome("Return");
        checkPalindrome("AruRa");
        checkPalindrome("arura");
        printLineBreak();
        //factorial
        factorial(1);
        factorial(10);
        factorial(15);
        printLineBreak();
    }

    private static void printLineBreak() {
        System.out.println("##################################");
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
        for (int index = chars.length - 1; index >= 0; index--) {
            builder.append(chars[index]);
        }
        System.out.printf("Input: %s , Output: %s %n", input, builder.toString());
    }

    /**
     * Swap two variables without using third variables
     */
    private static void swapVariables(int a, int b) {
        System.out.printf("a:%d swap with b:%d %n", a, b);
        a = a + b; // sum of both
        b = a - b; // a+b-b
        a = a - b; // a+b-(a+b-b)
        System.out.printf("a:%d swapped with b:%d %n", a, b);

    }

    /**
     * validate if string has vowels
     */
    public static void checkVowels(String input) {
        boolean containsVowels = input.toLowerCase().matches(".+[aeiou].+");
        System.out.printf("Does input string : '%s' has any vowel - %b %n", input, containsVowels);
    }

    /**
     * prime check. TODO: can this be optimized?
     */
    public static void checkPrime(long input) {
        boolean isPrime = true;
        if (input <= 1) {
            System.out.printf("%d is not prime %n", input);
            return;
        } else if (input <= 3) {
            System.out.printf("%d is prime %n", input);
            return;
        } else if (input % 2 == 0 || input % 3 == 0) {
            System.out.printf("%d is not prime %n", input);
            return;
        } else {
            for (int i = 5; i * i <= input; i = i + 6) {
                // after 5. validate with +2 to check against 7
                // +6 will give 11, +2 check with 13
                // +6 will give 17, +2 check with 19
                // +6 will give 23
                if (input % i == 0 || input % (i + 2) == 0)
                    isPrime = false;
            }
        }
        if (isPrime)
            System.out.printf("%d is prime %n", input);
        else
            System.out.printf("%d is not prime %n", input);

    }

    /**
     * Fibonacci
     */
    private static void printFibonacci(int limit) {
        int a = 0;
        int b = 1;
        int c = 1;
        List<Integer> fibonacciList = new ArrayList<>();
        for (int i = 0; i <= limit; i++) {
            fibonacciList.add(a);
            a = b;
            b = c;
            c = a + b;
        }
        System.out.printf("Fibonacci : %s %n",
                fibonacciList.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * Fibonacci using stream
     */
    private static void printFibonacciUsingStream(int limit) {
        System.out.printf("Fibonacci from Stream: %s %n", fibonacciString(limit));
    }

    private static String fibonacciString(int limit) {
        return Stream
                .iterate(new long[] { 0, 1 },
                        previousPair -> new long[] { previousPair[1], previousPair[0] + previousPair[1] })
                .limit(limit)//limit iterations
                .map(pair -> pair[0]) //get 0th element from pair
                .map(String::valueOf) // conver to string
                .collect(Collectors.joining(",")); // comma separated 
    }

    /**
     * Palindrome String
     */
    private static void checkPalindrome(String input){
        char[] inputChars = input.toCharArray();
        for(int i = 0 ; i<inputChars.length/2; i++){
            if(inputChars[i]!=inputChars[inputChars.length-1-i]){
                System.out.printf("input string '%s' is not a palindrome %n",input);
                return;
            }                
        }
        System.out.printf("input string '%s' is a palindrome %n",input);
    }

    /**
     * Factorial
     */
    private static void factorial(int input){
        int fact = input==1 ? 1 : IntStream.range(1, input).reduce(1,(i,j)->i*j);
        System.out.printf("Factorial of '%d' = %d %n",input,fact);
    }

}
