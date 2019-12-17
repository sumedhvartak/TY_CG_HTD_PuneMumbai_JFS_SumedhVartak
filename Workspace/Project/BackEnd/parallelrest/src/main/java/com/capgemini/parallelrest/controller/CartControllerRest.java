package com.capgemini.parallelrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.parallelrest.beans.CartBean;
import com.capgemini.parallelrest.beans.ResponseBean;
import com.capgemini.parallelrest.service.CartService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartControllerRest {
	
	@Autowired
	private CartService cartService;
	
	@PutMapping(path = "/addCart",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean addCart(@RequestParam int productId) {
		CartBean add = cartService.addCart(productId);
		ResponseBean responseBean = new ResponseBean();
		
		if(add!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("Added to Cart");
			responseBean.setCartBean(add);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to Add to Cart");
		}
		return responseBean;
	}//End of addCart()
	
	@GetMapping(path = "/showCart",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean showCart() {
		List<CartBean> list = cartService.showCart();
		ResponseBean responseBean = new ResponseBean();
		
		if(list!=null) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("The List of All product in Cart");
			responseBean.setCartList(list);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to load list of Cart");
		}//End of else
		return responseBean;
	}//End of showCart
	
	@DeleteMapping(path="/deleteItem",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteCart(@RequestParam int cartId) {
		boolean cartdeleted = cartService.deleteCart(cartId);
		ResponseBean responseBean = new ResponseBean();
		
		if(cartdeleted) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("Deleted a Item from Cart");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to Delete a Item");
		}
		return responseBean;
	}//End of deleteCart
	
	@DeleteMapping(path="/deleteAllItem",produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseBean deleteAllCart() {
		boolean cartdeleted = cartService.deleteAllCart();
		ResponseBean responseBean = new ResponseBean();
		
		if(cartdeleted) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setDescription("Payment Successful");
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Payment Failed");
		}
		return responseBean;
	}//End of deleteAllCart()
	
	@GetMapping(path="/getBill")
	public ResponseBean totalBill() {
		long total = cartService.totalBill();
		ResponseBean responseBean = new ResponseBean();
		
		if(total>0) {
			responseBean.setStatusCode(201);
			responseBean.setMessage("Success");
			responseBean.setPrice(total);
			responseBean.setDescription("Payment Done");
			responseBean.setPrice(total);
		}else {
			responseBean.setStatusCode(401);
			responseBean.setMessage("Failed");
			responseBean.setDescription("Failed to load payment");
		}
		return responseBean;
	}//End of totalBill

}//End of CartControllerRest
