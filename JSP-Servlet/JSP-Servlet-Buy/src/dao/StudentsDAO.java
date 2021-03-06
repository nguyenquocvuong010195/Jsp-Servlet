package dao;

import java.util.ArrayList;

import dto.Student;



public interface StudentsDAO {
	public ArrayList<Student> getAllStudents() ; 
	public void insertStudent(Student student);
	public void updateStudent(Student student);
	public void deleteStudent(int studentID);
	public Student findStudentByUserAndPassword(String username , String password);
	public void createStudent(Student student);
	public void createStudentByAdmin(Student student);
	public Student getStudentById(int id);
	public boolean addNewStudent(Student student);
}
