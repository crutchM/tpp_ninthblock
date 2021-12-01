package com.example.demo.Controllers;

import com.example.demo.Models.TodoEntry;
import com.example.demo.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class EntryController {
    @Autowired
    private TodoService _todoService;

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String index(Map<String, Object> map){
        map.put("header", "shopping todos:");
        map.put("todos", _todoService.getAll());
        return "index";
    }

    @ResponseBody
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Map<String, Object> add(@ModelAttribute("label") String label){
        TodoEntry res = _todoService.add(label);
        return Map.of(
                "label", label,
                "id", res.getId(),
                "updTxt", res.isDoneStr()
        );
    }


    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Map<String, Boolean> switchIsDone(@PathVariable("id") int id){
        boolean state = _todoService.switchIsDone(id);
        return Map.of("state", state);
    }

    @ResponseBody
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") int id){
        _todoService.remove(id);
        return "";
    }
}
