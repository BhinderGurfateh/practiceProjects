package poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.dao.StudentRepository;
import poc.entity.Student;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    
	@Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> listAll() {
        List<Student> students = new ArrayList<>();
        System.out.println(studentRepository.checkIfTableExist());
    	if("1".equals(studentRepository.checkIfTableExist())) {
            studentRepository.findAll().forEach(students::add); 
    	}else {
            studentRepository.createStudentTable();
    	}  	
        return students;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student saveOrUpdate(Student student) {
    	studentRepository.save(student);
        return student;
    }

    @Override
    public void delete(Long id) {
    	studentRepository.deleteById(id);

    }
    
    @Override
    public void dropTable() {
    	studentRepository.dropTable();

    }
    
    @Override
    public void saveAllStudents(List<Student> students) {
    	for (Student student : students) {
    		studentRepository.save(student);
		}
        return ;
    }


}
