package com.kozich.shape.entity;

import com.kozich.shape.observer.EllipseObserver;
import com.kozich.shape.observer.impl.EllipseObserverImpl;
import com.kozich.shape.util.EllipseCounter;


public class EllipseFigure {
    private final long ellipseId;
    private PointType firstPoint;
    private PointType secondPoint;
    private final EllipseObserver<EllipseFigure> observer;

    public EllipseFigure() {
        ellipseId = EllipseCounter.generateCounter();
        observer = new EllipseObserverImpl();
    }

    public EllipseFigure(PointType firstPoint, PointType secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        ellipseId = EllipseCounter.generateCounter();
        observer = new EllipseObserverImpl();
    }

    public PointType getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(PointType firstPoint) {
        this.firstPoint = firstPoint;
        observer.update(this);
    }

    public PointType getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(PointType secondPoint) {
        this.secondPoint = secondPoint;
        observer.update(this);
    }

    public long getEllipseId() {
        return ellipseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EllipseFigure that = (EllipseFigure) o;

        if (getFirstPoint() != null ? !getFirstPoint().equals(that.getFirstPoint()) : that.getFirstPoint() != null) {
            return false;
        }
        return getSecondPoint() != null ? getSecondPoint().equals(that.getSecondPoint()) : that.getSecondPoint() == null;
    }

    @Override
    public int hashCode() {
        int result = 3 * getFirstPoint().hashCode() + 8 * getSecondPoint().hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder ellipseStringBuilder = new StringBuilder("Ellipse: ");
        ellipseStringBuilder.append("ID = ").append(ellipseId).append(", Points: ");
        ellipseStringBuilder.append(getFirstPoint().toString()).append("; ").append(getSecondPoint().toString());
        return ellipseStringBuilder.toString();
    }
}
