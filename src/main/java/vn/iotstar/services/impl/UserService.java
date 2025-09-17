package vn.iotstar.services.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.User;
import vn.iotstar.repository.UserRepository;
import vn.iotstar.services.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


	@Override
	public List<User> findByUsernameContaining(String username) {
		return userRepository.findByUsernameContaining(username);
	}

	@Override
	public Page<User> findByUsernameContaining(String username, Pageable pageable) {
		return userRepository.findByUsernameContaining(username, pageable);
	}
	
	
}
