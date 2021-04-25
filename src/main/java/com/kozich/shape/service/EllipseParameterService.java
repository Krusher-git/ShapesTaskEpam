package com.kozich.shape.service;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.exception.EllipseException;

public interface EllipseParameterService {
    double calculatePerimeter(EllipseFigure ellipse) throws EllipseException;

    double calculateArea(EllipseFigure ellipse) throws EllipseException;

}
