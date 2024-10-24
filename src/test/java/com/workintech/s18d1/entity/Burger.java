package com.workintech.s18d1.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Burger {



    private int id;
    private String name;
    private double price;
    private boolean isVegan;
    private BreadType breadType;


}
