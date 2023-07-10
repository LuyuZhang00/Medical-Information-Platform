package com.barry.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.barry.model.user.Patient;

import java.util.List;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 10:47
 */
public interface PatientService extends IService<Patient> {
    List<Patient> findAllUserId(Long userId);

    Patient getPatientId(Long id);
}
