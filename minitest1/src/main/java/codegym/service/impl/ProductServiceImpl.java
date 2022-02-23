package codegym.service.impl;

import codegym.model.Product;
import codegym.repository.IProductRepository;
import codegym.service.IProductService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements IProductService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Autowired
    IProductRepository productRepository;

    @Override
    public ArrayList<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ArrayList<Product> findProductByName(String key) {
        return productRepository.findProductByKey(key);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    public Product deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.findProductById(id);
    }
}
