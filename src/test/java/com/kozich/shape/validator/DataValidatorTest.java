package com.kozich.shape.validator;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;

public class DataValidatorTest {
    private static final String PATH = "data/resourceFile.txt";
    private static final String INCORRECT_PATH = "data/resource.txt";
    private EllipseFigure figure;
    private PointType firstPoint;
    private PointType secondPoint;
    private static final String CORRECT_POINTS = "(1.2, 3.4), (3.5, 12.6)";

    @BeforeTest
    public void setUp() {
        figure = new EllipseFigure();
        firstPoint = new PointType(2.5, 3.2);
        secondPoint = new PointType(3.3, 9.5);
    }

    @Test
    public void isEllipseFalseTest() {
        boolean actual = DataValidator.isEllipse(figure);
        Assert.assertFalse(actual);
    }

    @Test
    public void isEllipseTrueTest() {
        figure.setFirstPoint(firstPoint);
        figure.setSecondPoint(secondPoint);
        boolean actual = DataValidator.isEllipse(figure);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidFileTest() {
        ClassLoader loader = DataValidatorTest.class.getClassLoader();
        URL filePath = loader.getResource(PATH);
        String currentPath = new File(filePath.getFile()).getAbsolutePath();
        boolean actual = DataValidator.isValidFile(currentPath);
        Assert.assertTrue(actual);
    }

    @Test
    public void isValidFileFalseTest() {
        boolean actual = DataValidator.isValidFile(INCORRECT_PATH);
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidStringFalseTest() {
        boolean actual = DataValidator.isValidString(PATH);
        Assert.assertFalse(actual);
    }

    @Test
    public void isValidStringTrueTest() {
        boolean actual = DataValidator.isValidString(CORRECT_POINTS);
        Assert.assertTrue(actual);
    }
}
