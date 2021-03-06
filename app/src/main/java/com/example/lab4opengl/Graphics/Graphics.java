package com.example.lab4opengl.Graphics;

import android.content.res.Configuration;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.example.lab4opengl.Graphics.Figures.Ellipse;
import com.example.lab4opengl.Graphics.Figures.Line;
import com.example.lab4opengl.Graphics.Figures.Rectangle;
import com.example.lab4opengl.Graphics.Figures.Triangle;
import com.example.lab4opengl.Graphics.Properties.Colors;
import com.example.lab4opengl.Graphics.Properties.FloatColor;
import com.example.lab4opengl.Graphics.Properties.FloatPoint;
import com.example.lab4opengl.OpenGLRenderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Graphics {
    private static GL10 GL;
    private static FloatBuffer vertexBuffer;
    private static FloatColor backgroundColor = Colors.Black;
    private static float defaultLineWidth = 3.0f;
    public static void createGraphics(GL10 gl) {
        GL = gl;
        setBackgroundColor();
        setDefaultLineWidth();
    }
    private static void setDefaultLineWidth() {
        GL.glLineWidth(3.0f);
    }
    public static void setBackgroundColor(FloatColor color) { backgroundColor = color; setBackgroundColor(); }
    private static void setBackgroundColor() {
        GL.glClearColor(
                backgroundColor.getR(),
                backgroundColor.getG(),
                backgroundColor.getB(),
                backgroundColor.getA()
        );
        Graphics.Clear();
    }
    private static int GetOrientationState() {
        return OpenGLRenderer.WindowHandler.getResources().getConfiguration().orientation;
    }
    private static android.graphics.Point GetScreenSize() {
        android.graphics.Point size = new android.graphics.Point();
        WindowManager w = OpenGLRenderer.WindowHandler.getWindowManager();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            w.getDefaultDisplay().getSize(size);
            return size;
        } else {
            Display d = w.getDefaultDisplay();
            return new android.graphics.Point(d.getWidth(), d.getHeight());
        }
    }
    public static float getDefaultLineWidth() { return defaultLineWidth; }
    public static void Clear() {
        GL.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }
    public static void LoadIdentity() {
        GL.glLoadIdentity();
    }
    public static void SetViewport(int width, int height) {
        android.graphics.Point screenSize = GetScreenSize();
        if (GetOrientationState() == Configuration.ORIENTATION_PORTRAIT) {
            GL.glViewport(0, 0, width, height);
        }
        else {
            //int viewWidth = (int)(height - ((double)height / (double) width) * height);
            int viewWidth = (int)(height * (((double)height + (double) height / 3) / (double)width));
            int X = screenSize.x / 2 - viewWidth / 2;
            GL.glViewport(X, 0, viewWidth, height);
        }
    }
    public static void drawLine(Line line) {
        float[] points = new float[] {
                line.getFirstPoint().getX(), line.getFirstPoint().getY(),
                line.getSecondPoint().getX(), line.getSecondPoint().getY()
        };
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(points);
        vertexBuffer.position(0);

        GL.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        GL.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
        GL.glColor4f(line.getLineColor().getR(), line.getLineColor().getG(), line.getLineColor().getB(), line.getLineColor().getA());
        GL.glLineWidth(line.getLineWidth());
        GL.glDrawArrays(GL10.GL_LINES, 0, 2);
        setDefaultLineWidth();
    }
    public static void Line(FloatPoint firstPoint, FloatPoint secondPoint) {
        drawLine(Line.Create(firstPoint, secondPoint));
    }
    public static void Line(FloatPoint firstPoint, FloatPoint secondPoint, FloatColor lineColor) {
        drawLine(Line.Create(firstPoint, secondPoint, lineColor));
    }
    public static void Line(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth) {
        drawLine(Line.Create(firstPoint, secondPoint, lineWidth));
    }
    public static void Line(FloatPoint firstPoint, FloatPoint secondPoint, float lineWidth, FloatColor lineColor) {
        drawLine(Line.Create(firstPoint, secondPoint, lineWidth, lineColor));
    }
    public static void Line(float x1, float y1, float x2, float y2) {
        drawLine(Line.Create(x1, y1, x2, y2));
    }
    public static void Line(float x1, float y1, float x2, float y2, FloatColor lineColor) {
        drawLine(Line.Create(x1, y1, x2, y2, lineColor));
    }
    public static void Line(float x1, float y1, float x2, float y2, float lineWidth) {
        drawLine(Line.Create(x1, y1, x2, y2, lineWidth));
    }
    public static void Line(float x1, float y1, float x2, float y2, float lineWidth, FloatColor lineColor) {
        drawLine(Line.Create(x1, y1, x2, y2, lineWidth, lineColor));
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
        GL.glColor4f(triangle.getFillColor().getR(), triangle.getFillColor().getG(), triangle.getFillColor().getB(), triangle.getFillColor().getA());
        GL.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);

        if (triangle.borderColorStated()) {
            GL.glColor4f(triangle.getBorderColor().getR(), triangle.getBorderColor().getG(), triangle.getBorderColor().getB(), triangle.getBorderColor().getA());
            GL.glDrawArrays(GL10.GL_LINE_LOOP, 0, 3);
        }
    }
    public static void Triangle(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor) {
        drawTriangle(Triangle.Create(x1, y1, x2, y2, x3, y3, fillColor));
    }
    public static void Triangle(float x1, float y1, float x2, float y2, float x3, float y3, FloatColor fillColor, FloatColor borderColor) {
        drawTriangle(Triangle.Create(x1, y1, x2, y2, x3, y3, fillColor, borderColor));
    }
    public static void Triangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor) {
        drawTriangle(Triangle.Create(point1, point2, point3, fillColor));
    }
    public static void Triangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatColor fillColor, FloatColor borderColor) {
        drawTriangle(Triangle.Create(point1, point2, point3, fillColor, borderColor));
    }
    public static void drawRectangle(Rectangle rectangle) {
        drawTriangle(Triangle.Create(
                rectangle.getPoint(0).getX(), rectangle.getPoint(0).getY(),
                rectangle.getPoint(1).getX(), rectangle.getPoint(1).getY(),
                rectangle.getPoint(2).getX(), rectangle.getPoint(2).getY(),
                rectangle.getFillColor()
        ));
        drawTriangle(Triangle.Create(
                rectangle.getPoint(0).getX(), rectangle.getPoint(0).getY(),
                rectangle.getPoint(3).getX(), rectangle.getPoint(3).getY(),
                rectangle.getPoint(2).getX(), rectangle.getPoint(2).getY(),
                rectangle.getFillColor()
        ));

        if (rectangle.borderColorStated()) {
            float[] points = new float[] {
                    rectangle.getPoint(0).getX(), rectangle.getPoint(0).getY(),
                    rectangle.getPoint(1).getX(), rectangle.getPoint(1).getY(),
                    rectangle.getPoint(2).getX(), rectangle.getPoint(2).getY(),
                    rectangle.getPoint(3).getX(), rectangle.getPoint(3).getY(),
            };

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
            byteBuffer.order(ByteOrder.nativeOrder());
            vertexBuffer = byteBuffer.asFloatBuffer();
            vertexBuffer.put(points);
            vertexBuffer.position(0);

            GL.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            GL.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
            GL.glColor4f(rectangle.getBorderColor().getR(), rectangle.getBorderColor().getG(), rectangle.getBorderColor().getB(), rectangle.getBorderColor().getA());
            GL.glDrawArrays(GL10.GL_LINE_LOOP, 0, 4);
        }
    }
    public static void Rectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor) {
        drawRectangle(Rectangle.Create(x1, y1, x2, y2, x3, y3, x4, y4, fillColor));
    }
    public static void Rectangle(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, FloatColor fillColor, FloatColor borderColor) {
        drawRectangle(Rectangle.Create(x1, y1, x2, y2, x3, y3, x4, y4, fillColor, borderColor));
    }
    public static void Rectangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor) {
        drawRectangle(Rectangle.Create(point1, point2, point3, point4, fillColor));
    }
    public static void Rectangle(FloatPoint point1, FloatPoint point2, FloatPoint point3, FloatPoint point4, FloatColor fillColor, FloatColor borderColor) {
        drawRectangle(Rectangle.Create(point1, point2, point3, point4, fillColor, borderColor));
    }
    public static void drawEllipse(Ellipse ellipse) {
        int segments = 360;
        float[] points = new float[segments * 2 + 2];

        int count = 0;

        points[count++] = ellipse.getCenter().getX();
        points[count++] = ellipse.getCenter().getY();

        for (float i = ellipse.getFirstAngle(); i < ellipse.getSecondAngle(); i += (ellipse.getAngleSum()/segments)) {
            points[count++] = (float)(ellipse.getCenter().getX() + Math.cos(Math.PI/180.0f * i) * ellipse.getWidth());
            points[count++] = (float)(ellipse.getCenter().getY() + Math.sin(Math.PI/180.0f * i) * ellipse.getHeight());
        }

        for (int i = 2; i < points.length - 2; i += 2) {
            Graphics.Triangle(
                    ellipse.getCenter().getX(),
                    ellipse.getCenter().getY(),
                    points[i],
                    points[i + 1],
                    points[i + 2],
                    points[i + 3],
                    ellipse.getFillColor()
            );
        }

        if (ellipse.getAngleSum() == 360.0f) {
            Graphics.Triangle(
                    ellipse.getCenter().getX(),
                    ellipse.getCenter().getY(),
                    points[2],
                    points[3],
                    points[points.length - 2],
                    points[points.length - 1],
                    ellipse.getFillColor()
            );
        }

        if (ellipse.borderColorStated()) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
            byteBuffer.order(ByteOrder.nativeOrder());
            vertexBuffer = byteBuffer.asFloatBuffer();
            vertexBuffer.put(points);
            vertexBuffer.position(0);

            GL.glVertexPointer(2, GL.GL_FLOAT, 0, vertexBuffer);
            GL.glEnableClientState(GL.GL_VERTEX_ARRAY);
            GL.glColor4f(ellipse.getBorderColor().getR(), ellipse.getBorderColor().getG(), ellipse.getBorderColor().getB(), ellipse.getBorderColor().getA());
            if (ellipse.getAngleSum() == 360.0f)
                GL.glDrawArrays(GL.GL_LINE_LOOP, 1, segments);
            else
                GL.glDrawArrays(GL.GL_LINE_LOOP, 0, segments);
        }
    }
    public static void Ellipse(float centerX, float centerY, float width, float height, FloatColor fillColor) {
        drawEllipse(Ellipse.Create(centerX, centerY, width, height, fillColor));
    }
    public static void Ellipse(float centerX, float centerY, float width, float height, float firstAngle, float secondAngle, FloatColor fillColor) {
        drawEllipse(Ellipse.Create(centerX, centerY, width, height, firstAngle, secondAngle, fillColor));
    }
    public static void Ellipse(float centerX, float centerY, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        drawEllipse(Ellipse.Create(centerX, centerY, width, height, fillColor, borderColor));
    }
    public static void Ellipse(float centerX, float centerY, float width, float height, float firstAngle, float secondAngle, FloatColor fillColor, FloatColor borderColor) {
        drawEllipse(Ellipse.Create(centerX, centerY, width, height, firstAngle, secondAngle, fillColor, borderColor));
    }
    public static void Ellipse(FloatPoint center, float width, float height, FloatColor fillColor) {
        drawEllipse(Ellipse.Create(center, width, height, fillColor));
    }
    public static void Ellipse(FloatPoint center, float width, float height, float firstAngle, float secondAngle, FloatColor fillColor) {
        drawEllipse(Ellipse.Create(center, width, height, firstAngle, secondAngle, fillColor));
    }
    public static void Ellipse(FloatPoint center, float width, float height, FloatColor fillColor, FloatColor borderColor) {
        drawEllipse(Ellipse.Create(center, width, height, fillColor, borderColor));
    }
    public static void Ellipse(FloatPoint center, float width, float height, float firstAngle, float secondAngle, FloatColor fillColor, FloatColor borderColor) {
        drawEllipse(Ellipse.Create(center, width, height, firstAngle, secondAngle, fillColor, borderColor));
    }
}
