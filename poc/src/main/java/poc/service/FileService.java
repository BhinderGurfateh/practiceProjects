package poc.service;

import java.util.List;

import poc.entity.FileInfo;


public interface FileService {

    List<FileInfo> listAll();

    FileInfo getById(Long id);

    FileInfo saveOrUpdate(FileInfo file);

    void delete(Long id);

/*	void dropTable();*/

	void saveAllFiles(List<FileInfo> student);

	List<FileInfo> listAllPendingFiles();

	void updateFileStatus(Long id);
}
