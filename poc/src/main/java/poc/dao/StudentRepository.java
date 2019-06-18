package poc.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import poc.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
    @Query(value="SELECT 1 FROM information_schema.tables WHERE table_schema = 'public' AND table_name = 'student'", nativeQuery = true) 
    String checkIfTableExist();
    
    @Transactional
    @Modifying
    @Query(value="create table student (_id  bigserial not null, student_class varchar(255), student_name varchar(255), primary key (_id))", nativeQuery = true) 
    void createStudentTable();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS student CASCADE ", nativeQuery = true) 
    void dropTable();
    
    
}
