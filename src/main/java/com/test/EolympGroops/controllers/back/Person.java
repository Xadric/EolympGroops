package com.test.EolympGroops.controllers.back;

import java.util.ArrayList;

public class Person {
    String login;
    ArrayList<Integer> tasks=new ArrayList<>();
    public int sumTasks = 0;

    public Person() {
    }

//    public addTask(String task){
//        tasks.add(task);
//    }


    public void addTasks(String task) {
        tasks.add(Integer.valueOf(task));
//        sumTasks++;
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

    public ArrayList<Integer> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Integer> tasks) {
        this.tasks = tasks;
    }
}
