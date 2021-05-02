package com.kozich.shape.service.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;
import com.kozich.shape.service.EllipseStatService;
import com.kozich.shape.validator.DataValidator;

public class EllipseStatServiceImpl implements EllipseStatService {

    @Override
    public boolean isCircle(EllipseFigure ellipse) {
        PointType firstPoint = ellipse.getFirstPoint();
        PointType secondPoint = ellipse.getFirstPoint();
        double firstDiameter = Math.abs(firstPoint.getX() - secondPoint.getX());
        double secondDiameter = Math.abs(firstPoint.getY() - secondPoint.getY());
        return firstDiameter == secondDiameter;
    }

    @Override
    public boolean isEllipse(EllipseFigure ellipse) {
        return DataValidator.isEllipse(ellipse);
    }

    @Override
    public boolean crossesAnyAxis(EllipseFigure ellipse) {
        PointType firstPoint = ellipse.getFirstPoint();
        PointType secondPoint = ellipse.getFirstPoint();
        return firstPoint.getX() * secondPoint.getX() < 0 || firstPoint.getY() * secondPoint.getY() < 0;
    }
}
