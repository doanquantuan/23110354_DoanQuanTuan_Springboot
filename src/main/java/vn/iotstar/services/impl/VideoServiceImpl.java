package vn.iotstar.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.Video;
import vn.iotstar.repository.VideoRepository;
import vn.iotstar.services.IVideoService;

@Service
public class VideoServiceImpl implements IVideoService{

	@Autowired
    private VideoRepository videoRepository;
	
	@Override
	public List<Video> findAll() {
		return videoRepository.findAll();
	}

	@Override
	public Video findById(Integer id) {
		return videoRepository.findById(id).orElse(null);
	}

	@Override
	public Video save(Video user) {
		return videoRepository.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		videoRepository.deleteById(id);
	}

	@Override
	public List<Video> findByTitleContaining(String title) {
		return videoRepository.findByTitleContaining(title);
	}

	@Override
	public Page<Video> findByTitleContaining(String title, Pageable pageable) {
		return videoRepository.findByTitleContaining(title, pageable);
	}

}
