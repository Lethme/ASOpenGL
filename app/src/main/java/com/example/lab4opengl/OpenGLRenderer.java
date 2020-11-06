package com.example.lab4opengl;

import android.opengl.GLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    private FloatBuffer vertexBuffer;
    private float vertices[];
    private final int LightBrownTrianglesCount = 22;
    private final int DarkBrownTrianglesCount = 20;
    private final int WhiteTrianglesCount = 2;
    private final int BlackTrianglesCount = 2;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        //Устанавливаем цвет очистки("заливки") экрана в черный
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        //Устанавливаем X, Y, Z координаты точек вершин и записываем их в массив vertices
        vertices = new float[]{
                /* Dark brown triangles */
                0.0f, 0.0f,
                -0.1f, -0.8f,
                0.1f, -0.8f,

                -0.6f, 0.1f,
                -0.35f, -0.9f,
                -0.1f, -0.8f,

                0.6f, 0.1f,
                0.35f, -0.9f,
                0.1f, -0.8f,

                -0.35f, -0.9f,
                -0.45f, -0.95f,
                -0.08f, -0.95f,

                0.35f, -0.9f,
                0.45f, -0.95f,
                0.08f, -0.95f,

                -0.475f, -0.4f,
                -0.7f, -0.95f,
                -0.75f, -0.92f,

                0.475f, -0.4f,
                0.7f, -0.95f,
                0.75f, -0.92f,

                0.0f, 0.0f,
                -0.4f, 0.6f,
                -0.35f, 0.3f,

                0.0f, 0.0f,
                0.4f, 0.6f,
                0.35f, 0.3f,

                0.0f, 0.15f,
                -0.1f, 0.2f,
                0.1f, 0.2f,

                0.0f, 0.2f,
                -0.1f, 0.2f,
                -0.08f, 0.23f,

                0.0f, 0.2f,
                0.1f, 0.2f,
                0.08f, 0.23f,

                0.0f, 0.2f,
                -0.08f, 0.23f,
                0.0f, 0.25f,

                0.0f, 0.2f,
                0.08f, 0.23f,
                0.0f, 0.25f,

                0.0f, 0.6f,
                -0.3f, 0.7f,
                0.3f, 0.7f,

                -0.3f, 0.7f,
                0.3f, 0.7f,
                0.0f, 0.8f,

                -0.3f, 0.7f,
                -0.36f, 0.74f,
                -0.4f, 0.7f,

                0.3f, 0.7f,
                0.36f, 0.74f,
                0.4f, 0.7f,

                -0.3f, 0.7f,
                -0.4f, 0.7f,
                -0.38f, 0.62f,

                0.3f, 0.7f,
                0.4f, 0.7f,
                0.38f, 0.62f,
                /* Dark brown triangles */

                /* Light brown triangles */
                -0.1f, -0.8f,
                -0.35f, -0.9f,
                -0.08f, -0.95f,

                0.1f, -0.8f,
                0.35f, -0.9f,
                0.08f, -0.95f,

                -0.1f, -0.8f,
                0.1f, -0.8f,
                -0.08f, -0.95f,

                0.1f, -0.8f,
                -0.08f, -0.95f,
                0.08f, -0.95f,

                -0.475f, -0.4f,
                -0.7f, -0.95f,
                -0.35f, -0.9f,

                0.475f, -0.4f,
                0.7f, -0.95f,
                0.35f, -0.9f,

                -0.45f, -0.95f,
                -0.7f, -0.95f,
                -0.35f, -0.9f,

                0.45f, -0.95f,
                0.7f, -0.95f,
                0.35f, -0.9f,

                -0.75f, -0.92f,
                -0.85f, -0.8f,
                -0.65f, -0.84f,

                0.75f, -0.92f,
                0.85f, -0.8f,
                0.65f, -0.84f,

                0.0f, 0.0f,
                -0.4f, 0.6f,
                0.0f, 0.6f,

                0.0f, 0.0f,
                0.4f, 0.6f,
                0.0f, 0.6f,

                -0.4f, 0.6f,
                0.0f, 0.6f,
                -0.3f, 0.7f,

                0.4f, 0.6f,
                0.0f, 0.6f,
                0.3f, 0.7f,

                0.0f, 0.0f,
                -0.1f, -0.8f,
                -0.6f, 0.1f,

                0.0f, 0.0f,
                0.1f, -0.8f,
                0.6f, 0.1f,

                -0.35f, 0.3f,
                -0.6f, 0.1f,
                0.0f, 0.0f,

                0.35f, 0.3f,
                0.6f, 0.1f,
                0.0f, 0.0f,

                -0.36f, 0.74f,
                -0.3f, 0.7f,
                -0.15f, 0.75f,

                0.36f, 0.74f,
                0.3f, 0.7f,
                0.15f, 0.75f,

                -0.36f, 0.74f,
                -0.27f, 0.78f,
                -0.15f, 0.75f,

                0.36f, 0.74f,
                0.27f, 0.78f,
                0.15f, 0.75f,
                /* Light brown triangles */

                /* White triangles */
                -0.15f, 0.5f,
                -0.25f, 0.4f,
                -0.05f, 0.4f,

                0.15f, 0.5f,
                0.25f, 0.4f,
                0.05f, 0.4f,
                /* White triangles */

                /* Black triangles */
                -0.15f, 0.5f,
                -0.18f, 0.47f,
                -0.12f, 0.47f,

                0.22f, 0.44f,
                0.25f, 0.4f,
                0.18f, 0.4f,
                /* Black triangles */
        };
        //Создаем буфер вершин, содержащий наш массив
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(vertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        vertexBuffer = byteBuffer.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
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
        //Очищаем буферы. В нашем случае буфер цвета и буфер глубины
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        //Включаем поддержку массивов вершин
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //Устанавливаем цвет серый
        //Указываем размер, тип и буфер с точками
        //Третий параметр, который равен нулю, нас пока не интересует
        gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glColor4f(0.3f, 0.22f, 0.16f, 1.0f);
        for (int i = 0, first = 60; i < LightBrownTrianglesCount; i++, first += 3)
        {
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, first, 3);
        }

        gl.glColor4f(0.2f, 0.15f, 0.12f, 1.0f);
        //Рисуем по принципу GL_TRIANGLE_STRIP
        for (int i = 0, first = 0; i < DarkBrownTrianglesCount; i++, first += 3)
        {
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, first, 3);
        }

        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        //Рисуем по принципу GL_TRIANGLE_STRIP
        for (int i = 0, first = 126; i < WhiteTrianglesCount; i++, first += 3)
        {
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, first, 3);
        }

        gl.glColor4f(0f, 0f, 0f, 1.0f);
        //Рисуем по принципу GL_TRIANGLE_STRIP
        for (int i = 0, first = 132; i < WhiteTrianglesCount; i++, first += 3)
        {
            gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, first, 3);
        }

        //Сбрасываем матрицу(об этом ниже)
        gl.glLoadIdentity();
    }
}
