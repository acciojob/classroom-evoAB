package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    HashMap<String, Student> studentDB = new HashMap<>();
    HashMap<String, Teacher> teacherDB = new HashMap<>();
    HashMap<String, List<String>> studentteacherDB = new HashMap<>();

    public void addStudent(Student student){
        studentDB.put(student.getName(),student);
    }
    public void addTeacher(Teacher teacher){
        teacherDB.put(teacher.getName(),teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        List<String> students=studentteacherDB.get(teacher);
        if (students==null)
            students=new ArrayList<>();
        students.add(student);
        studentteacherDB.put(teacher,students);
    }
    public Student getStudentByName(String name){
        return studentDB.get(name);
    }
    public Teacher getTeacherByName(String name){
        return teacherDB.get(name);
    }
    public List<String> getStudentsByTeacherName(String teacher){
        return studentteacherDB.get(teacher);
    }
    public List<String> getAllStudents(){
        List <String> students= new ArrayList<>();
        for(String s : studentDB.keySet())
            students.add(s);
        return students;
    }
    public void deleteTeacherByName(String teacher){
        teacherDB.remove(teacher);
        studentteacherDB.remove(teacher);
    }
    public void deleteAllTeachers(){
        teacherDB.clear();
        studentteacherDB.clear();
    }
}
