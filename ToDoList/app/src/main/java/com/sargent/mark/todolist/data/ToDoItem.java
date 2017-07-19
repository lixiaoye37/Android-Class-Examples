package com.sargent.mark.todolist.data;

/**
 * Created by mark on 7/4/17.
 */

public class ToDoItem {
    private String description;
    private String dueDate;
    private int done;

    public ToDoItem(String description, String dueDate,int done) {
        this.description = description;
        this.dueDate = dueDate;
        this.done=done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    //seter getter for done
    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }
}
