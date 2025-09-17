package vn.iotstar.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.iotstar.entity.User;

public interface UserRepository extends JpaRepository<User, Integer >{

    // Tìm kiếm user theo tên
    List<User> findByUsernameContaining(String username);

    // Tìm kiếm có phân trang
    Page<User> findByUsernameContaining(String username, Pageable pageable);
}
