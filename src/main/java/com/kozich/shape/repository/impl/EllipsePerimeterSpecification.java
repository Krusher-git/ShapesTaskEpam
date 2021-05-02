package com.kozich.shape.repository.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.repository.Specification;
import com.kozich.shape.service.impl.EllipseParameterServiceImpl;

public class EllipsePerimeterSpecification implements Specification {
    private double perimeter;

    public EllipsePerimeterSpecification(double perimeter) {
        this.perimeter = perimeter;
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
        return this.perimeter == perimeter;
    }
}
