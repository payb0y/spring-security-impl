package com.example.demo.employee.service;

import com.example.demo.employee.dto.EmployeDto;
import com.example.demo.employee.dto.EmployeMapper;
import com.example.demo.employee.entity.Employe;
import com.example.demo.employee.exception.DuplicateException;
import com.example.demo.employee.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeService {
    private final EmployeRepository employeRepository;

    public List<EmployeDto> getEmployes() {
        return employeRepository.findAll()
                .stream()
                .map(EmployeMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }


    public EmployeDto addNewEmploye(EmployeDto empDto) {
        Employe employe = EmployeMapper.convertDtoToEntity(empDto);
        Optional<Employe> empployeByEmail = employeRepository.findByEmail(employe.getEmail());
        if (empployeByEmail.isPresent()) {
            throw new DuplicateException("email taken with given ID...");
        }
        return EmployeMapper.convertEntityToDto(employeRepository.save(employe));
    }

    public void deleteEmploye(Long employeId) {
        boolean exists = employeRepository.existsById(employeId);
        if (!exists) {
            throw new IllegalStateException("Employe id :" + employeId + " n'existe pas");
        }
        employeRepository.deleteById(employeId);
    }

    @Transactional
    public Employe updateEmploye(Long empId, String nom, String email) {
        Employe emp = employeRepository.findById(empId)
                .orElseThrow(() -> new IllegalStateException("Employe ID" + empId + " n'existe pas"));
        if (nom != null && nom.length() > 0 && !Objects.equals(emp.getNom(), nom)) {
            emp.setNom(nom);
        }
        if (email != null && email.length() > 0 && !Objects.equals(emp.getEmail(), email)) {
            emp.setEmail(email);
        }
        return emp;
    }
}
