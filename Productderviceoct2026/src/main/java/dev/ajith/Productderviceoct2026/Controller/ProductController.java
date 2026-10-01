package dev.ajith.Productderviceoct2026.Controller;

import dev.ajith.Productderviceoct2026.DTO.FakestoreProductdto;
import dev.ajith.Productderviceoct2026.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public FakestoreProductdto[] getallproductss() {
        return productService.getallproducts();

    }

    @GetMapping("/product/{id}")
    public FakestoreProductdto getproductbyid(@PathVariable int id) {
        return productService.getproduct(id);

    }
}
