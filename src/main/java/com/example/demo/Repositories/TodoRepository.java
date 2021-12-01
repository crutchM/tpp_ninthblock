package com.example.demo.Repositories;

import com.example.demo.Models.TodoEntry;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TodoRepository {
    private final Map<Integer, TodoEntry> entryMap = new HashMap<>();

    public void add(TodoEntry todo){
        entryMap.put(todo.getId(), todo);
    }

    public Collection<TodoEntry> getAll(){
        return entryMap.values();
    }

    public boolean switchIsDone(Integer id){
        return entryMap.get(id).switchIsDone();
    }

    public void remove(int id){
        entryMap.remove(id);
    }
}
