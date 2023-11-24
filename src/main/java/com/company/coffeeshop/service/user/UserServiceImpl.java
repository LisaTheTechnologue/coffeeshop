package com.company.coffeeshop.service.user;

import com.company.coffeeshop.entity.user.User;
import com.company.coffeeshop.exception.ResourceNotFoundException;
import com.company.coffeeshop.interfaces.UserService;
import com.company.coffeeshop.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(String username, User userUpdated) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username",username));

        user.setFirstName(userUpdated.getFirstName());
        user.setLastName(userUpdated.getLastName());
        user.setActive(userUpdated.getActive());
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username",username));

        userRepo.delete(user);
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> result = userRepo.findByUsername(username);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("User", "username",username);
        }

//		Post post = postRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        //return post;
    }
}
