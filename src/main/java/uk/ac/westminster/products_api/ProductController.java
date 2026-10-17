package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        System.out.println(productService.getAllProducts() + "get method called");
         return productService.getAllProducts();
    }

    @GetMapping("products/{id}")
    public Product getProductById(@PathVariable Long id){
        System.out.println(productService.getProductById(id) + "getProductById method called");
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        System.out.println(productService.addProduct(product) + "addProduct method called");
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id){
          productService.deleteProduct(id);
    }
    @GetMapping("/products/search")
    public List <Product> search(@RequestParam String name){
        return productService.findByName(name);
    }





}

