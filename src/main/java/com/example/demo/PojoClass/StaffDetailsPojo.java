package com.example.demo.PojoClass;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Service
public class StaffDetailsPojo {
	@JsonProperty("username")
	private String staffNumberPojo;
	
	private String staffNamePojo;
	private String staffDesignationPojo;
	private Long staffMobileNumberPojo;
	private String staffMailIdPojo;
	private String staffRolePojo;
	
}
