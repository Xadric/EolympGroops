package com.test.EolympGroops.controllers.back;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


public class Eolymp {
    public Integer eolymp( String login,  String task) {
        RestTemplate restTemplate = new RestTemplate();
        String punchcardUrl = "https://www.eolymp.com/ru/users/" + login + "/punchcard";
        ResponseEntity<String> response = restTemplate.getForEntity(punchcardUrl, String.class);
        String responseBody = response.getBody();
        if (responseBody != null && responseBody.contains("/ru/problems/" + task)) {
            Integer title = getTitle(responseBody, task);
            return title;
        } else {
//            return "task not found";
            return -1;
        }
    }

    private Integer getTitle(String responseBody, String task) {
        int startIndex = responseBody.indexOf("/ru/problems/" + task);
        String startString=responseBody.substring(startIndex-12);
        int endIndex = startString.indexOf('%');
        String title = startString.substring(0, endIndex);
        char[] titlec=title.toCharArray();
        if (titlec[0]==' '){
            title=title.substring(1);
        }
        if (titlec[0]==','){
            title=title.substring(2);
        }
//        if(title.substring(1).equals(" ")){
//            title=title.substring(2,title.length());
//        }
        return Integer.valueOf(title);
    }


}
