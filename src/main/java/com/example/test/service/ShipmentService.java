package com.example.test.service;

import com.example.test.model.Client;
import com.example.test.model.Product;
import com.example.test.model.Shipment;
import com.example.test.model.Warehouse;
import com.example.test.repositories.ProductRepository;
import com.example.test.repositories.ShipmentRepository;
import com.example.test.repositories.WarehouseRepository;
import com.example.test.utilities.FormatValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShipmentService {
    @Autowired
    ShipmentRepository shipmentRepository;
    @Autowired
    ProductService productService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    ClientService clientService;

    public ArrayList<Shipment> getShipments() {

        return (ArrayList<Shipment>) shipmentRepository.findAll();
    }

    public Shipment saveShipment(Shipment shipment) {

        Warehouse originalWarehouse = warehouseService.getWarehouseById(shipment.getIdWarehouse()).get();

        Product originalProduct = productService.getProductById(shipment.getTypeProduct()).get();
        Client originalClient = clientService.getClientByCard(shipment.getIdClient()).get();

        shipment.setIdClient(originalClient.getId()+"");

        Shipment aux = null;
        String cadena = "";

        do {
            cadena = RandomStringUtils.randomAlphanumeric(10).toUpperCase();
        } while (shipmentRepository.validateGuide(cadena) != 0);
        shipment.setGuide(cadena);
        shipment.setPrice(originalProduct.getPriceUnit() * shipment.getQuantity());

        // Si la cantidad de productos es superior a 10 unidades, se deberá otorgar un descuento del 5% al precio de envío para la logística terrestre y un 3% para la logística marítima y dejar registrado el precio normal y el descuento otorgado.
        //1 representa transporte terrestre, 2 transporte maritimo

        FormatValidator f = new FormatValidator();
        f.validateDate(shipment.getDateIn());

        if (originalWarehouse.getType() == 1) {
            f.validateVehicle(shipment.getIdVehicle());
            if (shipment.getQuantity() > 10) {
                shipment.setDiscount(shipment.getPrice() * 0.05f);
            }

        } else if (originalWarehouse.getType() == 2) {
            f.validateNumberBoat(shipment.getIdVehicle());
            if (shipment.getQuantity() > 10) {
                shipment.setDiscount(shipment.getPrice() * 0.03f);
            }
        } else {
            throw new IllegalArgumentException("Tipo de producto incorrecto. 1. Para envío terrestre 2. Para envío maritimo");
        }

        return shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipmentById(int id) {
        return shipmentRepository.findById(id);
    }

    public boolean deleteShipment(int id) {
        try {
            shipmentRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }

    public boolean updateShipment(Shipment shipment, int id) {
        try {
            Optional<Shipment> s = shipmentRepository.findById(id);
            Shipment originalShipment = s.get();
            shipmentRepository.save(originalShipment);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
