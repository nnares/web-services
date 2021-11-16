package com.nish.restdemo.model;



import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

//mark class as an Entity
@Entity
//defining DB table name as class name
@Table(name = "books")

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Books {
    //Defining book id as primary key
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    int bookId;
    @Column(name = "book_name", nullable = false)
    String bookName;
    @Column
    String author;
    @Column
    int price;

}
