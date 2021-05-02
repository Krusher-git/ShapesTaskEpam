package com.kozich.shape.repository.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.repository.Specification;
import com.kozich.shape.service.impl.EllipseParameterServiceImpl;

public class EllipseAreaSpecification implements Specification {
    private double minArea;
    private double maxArea;

    public EllipseAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(EllipseFigure ellipse) {
        EllipseParameterServiceImpl ellipseParameterService = new EllipseParameterServiceImpl();
        double area;
        try {
            area = ellipseParameterService.calculateArea(ellipse);
        } catch (EllipseException e) {
            return false;
        }
        return area >= minArea && area <= maxArea;
    }
}
