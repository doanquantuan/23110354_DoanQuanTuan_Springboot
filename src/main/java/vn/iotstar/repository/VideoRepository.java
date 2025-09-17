package vn.iotstar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer > {
	// Tìm kiếm theo tiêu đề
    List<Video> findByTitleContaining(String title);

    // Tìm kiếm theo tiêu đề + phân trang
    Page<Video> findByTitleContaining(String title, Pageable pageable);
}
