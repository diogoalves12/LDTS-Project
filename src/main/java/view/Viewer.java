package view;

import javax.swing.*;

public abstract class Viewer<T> {
    private final T model;

    protected Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(){

    }



}


