package com.kozich.shape.repository.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.repository.Specification;

public class EllipseIdSpecification implements Specification {
    private long id;

    public EllipseIdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(EllipseFigure ellipse) {
        return id == ellipse.getEllipseId();

    }
}
