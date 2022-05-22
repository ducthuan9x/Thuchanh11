package Sevice;

import Model.Product;

import java.util.List;

public interface ProductSevice {
    void save(Product product);
    List<Product> display();
    int findIndexById(int id);
    List<Product> finByName(String name);
    void edit(int id , Product product);
    void delete(int id);
    Product findById(int  id);
}
