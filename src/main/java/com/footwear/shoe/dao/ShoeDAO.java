package com.footwear.shoe.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.footwear.shoe.entity.ShoeEntity;

public interface ShoeDAO extends JpaRepository<ShoeEntity, Integer> {
	
	List<ShoeEntity> findByCreatedonBetween(Date d1, Date d2);

}
