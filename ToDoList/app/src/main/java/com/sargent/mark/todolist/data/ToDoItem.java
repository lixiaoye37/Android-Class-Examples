package com.sargent.mark.todolist.data;

/**
 * Created by mark on 7/4/17.
 */

public class ToDoItem {
    private String description;
    private String dueDate;
    private Integer done;
    private String category;

    public ToDoItem(String description, String dueDate,int done,String category) {

        this.description = description;
        this.dueDate = dueDate;
        //add two variable in the todoItem class
        this.done=done;
        this.category=category;

    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
