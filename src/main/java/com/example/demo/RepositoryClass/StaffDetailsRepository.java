package com.example.demo.RepositoryClass;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.StaffDetailsEntity;

@Service("/StaffRepo")
public interface StaffDetailsRepository extends JpaRepository<StaffDetailsEntity,String> {
	public Optional<StaffDetailsEntity> findByStaffNumberEntity(String staffNumber);
}