package com.example.lab4opengl.Graphics;

public class FloatPoint {
    private float X, Y;
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
