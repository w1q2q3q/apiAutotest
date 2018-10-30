package com.example.demo.Entity;

import lombok.Data;


@Data
public class Person {

     private int id;

     private String data;

     private String name;

     private int state;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getData() {
          return data;
     }

     public void setData(String data) {
          this.data = data;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public int getState() {
          return state;
     }

     public void setState(int state) {
          this.state = state;
     }

     @Override
     public String toString() {
          return "Person{" +
                  "id=" + id +
                  ", data='" + data + '\'' +
                  ", name='" + name + '\'' +
                  ", state=" + state +
                  '}';
     }
}
