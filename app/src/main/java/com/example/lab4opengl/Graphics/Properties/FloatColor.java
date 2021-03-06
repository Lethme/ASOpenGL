package com.example.lab4opengl.Graphics.Properties;

public class FloatColor {
    private float R, G, B, A;
    public static FloatColor Transparent = FloatColor.CreateTransparent();

    public FloatColor(float r, float g, float b, float a) {
        if (r > 1.0f || g > 1.0f || b > 1.0f || a > 1.0f ||
            r < 0.0f || g < 0.0f || b < 0.0f || a < 0.0f)
            throw new IllegalArgumentException();
        else {
            this.R = r;
            this.G = g;
            this.B = b;
            this.A = a;
        }
    }
    public FloatColor(float r, float g, float b) {
        if (r > 1.0f || g > 1.0f || b > 1.0f ||
            r < 0.0f || g < 0.0f || b < 0.0f)
            throw new IllegalArgumentException();
        else {
            this.R = r;
            this.G = g;
            this.B = b;
            this.A = 1.0f;
        }
    }
    public FloatColor(int r, int g, int b, float a) {
        if (r > 255 || g > 255 || b > 255 || a > 1.0f ||
            r < 0 || g < 0 || b < 0 || a < 0.0f)
            throw new IllegalArgumentException();
        else {
            this.R = (float)r / 255;
            this.G = (float)g / 255;
            this.B = (float)b / 255;
            this.A = a;
        }
    }
    public FloatColor(int r, int g, int b) {
        if (r > 255 || g > 255 || b > 255 ||
            r < 0 || g < 0 || b < 0)
            throw new IllegalArgumentException();
        else {
            this.R = (float)r / 255;
            this.G = (float)g / 255;
            this.B = (float)b / 255;
            this.A = 1.0f;
        }
    }

    public float getR() { return this.R; }
    public float getG() { return this.G; }
    public float getB() { return this.B; }
    public float getA() { return this.A; }

    public boolean Equals(FloatColor otherColor) {
        return this.R == otherColor.R &&
               this.G == otherColor.G &&
               this.B == otherColor.B &&
               this.A == otherColor.A;
    }
    public boolean IsTransparent() {
        return this == Transparent;
    }

    public static FloatColor Create(float r, float g, float b, float a) {
        return new FloatColor(r, g, b, a);
    }
    public static FloatColor Create(float r, float g, float b) {
        return new FloatColor(r, g, b);
    }
    public static FloatColor Create(int r, int g, int b, float a) {
        return new FloatColor(r, g, b, a);
    }
    public static FloatColor Create(int r, int g, int b) {
        return new FloatColor(r, g, b);
    }

    protected void setRGBA(float r, float g, float b) { this.R = r; this.G = g; this.B = b; }
    protected void setRGBA(float r, float g, float b, float a) { this.R = r; this.G = g; this.B = b; this.A = a; }
    protected void setRGBA(int r, int g, int b) { this.R = (float)r / 255; this.G = (float)g / 255; this.B = (float)b / 255; }
    protected void setRGBA(int r, int g, int b, float a) { this.R = (float)r / 255; this.G = (float)g / 255; this.B = (float)b / 255; this.A = a; }
    protected static FloatColor CreateTransparent() {
        FloatColor transparent = FloatColor.Create(0, 0, 0);
        transparent.setRGBA(-1f, -1f, -1f);
        return transparent;
    }
}
