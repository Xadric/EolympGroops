package com.test.EolympGroops.controllers;

import com.test.EolympGroops.controllers.back.Eolymp;
import com.test.EolympGroops.controllers.back.Eolymp2;
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
    ArrayList<String> tasks = new ArrayList<>();




    @GetMapping("/")
    public String main(Model model){
        Eolymp eolymp = new Eolymp();

        for (int i = 0; i < persons.size(); i++) {
            ArrayList<Integer> persons_help = new ArrayList<Integer>();
            for (int j = 0; j < tasks.size(); j++) {
                persons_help.add(eolymp.eolymp(persons.get(i).getLogin(), tasks.get(j)));
            }
            persons.get(i).setTasks(persons_help);
        }
        for (int i = 0; i < persons.size(); i++) {
            int sumTasks = 0;
            Person person=persons.get(i);
            for (int j = 0; j < person.getTasks().size(); j++) {
                sumTasks+=person.getTasks().get(j);
            }
            persons.get(i).sumTasks=sumTasks;
        }
        sortPersons();

        model.addAttribute("title","Main page");
        model.addAttribute("persons",persons);
        model.addAttribute("tasks",tasks);
//        model.addAttribute("sumTasks",sumTasks);

//        model.addAttribute("prossent",prossent);
        return "main";
    }

    private void sortPersons() {
        ArrayList<Person> personsHelpSort = new ArrayList<Person>();
        ArrayList<Integer> sumsTasks = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            sumsTasks.add(persons.get(i).sumTasks);
        }
        for (int i = 0; i < sumsTasks.size(); i++) {
            int maxsum=max(sumsTasks);
            int indmaxsum = sumsTasks.indexOf(maxsum);
            personsHelpSort.add(persons.get(indmaxsum));
            sumsTasks.set(indmaxsum,-2);
        }

        persons= (ArrayList<Person>) personsHelpSort.clone();
    }

    private int max(ArrayList<Integer> sumsTasks) {
        int maximum = sumsTasks.get(0);
        for (int i = 1; i < sumsTasks.size(); i++) {
            if (maximum < sumsTasks.get(i))
                maximum = sumsTasks.get(i);
        }
        return maximum;
    }


    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String login, Model model){
        Eolymp eolymp = new Eolymp();
        Person person = new Person(login);


//        for (int j = 0; j < tasks.size(); j++) {
//            person.addTasks(eolymp.eolymp(person.getLogin(), tasks.get(j)));
//        }
        persons.add(person);
        int sumTasks = 0;
        person.sumTasks=sumTasks;





        model.addAttribute("title","Main page");
        model.addAttribute("persons",persons);
        model.addAttribute("tasks",tasks);
//        model.addAttribute("sumTasks",sumTasks);
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
