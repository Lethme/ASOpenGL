package com.example.lab4opengl.Graphics.Figures;

import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;
import com.example.lab4opengl.Graphics.Graphics;

public class Rectangle {
    private FloatPoint[] points;
    private FloatColor fillColor, borderColor;

    public Rectangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor) {
        this.points = new FloatPoint[]{ point1, point2, point3, point4 };
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Rectangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor, FloatColor borderColor) {
        this.points = new FloatPoint[]{ point1, point2, point3, point4 };
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public Rectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3),
                FloatPoint.Create(x4, y4)
        };
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Rectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor, FloatColor borderColor) {
        this.points = new FloatPoint[]{
                FloatPoint.Create(x1, y1),
                FloatPoint.Create(x2, y2),
                FloatPoint.Create(x3, y3),
                FloatPoint.Create(x4, y4)
        };
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public FloatPoint getPoint(int pointNumber) { return this.points[pointNumber]; }
    public FloatColor getFillColor() { return this.fillColor; }
    public FloatColor getBorderColor() { return this.borderColor; }

    public void draw() { Graphics.drawRectangle(this); }
    public boolean borderColorStated() { return !fillColor.Equals(borderColor); }

    public static Rectangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor) {
        return new Rectangle(point1, point2, point3, point4, fillColor);
    }
    public static Rectangle Create(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor, FloatColor borderColor) {
        return new Rectangle(point1, point2, point3, point4, fillColor, borderColor);
    }
    public static Rectangle Create(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor) {
        return new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4, fillColor);
    }
    public static Rectangle Create(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor, FloatColor borderColor) {
        return new Rectangle(x1, y1, x2, y2, x3, y3, x4, y4, fillColor, borderColor);
    }
}
