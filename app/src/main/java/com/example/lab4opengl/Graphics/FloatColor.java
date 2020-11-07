package com.example.lab4opengl.Graphics;

public class FloatColor {
    private float R, G, B, A;
    public FloatColor(float r, float g, float b, float a) {
        this.R = r;
        this.G = g;
        this.B = b;
        this.A = a;
    }
    public FloatColor(int r, int g, int b, float a) {
        this.R = (float)r / 255;
        this.G = (float)g / 255;
        this.B = (float)b / 255;
        this.A = a;
    }
    public float getR() { return this.R; }
    public float getG() { return this.G; }
    public float getB() { return this.B; }
    public float getA() { return this.A; }
    public static FloatColor Create(float r, float g, float b, float a) {
        return new FloatColor(r, g, b, a);
    }
    public static FloatColor Create(int r, int g, int b, float a) {
        return new FloatColor(r, g, b, a);
    }
}
