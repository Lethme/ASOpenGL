package com.example.lab4opengl.Graphics.Pictures;

import com.example.lab4opengl.Graphics.Figures.Figure;
import com.example.lab4opengl.Graphics.Graphics;

import java.util.ArrayList;

public class Picture {
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
}
