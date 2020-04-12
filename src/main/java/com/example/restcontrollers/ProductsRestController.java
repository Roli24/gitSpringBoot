package com.example.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Product;
import com.example.repository.ProductRepository;

@RestController
public class ProductsRestController {
	//@RequestMapping(method =)
	
	@Autowired
	private ProductRepository ProductRepository;
	/*
	 * @GetMapping("/hplus/rest/products")
	 * 
	 * @ResponseBody public List<Product> getProducts() { List<Product> products =
	 * new ArrayList<Product>(); ProductRepository.findAll().forEach(product ->
	 * products.add(product)); return products;
	 * 
	 * //call product repo
	 * 
	 * }
	 */
	
	@GetMapping("hplus/rest/products")
	public ResponseEntity getProductsByRequestParam(@RequestParam String name)
	
	{
		List<Product> products = ProductRepository.searchByName(name);
		return new ResponseEntity(products, HttpStatus.OK);
		
	}
	
	@GetMapping("hplus/rest/products/{name}")
	public ResponseEntity getProductsByPathVariable(@PathVariable("name") String name)
	{
		List<Product> products = ProductRepository.searchByName(name);
		return new ResponseEntity(products, HttpStatus.OK);
	}
	
	

}
