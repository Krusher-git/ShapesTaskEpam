package com.kozich.shape.service.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.service.EllipseParameterService;
import com.kozich.shape.validator.DataValidator;

public class EllipseParameterServiceImpl implements EllipseParameterService {
    @Override
    public double calculatePerimeter(EllipseFigure ellipse) throws EllipseException {
        if (!DataValidator.isEllipse(ellipse)) {
            throw new EllipseException("Error with input ellipse");
        }
        PointType firstPoint = ellipse.getFirstPoint();
        PointType secondPoint = ellipse.getSecondPoint();
        double majorAxis = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double minorAxis = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        if (majorAxis < minorAxis) {
            double temp = majorAxis;
            majorAxis = minorAxis;
            minorAxis = temp;
        }
        double perimeter = 4 * (Math.PI * majorAxis * minorAxis + Math.pow((majorAxis - minorAxis), 2)) / (majorAxis + minorAxis);
        return perimeter;
    }

    @Override
    public double calculateArea(EllipseFigure ellipse) throws EllipseException {
        if (!DataValidator.isEllipse(ellipse)) {
            throw new EllipseException("Error with input ellipse");
        }

        PointType firstPoint = ellipse.getFirstPoint();
        PointType secondPoint = ellipse.getSecondPoint();
        double majorAxis = Math.abs(firstPoint.getX() - secondPoint.getX()) / 2;
        double minorAxis = Math.abs(firstPoint.getY() - secondPoint.getY()) / 2;
        double area = Math.PI * minorAxis * majorAxis;
        return area;
    }
}
