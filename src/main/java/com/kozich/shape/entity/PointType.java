package com.kozich.shape.entity;

public class PointType {

    private double x;
    private double y;

    public PointType() {
    }

    public PointType(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PointType pointType = (PointType) o;

        if (Double.compare(pointType.getX(), getX()) != 0) {
            return false;
        }
        return Double.compare(pointType.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        double temp = 3 * getX() + 14 * getY();
        result = (int) temp;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder pointType = new StringBuilder();
        pointType.append("(").append(getX()).append(", ").append(getY()).append(")");
        return pointType.toString();
    }
}
