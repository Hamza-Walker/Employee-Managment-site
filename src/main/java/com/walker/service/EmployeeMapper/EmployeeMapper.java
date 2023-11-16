package com.walker.service.EmployeeMapper;

import com.walker.model.Department;
import com.walker.model.DepartmentDto;
import com.walker.model.Employee;
import com.walker.model.EmployeeDto;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentId(employee.getDepartmentId());

        // If the employee has a department, map it to DepartmentDto
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentDto(mapToDepartmentDto(employee.getDepartment()));
        }

        return employeeDto;
    }

    private static DepartmentDto mapToDepartmentDto(Department department) {
        if (department == null) {
            return null;
        }

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());

        return departmentDto;
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        // Set the department if available in the DTO
        if (employeeDto.getDepartmentId() != null) {
            Department department = new Department();
            department.setId(employeeDto.getDepartmentId());
            employee.setDepartment(department);
        }

        return employee;
    }
}
