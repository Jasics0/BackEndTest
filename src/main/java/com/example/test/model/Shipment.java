package com.example.test.model;

import javax.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "num_guide", unique = true, nullable = false)
    private String guide;
    @Column(name = "type_product", nullable = false)
    private int typeProduct;
    @Column(name = "date_in", nullable = false)
    private String dateIn;
    @Column(name = "date_delivery")
    private String dateDelivery;
    private float price;
    private float discount;
    @Column(name = "id_vehicle", nullable = false)
    private String idVehicle;
    @Column(name = "id_client", nullable = false)
    private String idClient;
    @Column(name = "id_warehouse", nullable = false)
    private int idWarehouse;
    private int quantity;

    public Shipment(int id, String guide, int typeProduct, String dateIn, String dateDelivery, float price, float discount, String idVehicle, String idClient, int idWarehouse, int quantity) {
        this.id = id;
        this.guide = guide;
        this.typeProduct = typeProduct;
        this.dateIn = dateIn;
        this.dateDelivery = dateDelivery;
        this.price = price;
        this.discount = discount;
        this.idVehicle = idVehicle;
        this.idClient = idClient;
        this.idWarehouse = idWarehouse;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shipment() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public int getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(int typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    @Override
    public String
    toString() {
        return "Shipment{" +
                "id=" + id +
                ", guide='" + guide + '\'' +
                ", typeProduct=" + typeProduct +
                ", dateIn='" + dateIn + '\'' +
                ", dateDelivery='" + dateDelivery + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", idVehicle='" + idVehicle + '\'' +
                ", idClient=" + idClient +
                ", idWarehouse=" + idWarehouse +
                ", quantity=" + quantity +
                '}';
    }
}
