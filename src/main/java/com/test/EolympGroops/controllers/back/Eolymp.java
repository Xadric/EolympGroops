package com.test.EolympGroops.controllers.back;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Eolymp {
    WebDriver driver = new ChromeDriver();
    String eolymp_url="https://www.eolymp.com/ru/users/";

    private void visitEolymp(String login){
//        driver.navigate().to(eolymp_url+login+"/punchcard");
        driver.get(eolymp_url+login+"/punchcard");
    }

/*    @Test
    public int eolympTest(){
        String login="artem_linnik";
        int task = 263;
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        visitEolymp(login);
        List<WebElement> elements=driver.findElements(By.className("eo-punchcard__cell"));
        for (WebElement element : elements) {
            if (element.getAttribute("href").equals("https://www.eolymp.com/ru/problems/"+task)){
                System.out.println(getProssent(element.getAttribute("title")));
                return getProssent(element.getAttribute("title"));
            }
        }


        return 0;
    }*/
    public String eolymp(String login , String task){
        System.out.println(login+" "+task);
//        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromeDriver\\chromedriver.exe");
        visitEolymp(login);
        List<WebElement> elements=driver.findElements(By.className("eo-punchcard__cell"));
        for (WebElement element : elements) {
            if (element.getAttribute("href").equals("https://www.eolymp.com/ru/problems/"+task)){
                System.out.println(getProssent(element.getAttribute("title")));
                String rez = getProssent(element.getAttribute("title"));
//                driver.quit();
                return rez;
            }
        }


        return "0";
    }


    private String getProssent(String title) {
        String[] s = title.split(" ");
        String last=s[s.length - 1];
        return last.substring(0,last.length()-1);

    }

}

