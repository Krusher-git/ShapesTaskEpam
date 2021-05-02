package com.kozich.shape.comparator;

import com.kozich.shape.entity.EllipseFigure;

import java.util.Comparator;

public class EllipseCompareSecondX implements Comparator<EllipseFigure> {
    @Override
    public int compare(EllipseFigure o1, EllipseFigure o2) {
        double firstX = o1.getSecondPoint().getX();
        double secondX = o2.getSecondPoint().getX();
        return Double.compare(firstX, secondX);
    }
}
