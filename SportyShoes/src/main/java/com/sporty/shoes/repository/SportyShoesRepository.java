package com.sporty.shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sporty.shoes.model.SportyShoesModel;

@Repository
public interface SportyShoesRepository extends JpaRepository<SportyShoesModel, Integer>{
	

}
