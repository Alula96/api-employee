package com.test.apiemployee.dto;

import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Employee DTO 
 */
@Getter
@AllArgsConstructor
public class EmployeeDTO {

	private long id;
	
	@NotNull(message = "Employee's name is required")
    private String name;
	
	@NotNull(message = "Employee's lastname is required")
    private String lastName;
        
	@NotNull(message = "Employee's birthdate is required")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private Calendar birthdate;
    
    @NotNull(message = "Employee's payment is required")
    private Double pay;
    
}
