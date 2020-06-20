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
        Country country1 = new Country(new BigDecimal("1012222222000"));
        Country country2 = new Country(new BigDecimal("2000000"));
        Country country3 = new Country(new BigDecimal("3000000"));
        Country country4 = new Country(new BigDecimal("4000000"));
        Country country5 = new Country(new BigDecimal("5000000"));
        Country country6 = new Country(new BigDecimal("6000000"));

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
        BigDecimal expectedPeople = new BigDecimal("1012242222000");
        Assert.assertEquals(expectedPeople, totalPeople);
        System.out.println("Test OK");

    }
}
