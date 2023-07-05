package com.barry.hosp.repository;

import com.barry.model.hosp.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-05 10:44
 */
@Repository
public interface ScheduleRepository extends MongoRepository<Schedule,String>{
    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);

    List<Schedule> findScheduleByHoscodeAndDepcodeAndWorkDate(String hoscode, String depcode, Date date);
}
