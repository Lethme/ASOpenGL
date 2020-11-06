package com.example.lab4opengl.Graphics;

import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.example.lab4opengl.OpenGLRenderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Graphics {
    private static GL10 GL;
    private static FloatBuffer vertexBuffer;
    private static FloatColor backgroundColor = Colors.Black;
    public static void createGraphics(GL10 gl) {
        GL = gl;
        setBackgroundColor();
    }
    public static void setBackgroundColor(FloatColor color) { backgroundColor = color; setBackgroundColor(); }
    private static void setBackgroundColor() {
        GL.glClearColor(
                backgroundColor.getR(),
                backgroundColor.getG(),
                backgroundColor.getB(),
                backgroundColor.getA()
        );
    }
    private static Point GetScreenSize() {
        Point size = new Point();
        WindowManager w = OpenGLRenderer.WindowHandler.getWindowManager();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            w.getDefaultDisplay().getSize(size);
            return size;
        } else {
            Display d = w.getDefaultDisplay();
            return new Point(d.getWidth(), d.getHeight());
        }
    }
    public static void Clear() {
        GL.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }
    public static void LoadIdentity() {
        GL.glLoadIdentity();
    }
    public static void SetViewport(int width, int height) {
        Point screenSize = GetScreenSize();
        if (screenSize.x < screenSize.y) {
            GL.glViewport(0, 0, width, height);
        }
        else {
            int viewWidth = (int)(height - ((double)height / (double) width) * height);
            int X = screenSize.x / 2 - viewWidth / 2;
            GL.glViewport(X, 0, viewWidth, height);
        }
    }
    public static void drawTriangle(Triangle triangle) {
        float[] points = new float[] {
                triangle.getPoint(0).getX(), triangle.getPoint(0).getY(),
                triangle.getPoint(1).getX(), triangle.getPoint(1).getY(),
                triangle.getPoint(2).getX(), triangle.getPoint(2).getY()
        };
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(points);
        vertexBuffer.position(0);

        GL.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        GL.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
        GL.glColor4f(triangle.getColor().getR(), triangle.getColor().getG(), triangle.getColor().getB(), triangle.getColor().getA());
        GL.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
    }
    public static void drawRectangle(Rectangle rectangle) {
        drawTriangle(Triangle.Create(
                rectangle.getPoint(0).getX(), rectangle.getPoint(0).getY(),
                rectangle.getPoint(1).getX(), rectangle.getPoint(1).getY(),
                rectangle.getPoint(2).getX(), rectangle.getPoint(2).getY(),
                rectangle.getColor()
        ));
        drawTriangle(Triangle.Create(
                rectangle.getPoint(0).getX(), rectangle.getPoint(0).getY(),
                rectangle.getPoint(3).getX(), rectangle.getPoint(3).getY(),
                rectangle.getPoint(2).getX(), rectangle.getPoint(2).getY(),
                rectangle.getColor()
        ));
    }
}
