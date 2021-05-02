package com.kozich.shape.comparator;

import com.kozich.shape.entity.EllipseFigure;

import java.util.Comparator;

public class EllipseCompareFirstY implements Comparator<EllipseFigure> {
    @Override
    public int compare(EllipseFigure o1, EllipseFigure o2) {
        double firstY = o1.getFirstPoint().getY();
        double secondY = o2.getFirstPoint().getY();
        return Double.compare(firstY, secondY);
    }
}
