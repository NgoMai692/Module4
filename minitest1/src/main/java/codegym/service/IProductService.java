package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;

public interface IProductService {
    ArrayList<Product> getAllProduct();

    ArrayList<Product> findProductByName(String key);

    Product saveProduct(Product product);

    Product deleteProduct(int id);

    Product getProduct(int id);
}
