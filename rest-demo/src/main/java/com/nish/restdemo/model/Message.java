package com.nish.restdemo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Message {
    @Id
    private int id;
    private String message;
    private String author;
    private String created;

}
