package vn.iotstar.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.entity.Video;

public interface IVideoService {
	List<Video> findAll();
	
    Video findById(Integer id);
    
    Video save(Video user);
    
    void deleteById(Integer id);
    
    List<Video> findByTitleContaining(String title);
    
    Page<Video> findByTitleContaining(String title, Pageable pageable);
}
