package poc.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
    private String studentName;
    private String studentClass;

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

	public Long get_id() {
		return _id;
	}

	public void set_id(Long _id) {
		this._id = _id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	@Override
	public String toString() {
		return "Student [_id=" + _id + ", studentName=" + studentName + ", studentClass=" + studentClass + "]";
	}
    
	
	
}

