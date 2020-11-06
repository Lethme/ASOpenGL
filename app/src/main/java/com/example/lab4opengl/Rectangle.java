package com.example.lab4opengl;

public class Rectangle {
    private FloatPoint[] points;
    private FloatColor color;
    public Rectangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor color) {
        this.points = new FloatPoint[]{ point1, point2, point3, point4 };
        this.color = color;
    }
    public Rectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor color) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3),
                FloatPoint.Create(x4, y4)
        };
        this.color = color;
    }
    public FloatPoint getPoint(int pointNumber) { return this.points[pointNumber]; }
    public FloatColor getColor() { return this.color; }
    public void draw() { Graphics.drawRectangle(this); }
    public static Rectangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor color) {
        return new Rectangle(point1, point2, point3, point4, color);
    }
    public static Rectangle Create(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor color) {
        return new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4, color);
    }
}
