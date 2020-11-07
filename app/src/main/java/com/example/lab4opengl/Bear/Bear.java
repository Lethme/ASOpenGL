package com.example.lab4opengl.Bear;

import com.example.lab4opengl.Graphics.Figures.Ellipse;
import com.example.lab4opengl.Graphics.Properties.Colors;
import com.example.lab4opengl.Graphics.Graphics;
import com.example.lab4opengl.Graphics.Figures.Rectangle;
import com.example.lab4opengl.Graphics.Figures.Triangle;

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
    private static Rectangle[] rectangles = new Rectangle[] {  };
    private static Ellipse[] ellipses = new Ellipse[] {
            /* GhostWhite ellipses */
            Ellipse.Create(-0.2f, 0.45f, 0.1f, 0.05f, Colors.GhostWhite),
            Ellipse.Create(0.2f, 0.45f, 0.1f, 0.05f, Colors.GhostWhite),
            /* GhostWhite ellipses */

            /* Black ellipses */
            Ellipse.Create(-0.22f, 0.47f, 0.05f, 0.025f, Colors.Black),
            Ellipse.Create(0.22f, 0.43f, 0.05f, 0.025f, Colors.Black),
            /* Black ellipses */

            /* Dark brown ellipses */
            Ellipse.Create(0.0f, 0.15f, 0.05f, 0.035f, -180.0f, 0.0f, Colors.DarkBrown),
            /* Dark brown ellipses */

            /* Dark red ellipses */
            Ellipse.Create(0.0f, 0.14f, 0.025f, 0.015f, -180.0f, 0.0f, Colors.DarkRed),
            /* Dark red ellipses */
    };
    public static void Draw() {
        Graphics.Clear();
        for (Triangle triangle: triangles) { triangle.draw(); }
        for (Rectangle rectangle: rectangles) { rectangle.draw(); }
        for (Ellipse ellipse: ellipses) { ellipse.draw(); }
        Graphics.LoadIdentity();
    }
}
