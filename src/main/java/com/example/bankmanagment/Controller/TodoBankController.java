package com.example.bankmanagment.Controller;

import com.example.bankmanagment.Model.TodoBank;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/todo")

public class TodoBankController {
    ArrayList<TodoBank> todos = new ArrayList<>();

}
