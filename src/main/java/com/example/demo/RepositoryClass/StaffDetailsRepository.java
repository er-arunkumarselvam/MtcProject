package com.example.demo.RepositoryClass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.StaffDetailsEntity;

@Service("/StaffRepo")
public interface StaffDetailsRepository extends CrudRepository<StaffDetailsEntity,String> {

}