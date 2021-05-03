package com.kozich.shape.observer.impl;

import com.kozich.shape.entity.EllipseFigure;
import com.kozich.shape.entity.EllipseParameters;
import com.kozich.shape.exception.EllipseException;
import com.kozich.shape.observer.EllipseObserver;
import com.kozich.shape.service.EllipseParameterService;
import com.kozich.shape.service.impl.EllipseParameterServiceImpl;
import com.kozich.shape.warehouse.impl.EllipseWarehouse;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EllipseObserverImpl implements EllipseObserver<EllipseFigure> {
    private static final Logger logger = LogManager.getLogger();
    private static final String INFO_MESSAGE = "Changed";
    private EllipseFigure figure;

    @Override
    public void update(EllipseFigure o) {
        this.figure = o;
        // Put new parameters if ellipse has been changed
        try {
            EllipseWarehouse warehouse = EllipseWarehouse.getInstance();
            EllipseParameterService parameterService = new EllipseParameterServiceImpl();
            double perimeter = parameterService.calculatePerimeter(figure);
            double area = parameterService.calculateArea(figure);
            EllipseParameters parameters = new EllipseParameters();
            parameters.setArea(area);
            parameters.setPerimeter(perimeter);
            warehouse.put(figure.getEllipseId(), parameters);
        } catch (EllipseException e) {
            logger.log(Level.ERROR, e);
        }
        logger.log(Level.INFO, INFO_MESSAGE);
    }
}
