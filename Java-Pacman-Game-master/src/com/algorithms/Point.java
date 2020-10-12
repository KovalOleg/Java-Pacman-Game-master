package com.algorithms;

import java.util.ArrayDeque;

public class Point {
    private int positionI;
    private int positionJ;
    private int positionRaw, data;
    private ArrayDeque<Point> wayToStart = new ArrayDeque<>();
    private boolean passed = false;


    public ArrayDeque<Point> getWayToStart() {
        return wayToStart;
    }

    public void setWayToStart(ArrayDeque<Point> wayToStart) {
        this.wayToStart = wayToStart;
    }

    public int getData() {
        return data;
    }

    public int getPositionRaw() {
        return positionRaw;
    }

    public void setPositionRaw(int positionRaw) {
        this.positionRaw = positionRaw;
    }

    public Point(int positionI, int positionJ, int positionRaw, boolean passed, int data) {
        this.positionI = positionI;
        this.positionJ = positionJ;
        this.positionRaw = positionRaw;
        this.passed = passed;
        this.data = data;
    }

    public int getPositionI() {
        return positionI;
    }

    public void setPositionI(int positionJ) {
        this.positionI = positionJ;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public void setPositionJ(int positionJ) {
        this.positionJ = positionJ;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
