/*
 * Question: 3: For a given set of string, print the largest string.
 * {"apple","mango","banana"}
 */

public class f_largestString {
    public static void main(String[] args) {
        String fruits[] = {"apple","bannane","mango"};
        String largest = fruits[0]; // inilizse.
        for (int i = 0; i < fruits.length; i++) {
            if(largest.compareTo(fruits[i])<0) {
                largest = fruits[i];
            }
        }
        System.out.println("Largest is: "+largest); // mango.
    }
}
