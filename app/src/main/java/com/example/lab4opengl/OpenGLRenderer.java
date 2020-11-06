package com.example.lab4opengl;

import android.opengl.GLSurfaceView;

import com.example.lab4opengl.Bear.Bear;
import com.example.lab4opengl.Graphics.Graphics;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLRenderer implements GLSurfaceView.Renderer {
    public static MainActivity WindowHandler;
    public OpenGLRenderer(MainActivity windowHandler) { WindowHandler = windowHandler; }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) { Graphics.createGraphics(gl); }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) { Graphics.SetViewport(width, height); }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        Graphics.Clear();
        Bear.Draw();
        Graphics.LoadIdentity();
    }
}
