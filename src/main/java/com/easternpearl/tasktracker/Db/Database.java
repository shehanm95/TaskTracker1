package com.easternpearl.tasktracker.Db;

import com.easternpearl.tasktracker.medel.Category;
import com.easternpearl.tasktracker.medel.ToDo;

import java.util.ArrayList;

public interface Database {

  public void AddToto(ToDo newToDo);
  public ArrayList<ToDo> GetToDoAll();
  public void UpdateTodo(ToDo updatedTodo);
  public void deleteTodo(ToDo deleteTodo);
  public ArrayList<ToDo> searchToDo(String searchText);


  public ArrayList<Category> getCategoryAll();
  public Category getCategory(int CategoryId);
  public void addCategory(Category category);
  public void editCategory(Category category);
  public void deleteCategory(Category category);







  public static Database getDataBase(){
      return ArrayDatabase.getDatabase();
  }

}
