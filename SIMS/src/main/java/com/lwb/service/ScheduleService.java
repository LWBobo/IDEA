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
     * 初始化管理员看到的课表，也就是总课表
     */
    int initadminTimeTable(String uid);

    /**
     * 根据学号获取学生课表
     * @param tableid
     * @return
     */
    List<List<String>> getStuTable(String tableid);

    /**
     * 添加实验课程
     * @param labCourse
     * @return
     */
    int insertLabCourse(LabCourse labCourse);

    /**
     * 添加实验课安排表
     * @param labClassSchedule
     * @return
     */
    int insertLabClassSchedule(LabClassSchedule labClassSchedule);

    /**
     * 根据实验课程号删除实验课程
     * @param lcnum
     * @return
     */
    int delLabCourse(String lcnum);

    /**
     * 根据实验课程号删除实验课程安排表
     * @param lcnum
     * @return
     */
    int delLabClassSchedule(String lcnum);

    int delLabCourseFromTable(String cnum , String adminNum);


    int addLabScheduleAndUpdateTimetable(Course course,LabCourse labCourse,LabClassSchedule labClassSchedule);
}
