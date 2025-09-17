package vn.iotstar.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.entity.User;

public interface IUserService {
	List<User> findAll();
	
    User findById(Integer id);
    
    User save(User user);
    
    void deleteById(Integer id);
    
    List<User> findByUsernameContaining(String username);
    
    Page<User> findByUsernameContaining(String username, Pageable pageable);
}
