package com.test.apiemployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.apiemployee.dto.EmployeeDTO;
import com.test.apiemployee.dto.IdDTO;
import com.test.apiemployee.exception.ResourceNotFoundException;
import com.test.apiemployee.model.Employee;
import com.test.apiemployee.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee/employee")
public class EmployeeController {
	
	static final String RESOURCE_NOT_FOUND_MESSAGE = "Resource not found with id: ";	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/**
	 * Get all employees list.
	 *
	 * @return the list
	 */
	 @GetMapping
	 public List<Employee> getAllEmployees() {
		 return employeeRepository.findAll();
	}
	 
	/**
	 * Gets employee by id.
	 *
	 * @param employeeId the employee id
	 * @return the employee by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
	      throws ResourceNotFoundException {
			Employee employee =
				employeeRepository
			        .findById(employeeId)
			        .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND_MESSAGE + employeeId));
			return ResponseEntity.ok().body(employee);
	}
	
	/**
	 * Create employee
	 *
	 * @param employee the employee
	 * @return the employee with HTTPSTATUS CREATED
	 */
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		Employee employee = new Employee(
				employeeDTO.getId(),
				employeeDTO.getName(),
				employeeDTO.getLastName(),
				employeeDTO.getBirthdate(),
				employeeDTO.getPay());
		return new ResponseEntity<>(this.employeeRepository.save(employee), HttpStatus.CREATED);
	}
	
	/**
	   * Update employee response entity.
	   *
	   * @param employeeId the employee id
	   * @param employeeDetails the employee details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO)
	      throws ResourceNotFoundException {
		Employee employee =
			employeeRepository
		        .findById(employeeDTO.getId())
		        .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND_MESSAGE + employeeDTO.getId()));
		employee.setName(employeeDTO.getName());
		employee.setLastName(employeeDTO.getName());
		employee.setBirthdate(employeeDTO.getBirthdate());
		employee.setPay(employeeDTO.getPay());		
		return ResponseEntity.ok().body(this.employeeRepository.save(employee));
	}
	
	/**
	   * Delete employee.
	   *
	   * @param employeeId the employee id
	   * @return empty response
	   * @throws Exception the exception
	   */
	@DeleteMapping
	public void deleteUser(@Valid @RequestBody IdDTO idDTO) 
			throws ResourceNotFoundException {
		long employeeId = idDTO.getId();
		Employee employee =
				employeeRepository
			        .findById(employeeId)
			        .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND_MESSAGE + employeeId));
		this.employeeRepository.delete(employee);
	}
}
