package com.kozich.shape.factory.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.factory.ShapeFactory;


public class EllipseFactory extends ShapeFactory {
    private static final int POINTS_AMOUNT = 4;
    private static final String POINTS_ERROR_MESSAGE = "Error with incoming parameters, expected: 4, but found: ";

    @Override
    public EllipseFigure createEllipse(double... pointArray) throws EllipseException {
        if (pointArray.length != POINTS_AMOUNT) {
            throw new EllipseException(POINTS_ERROR_MESSAGE + pointArray.length);
        }
        PointType firstPoint = new PointType(pointArray[0], pointArray[1]);
        PointType secondPoint = new PointType(pointArray[2], pointArray[3]);
        EllipseFigure ellipse = new EllipseFigure(firstPoint, secondPoint);
        return ellipse;
    }
}
