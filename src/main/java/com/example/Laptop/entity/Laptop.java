package com.example.Laptop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "Laptop")
@ApiModel("Entidad laptop para obtener todos los registro de laptop de una organizacion")
public class Laptop {

    //atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Es una clave primaria id autoincremental")
    private Long id;
    private String description;
    @ApiModelProperty("Price de tipo Double para separar el decimal con . ejemplo: 30.00")
    private Double price;
    private int stock;

    //contructor vacio

    public Laptop() {
    }

    //Constructor con

    public Laptop(Long id, String description, Double price, int stock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }


    //metodos

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    //to String

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
