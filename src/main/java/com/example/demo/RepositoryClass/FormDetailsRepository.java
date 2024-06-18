package com.example.demo.RepositoryClass;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.EntitiesClass.FormDetailsEntity;

@Service("/formRepObj")
public interface FormDetailsRepository extends CrudRepository<FormDetailsEntity,String>{

}
