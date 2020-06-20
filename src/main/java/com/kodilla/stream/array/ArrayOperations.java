

package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        /*IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);*/
        //tworzę zmienną average, tworzę strumień elementów typu int o zakresach numerów od 0 do numbers.length
        double average = IntStream.range(0, numbers.length)
                //dokonuję transformacji, do każdego numeru przypisany jest numer z tablicy numers
                .map(n -> numbers[n])
                // liczona jest średnia z elementów tablicy numbers
                .average();
        return average;

    }
}


