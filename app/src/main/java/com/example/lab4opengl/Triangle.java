package com.example.lab4opengl;

public class Triangle {
    private FloatPoint[] points;
    private FloatColor color;
    public Triangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor color) {
        this.points = new FloatPoint[]{ point1, point2, point3 };
        this.color = color;
    }
    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor color) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3)
        };
        this.color = color;
    }
    public FloatPoint getPoint(int pointNumber) { return this.points[pointNumber]; }
    public FloatColor getColor() { return this.color; }
    public void draw() { Graphics.drawTriangle(this); }
    public static Triangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor color) {
        return new Triangle(point1, point2, point3, color);
    }
    public static Triangle Create(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor color) {
        return new Triangle(x1, y1, x2, y2, x3, y3, color);
    }
}
