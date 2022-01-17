package com.example.test.service;

import com.example.test.model.Warehouse;
import com.example.test.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public ArrayList<Warehouse> getWarehouses() {
        return (ArrayList<Warehouse>) warehouseRepository.findAll();
    }

    public Warehouse saveWarehouses(Warehouse warehouse) {
        if(warehouse.getName()=="null" ||warehouse.getType()==0 ){
            throw new NullPointerException("Verifique que los datos necesarios fueron ingresados.");
        }
        if (warehouse.getType()!=1 && warehouse.getType()!=2)
            throw new IllegalArgumentException("Tipo de producto incorrecto. 1. Para envío terrestre 2. Para envío maritimo");
        return warehouseRepository.save(warehouse);
    }

    public Optional<Warehouse> getWarehouseById(int id) {
        return warehouseRepository.findById(id);
    }

    public boolean deleteWarehouse(int id) {
        try {
            warehouseRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public boolean updateWarehouse(Warehouse warehouse, int id) {
        try {
            Warehouse originalWarehouse = warehouseRepository.findById(id).get();
            originalWarehouse.setName(warehouse.getName());
            originalWarehouse.setType(warehouse.getType());
            warehouseRepository.save(originalWarehouse);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
