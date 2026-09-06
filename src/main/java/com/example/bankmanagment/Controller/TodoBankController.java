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
    public ApiResponseBank add(@PathVariable String ID, @PathVariable String username, @PathVariable double balance){
        TodoBank todo = new TodoBank(ID,username,balance);
        todos.add(todo);
        return new ApiResponseBank("Customer added");
    }
    @DeleteMapping("/delete/{ID}")
    public ApiResponseBank delete(@PathVariable String ID){
        TodoBank todo;
        for (TodoBank value : todos){
            if ( value.getID().equalsIgnoreCase(ID))
                todos.remove(value);
        }
        return new ApiResponseBank("Customer removed");
    }

    @PutMapping("/deposit/{ID}/{balance}")
    public ApiResponseBank deposit(@PathVariable String ID, @PathVariable double balance){
        for (TodoBank value : todos){
            if ( value.getID().equalsIgnoreCase(ID))
                value.setBalance(value.getBalance()+balance);
        }
        return new ApiResponseBank("money deposited");
    }

    @PutMapping("/withdraw/{ID}/{balance}")
    public ApiResponseBank withdraw(@PathVariable String ID, @PathVariable double balance){
        for (TodoBank value : todos){
            if ( value.getID().equalsIgnoreCase(ID))
                value.setBalance(value.getBalance()-balance);
        }
        return new ApiResponseBank("money withdrew");
    }

}
