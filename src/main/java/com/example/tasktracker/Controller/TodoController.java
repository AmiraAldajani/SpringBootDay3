package com.example.tasktracker.Controller;


import com.example.tasktracker.Api.ApiResponse;
import com.example.tasktracker.Model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    ArrayList<Todo> todos = new ArrayList<>();

    @PostMapping("/create/{ID}/{title}/{description}/{status}")
    public ApiResponse createTask(@PathVariable String ID, @PathVariable String title, @PathVariable String description, @PathVariable boolean status){
        Todo todo = new Todo(ID, title, description, status);
        todos.add(todo);
        return  new ApiResponse("Task created!");
    }

    @GetMapping("/get")
    public ArrayList<Todo> getTodos(){
        return todos;
    }

    @PutMapping("/update/{ID}/{title}/{description}/{status}")
    public ApiResponse updateTask(@PathVariable String ID, @PathVariable String title, @PathVariable String description, @PathVariable boolean status){
        for (Todo value: todos){
            if (value.getID().equalsIgnoreCase(ID)){
                value.setTitle(title);
                value.setDescription(description);
                value.setStatus(status);
            }
        }
        return new ApiResponse("Task updated");
    }
    @PutMapping("/delete/{ID}")
    public ApiResponse deleteTask(@PathVariable String ID){
        for (Todo value: todos){
            if (value.getID().equalsIgnoreCase(ID)) {
                todos.remove(value);
            }
        }
        return new ApiResponse("Task updated");
    }
    @PutMapping("/chengestatus/{ID}/{isDone}")
    public ApiResponse deleteTask(@PathVariable String ID, @PathVariable String isDone){
        for (Todo value: todos){
            if (value.getID().equalsIgnoreCase(ID)) {
                if (isDone.equalsIgnoreCase("done"))
                    value.setStatus(true);
                else value.setStatus(false);
            }
        }
        return new ApiResponse("Status changed");
    }
    @GetMapping("/getbytitle/{title}")
    public Todo getTodosByTitle( @PathVariable String title){
        Todo todo;
        for (int i=0; i< todos.size();i++){
            if (todos.get(i).getTitle().equalsIgnoreCase(title)) {
                todo = todos.get(i);
                return todo;
            }
        }
        return null;
    }




}
