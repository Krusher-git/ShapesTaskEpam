package com.kozich.shape.repository;

import com.kozich.shape.entity.EllipseFigure;

@FunctionalInterface
public interface Specification {
    boolean specify(EllipseFigure ellipse);
}
