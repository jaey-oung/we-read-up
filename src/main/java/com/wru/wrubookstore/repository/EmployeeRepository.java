package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.EmployeeDto;

public interface EmployeeRepository {

    EmployeeDto selectByEmailAndPassword(String email, String password) throws Exception;

}
