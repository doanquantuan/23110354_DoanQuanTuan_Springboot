package vn.iotstar.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer >{
	// Tìm kiếm theo tên
    List<Category> findByCategoryNameContaining(String name);

    // Tìm kiếm có phân trang
    Page<Category> findByCategoryNameContaining(String name, Pageable pageable);
}
