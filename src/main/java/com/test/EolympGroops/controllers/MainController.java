package com.test.EolympGroops.controllers;

import com.test.EolympGroops.controllers.back.Eolymp;
import com.test.EolympGroops.controllers.back.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    ArrayList<Person> persons = new ArrayList<Person>();
    ArrayList<String> tasks = new ArrayList<>(List.of(new String[]{"name"}));




    @GetMapping("/")
    public String main(Model model){
        Eolymp eolymp = new Eolymp();

        for (int i = 0; i < persons.size(); i++) {
            ArrayList<String> persons_help = new ArrayList<String>();
            for (int j = 1; j < tasks.size(); j++) {
                persons_help.add(eolymp.eolymp(persons.get(i).getLogin(), tasks.get(j)));
            }
            persons.get(i).setTasks(persons_help);
        }


        model.addAttribute("title","Main page");
        model.addAttribute("persons",persons);
        model.addAttribute("tasks",tasks);
//        model.addAttribute("prossent",prossent);
        return "main";
    }
    /*@GetMapping("/sasa")
    public String sasa(Model model) {
     //   model.addAttribute("title", "Main page");
       // return "addPerson";
        return "sassa";
    }*/



    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String login, Model model){
        Eolymp eolymp = new Eolymp();
        Person person = new Person(login);


        for (int j = 1; j < tasks.size(); j++) {
            person.addTasks(eolymp.eolymp(person.getLogin(), tasks.get(j)));
        }
        persons.add(person);

        model.addAttribute("title","Main page");
        model.addAttribute("persons",persons);
        model.addAttribute("tasks",tasks);
//        return "redirect:/";
        return "main";
    }

    @GetMapping("/addTask")
    public String addTask(Model model){
        model.addAttribute("title","Main page");
        return "addTask";
    }
    @PostMapping("/addTask")
    public String addTask(@RequestParam String task, Model model){
        Eolymp eolymp = new Eolymp();

        tasks.add(task);

        model.addAttribute("title","Main page");
        model.addAttribute("persons",persons);
        model.addAttribute("tasks",tasks);
//        return "redirect:/";
        return "main";
    }


}
