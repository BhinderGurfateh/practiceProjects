package poc.service;

import java.util.List;

import poc.entity.Student;


public interface StudentService {

    List<Student> listAll();

    Student getById(Long id);

    Student saveOrUpdate(Student s);

    void delete(Long id);

	void dropTable();

	void saveAllStudents(List<Student> student);
}
