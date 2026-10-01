package dev.ajith.Productderviceoct2026.Service;

import dev.ajith.Productderviceoct2026.Client.Fakestoreclient;
import dev.ajith.Productderviceoct2026.DTO.FakestoreProductdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private Fakestoreclient fakestoreclient;

    public FakestoreProductdto getproduct(int id){
      return  fakestoreclient.getproductbyiid(id);
    }
    public FakestoreProductdto[] getallproducts(){
      return  fakestoreclient.getalllproducts();
    }
}
