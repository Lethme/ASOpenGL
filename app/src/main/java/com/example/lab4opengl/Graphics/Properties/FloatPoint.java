package com.example.lab4opengl.Graphics.Properties;

public class FloatPoint {
    private float X, Y;

    public FloatPoint() {
        this.X = 0.0f;
        this.Y = 0.0f;
    }
    public FloatPoint(float x, float y) {
        this.X = x;
        this.Y = y;
    }

    public float getX() { return this.X; }
    public float getY() { return this.Y; }

    public static FloatPoint Create(float x, float y) {
        return new FloatPoint(x, y);
    }
}
