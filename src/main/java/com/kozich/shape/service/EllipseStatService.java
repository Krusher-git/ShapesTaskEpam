package com.kozich.shape.service;

import com.kozich.shape.entity.EllipseFigure;

public interface EllipseStatService {
    boolean isCircle(EllipseFigure ellipse);

    boolean isEllipse(EllipseFigure ellipse);

    boolean crossesAnyAxis(EllipseFigure ellipse);
}
