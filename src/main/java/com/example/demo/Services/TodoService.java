package com.example.demo.Services;

import com.example.demo.Models.TodoEntry;
import com.example.demo.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private int index = 0;

    @Autowired
    private TodoRepository repository;


    public List<TodoEntry> getAll(){
        return new ArrayList<>(repository.getAll());
    }

    public boolean switchIsDone(int id){
        return repository.switchIsDone(id);
    }

    public TodoEntry add(String label){
        TodoEntry res = new TodoEntry(++index, label, false);
        repository.add(res);
        return res;
    }

    public void remove(int id){
        repository.remove(id);
    }
}
