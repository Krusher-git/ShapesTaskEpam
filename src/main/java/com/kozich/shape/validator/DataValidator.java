package com.kozich.shape.validator;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.PointType;

import java.io.File;

public class DataValidator {
    private static final String POINTS_REGEXP = "(.*)(-?\\d{1,3}.\\d{1,3},\\s-?\\d{1,3}.\\d{1,3})(.*)";

    public static boolean isEllipse(EllipseFigure ellipse) {
        if (ellipse == null) {
            return false;
        }
        PointType firstPoint = ellipse.getFirstPoint();
        PointType secondPoint = ellipse.getSecondPoint();
        if (firstPoint == null || secondPoint == null) {
            return false;
        }
        if (firstPoint.getX() == secondPoint.getX() || firstPoint.getY() == secondPoint.getY()) {
            return false;
        }
        return true;
    }

    public static boolean isValidFile(String path) {
        File file = new File(path);
        boolean result = file.exists() && file.isFile();
        return result;
    }

    public static boolean isValidString(String pointString) {
        if (pointString.matches(POINTS_REGEXP)) {
            return true;
        }
        return false;
    }
}
