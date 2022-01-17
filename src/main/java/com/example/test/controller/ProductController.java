package com.example.test.controller;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteProductById(@PathVariable("id") int id) {
        boolean done = productService.deleteProduct(id);
        return (done) ? "Se eliminó el producto con id: " + id : "No se pudo eliminar el producto";
    }

    @PutMapping(path = "/{id}")
    public String updateProductById(@RequestBody Product product, @PathVariable("id") int id) {
        boolean done = productService.updateProduct(product,id);
        return (done) ? "Se actualizó el producto con id: " + id : "No se pudo actualizar el producto";
    }
}
