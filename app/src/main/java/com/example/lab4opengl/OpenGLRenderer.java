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
    private float angle = 0.0f;

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {
        //Устанавливаем цвет очистки("заливки") экрана в черный
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        //Устанавливаем X, Y, Z координаты точек вершин и записываем их в массив vertices
        vertices = new float[]{-0.5f, -0.5f, 0.0f, -0.5f, 0.5f, 0.0f, 0.5f, -0.5f, 0.0f, 0.5f, 0.5f, 0.0f};
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
        gl.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
        //Указываем размер, тип и буфер с точками
        //Третий параметр, который равен нулю, нас пока не интересует
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        //Рисуем по принципу GL_TRIANGLE_STRIP
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
        //Сбрасываем матрицу(об этом ниже)
        gl.glLoadIdentity();
        //Вращаем текущую матрицу(наш объект, если сильно утрировать)
        gl.glRotatef(angle, 1.0f, 1.0f, 1.0f);
        angle++;
    }
}
