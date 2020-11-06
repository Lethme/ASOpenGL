package com.example.lab4opengl;

import android.graphics.Point;
import android.opengl.GLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private FloatBuffer vertexBuffer;
    private float[] vertices;
    private Triangle[] triangles;
    private final int LightBrownTrianglesCount = 22;
    private final int DarkBrownTrianglesCount = 20;
    private final int WhiteTrianglesCount = 2;
    private final int BlackTrianglesCount = 2;

    public void drawTriangle(Triangle triangle, GL10 gl)
    {
        float points[] = new float[] {
                triangle.getPoints()[0].getX(), triangle.getPoints()[0].getY(),
                triangle.getPoints()[1].getX(), triangle.getPoints()[1].getY(),
                triangle.getPoints()[2].getX(), triangle.getPoints()[2].getY()
        };
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(points.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(points);
        vertexBuffer.position(0);

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glColor4f(triangle.getColor().getR(), triangle.getColor().getG(), triangle.getColor().getB(), triangle.getColor().getA());
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        //Устанавливаем цвет очистки("заливки") экрана в черный
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        //Устанавливаем X, Y, Z координаты точек вершин и записываем их в массив vertices
        triangles = new Triangle[]{
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

                /* White triangles */
                Triangle.Create(-0.15f, 0.5f, -0.25f, 0.4f, -0.05f, 0.4f, Colors.White),
                Triangle.Create(0.15f, 0.5f, 0.25f, 0.4f, 0.05f, 0.4f, Colors.White),
                /* White triangles */

                /* Black triangles */
                Triangle.Create(-0.15f, 0.5f, -0.18f, 0.47f, -0.12f, 0.47f, Colors.Black),
                Triangle.Create(0.22f, 0.44f, 0.25f, 0.4f, 0.18f, 0.4f, Colors.Black),
                /* Black triangles */
        };
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        //Устанавливаем область отрисовки
        gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        for (Triangle triangle: triangles) {
            drawTriangle(triangle, gl);
        }

        gl.glLoadIdentity();
    }
}
