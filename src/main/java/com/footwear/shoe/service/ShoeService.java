package com.footwear.shoe.service;

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
	
	
	public int addShoe(Shoe s) {
		ShoeEntity shoeEntity = new ShoeEntity();
		BeanUtils.copyProperties(s, shoeEntity);
		shoeEntity.setCreatedon(new Date("2016-01-15 00:00:00"));
		ShoeEntity temp = (ShoeEntity) shoeDAO.save(shoeEntity);
		System.out.println(temp.getName() + " inserted!");
		return temp.getId();
	}

}
