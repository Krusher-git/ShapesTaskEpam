package com.kozich.shape.service.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.service.EllipseParameterService;
import com.kozich.shape.service.EllipseStatService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EllipseStatServiceImplTest {
    private double[] points;
    private EllipseStatService service;
    private EllipseFigure figure;
    private PointType firstPoint;
    private PointType secondPoint;

    @BeforeTest
    public void setUp() {
        points = new double[]{1, 2, 3, 4};
        firstPoint = new PointType(1, 2);
        secondPoint = new PointType(3, 4);
        figure = new EllipseFigure(firstPoint, secondPoint);
        service = new EllipseStatServiceImpl();
    }

    @Test
    public void isCircleTest() {
        boolean actual = service.isCircle(figure);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void isEllipseTest() {
        boolean actual = service.isEllipse(figure);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void crossesAnyAxisTest() {
        boolean actual = service.crossesAnyAxis(figure);
        boolean expected = false;
        Assert.assertEquals(actual, expected);
    }
}
