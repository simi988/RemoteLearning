package com.iquestgroup.remotelearning.factory;

import com.iquestgroup.remotelearning.domain.Employee;
import com.iquestgroup.remotelearning.domain.Engine;
import com.iquestgroup.remotelearning.domain.EngineArchitecture;
import com.iquestgroup.remotelearning.exception.UnqualifiedEmployeeException;
import com.iquestgroup.remotelearning.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EngineFactory {

    private EmployeeService employeeService;

    public EngineFactory(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Engine> manufactureEngines(int numberOfEngines, Employee assignedEmployee) {
        if (!employeeService.isAssemblyLineWorker(assignedEmployee)) {
            throw new UnqualifiedEmployeeException("Employee [" + assignedEmployee.getName() + "] is not qualified to build engines!");
        }

        List<Engine> newEngines = new ArrayList<Engine>();
        for (int i = 0; i < numberOfEngines; i++) {
            newEngines.add(new Engine(EngineArchitecture.L4, 2.0, 210));
        }
        return newEngines;
    }

}
