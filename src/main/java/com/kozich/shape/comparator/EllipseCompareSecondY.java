package com.kozich.shape.comparator;

import com.kozich.shape.entity.EllipseFigure;

import java.util.Comparator;

public class EllipseCompareSecondY implements Comparator<EllipseFigure> {
    @Override
    public int compare(EllipseFigure o1, EllipseFigure o2) {
        double firstY = o1.getSecondPoint().getY();
        double secondY = o2.getSecondPoint().getY();
        return Double.compare(firstY, secondY);
    }
}
