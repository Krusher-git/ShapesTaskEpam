package com.kozich.shape.warehouse;

import com.kozich.shape.entity.EllipseParameters;

public interface Warehouse {
    EllipseParameters get(long id);

    EllipseParameters put(long id, EllipseParameters parameters);

    EllipseParameters remove(long id);
}
