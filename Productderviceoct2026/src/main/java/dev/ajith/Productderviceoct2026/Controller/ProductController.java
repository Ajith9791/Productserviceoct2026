package dev.ajith.Productderviceoct2026.Controller;

import dev.ajith.Productderviceoct2026.DTO.FakestoreProductdto;
import dev.ajith.Productderviceoct2026.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/product")
    public FakestoreProductdto createproduct(@RequestBody FakestoreProductdto fakestoreProductdto) {
      return  productService.createproduct(fakestoreProductdto);

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

