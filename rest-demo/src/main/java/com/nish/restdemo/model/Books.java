package com.nish.restdemo.model;



import lombok.*;

import javax.persistence.*;

//mark class as an Entity
@Entity
//defining DB table name as class name
@Table(name = "books")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString
public class Books {
    //Defining book id as primary key
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @Column(name = "book_name", nullable = false)
    private String bookName;
    @Column
    private String author;
    @Column
    private int price;

}
