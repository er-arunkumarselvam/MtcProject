package com.example.demo.RepositoryClass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.VehicleDetailsEntity;

@Service("/vehicleDetailsRepo")
public interface VechicleDetailsRepository extends CrudRepository<VehicleDetailsEntity,String>{

}