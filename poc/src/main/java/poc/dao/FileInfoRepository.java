package poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import poc.entity.FileInfo;

public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {
	
    @Query("SELECT f FROM FileInfo f WHERE f.isDeleted=FALSE AND f.isProcessed=FALSE") 
    List<FileInfo> fetchAllPendingFiles();
    
    @Transactional
    @Modifying
    @Query("Update FileInfo f set f.isProcessed=TRUE where f._id= ?1") 
    void updateFileStatus(Long fileId);
    
}
