package dev.ajith.ProductServiceoct2026.Service;

import dev.ajith.ProductServiceoct2026.Client.Fakestoreclient;
import dev.ajith.ProductServiceoct2026.DTO.FakestoreProductdto;
import dev.ajith.ProductServiceoct2026.Exception.Productnotfoundexception;
import dev.ajith.ProductServiceoct2026.Model.Product;
import dev.ajith.ProductServiceoct2026.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private Fakestoreclient fakestoreclient;
    @Autowired
    private ProductRepository productRepository;

    public Product saveproduct(Product product){
        return productRepository.save(product);
    }
    public boolean dltproduct(int id){
        productRepository.deleteById(id); return true;
    }
    public  Product getProduct(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new Productnotfoundexception("product with id "+id+" not found");
        } else{
            return product.get();
        }
    }
    public List<Product> getallProducts(){
      return  productRepository.findAll();
    }
    public Product updateProduct(Product newproduct,int id){
        Product savedProduct = getProduct(id);
        newproduct.setId(id);
        productRepository.save(newproduct);
        return newproduct;

    }

    public FakestoreProductdto getproduct(int id){
      return  fakestoreclient.getproductbyiid(id);
    }
    public FakestoreProductdto[] getallproducts(){
      return  fakestoreclient.getalllproducts();
    }
    public FakestoreProductdto createproduct(FakestoreProductdto fakestoreProductdto){
            return fakestoreclient.createproduct(fakestoreProductdto);
    }
    public FakestoreProductdto replaceproduct(int id, FakestoreProductdto fakestoreProductdto) {
        return fakestoreclient.replaceproduct(id,fakestoreProductdto);
    }
    public boolean deleteproduct(int id){
        return fakestoreclient.deleteproduct(id);
    }
}
