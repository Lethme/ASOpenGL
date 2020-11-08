package com.example.lab4opengl.Graphics.Figures;

import com.example.lab4opengl.Graphics.Graphics;
import com.example.lab4opengl.Graphics.Properties.Colors;
import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;

public class Line implements Figure {
    private FloatPoint firstPoint, secondPoint;
    private FloatColor lineColor;
    private float lineWidth;

    public Line(FloatPoint firstPoint, FloatPoint secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.lineWidth = Graphics.getDefaultLineWidth();
        this.lineColor = Colors.White;
    }
    public Line(FloatPoint firstPoint, FloatPoint secondPoint, FloatColor lineColor) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.lineWidth = Graphics.getDefaultLineWidth();
        this.lineColor = lineColor;
    }
    public Line(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.lineWidth = lineWidth;
        this.lineColor = Colors.White;
    }
    public Line(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth, FloatColor lineColor) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
    }
    public Line(float x1, float y1, float x2, float y2) {
        this.firstPoint = FloatPoint.Create(x1, y1);
        this.secondPoint = FloatPoint.Create(x2, y2);
        this.lineWidth = Graphics.getDefaultLineWidth();
        this.lineColor = Colors.White;
    }
    public Line(float x1, float y1, float x2, float y2, FloatColor lineColor) {
        this.firstPoint = FloatPoint.Create(x1, y1);
        this.secondPoint = FloatPoint.Create(x2, y2);
        this.lineWidth = Graphics.getDefaultLineWidth();
        this.lineColor = lineColor;
    }
    public Line(float x1, float y1, float x2, float y2, float lineWidth) {
        this.firstPoint = FloatPoint.Create(x1, y1);
        this.secondPoint = FloatPoint.Create(x2, y2);
        this.lineWidth = lineWidth;
        this.lineColor = Colors.White;
    }
    public Line(float x1, float y1, float x2, float y2, float lineWidth, FloatColor lineColor) {
        this.firstPoint = FloatPoint.Create(x1, y1);
        this.secondPoint = FloatPoint.Create(x2, y2);
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
    }

    public FloatPoint getFirstPoint() { return this.firstPoint; }
    public FloatPoint getSecondPoint() { return this.secondPoint; }
    public FloatColor getLineColor() { return this.lineColor; }
    public float getLineWidth() { return this.lineWidth; }

    @Override public void draw() { Graphics.drawLine(this); }

    public static Line Create(FloatPoint firstPoint, FloatPoint secondPoint) {
        return new Line(firstPoint, secondPoint);
    }
    public static Line Create(FloatPoint firstPoint, FloatPoint secondPoint, FloatColor lineColor) {
        return new Line(firstPoint, secondPoint, lineColor);
    }
    public static Line Create(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth) {
        return new Line(firstPoint, secondPoint, lineWidth);
    }
    public static Line Create(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth, FloatColor lineColor) {
        return new Line(firstPoint, secondPoint, lineWidth, lineColor);
    }
    public static Line Create(float x1, float y1, float x2, float y2) {
        return new Line(x1, y1, x2, y2);
    }
    public static Line Create(float x1, float y1, float x2, float y2, FloatColor lineColor) {
        return new Line(x1, y1, x2, y2, lineColor);
    }
    public static Line Create(float x1, float y1, float x2, float y2, float lineWidth) {
        return new Line(x1, y1, x2, y2, lineWidth);
    }
    public static Line Create(float x1, float y1, float x2, float y2, float lineWidth, FloatColor lineColor) {
        return new Line(x1, y1, x2, y2, lineWidth, lineColor);
    }
}
