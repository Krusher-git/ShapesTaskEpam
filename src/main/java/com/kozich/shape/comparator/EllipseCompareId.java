package com.kozich.shape.comparator;

import com.kozich.shape.entity.EllipseFigure;

import java.util.Comparator;

public class EllipseCompareId implements Comparator<EllipseFigure> {
    @Override
    public int compare(EllipseFigure o1, EllipseFigure o2) {
        long firstId = o1.getEllipseId();
        long secondId = o2.getEllipseId();
        return Long.compare(firstId, secondId);
    }
}
