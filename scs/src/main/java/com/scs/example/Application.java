package com.scs.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by cuixun on 4/20/16.
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("===================================" +
                "Please check the 25 commits here: " + "===================================" + "\n" +
                "http://localhost:8080/commits.html"
                );
    }


}
