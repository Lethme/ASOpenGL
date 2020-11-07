package com.example.lab4opengl.Graphics.Figures;

import com.example.lab4opengl.Graphics.Graphics;
import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;

public class Ellipse {
    private FloatPoint center;
    private float width, height;
    private FloatColor fillColor, borderColor;

    public Ellipse(FloatPoint center, float width, float height, FloatColor fillColor) {
        this.center = center;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Ellipse(FloatPoint center, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        this.center = center;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    public Ellipse(float centerX, float centerY, float width, float height, FloatColor fillColor) {
        this.center = FloatPoint.Create(centerX, centerY);
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = fillColor;
    }
    public Ellipse(float centerX, float centerY, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        this.center = FloatPoint.Create(centerX, centerY);
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    public FloatPoint getCenter() { return this.center; }
    public FloatColor getFillColor() { return this.fillColor; }
    public FloatColor getBorderColor() { return this.borderColor; }
    public float getWidth() { return this.width; }
    public float getHeight() { return this.height; }

    public void draw() { Graphics.drawEllipse(this); }
    public boolean borderColorStated() { return !fillColor.Equals(borderColor); }

    public static Ellipse Create(FloatPoint center, float width, float height, FloatColor fillColor) {
        return new Ellipse(center, width, height, fillColor);
    }
    public static Ellipse Create(FloatPoint center, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        return new Ellipse(center, width, height, fillColor, borderColor);
    }
    public static Ellipse Create(float centerX, float centerY, float width, float height, FloatColor fillColor) {
        return new Ellipse(centerX, centerY, width, height, fillColor);
    }
    public static Ellipse Create(float centerX, float centerY, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        return new Ellipse(centerX, centerY, width, height, fillColor, borderColor);
    }
}