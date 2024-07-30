package com.example.demo.ServiceClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.VehicleDetailsEntity;
import com.example.demo.PojoClass.VehicleDetailsPojo;
import com.example.demo.RepositoryClass.VechicleDetailsRepository;

@Service("/VehicleDetails")
public class VehicleEntityDataTransferManager {
	

	@Autowired
	@Qualifier("/vehicleDetailsRepo")
	private  VechicleDetailsRepository vechicleDetailsRepositoryObj;
	
	@Autowired
	private DataTransferClass dataTransferClassObj;
	
	//Entity to DataBase-->Save new entry 
	public void addVechicleDataFromEntityToDataBase(VehicleDetailsPojo vehicleDetailsPojoObj)
	{
		vechicleDetailsRepositoryObj.save(dataTransferClassObj.vehicleDetailsPojoToEntity(vehicleDetailsPojoObj));	
	}
	
    // READ ALL DATA
    public List<VehicleDetailsPojo> getAllVehicleDetailsFromDataBase() {
        Iterable<VehicleDetailsEntity> data = vechicleDetailsRepositoryObj.findAll();
        List<VehicleDetailsEntity> dataList = new ArrayList<>();
        data.forEach(dataList::add); // Convert Iterable to List
        
        //list of entity to list of pojo
        List<VehicleDetailsPojo> pojoList = dataList.stream()
                .map(dataTransferClassObj::vehicleDetailsEntityToPojo)
                .collect(Collectors.toList());
        return pojoList;
    }
    
    // UPDATE DATA 
    public String updateVehicleDetails(VehicleDetailsPojo vehicleObj)
    {
    	Optional<VehicleDetailsEntity> data = vechicleDetailsRepositoryObj.findById(vehicleObj.getVehicleFleetNumberPojo());
    	if(data.isPresent())
    	{
    		VehicleDetailsEntity updatedVehicle = data.get();
    		updatedVehicle = dataTransferClassObj.vehicleDetailsPojoToEntity(vehicleObj);
    		vechicleDetailsRepositoryObj.save(updatedVehicle);
    		return "Successfully updated Vehicle Details";
    	}
    	else
    		return "Invalid FleetNo";
	}
    
    //DELETE DATA
    public String deleteVehicleDetails(VehicleDetailsPojo vehicleObj)
    {
    	Optional<VehicleDetailsEntity> data = vechicleDetailsRepositoryObj.findById(vehicleObj.getVehicleFleetNumberPojo());
    	if(data.isPresent())
    	{
    		VehicleDetailsEntity vehicleData = data.get();
    		vechicleDetailsRepositoryObj.deleteById(vehicleData.getVehicleFleetNumberEntity());
    		return "Vehicle Info Successfully Deleted";
    	}
    	else
    		return "Invalid FleetNo";
    }
}

