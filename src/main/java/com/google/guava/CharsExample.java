package com.google.guava;

import com.google.common.primitives.Chars;

import java.util.List;

public class CharsExample {
    public static void main(String[] args) {
        CharsExample tester = new CharsExample();
        tester.testChars();
    }

    private void testChars() {
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};

        // convert array of primitives to array of objects
        List<Character> objectArray = Chars.asList(charArray);
        System.out.println(objectArray.toString());

        // convert array of objects to array of primitives
        charArray = Chars.toArray(objectArray);
        System.out.print("[ ");

        for (char c : charArray) {
            System.out.print(c + " ");
        }

        System.out.println("]");

        // check if element is present in the list of primitives or not
        System.out.println("c is in list? " + Chars.contains(charArray, 'c'));

        // return the index of element
        System.out.println("c position in list " + Chars.indexOf(charArray, 'c'));

        // Returns the minimum
        System.out.println("Min: " + Chars.min(charArray));

        // Returns the maximum
        System.out.println("Max: " + Chars.max(charArray));
    }
}
