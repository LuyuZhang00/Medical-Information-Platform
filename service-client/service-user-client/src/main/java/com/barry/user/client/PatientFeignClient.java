package com.barry.user.client;

import com.barry.model.user.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @Author : Luyu Zhang
 * @create 2023-07-10 23:06
 */
@FeignClient(value = "service-user")
@Repository
public interface PatientFeignClient {

    //获取就诊人
    @GetMapping("/api/user/patient/inner/get/{id}")
    Patient getPatient(@PathVariable("id") Long id);
}
