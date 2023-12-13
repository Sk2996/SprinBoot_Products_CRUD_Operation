
package com.coding.ProductApplication.controller;
import com.coding.ProductApplication.entity.ProductDTO;
import com.coding.ProductApplication.entity.ProductEntity;
import com.coding.ProductApplication.service.ProductService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductPageController {


    @Autowired
    private ProductService productService;

    @ApiOperation(value = "Fetch Active Products API", notes = "Get the sorted list of products - Recent To Older")
    @GetMapping
    public List<ProductEntity> getProducts(){
        return productService.getAllActiveProducts();
    }

    @ApiOperation(value = "Search Products API", notes = "Products can be searched based on the given criteria (product name, price range, and posted date range)." )
    @GetMapping("/search")
    public List<ProductEntity> getSearchProducts(
            @RequestParam(value = "productName", required=false) String productName,
            @RequestParam(value = "minPrice", required=false) Integer minPrice,
            @RequestParam(value = "maxPrice", required=false) Integer maxPrice,
            @RequestParam(value = "minPostedDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date minPostedDate,
            @RequestParam(value = "maxPostedDate", required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date maxPostedDate){


        return productService.getAllSearchProducts(productName, minPrice, maxPrice, minPostedDate, maxPostedDate);
    }

    @ApiOperation(value = "Create Product API" , notes = "Note: The price must not exceed $10,000. If the price is more than $5,000, the product should be pushed to the approval queue.")
    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductDTO product) {

        if(product.getPrice() > 10000){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Product price should not be more than $10000.");
        }else{
            return productService.createProduct(product);
        }

    }

    @ApiOperation(value = "Update Product API", notes = "Note: If the price of product getting updated is more than 50% of its previous price, the product should be pushed to the approval queue.")
    @PutMapping("/{productId}")
    public ResponseEntity<Object> updateProduct(@PathVariable("productId") long productId, @RequestBody ProductDTO product) {

        if(product.getPrice() > 10000){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Product price should not be more than $10000.");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productId, product));
        }
    }

    @ApiOperation(value = "Delete Product API", notes = "Note: Deleted products should be pushed to the approval queue.")
    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") long productId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.deleteProduct(productId));
    }

    @ApiOperation(value = "Approval Queue Products API", notes = "Get all the products in the approval queue, sorted by request date.")
    @GetMapping("/approval-queue")
    public ResponseEntity<Object> getAllProductFromApprovalQueue(){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.getAllProductFromApprovalQueue());
    }

    @ApiOperation(value = "Approve Product API", notes = "Note: To approve the product state of the product should be updated, and it should be removed form the approval queue.")
    @PutMapping("/approval-queue/{approvalId}/approve")
    public ResponseEntity<Object> approveProductByApprovalId(@PathVariable("approvalId") long approvalId){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.approveProductByApprovalId(approvalId));
    }

    @ApiOperation(value = "Reject Product API", notes = "Note: The product state should remain the same, and it should be removed from the approval queue.")
    @PutMapping("/approval-queue/{approvalId}/reject")
    public ResponseEntity<Object> rejectProductByApprovalId(@PathVariable("approvalId") long approvalId){
        return  ResponseEntity.status(HttpStatus.OK).body(productService.rejectProductByApprovalId(approvalId));
    }
}
