package com.footwear.shoe.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.shoe.bean.Shoe;
import com.footwear.shoe.dao.ShoeDAO;
import com.footwear.shoe.entity.ShoeEntity;

@Service
public class ShoeService {
	
	@Autowired
	private ShoeDAO shoeDAO;
	
//	public static String getCurrentTimeUsingDate() {
//	    Date date = new Date();
//	    String strDateFormat = "hh:mm:ss a";
//	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//	    String formattedDate= dateFormat.format(date);
//	    System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
//	    return formattedDate;
//	}
//	
	
	public int addShoe(Shoe s) {
		ShoeEntity shoeEntity = new ShoeEntity();
		BeanUtils.copyProperties(s, shoeEntity);
		ShoeEntity temp = (ShoeEntity) shoeDAO.save(shoeEntity);
		System.out.println(temp.getName() + " inserted!");
		return temp.getId();
	}
	
	public Collection<Shoe> getShoeDetails() {
		Collection<ShoeEntity> shoes = shoeDAO.findAll();
		List<Shoe> result = new ArrayList<Shoe>();
		
		for (ShoeEntity shoe: shoes) {
			Shoe s = new Shoe();
			BeanUtils.copyProperties(shoe, s);
			result.add(s);
		}
		
		return result;
	}
	
	public Shoe findShoeById(int id) {
		ShoeEntity shoe = shoeDAO.findOne(id);
		Shoe result = new Shoe();
		BeanUtils.copyProperties(shoe, result);
		
		return result;
	}
	
	public Collection<Shoe> getShoesCreatedBetween(Date d1, Date d2) {
		Collection<ShoeEntity> shoes = shoeDAO.findByCreatedonBetween(d1, d2);
		List<Shoe> result = new ArrayList<Shoe>();
		
		System.out.println(d1.toString() + "\t" + d2.toString());
		System.out.println(shoes);
		
		for (ShoeEntity shoe: shoes) {
			Shoe s = new Shoe();
			BeanUtils.copyProperties(shoe, s);
			result.add(s);
		}
		
		return result;
	}

}
