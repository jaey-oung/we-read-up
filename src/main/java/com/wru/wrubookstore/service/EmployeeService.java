package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto login(String email, String password);

}
