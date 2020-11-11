package com.example.lab4opengl.Graphics.Pictures;

import com.example.lab4opengl.Graphics.Figures.Ellipse;
import com.example.lab4opengl.Graphics.Figures.Line;
import com.example.lab4opengl.Graphics.Figures.Rectangle;
import com.example.lab4opengl.Graphics.Figures.Triangle;

import java.util.ArrayList;

public interface Pictures {
    public ArrayList<Triangle> getTriangles();
    public ArrayList<Rectangle> getRectangles();
    public ArrayList<Ellipse> getEllipses();
    public ArrayList<Line> getLines();
}
