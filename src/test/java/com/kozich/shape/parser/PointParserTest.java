package com.kozich.shape.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PointParserTest {
    private PointParser pointParser;
    private final String POINTS_STRING = "(1.0, 2.3), (4.5, 8.4)";
    private final String INCORRECT_POINTS_STRING = "(1.0, 2.3), (4.5, 8.4, 12.2)";
    private final double[] expected = {1.0, 2.3, 4.5, 8.4};

    @BeforeTest
    public void setUp() {
        pointParser = new PointParser();
    }

    @Test
    public void receivePointsArrayTest() {
        double[] actualArray;
        actualArray = pointParser.receivePointsArray(POINTS_STRING);
        Assert.assertEquals(actualArray, expected);
    }

    @Test
    public void receivePointsArrayNullTest() {
        double[] actualArray;
        actualArray = pointParser.receivePointsArray(INCORRECT_POINTS_STRING);
        Assert.assertNull(actualArray);
    }
}
