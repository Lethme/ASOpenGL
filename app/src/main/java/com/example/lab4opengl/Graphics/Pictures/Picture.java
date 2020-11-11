package com.example.lab4opengl.Graphics.Pictures;

import com.example.lab4opengl.Graphics.Figures.Ellipse;
import com.example.lab4opengl.Graphics.Figures.Figure;
import com.example.lab4opengl.Graphics.Figures.Line;
import com.example.lab4opengl.Graphics.Figures.Rectangle;
import com.example.lab4opengl.Graphics.Figures.Triangle;
import com.example.lab4opengl.Graphics.Graphics;

import java.util.ArrayList;

public class Picture implements Pictures {
    protected ArrayList<Figure> figures;

    public Picture() {
        this.figures = new ArrayList<Figure>();
    }
    public Picture(Figure... figures) {
        this.figures = new ArrayList<Figure>();
        Add(figures);
    }

    public void Add(Figure... figures) {
        for (Figure figure : figures) {
            this.figures.add(figure);
        }
    }

    public void Draw() {
        Graphics.Clear();
        for (Figure figure : this.figures) {
            figure.draw();
        }
        Graphics.LoadIdentity();
    }

    public static Picture Create() {
        return new Picture();
    }
    public static Picture Create(Figure... figures) {
        return new Picture(figures);
    }

    @Override
    public ArrayList<Triangle> getTriangles() {
        ArrayList<Triangle> list = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getClass() == Triangle.class) {
                list.add((Triangle) figure);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Rectangle> getRectangles() {
        ArrayList<Rectangle> list = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getClass() == Rectangle.class) {
                list.add((Rectangle) figure);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Ellipse> getEllipses() {
        ArrayList<Ellipse> list = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getClass() == Ellipse.class) {
                list.add((Ellipse) figure);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Line> getLines() {
        ArrayList<Line> list = new ArrayList<>();
        for (Figure figure : figures) {
            if (figure.getClass() == Line.class) {
                list.add((Line) figure);
            }
        }
        return list;
    }
}
