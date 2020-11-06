package com.example.lab4opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Graphics {
    private static GL10 GL;
    private static FloatBuffer vertexBuffer;
    public static void createGraphics(GL10 gl) {
        GL = gl;
    }
    public static void drawTriangle(Triangle triangle) {
        float points[] = new float[] {
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
}
