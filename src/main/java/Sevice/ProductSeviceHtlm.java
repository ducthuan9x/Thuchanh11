package Sevice;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSeviceHtlm implements ProductSevice{
    List<Product>productList;
    public ProductSeviceHtlm() {
        productList=new ArrayList<>();
        productList.add(new Product(1,"May Giat",310));
        productList.add(new Product(2,"Dieu Hoa",200));
        productList.add(new Product(3,"Tu Lanh",180));
        productList.add(new Product(4,"Tivi",250));
        productList.add(new Product(5,"Lo Vi Song",230));

    }


    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public int findIndexById(int id) {
        int indexOf=-1;
        for(int i=0; i<productList.size();i++){
            if(id==productList.get(i).getId()){
                indexOf=i;
            }
        }
        return indexOf;
    }

    @Override
    public List<Product> finByName(String name) {
        return null;
    }

    @Override
    public void edit(int id, Product product) {
        int indexOf=findIndexById(id);
        productList.set(indexOf,product);
    }

    @Override
    public void delete(int id) {
        int indexOf=findIndexById(id);
        productList.remove(indexOf);
    }

    @Override
    public Product findById(int id) {
        for (Product product:productList) {
            if(product.getId()==id)
                return product;
        }
        return null;
    }

}
