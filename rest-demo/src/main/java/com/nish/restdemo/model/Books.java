package com.nish.restdemo.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity
@Entity
//defining DB table name as class name
@Table
@Getter @Setter @NoArgsConstructor
public class Books {
    //Defining book id as primary key
    @Id
    @Column
    private int bookId;
    @Column
    private String bookName;
    @Column
    private String author;
    @Column
    private int price;

}
