package com.example.test.model;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

// Modelo de la entidad

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "id_card", unique = true, nullable = false)
    @NotNull(message = "La cedula no debe ser nula.")
    private String idCard;
    @Column(nullable = false)
    @NotNull(message = "El nombre no debe ser nulo.")
    private String name;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Client() {

    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", id_card='" + idCard + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
