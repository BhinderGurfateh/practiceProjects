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
    @Query(value="create table student (_id  bigserial not null , student_class varchar(255), student_name varchar(255), primary key (_id))", nativeQuery = true) 
    void createStudentTable();
    
    @Transactional
    @Modifying
    @Query(value="create table studentA (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA1 varchar(255), student_nameA1 varchar(255), student_classB1 varchar(255), student_nameB1 varchar(255), student_classC1 varchar(255), student_nameC1 varchar(255), student_classD1 varchar(255), student_nameD1 varchar(255),student_classE1 varchar(255), student_nameE1 varchar(255),student_classF1 varchar(255), student_nameF1 varchar(255), student_classG1 varchar(255), student_nameG1 varchar(255),student_classH1 varchar(255), student_nameH1 varchar(255),student_classI1 varchar(255), student_nameI1 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableA();

    @Transactional
    @Modifying
    @Query(value="create table studentB (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA2 varchar(255), student_nameA2 varchar(255), student_classB2 varchar(255), student_nameB2 varchar(255), student_classC2 varchar(255), student_nameC2 varchar(255), student_classD2 varchar(255), student_nameD2 varchar(255),student_classE2 varchar(255), student_nameE2 varchar(255),student_classF2 varchar(255), student_nameF2 varchar(255), student_classG2 varchar(255), student_nameG2 varchar(255),student_classH2 varchar(255), student_nameH2 varchar(255),student_classI2 varchar(255), student_nameI2 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableB();
    
    @Transactional
    @Modifying
    @Query(value="create table studentC (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA3 varchar(255), student_nameA3 varchar(255), student_classB3 varchar(255), student_nameB3 varchar(255), student_classC3 varchar(255), student_nameC3 varchar(255), student_classD3 varchar(255), student_nameD3 varchar(255),student_classE3 varchar(255), student_nameE3 varchar(255),student_classF3 varchar(255), student_nameF3 varchar(255), student_classG3 varchar(255), student_nameG3 varchar(255),student_classH3 varchar(255), student_nameH3 varchar(255),student_classI3 varchar(255), student_nameI3 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableC();
    
    @Transactional
    @Modifying
    @Query(value="create table studentD (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA4 varchar(255), student_nameA4 varchar(255), student_classB4 varchar(255), student_nameB4 varchar(255), student_classC4 varchar(255), student_nameC4 varchar(255), student_classD4 varchar(255), student_nameD4 varchar(255),student_classE4 varchar(255), student_nameE4 varchar(255),student_classF4 varchar(255), student_nameF4 varchar(255), student_classG4 varchar(255), student_nameG4 varchar(255),student_classH4 varchar(255), student_nameH4 varchar(255),student_classI4 varchar(255), student_nameI4 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableD();
    
    @Transactional
    @Modifying
    @Query(value="create table studentE (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA5 varchar(255), student_nameA5 varchar(255), student_classB5 varchar(255), student_nameB5 varchar(255), student_classC5 varchar(255), student_nameC5 varchar(255), student_classD5 varchar(255), student_nameD5 varchar(255),student_classE5 varchar(255), student_nameE5 varchar(255),student_classF5 varchar(255), student_nameF5 varchar(255), student_classG5 varchar(255), student_nameG5 varchar(255),student_classH5 varchar(255), student_nameH5 varchar(255),student_classI5 varchar(255), student_nameI5 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableE();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentF (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA6 varchar(255), student_nameA6 varchar(255), student_classB6 varchar(255), student_nameB6 varchar(255), student_classC6 varchar(255), student_nameC6 varchar(255), student_classD6 varchar(255), student_nameD6 varchar(255),student_classE6 varchar(255), student_nameE6 varchar(255),student_classF6 varchar(255), student_nameF6 varchar(255), student_classG6 varchar(255), student_nameG6 varchar(255),student_classH6 varchar(255), student_nameH6 varchar(255),student_classI6 varchar(255), student_nameI6 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableF();
    
    @Transactional
    @Modifying
    @Query(value="create table studentG (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA7 varchar(255), student_nameA7 varchar(255), student_classB7 varchar(255), student_nameB7 varchar(255), student_classC7 varchar(255), student_nameC7 varchar(255), student_classD7 varchar(255), student_nameD7 varchar(255),student_classE7 varchar(255), student_nameE7 varchar(255),student_classF7 varchar(255), student_nameF7 varchar(255), student_classG7 varchar(255), student_nameG7 varchar(255),student_classH7 varchar(255), student_nameH7 varchar(255),student_classI7 varchar(255), student_nameI7 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableG();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentH (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA8 varchar(255), student_nameA8 varchar(255), student_classB8 varchar(255), student_nameB8 varchar(255), student_classC8 varchar(255), student_nameC8 varchar(255), student_classD8 varchar(255), student_nameD8 varchar(255),student_classE8 varchar(255), student_nameE8 varchar(255),student_classF8 varchar(255), student_nameF8 varchar(255), student_classG8 varchar(255), student_nameG8 varchar(255),student_classH8 varchar(255), student_nameH8 varchar(255),student_classI8 varchar(255), student_nameI8 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableH();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentI (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA9 varchar(255), student_nameA9 varchar(255), student_classB9 varchar(255), student_nameB9 varchar(255), student_classC9 varchar(255), student_nameC9 varchar(255), student_classD9 varchar(255), student_nameD9 varchar(255),student_classE9 varchar(255), student_nameE9 varchar(255),student_classF9 varchar(255), student_nameF9 varchar(255), student_classG9 varchar(255), student_nameG9 varchar(255),student_classH9 varchar(255), student_nameH9 varchar(255),student_classI9 varchar(255), student_nameI9 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableI();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentJ (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA10 varchar(255), student_nameA10 varchar(255), student_classB10 varchar(255), student_nameB10 varchar(255), student_classC10 varchar(255), student_nameC10 varchar(255), student_classD10 varchar(255), student_nameD10 varchar(255),student_classE10 varchar(255), student_nameE10 varchar(255),student_classF10 varchar(255), student_nameF10 varchar(255), student_classG10 varchar(255), student_nameG10 varchar(255),student_classH10 varchar(255), student_nameH10 varchar(255),student_classI10 varchar(255), student_nameI10 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableJ();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentK (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA11 varchar(255), student_nameA11 varchar(255), student_classB11 varchar(255), student_nameB11 varchar(255), student_classC11 varchar(255), student_nameC11 varchar(255), student_classD11 varchar(255), student_nameD11 varchar(255),student_classE11 varchar(255), student_nameE11 varchar(255),student_classF11 varchar(255), student_nameF11 varchar(255), student_classG11 varchar(255), student_nameG11 varchar(255),student_classH11 varchar(255), student_nameH11 varchar(255),student_classI11 varchar(255), student_nameI11 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableK();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentL (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA12 varchar(255), student_nameA12 varchar(255), student_classB12 varchar(255), student_nameB12 varchar(255), student_classC12 varchar(255), student_nameC12 varchar(255), student_classD12 varchar(255), student_nameD12 varchar(255),student_classE12 varchar(255), student_nameE12 varchar(255),student_classF12 varchar(255), student_nameF12 varchar(255), student_classG12 varchar(255), student_nameG12 varchar(255),student_classH12 varchar(255), student_nameH12 varchar(255),student_classI12 varchar(255), student_nameI12 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableL();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentM (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA13 varchar(255), student_nameA13 varchar(255), student_classB13 varchar(255), student_nameB13 varchar(255), student_classC13 varchar(255), student_nameC13 varchar(255), student_classD13 varchar(255), student_nameD13 varchar(255),student_classE13 varchar(255), student_nameE13 varchar(255),student_classF13 varchar(255), student_nameF13 varchar(255), student_classG13 varchar(255), student_nameG13 varchar(255),student_classH13 varchar(255), student_nameH13 varchar(255),student_classI13 varchar(255), student_nameI13 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableM();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentN (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA14 varchar(255), student_nameA14 varchar(255), student_classB14 varchar(255), student_nameB14 varchar(255), student_classC14 varchar(255), student_nameC14 varchar(255), student_classD14 varchar(255), student_nameD14 varchar(255),student_classE14 varchar(255), student_nameE14 varchar(255),student_classF14 varchar(255), student_nameF14 varchar(255), student_classG14 varchar(255), student_nameG14 varchar(255),student_classH14 varchar(255), student_nameH14 varchar(255),student_classI14 varchar(255), student_nameI14 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableN();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentO (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA15 varchar(255), student_nameA15 varchar(255), student_classB15 varchar(255), student_nameB15 varchar(255), student_classC15 varchar(255), student_nameC15 varchar(255), student_classD15 varchar(255), student_nameD15 varchar(255),student_classE15 varchar(255), student_nameE15 varchar(255),student_classF15 varchar(255), student_nameF15 varchar(255), student_classG15 varchar(255), student_nameG15 varchar(255),student_classH15 varchar(255), student_nameH15 varchar(255),student_classI15 varchar(255), student_nameI15 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableO();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentP (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA16 varchar(255), student_nameA16 varchar(255), student_classB16 varchar(255), student_nameB16 varchar(255), student_classC16 varchar(255), student_nameC16 varchar(255), student_classD16 varchar(255), student_nameD16 varchar(255),student_classE16 varchar(255), student_nameE16 varchar(255),student_classF16 varchar(255), student_nameF16 varchar(255), student_classG16 varchar(255), student_nameG16 varchar(255),student_classH16 varchar(255), student_nameH16 varchar(255),student_classI16 varchar(255), student_nameI16 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableP();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentQ (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA17 varchar(255), student_nameA17 varchar(255), student_classB17 varchar(255), student_nameB17 varchar(255), student_classC17 varchar(255), student_nameC17 varchar(255), student_classD17 varchar(255), student_nameD17 varchar(255),student_classE17 varchar(255), student_nameE17 varchar(255),student_classF17 varchar(255), student_nameF17 varchar(255), student_classG17 varchar(255), student_nameG17 varchar(255),student_classH17 varchar(255), student_nameH17 varchar(255),student_classI17 varchar(255), student_nameI17 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableQ();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentR (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA18 varchar(255), student_nameA18 varchar(255), student_classB18 varchar(255), student_nameB18 varchar(255), student_classC18 varchar(255), student_nameC18 varchar(255), student_classD18 varchar(255), student_nameD18 varchar(255),student_classE18 varchar(255), student_nameE18 varchar(255),student_classF18 varchar(255), student_nameF18 varchar(255), student_classG18 varchar(255), student_nameG18 varchar(255),student_classH18 varchar(255), student_nameH18 varchar(255),student_classI18 varchar(255), student_nameI18 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableR();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentS (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA19 varchar(255), student_nameA19 varchar(255), student_classB19 varchar(255), student_nameB19 varchar(255), student_classC19 varchar(255), student_nameC19 varchar(255), student_classD19 varchar(255), student_nameD19 varchar(255),student_classE19 varchar(255), student_nameE19 varchar(255),student_classF19 varchar(255), student_nameF19 varchar(255), student_classG19 varchar(255), student_nameG19 varchar(255),student_classH19 varchar(255), student_nameH19 varchar(255),student_classI19 varchar(255), student_nameI19 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableS();
    
    
    @Transactional
    @Modifying
    @Query(value="create table studentT (_id  bigserial not null REFERENCES student (_id), student_class boolean, student_name date, student_classA20 varchar(255), student_nameA20 varchar(255), student_classB20 varchar(255), student_nameB20 varchar(255), student_classC20 varchar(255), student_nameC20 varchar(255), student_classD20 varchar(255), student_nameD20 varchar(255),student_classE20 varchar(255), student_nameE20 varchar(255),student_classF20 varchar(255), student_nameF20 varchar(255), student_classG20 varchar(255), student_nameG20 varchar(255),student_classH20 varchar(255), student_nameH20 varchar(255),student_classI20 varchar(255), student_nameI20 varchar(255),primary key (_id)) ", nativeQuery = true) 
    void createStudentTableT();
    

    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS student CASCADE ", nativeQuery = true) 
    void dropTable();
    
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentA CASCADE ", nativeQuery = true) 
    void dropTableA();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentB CASCADE ", nativeQuery = true) 
    void dropTableB();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentC CASCADE ", nativeQuery = true) 
    void dropTableC();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentD CASCADE ", nativeQuery = true) 
    void dropTableD();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentE CASCADE ", nativeQuery = true) 
    void dropTableE();
    
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentF CASCADE ", nativeQuery = true) 
    void dropTableF();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentG CASCADE ", nativeQuery = true) 
    void dropTableG();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentH CASCADE ", nativeQuery = true) 
    void dropTableH();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentI CASCADE ", nativeQuery = true) 
    void dropTableI();
    
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentJ CASCADE ", nativeQuery = true) 
    void dropTableJ();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentK CASCADE ", nativeQuery = true) 
    void dropTableK();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentL CASCADE ", nativeQuery = true) 
    void dropTableL();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentM CASCADE ", nativeQuery = true) 
    void dropTableM();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentN CASCADE ", nativeQuery = true) 
    void dropTableN();
    
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentO CASCADE ", nativeQuery = true) 
    void dropTableO();
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentP CASCADE ", nativeQuery = true) 
    void dropTableP();
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentQ CASCADE ", nativeQuery = true) 
    void dropTableQ();
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentR CASCADE ", nativeQuery = true) 
    void dropTableR();
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentS CASCADE ", nativeQuery = true) 
    void dropTableS();
    @Transactional
    @Modifying
    @Query(value="DROP TABLE IF EXISTS studentT CASCADE ", nativeQuery = true) 
    void dropTableT();    
 
    
    
}
