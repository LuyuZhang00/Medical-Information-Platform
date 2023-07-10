package com.barry.hosp.service;

import com.barry.model.hosp.Schedule;
import com.barry.vo.hosp.ScheduleOrderVo;
import com.barry.vo.hosp.ScheduleQueryVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * @Author : Luyu Zhang
 * @create 2023-07-05 10:45
 */
public interface ScheduleService {

    //上传排班接口
    void save(Map<String, Object> paramMap);

    //查询排班接口
    Page<Schedule> findPageSchedule(int page, int limit, ScheduleQueryVo scheduleQueryVo);

    //删除排班
    void remove(String hoscode, String hosScheduleId);

    //根据医院编号 和 科室编号 ，查询排班规则数据
    Map<String, Object> getRuleSchedule(long page, long limit, String hoscode, String depcode);

    //根据医院编号 、科室编号和工作日期，查询排班详细信息
    List<Schedule> getDetailSchedule(String hoscode, String depcode, String workDate);

    Map<String, Object> getBookingScheduleRule(Integer page, Integer limit, String hoscode, String depcode);

    Schedule getById(String scheduleId);

    ScheduleOrderVo getScheduleOrderVo(String scheduleId);
}
