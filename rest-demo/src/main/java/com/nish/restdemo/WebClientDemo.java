package com.nish.restdemo;

import com.nish.restdemo.model.Books;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class WebClientDemo {

    private WebClient webClient = WebClient.create();

    public static void main(String[] args) {

        WebClientDemo ref = new WebClientDemo();

        Mono<Books[]> response1 = ref.listBooksArray();
        response1.block();
        System.out.println("===============================================");
        Mono<String> response2 = ref.listBooksString();
        response2.block();

    }

    private Mono<Books[]> listBooksArray() {
        return webClient.get()
                .uri("http://localhost:8090/books")
                .retrieve()
                .bodyToMono(Books[].class);
    }

    private Mono<String> listBooksString() {
        return webClient.get()
                .uri("http://localhost:8090/books")
                .retrieve()
                .bodyToMono(String.class);
    }

}
