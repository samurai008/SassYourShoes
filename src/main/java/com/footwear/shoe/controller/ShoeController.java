package com.footwear.shoe.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoe.bean.CustomDates;
import com.footwear.shoe.bean.Shoe;
import com.footwear.shoe.entity.ShoeEntity;
import com.footwear.shoe.service.ShoeService;

@RestController
public class ShoeController {
	
	@Autowired
	private ShoeService shoeService;
	
	@RequestMapping(value="/shoe/controller/addShoe", 
			method=RequestMethod.POST, 
			produces=MediaType.TEXT_HTML_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addShoe(@RequestBody Shoe shoe) {
		Date d = new Date();
		System.out.println(shoe.getName());
		shoe.setCreatedon(d);
		int id = shoeService.addShoe(shoe);
		System.out.println("Shoe with id=" + id + " inserted!");
		return new ResponseEntity<String>("resposeentity", HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/shoe/controller/getAllShoes",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Shoe>> getShoeDetails() {
		Collection<Shoe> shoes = shoeService.getShoeDetails();
		System.out.println(shoes.iterator().next().getName());
		
		return new ResponseEntity<Collection<Shoe>>(shoes, HttpStatus.OK);
	}
	
	@RequestMapping(value="/shoe/controller/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shoe> findShoeById(@PathVariable("id") int id) {
		Shoe s = shoeService.findShoeById(id);
		Date createdon = s.getCreatedon();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(createdon));
		
		return new ResponseEntity<Shoe>(s, HttpStatus.OK);
	}
	
	@RequestMapping(value="/shoe/controller/getShoesCreatedBetween",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Shoe>> getShoesCreatedBetween(@RequestBody CustomDates dates) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date newD1, newD2;
		Collection<Shoe> shoes;
		
		try {
			newD1 = (Date) format.parse(dates.getD1());
			newD2 = (Date) format.parse(dates.getD2());
			
			System.out.println(newD1 + "\t" + newD2);
			
			shoes = shoeService.getShoesCreatedBetween(newD1, newD2);
			
			System.out.println(shoes.toString());
			
			return new ResponseEntity<Collection<Shoe>>(shoes, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<Collection<Shoe>>(HttpStatus.BAD_REQUEST);
	}
	
}
