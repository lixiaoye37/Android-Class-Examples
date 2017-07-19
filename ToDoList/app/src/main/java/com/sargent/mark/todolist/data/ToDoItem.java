package com.sargent.mark.todolist.data;

/**
 * Created by mark on 7/4/17.
 */

public class ToDoItem {
    private long id;
    private String description;
    private String dueDate;
    private int done;
    private String category;

    public ToDoItem(long id,String description, String dueDate,int done,String category) {
        this.id=id;
        this.description = description;
        this.dueDate = dueDate;
        this.done=done;
        this.category=category;

    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
