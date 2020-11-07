package com.example.lab4opengl.Bear;

import com.example.lab4opengl.Graphics.Colors;
import com.example.lab4opengl.Graphics.Graphics;
import com.example.lab4opengl.Graphics.Rectangle;
import com.example.lab4opengl.Graphics.Triangle;

public class Bear {
    private static Triangle[] triangles = new Triangle[]{
            /* Light brown triangles */
            Triangle.Create(-0.1f, -0.8f, -0.35f, -0.9f, -0.08f, -0.95f, Colors.LightBrown),
            Triangle.Create(0.1f, -0.8f, 0.35f, -0.9f, 0.08f, -0.95f, Colors.LightBrown),
            Triangle.Create(-0.1f, -0.8f, 0.1f, -0.8f, -0.08f, -0.95f, Colors.LightBrown),
            Triangle.Create(0.1f, -0.8f, -0.08f, -0.95f, 0.08f, -0.95f, Colors.LightBrown),
            Triangle.Create(-0.475f, -0.4f, -0.7f, -0.95f, -0.35f, -0.9f, Colors.LightBrown),
            Triangle.Create(0.475f, -0.4f, 0.7f, -0.95f, 0.35f, -0.9f, Colors.LightBrown),
            Triangle.Create(-0.45f, -0.95f, -0.7f, -0.95f, -0.35f, -0.9f, Colors.LightBrown),
            Triangle.Create(0.45f, -0.95f, 0.7f, -0.95f, 0.35f, -0.9f, Colors.LightBrown),
            Triangle.Create(-0.75f, -0.92f, -0.85f, -0.8f, -0.65f, -0.84f, Colors.LightBrown),
            Triangle.Create(0.75f, -0.92f, 0.85f, -0.8f, 0.65f, -0.84f, Colors.LightBrown),
            Triangle.Create(0.0f, 0.0f, -0.4f, 0.6f, 0.0f, 0.6f, Colors.LightBrown),
            Triangle.Create(0.0f, 0.0f, 0.4f, 0.6f, 0.0f, 0.6f, Colors.LightBrown),
            Triangle.Create(-0.4f, 0.6f, 0.0f, 0.6f, -0.3f, 0.7f, Colors.LightBrown),
            Triangle.Create(0.4f, 0.6f, 0.0f, 0.6f, 0.3f, 0.7f, Colors.LightBrown),
            Triangle.Create(0.0f, 0.0f, -0.1f, -0.8f, -0.6f, 0.1f, Colors.LightBrown),
            Triangle.Create(0.0f, 0.0f, 0.1f, -0.8f, 0.6f, 0.1f, Colors.LightBrown),
            Triangle.Create(-0.35f, 0.3f, -0.6f, 0.1f, 0.0f, 0.0f, Colors.LightBrown),
            Triangle.Create(0.35f, 0.3f, 0.6f, 0.1f, 0.0f, 0.0f, Colors.LightBrown),
            Triangle.Create(-0.36f, 0.74f, -0.3f, 0.7f, -0.15f, 0.75f, Colors.LightBrown),
            Triangle.Create(0.36f, 0.74f, 0.3f, 0.7f, 0.15f, 0.75f, Colors.LightBrown),
            Triangle.Create(-0.36f, 0.74f, -0.27f, 0.78f, -0.15f, 0.75f, Colors.LightBrown),
            Triangle.Create(0.36f, 0.74f, 0.27f, 0.78f, 0.15f, 0.75f, Colors.LightBrown),
            /* Light brown triangles */

            /* Dark brown triangles */
            Triangle.Create(0.0f, 0.0f, -0.1f, -0.8f, 0.1f, -0.8f, Colors.DarkBrown),
            Triangle.Create(-0.6f, 0.1f, -0.35f, -0.9f, -0.1f, -0.8f, Colors.DarkBrown),
            Triangle.Create(0.6f, 0.1f, 0.35f, -0.9f, 0.1f, -0.8f, Colors.DarkBrown),
            Triangle.Create(-0.35f, -0.9f, -0.45f, -0.95f, -0.08f, -0.95f, Colors.DarkBrown),
            Triangle.Create(0.35f, -0.9f, 0.45f, -0.95f, 0.08f, -0.95f, Colors.DarkBrown),
            Triangle.Create(-0.475f, -0.4f, -0.7f, -0.95f, -0.75f, -0.92f, Colors.DarkBrown),
            Triangle.Create(0.475f, -0.4f, 0.7f, -0.95f, 0.75f, -0.92f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.0f, -0.4f, 0.6f, -0.35f, 0.3f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.0f, 0.4f, 0.6f, 0.35f, 0.3f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.2f, -0.1f, 0.25f, 0.1f, 0.25f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.25f, -0.1f, 0.25f, -0.08f, 0.28f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.25f, 0.1f, 0.25f, 0.08f, 0.28f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.25f, -0.08f, 0.28f, 0.0f, 0.3f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.25f, 0.08f, 0.28f, 0.0f, 0.3f, Colors.DarkBrown),
            Triangle.Create(0.0f, 0.6f, -0.3f, 0.7f, 0.3f, 0.7f, Colors.DarkBrown),
            Triangle.Create(-0.3f, 0.7f, 0.3f, 0.7f, 0.0f, 0.8f, Colors.DarkBrown),
            Triangle.Create(-0.3f, 0.7f, -0.36f, 0.74f, -0.4f, 0.7f, Colors.DarkBrown),
            Triangle.Create(0.3f, 0.7f, 0.36f, 0.74f, 0.4f, 0.7f, Colors.DarkBrown),
            Triangle.Create(-0.3f, 0.7f, -0.4f, 0.7f, -0.38f, 0.62f, Colors.DarkBrown),
            Triangle.Create(0.3f, 0.7f, 0.4f, 0.7f, 0.38f, 0.62f, Colors.DarkBrown),
            /* Dark brown triangles */
    };
    private static Rectangle[] rectangles = new Rectangle[] {
            /* White rectangles */
            Rectangle.Create(-0.25f, 0.4f, -0.05f, 0.4f, -0.05f, 0.5f, -0.25f, 0.5f, Colors.White),
            Rectangle.Create(0.25f, 0.4f, 0.05f, 0.4f, 0.05f, 0.5f, 0.25f, 0.5f, Colors.White),
            /* White rectangles */

            /* Black rectangles */
            Rectangle.Create(-0.24f, 0.495f, -0.18f, 0.495f, -0.18f, 0.46f, -0.24f, 0.46f, Colors.Black),
            Rectangle.Create(0.24f, 0.405f, 0.18f, 0.405f, 0.18f, 0.44f, 0.24f, 0.44f, Colors.Black),
            /* Black rectangles */
    };
    public static void Draw() {
        Graphics.Clear();
        for (Triangle triangle: triangles) { triangle.draw(); }
        for (Rectangle rectangle: rectangles) { rectangle.draw(); }
        Graphics.LoadIdentity();
    }
}
