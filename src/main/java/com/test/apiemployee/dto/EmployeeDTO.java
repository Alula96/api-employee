package com.test.apiemployee.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

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
    private Date birthdate;
    
    @NotNull(message = "Employee's payment is required")
    private Double pay;
    
}
