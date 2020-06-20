package com.kodilla.stream.world;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country country1 = new Country();
        Country country2 = new Country();
        Country country3 = new Country();
        Country country4 = new Country();
        Country country5 = new Country();
        Country country6 = new Country();

        Continent continent1 = new Continent();
        continent1.addCuntry(country1);
        continent1.addCuntry(country2);
        continent1.addCuntry(country3);

        Continent continent2 = new Continent();
        continent2.addCuntry(country4);
        continent2.addCuntry(country5);
        continent2.addCuntry(country6);

        World word = new World();
        word.addContinent(continent1);
        word.addContinent(continent2);

        //When
        BigDecimal totalPeople = word.getPeopleQuantity();

        //Then
        BigDecimal expectedPeople = new BigDecimal("600000000");
        Assert.assertEquals(expectedPeople, totalPeople);
        System.out.println("Test OK");

    }
}
