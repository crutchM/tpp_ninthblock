package com.example.demo.Models;

import java.io.Serializable;
import java.util.Objects;

public class TodoEntry implements Serializable {
    private final int id;

    private final String label;

    private boolean isDone;

    public TodoEntry(int id, String label, boolean isDone){
        this.id = id;
        this.label = label;
        this.isDone = isDone;
    }


    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean switchIsDone(){
        this.isDone = !this.isDone;
        return this.isDone;
    }

    public String isDoneStr(){
        return isDone ? "Uncheck" : "Check";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        TodoEntry td = (TodoEntry) o;
        return id == td.id && label.equals(td.label);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, label);
    }

    @Override
    public String toString(){
        return label;
    }
}
