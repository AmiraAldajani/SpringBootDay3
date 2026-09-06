package com.example.bankmanagment.Controller;

import com.example.bankmanagment.Api.ApiResponseBank;
import com.example.bankmanagment.Model.TodoBank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todo")

public class TodoBankController {
    ArrayList<TodoBank> todos = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TodoBank> getall(){
        return todos;
    }

    @PostMapping("/add/{ID}/{username}/{balance}")
    public ApiResponseBank add(@PathVariable String ID, @PathVariable String username, @PathVariable String balance){
        TodoBank todo = new TodoBank(ID,username,balance);
        todos.add(todo);
        return new ApiResponseBank("Customer added");
    }


}
