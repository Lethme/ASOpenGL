package com.example.lab4opengl.Graphics.Pictures;

import com.example.lab4opengl.Graphics.Figures.Figure;

import java.util.ArrayList;

public interface Pictures {
    public <T extends Figure> ArrayList<T> getFigures();
}
