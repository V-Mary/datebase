package com.martciv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.martciv.repository.InsuranceRepository;
import com.martciv.models.domain.Insurance;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InsuranceService {
    @Autowired
    InsuranceRepository insuranceRepository;

    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }

    public Insurance getById(Integer id) {
        return insuranceRepository.findById(id).get();
    }

    @Transactional
    public Insurance create(Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @Transactional
    public void updateById(Insurance insurance, Integer id) {
        Insurance updatedInsurance = insuranceRepository.findById(id).get();
        updatedInsurance.setName(insurance.getName());
        updatedInsurance.setPrice(insurance.getPrice());
        updatedInsurance.setDays(insurance.getDays());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!insuranceRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        insuranceRepository.deleteById(id);
    }
}
