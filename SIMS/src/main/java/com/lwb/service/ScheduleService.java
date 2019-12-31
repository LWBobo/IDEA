package com.lwb.service;

import com.lwb.pojo.Course;
import com.lwb.pojo.Lab;
import com.lwb.pojo.LabClassSchedule;

import java.util.List;

public interface ScheduleService {
    int doScheduleToTimetable(LabClassSchedule labClassSchedule);

    /**
     * 获取带有实验课信息的课程信息
     * @return
     */
    List<Course> findAllCourseWithLabCourse();

    /**
     * 获取所有的实验室信息
     * @return
     */
    List<Lab> findAllLab();
}
