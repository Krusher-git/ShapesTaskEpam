package com.kozich.shape.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointParser {
    private static Logger logger = LogManager.getLogger();
    private static final String CONVERTER = "[\\s|,|(|)]+";
    private static final String INFO_MESSAGE = "Points were received";

    public double[] receivePointsArray(String pointString) {
        String[] points = pointString.split(CONVERTER);
        if (points.length < 4) {
            return null;
        }
        //TODO: find, why does split produce "" string
        double[] pointsArray = new double[4];
        int i = 0;
        for (String point : points) {
            if (!point.isBlank()) {
                pointsArray[i] = Double.parseDouble(point);
                i++;
            }
        }
        logger.log(Level.INFO, INFO_MESSAGE);
        return pointsArray;
    }
}
