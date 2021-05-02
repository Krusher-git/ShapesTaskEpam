package com.kozich.shape.warehouse.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.EllipseParameters;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.service.impl.EllipseParameterServiceImpl;
import com.kozich.shape.warehouse.Warehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class EllipseWarehouse implements Warehouse {
    private static final EllipseWarehouse ellipseWarehouse = new EllipseWarehouse();
    private Map<Long, EllipseParameters> ellipseParametersMap;
    private static final Logger logger = LogManager.getLogger();

    private EllipseWarehouse() {
        ellipseParametersMap = new HashMap<>();
    }

    public static EllipseWarehouse getInstance() {
        return ellipseWarehouse;
    }

    @Override
    public boolean put(EllipseFigure ellipse) {
        long currentId = ellipse.getEllipseId();
        EllipseParameterServiceImpl ellipseParameterService = new EllipseParameterServiceImpl();
        double perimeter = 0, area = 0;
        try {
            perimeter = ellipseParameterService.calculatePerimeter(ellipse);
            area = ellipseParameterService.calculateArea(ellipse);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        if (perimeter == 0 || area == 0) {
            return false;
        }
        EllipseParameters parameters = new EllipseParameters(perimeter, area);
        ellipseParametersMap.put(currentId, parameters);
        return true;
    }

    @Override
    public boolean get(EllipseFigure ellipse) {
        return false;
    }

    @Override
    public boolean remove(EllipseFigure ellipse) {
        return false;
    }
}
