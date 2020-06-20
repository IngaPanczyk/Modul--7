package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite implements ArrayOperations {
    @Test
    public void testGetAverage() {
        //Given
        //tworzę tablicę numerów
        int[] numbers = new int[20];
        //w pętli wypełniam ją liczbami od 1-20
        for (int i = 0; i < 20; i++)
            numbers[i] = i + 1;
        //When
        //Wywołuję metodę getAverage na obiekcie numbers
        double average = getAverage(numbers);
        //Then
        //Sprawdzam policzoną średnią
        Assert.assertEquals(3.0,average,0);
    }
}
