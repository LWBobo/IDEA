package com.lwb.service;

import com.lwb.pojo.*;

import java.util.List;

public interface ScheduleService {
    /**
     * 从实验课程安排表到课表
     * @param labClassSchedule
     * @param uid
     * @return
     */
    TimeTable doLabScheduleToTimetable(LabClassSchedule labClassSchedule,String uid ,TimeTable timetable);

    /**
     * 从课程安排表到课表
     * @param classSchedule
     * @param uid
     * @return
     */
    TimeTable doScheduleToTimetable(ClassSchedule classSchedule, String uid , TimeTable timeTable);

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


    /**
     * 初始化课程表
     */
    void initTimeTable() throws ClassRepeatException;

    /**
     * 根据学号获取学生课表
     * @param tableid
     * @return
     */
    List<List<String>> getStuTable(String tableid);
}
