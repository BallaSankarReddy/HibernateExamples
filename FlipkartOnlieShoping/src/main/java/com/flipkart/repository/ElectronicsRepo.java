package com.flipkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.model.Electronics;

@Repository
public interface ElectronicsRepo extends JpaRepository<Electronics, Integer> {

}
