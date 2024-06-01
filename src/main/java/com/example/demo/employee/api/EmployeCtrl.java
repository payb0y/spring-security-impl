package com.example.demo.employee.api;

import com.example.demo.employee.dto.EmployeDto;
import com.example.demo.employee.entity.Employe;
import com.example.demo.employee.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/emp")
@RequiredArgsConstructor
public class EmployeCtrl {
    private final EmployeService employeService;

    @GetMapping
    public List<EmployeDto> getEmployes() {
        return employeService.getEmployes();
    }

    @PostMapping
    public ResponseEntity<EmployeDto> registerNewEmploye(@RequestBody EmployeDto employeDto) {
        EmployeDto saveEmploye = employeService.addNewEmploye(employeDto);
        return new ResponseEntity<>(saveEmploye, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{employeId}")
    public String deleteEmploye(@PathVariable("employeId") Long employeId) {
        employeService.deleteEmploye(employeId);
        return ("employe ID " + employeId + "deleted with succes---");
    }

    @PutMapping(path = "{empId}")
    public Employe updateEmploye(
            @PathVariable("empId") Long empId,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String email
    ) {
        return employeService.updateEmploye(empId, nom, email);
    }
}
