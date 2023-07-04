package com.barry.hosp.repository;

import com.barry.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-04 19:09
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    Hospital getHospitalByHoscode(String hoscode);
}
