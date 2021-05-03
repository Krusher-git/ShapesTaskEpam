package com.kozich.shape.service.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.service.EllipseParameterService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EllipseParameterServiceImplTest {
    private double[] points;
    private EllipseParameterService service;
    private EllipseFigure figure;
    private PointType firstPoint;
    private PointType secondPoint;

    @BeforeTest
    public void setUp() {
        points = new double[]{1, 2, 3, 4};
        firstPoint = new PointType(1, 2);
        secondPoint = new PointType(3, 4);
        figure = new EllipseFigure(firstPoint, secondPoint);
        service = new EllipseParameterServiceImpl();
    }

    @Test
    public void calculatePerimeterTest() throws EllipseException {
        double actual = service.calculatePerimeter(figure);
        double expected = 2 * Math.PI;
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void calculateAreaTest() throws EllipseException {
        double actual = service.calculateArea(figure);
        double expected = Math.PI;
        Assert.assertEquals(actual, expected);
    }
}
