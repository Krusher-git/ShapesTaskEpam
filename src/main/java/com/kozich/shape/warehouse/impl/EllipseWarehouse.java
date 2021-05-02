package com.kozich.shape.warehouse.impl;

import com.kozich.shape.entity.EllipseParameters;
import com.kozich.shape.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class EllipseWarehouse implements Warehouse {
    private static final EllipseWarehouse ellipseWarehouse = new EllipseWarehouse();
    private Map<Long, EllipseParameters> ellipseParametersMap;

    private EllipseWarehouse() {
        ellipseParametersMap = new HashMap<>();
    }

    public static EllipseWarehouse getInstance() {
        return ellipseWarehouse;
    }

    @Override
    public EllipseParameters put(long id, EllipseParameters parameters) {
        return ellipseParametersMap.put(id, parameters);
    }

    @Override
    public EllipseParameters get(long id) {
        return ellipseParametersMap.get(id);
    }

    @Override
    public EllipseParameters remove(long id) {
        return ellipseParametersMap.remove(id);
    }
}
