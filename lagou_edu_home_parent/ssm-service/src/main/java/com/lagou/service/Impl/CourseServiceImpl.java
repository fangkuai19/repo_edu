package com.lagou.service.Impl;

import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    /**
     * 条件查询
     *
     * @param courseVO
     * @return
     */
    @Override
    public List<Course> findCourseByConditioin(CourseVO courseVO) {
        List<Course> courseByConditioin = courseMapper.findCourseByConditioin(courseVO);

        return courseByConditioin;
    }

    /**
     * 保存课程信息
     *
     * @param courseVO
     */
    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) {

        try {
//        封装课程信息
            Course course = new Course();
            BeanUtils.copyProperties(courseVO, course);

//        补全信息
            Date date = new Date();
            course.setCreateTime(date);
            course.setUpdateTime(date);

//        保存课程
            courseMapper.saveCourse(course);

//        获取新插入数据的id
            int id = course.getId();

//        封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(courseVO, teacher);

//        补全信息
            teacher.setCourseId(id);
            teacher.setCreateTime(date);
            teacher.setUpdateTime(date);
            teacher.setIsDel(0);

//        保存讲师信息
            courseMapper.saveTeacher(teacher);
        } catch (BeansException e) {
            e.printStackTrace();
        }

    }

    /**
     * 根据课程id查询课程
     *
     * @param id
     * @return
     */
    @Override
    public CourseVO findCourseById(int id) {

        return courseMapper.findCourseById(id);
    }

    /**
     * 修改课程和教师信息
     *
     * @param courseVO
     */
    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) {
        try {
            //封装课程信息
            Course course = new Course();
            BeanUtils.copyProperties(courseVO, course);
            //补全信息
            Date date = new Date();
            course.setUpdateTime(date);
            //更新课程
            courseMapper.updateCourse(course);
            //封装讲师信息
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(courseVO, teacher);
            //补全信息
            teacher.setCourseId(course.getId());
            teacher.setUpdateTime(date);
            //更新讲师信息
            courseMapper.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*** 修改课程状态 * */
    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        try {
            //封装数据
            Course course = new Course();
            course.setStatus(status);
            course.setId(id);
            course.setUpdateTime(new Date());
            //调用Dao
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

