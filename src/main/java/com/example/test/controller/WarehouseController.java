package com.example.test.controller;

import com.example.test.model.Warehouse;
import com.example.test.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/depositos")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @GetMapping()
    public ArrayList<Warehouse> getWarehouses() {
        return warehouseService.getWarehouses();
    }


    @PostMapping()
    public Warehouse saveWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.saveWarehouses(warehouse);
    }

    @GetMapping(path = "/{id}")
    public Optional<Warehouse> getWarehouseById(@PathVariable("id") int id) {
        return warehouseService.getWarehouseById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteWarehouseById(@PathVariable("id") int id) {
        boolean done = warehouseService.deleteWarehouse(id);
        return (done) ? "Se eliminó el deposito con id: " + id : "No se pudo eliminar el deposito";
    }
}
