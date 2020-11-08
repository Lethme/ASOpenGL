package com.example.lab4opengl.Graphics.Figures;

import com.example.lab4opengl.Graphics.Graphics;
import com.example.lab4opengl.Graphics.Properties.Colors;
import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;

public class Point implements Figure {
    private FloatPoint point;
    private FloatColor pointColor;
    private float pointSize;

    public Point(FloatPoint point) {
        this.point = point;
        this.pointSize = Graphics.getDefaultPointSize();
        this.pointColor = Colors.White;
    }
    public Point(FloatPoint point, float pointSize) {
        this.point = point;
        this.pointSize = pointSize;
        this.pointColor = Colors.White;
    }
    public Point(FloatPoint point, FloatColor pointColor) {
        this.point = point;
        this.pointSize = Graphics.getDefaultPointSize();
        this.pointColor = pointColor;
    }
    public Point(FloatPoint point, float pointSize, FloatColor pointColor) {
        this.point = point;
        this.pointSize = pointSize;
        this.pointColor = pointColor;
    }
    public Point(float x, float y) {
        this.point = FloatPoint.Create(x, y);
        this.pointSize = Graphics.getDefaultPointSize();
        this.pointColor = Colors.White;
    }
    public Point(float x, float y, float pointSize) {
        this.point = FloatPoint.Create(x, y);
        this.pointSize = pointSize;
        this.pointColor = Colors.White;
    }
    public Point(float x, float y, FloatColor pointColor) {
        this.point = FloatPoint.Create(x, y);
        this.pointSize = Graphics.getDefaultPointSize();
        this.pointColor = pointColor;
    }
    public Point(float x, float y, float pointSize, FloatColor pointColor) {
        this.point = FloatPoint.Create(x, y);
        this.pointSize = pointSize;
        this.pointColor = pointColor;
    }

    public FloatPoint getPoint() { return this.point; }
    public FloatColor getPointColor() { return this.pointColor; }
    public float getPointSize() { return this.pointSize; }

    @Override public void draw() { Graphics.drawPoint(this); }

    public static Point Create(FloatPoint point) {
        return new Point(point);
    }
    public static Point Create(FloatPoint point, float pointSize) {
        return new Point(point, pointSize);
    }
    public static Point Create(FloatPoint point, FloatColor pointColor) {
        return new Point(point, pointColor);
    }
    public static Point Create(FloatPoint point, float pointSize, FloatColor pointColor) {
        return new Point(point, pointSize, pointColor);
    }
    public static Point Create(float x, float y) {
        return new Point(x, y);
    }
    public static Point Create(float x, float y, float pointSize) {
        return new Point(x, y, pointSize);
    }
    public static Point Create(float x, float y, FloatColor pointColor) {
        return new Point(x, y, pointColor);
    }
    public static Point Create(float x, float y, float pointSize, FloatColor pointColor) {
        return new Point(x, y, pointSize, pointColor);
    }
}
