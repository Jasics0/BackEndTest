package com.example.test.service;

import com.example.test.model.Product;
import com.example.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> getProducts(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product saveProduct(Product product){
        if(product.getName()=="null" ||product.getPriceUnit()==0 ){
            throw new NullPointerException("Verifique que los datos necesarios fueron ingresados.");
        }
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(int id){
        return productRepository.findById(id);
    }

    public boolean deleteProduct(int id){
        try {
            productRepository.deleteById(id);
            return true;
        }catch (Exception error){
            return false;
        }
    }

    public boolean updateProduct(Product product,int id){
        try {

            Product originalProduct=productRepository.findById(id).get();
            originalProduct.setName(product.getName());
            originalProduct.setDescription(product.getDescription());
            originalProduct.setPriceUnit(product.getPriceUnit());
            productRepository.save(originalProduct);
            return true;
        }catch (Exception error){
            return false;
        }
    }
}
