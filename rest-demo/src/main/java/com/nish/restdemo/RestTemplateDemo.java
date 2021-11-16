package com.nish.restdemo;

import com.nish.restdemo.model.Books;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/*
*
* https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
* */
public class RestTemplateDemo {
    public static void main(String[] args) {

        restTemplatePOSTmthd();
        restTemplateGETmthd();

    }

    private static void restTemplateGETmthd() {

        RestTemplate restTemplate = new RestTemplate();
        String bookResourceUrl = "http://localhost:8090/books";
        // in String - xml
        ResponseEntity<String> response = restTemplate.getForEntity(bookResourceUrl + "/6830", String.class);
        if(response.getStatusCode().equals(HttpStatus.OK))
            System.out.println("response = " + response.getBody());

        // in POJO
        ResponseEntity<Books> response1 = restTemplate.getForEntity(bookResourceUrl + "/6830", Books.class);
        if(response1.getStatusCode().equals(HttpStatus.OK))
            System.out.println("response = " + response1.getBody());

    }

    private static void restTemplatePOSTmthd() {
        RestTemplate restTemplate = new RestTemplate();
        String bookResourceUrl = "http://localhost:8090/books";

        HttpEntity<Books> request = new HttpEntity<>(new Books(9999, "Concurrency In Practice -1", "Brian Goetz -1", 1500));
        Books books = restTemplate.postForObject(bookResourceUrl, request, Books.class);
        if(null != books)
            System.out.println("books = " + books);

    }

}
