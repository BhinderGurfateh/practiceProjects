package poc.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;
	private String filePath;
	private Boolean isProcessed;
	private Boolean isDeleted;
	@Temporal(TemporalType.DATE)
	private Date dateOfUpload;
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Boolean getIsProcessed() {
		return isProcessed;
	}
	public void setIsProcessed(Boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Date getDateOfUpload() {
		return dateOfUpload;
	}
	public void setDateOfUpload(Date dateOfUpload) {
		this.dateOfUpload = dateOfUpload;
	}
	@Override
	public String toString() {
		return "FileInfo [_id=" + _id + ", filePath=" + filePath + ", isProcessed=" + isProcessed + ", isDeleted="
				+ isDeleted + ", dateOfUpload=" + dateOfUpload + "]";
	}
	
	
	
}
