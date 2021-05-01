package com.kozich.shape.factory;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.exception.EllipseException;

public abstract class ShapeFactory {
    public abstract EllipseFigure createEllipse(double... pointArray) throws EllipseException;
}
