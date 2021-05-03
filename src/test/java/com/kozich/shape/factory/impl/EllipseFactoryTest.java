package com.kozich.shape.factory.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.factory.ShapeFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class EllipseFactoryTest {
    private ShapeFactory factory;
    private double[] points;
    private EllipseFigure figure;
    private PointType firstPoint;
    private PointType secondPoint;

    @BeforeTest
    public void setUp() {
        factory = new EllipseFactory();
        points = new double[]{1, 2, 3, 4};
        figure = new EllipseFigure();
        firstPoint = new PointType(1, 2);
        secondPoint = new PointType(3, 4);
    }

    @Test
    public void createEllipseTest() throws EllipseException {
        figure.setFirstPoint(firstPoint);
        figure.setSecondPoint(secondPoint);
        EllipseFigure ellipse = factory.createEllipse(points);
        Assert.assertEquals(ellipse, figure);
    }
}