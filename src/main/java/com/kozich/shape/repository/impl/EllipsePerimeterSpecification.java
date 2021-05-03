package com.kozich.shape.repository.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.repository.Specification;
import com.kozich.shape.service.impl.EllipseParameterServiceImpl;

public class EllipsePerimeterSpecification implements Specification {
    private double minPerimeter;
    private double maxPerimeter;

    public EllipsePerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean specify(EllipseFigure ellipse) {
        EllipseParameterServiceImpl parameterService = new EllipseParameterServiceImpl();
        double perimeter;
        try {
            perimeter = parameterService.calculatePerimeter(ellipse);
        } catch (EllipseException e) {
            return false;
        }
        return minPerimeter <= perimeter && maxPerimeter >= perimeter;
    }
}
