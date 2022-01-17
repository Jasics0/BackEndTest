package com.example.test.controller;

import com.example.test.model.Shipment;
import com.example.test.service.ShipmentService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/envios")
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;
    @GetMapping()
    public ArrayList<Shipment> getShipments() {
        return shipmentService.getShipments();
    }

    @PostMapping()
    public Shipment saveShipment(@RequestBody Shipment shipment) {
        return shipmentService.saveShipment(shipment);
    }

    @GetMapping(path = "/{id}")
    public Optional<Shipment> getClientById(@PathVariable("id") int id) {
        return shipmentService.getShipmentById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteShipmentById(@PathVariable("id") int id) {
        boolean done = shipmentService.deleteShipment(id);
        return (done) ? "Se eliminó el envío con id: " + id : "No se pudo eliminar el envío";
    }
}
