package com.kozich.shape.warehouse;

import com.kozich.shape.entity.EllipseFigure;

public interface Warehouse {
    boolean get(EllipseFigure ellipse);
    boolean put(EllipseFigure ellipse);
    boolean remove(EllipseFigure ellipse);
}
