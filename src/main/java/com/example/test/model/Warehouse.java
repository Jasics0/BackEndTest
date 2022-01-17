package com.example.test.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(nullable = false)
    @NotNull(message = "El tipo de deposito no debe ser nulo")
    private int type; //Este valor será 1 o 2 dependiento si es envio por tierra o maritimo.
    @Column(nullable = false)
    @NotNull(message = "El nombde del deposito no debe ser nulo")
    private String name;

    public Warehouse(int id, int type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Warehouse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
