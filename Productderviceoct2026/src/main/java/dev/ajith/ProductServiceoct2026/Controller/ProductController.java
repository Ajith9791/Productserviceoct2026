package dev.ajith.ProductServiceoct2026.Controller;

import dev.ajith.ProductServiceoct2026.DTO.FakestoreProductdto;
import dev.ajith.ProductServiceoct2026.Model.Product;
import dev.ajith.ProductServiceoct2026.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public FakestoreProductdto[] getallproductss() {
        return productService.getallproducts();

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<FakestoreProductdto> getproductbyid(@PathVariable int id) {
        if(id<0){
            throw new IllegalArgumentException("product not found");
//            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        FakestoreProductdto fakestoreProductdto=productService.getproduct(id);
        return new ResponseEntity<>(fakestoreProductdto,HttpStatus.OK);


    }
    @PostMapping("/productrep")
    public ResponseEntity<Product>createproduct(@RequestBody Product product) {
        Product savedproduct=productService.saveproduct(product);
        return new ResponseEntity<>(savedproduct,HttpStatus.CREATED);
    }
    @PostMapping("/product")
    public FakestoreProductdto createproduct(@RequestBody FakestoreProductdto fakestoreProductdto) {
      return  productService.createproduct(fakestoreProductdto);

    }
    @GetMapping("/productrep")
    public ResponseEntity<List<Product>> getallproducts() {
        List<Product>allprod=productService.getallProducts();
        return new ResponseEntity<>(allprod,HttpStatus.OK);
    }
    @GetMapping("/productrep/{id}")
    public ResponseEntity<Product>getprod(@PathVariable int id) {
        Product savedprod=productService.getProduct(id);
        return new ResponseEntity<>(savedprod,HttpStatus.OK);
    }
    @DeleteMapping("/productrep/{id}")
    public ResponseEntity<Boolean>dltprod(@PathVariable int productid){
        boolean response=productService.deleteproduct(productid);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/product/{id}")
    public FakestoreProductdto replaceproduct(@PathVariable int id, @RequestBody FakestoreProductdto fakestoreProductdto) {
        return productService.replaceproduct(id,fakestoreProductdto);
    }
    @DeleteMapping("/product/{id}")
        public boolean deleteproduct(@PathVariable int id){
            return productService.deleteproduct(id);
        }
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<String> handleexception(Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleallexception(Exception e) {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

    }

