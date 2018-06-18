package com.footwear.shoe.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoe.bean.Shoe;
import com.footwear.shoe.entity.ShoeEntity;
import com.footwear.shoe.service.ShoeService;

@RestController
public class ShoeController {
	
	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping(value="/shoe/controller/addShoe", method=RequestMethod.POST, produces=MediaType.TEXT_HTML_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addShoe(@RequestBody Shoe shoe) {
		int id = shoeService.addShoe(shoe);
		System.out.println("Shoe with id=" + id + " inserted!");
		return new ResponseEntity<String>("resposeentity", HttpStatus.CREATED);
	}
	
}
