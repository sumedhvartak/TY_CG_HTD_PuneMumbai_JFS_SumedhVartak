package com.capgemini.parallelrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.parallelrest.beans.ProductBean;
import com.capgemini.parallelrest.beans.ResponseBean;
import com.capgemini.parallelrest.service.ProductBeanService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductControllerRest {
	
	@Autowired
	private ProductBeanService productBeanService;
	
	@PutMapping(path = "/addProduct",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addProduct(@RequestBody ProductBean productBean) {
		boolean addProduct = productBeanService.addProduct(productBean);
		ResponseBean responseBean = new ResponseBean();
		
		if(addProduct) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Product Added successfully");
			
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Product Failed to Add");
		}
		return responseBean;
	}//End of addProduct()
	
	@GetMapping(path="/showAllProduct",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showAllProduct() {
		List<ProductBean> list = productBeanService.showAllProduct();
		ResponseBean responseBean = new ResponseBean();
		
		if(list!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("The List of all Product");
			responseBean.setProductList(list);
			
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("The List failed to display");
		}
		return responseBean;
	}//End of showAllProduct()
	
	@DeleteMapping(path = "/deleteProduct",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteProduct(@RequestParam int productId) {
		boolean delete = productBeanService.deleteProduct(productId);
		ResponseBean responseBean = new ResponseBean();
		
		if(delete) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Product Deleted");
			
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Product Failed to Delete");
		}
		return responseBean;
		
	}//End of deleteProduct()
	
	@PostMapping(path = "/updateProduct",consumes= {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public ResponseBean updateProduct(@RequestParam int productId,@RequestParam int productPrice,@RequestParam int quantity) {
		boolean update = productBeanService.updateProduct(productId, productPrice, quantity);
		ResponseBean responseBean = new ResponseBean();
		
		if(update) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Successful");
			responseBean.setDescription("Product Update");
			
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Product Failed to Update");
		}
		return responseBean;
	}//End of updateProduct()
}//End of ProductControllerRest
