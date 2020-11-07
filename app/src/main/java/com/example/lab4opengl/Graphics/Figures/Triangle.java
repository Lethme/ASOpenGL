package com.example.lab4opengl.Graphics.Figures;

import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;
import com.example.lab4opengl.Graphics.Graphics;

public class Triangle {
    private FloatPoint[] points;
    private FloatColor fillColor, borderColor;

    public Triangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor) {
        this.points = new FloatPoint[]{ point1, point2, point3 };
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Triangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor, FloatColor borderColor) {
        this.points = new FloatPoint[]{ point1, point2, point3 };
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3)
        };
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Triangle(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor, FloatColor borderColor) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3)
        };
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public FloatPoint getPoint(int pointNumber) { return this.points[pointNumber]; }
    public FloatColor getFillColor() { return this.fillColor; }
    public FloatColor getBorderColor() { return this.borderColor; }

    public void draw() { Graphics.drawTriangle(this); }
    public boolean borderColorStated() { return !fillColor.Equals(borderColor); }

    public static Triangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor) {
        return new Triangle(point1, point2, point3, fillColor);
    }
    public static Triangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor, FloatColor borderColor) {
        return new Triangle(point1, point2, point3, fillColor, borderColor);
    }
    public static Triangle Create(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor) {
        return new Triangle(x1, y1, x2, y2, x3, y3, fillColor);
    }
    public static Triangle Create(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor, FloatColor borderColor) {
        return new Triangle(x1, y1, x2, y2, x3, y3, fillColor, borderColor);
    }
}
