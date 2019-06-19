package poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.dao.FileInfoRepository;
import poc.entity.FileInfo;

import java.util.ArrayList;
import java.util.List;


@Service
public class FileServiceImpl implements FileService {
    
	@Autowired
    private FileInfoRepository fileInfoRepository;


    @Override
    public List<FileInfo> listAll() {
        List<FileInfo> FileInfos = new ArrayList<>();
        fileInfoRepository.findAll().forEach(FileInfos::add); 
    	 	
        return FileInfos;
    }

    @Override
    public List<FileInfo> listAllPendingFiles() {
        List<FileInfo> FileInfos = new ArrayList<>();
        fileInfoRepository.fetchAllPendingFiles().forEach(FileInfos::add); 
    	 	
        return FileInfos;
    }
    
    @Override
    public FileInfo getById(Long id) {
        return fileInfoRepository.findById(id).orElse(null);
    }

    @Override
    public FileInfo saveOrUpdate(FileInfo FileInfo) {
    	fileInfoRepository.save(FileInfo);
        return FileInfo;
    }

    @Override
    public void delete(Long id) {
    	fileInfoRepository.deleteById(id);

    }
    
    @Override
    public void updateFileStatus(Long id) {
    	fileInfoRepository.updateFileStatus(id);
        return ;
    }
    
    @Override
    public void saveAllFiles(List<FileInfo> FileInfos) {
    	for (FileInfo FileInfo : FileInfos) {
    		fileInfoRepository.save(FileInfo);
		}
        return ;
    }




}
