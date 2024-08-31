package com.easternpearl.tasktracker.Db;

import com.easternpearl.tasktracker.medel.Category;
import com.easternpearl.tasktracker.medel.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

public class ArrayDatabase implements Database{
    private static ArrayDatabase database;

    public static Database getDatabase() {
        if(database == null) database = new ArrayDatabase();
        return database;
    }

    ArrayList<ToDo> todos = new ArrayList<>();
    ArrayList<Category> categories = new ArrayList<>();


    private void addsamples(){

        todos.add(new ToDo(1,"Buy groceries",2, "Milk, Bread, Eggs", false,LocalDate.parse("2023-02-02"),null));
        todos.add(new ToDo(2,"Read book",3, "Finish reading 'JavaFX for Dummies'", true,LocalDate.parse("2023-02-02"),LocalDate.parse("2024-02-02")));
        todos.add(new ToDo(3,"Exercise",1, "Go for a 30-minute run", false,LocalDate.parse("2023-02-02"),LocalDate.parse("2023-02-02")));

        categories.add(new Category(1,"home work"));
        categories.add(new Category(2,"company work"));
        categories.add(new Category(3,"hobby work"));

    }

    private ArrayDatabase(){
        addsamples();
    }


    @Override
    public void AddToto(ToDo newToDo) {
        todos.add(newToDo);
    }

    @Override
    public ArrayList<ToDo> GetToDoAll() {
        return todos;
    }

    @Override
    public void UpdateTodo(ToDo updatedTodo) {
        for (int i = 0; i < todos.size(); i++) {
            if(todos.get(i).getId() == updatedTodo.getId()){
                todos.get(i).setId(updatedTodo.getId());
                todos.get(i).setDescription(updatedTodo.getDescription());
                todos.get(i).setFinished(updatedTodo.getFinished());
                todos.get(i).setTitle(updatedTodo.getTitle());
            }
        }
    }


// category area =========================================================================;
    @Override
    public void deleteTodo(ToDo deleteTodo) {
            this.todos.remove(todos.indexOf(deleteTodo));
    }

    @Override
    public ArrayList<ToDo> searchToDo(String searchText) {
        return null;
    }

    @Override
    public ArrayList<Category> getCategoryAll() {
        return categories;
    }

    @Override
    public Category getCategory(int CategoryId) {
        return null;
    }

    @Override
    public void addCategory(Category category) {

    }

    @Override
    public void editCategory(Category category) {

    }

    @Override
    public void deleteCategory(Category category) {

    }

    //=======================================================


}
