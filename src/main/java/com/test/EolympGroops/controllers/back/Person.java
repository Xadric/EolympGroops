package com.test.EolympGroops.controllers.back;

import java.util.ArrayList;

public class Person {
    String login;
    ArrayList<String> tasks=new ArrayList<>();

    public Person() {
    }

//    public addTask(String task){
//        tasks.add(task);
//    }


    public void addTasks(String task) {
        tasks.add(task);
    }

    public Person(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
    }
}
