package dev.ajith.Productderviceoct2026.Client;

import dev.ajith.Productderviceoct2026.DTO.FakestoreProductdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Fakestoreclient {
    @Autowired
    private RestTemplate restTemplate ;
    public FakestoreProductdto getproductbyiid(int id)
    {
        String getproduct ="https://fakestoreapi.com/products/1";
        FakestoreProductdto fspdto=restTemplate.getForObject(getproduct,FakestoreProductdto.class);
        return fspdto;
    }
    public FakestoreProductdto[]  getalllproducts()
    {
        String getproduct ="https://fakestoreapi.com/products";
        FakestoreProductdto[] fspdtos=restTemplate.getForObject(getproduct,FakestoreProductdto[].class);
        return fspdtos;
    }

}
