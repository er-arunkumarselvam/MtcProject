package com.example.demo.ServiceClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.FormDetailsEntity;
import com.example.demo.EntitiesClass.StaffDetailsEntity;
import com.example.demo.PojoClass.FormDetailsPojo;
import com.example.demo.PojoClass.StaffDetailsPojo;
import com.example.demo.RepositoryClass.FormDetailsRepository;

@Service("/FormDetails")
public class FormEntityDataTransferManager{
	
	@Autowired
	@Qualifier("/formRepObj")
	public FormDetailsRepository formDetailsRepositoryObj;
	
	@Autowired
	@Qualifier("/formEntityObj")
	public FormDetailsEntity formDetailsEntityObj; 
	
	@Autowired
	private DataTransferClass dataTransferClassObj;
	 
	public LocalDateTime getSystemDateAndTime()
	{
		LocalDateTime systemDateAndTime = LocalDateTime.now();
		return systemDateAndTime;
	}

	public void addFormDataFromPojoToEntity(FormDetailsPojo formDetailsPojoObj)
	{	
		formDetailsEntityObj = dataTransferClassObj.formDetailsPojoToEntity(formDetailsPojoObj);
		System.out.println("------------"+formDetailsEntityObj);
		formDetailsEntityObj.setDateAndTimeOfSubmition(getSystemDateAndTime());
	}
	
	public void addFormDataFromEntityToDataBase(FormDetailsPojo formDetailsPojoObj)
	{
		addFormDataFromPojoToEntity(formDetailsPojoObj);
		formDetailsRepositoryObj.save(formDetailsEntityObj);
	}
	
    // READ ALL DATA
    public List<FormDetailsPojo> getAllFormDetailsFromDataBase() {
        Iterable<FormDetailsEntity> data = formDetailsRepositoryObj.findAll();
        List<FormDetailsEntity> dataList = new ArrayList<>();
        data.forEach(dataList::add); // Convert Iterable to List
        
        //list of entity to list of pojo
        List<FormDetailsPojo> pojoList = dataList.stream()
                .map(dataTransferClassObj::formDetailsEntityToPojo)
                .collect(Collectors.toList());
        return pojoList;
    }

}
