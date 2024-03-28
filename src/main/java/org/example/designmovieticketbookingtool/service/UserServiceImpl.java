package org.example.designmovieticketbookingtool.service;

import org.example.designmovieticketbookingtool.exception.EntityNotPresentException;
import org.example.designmovieticketbookingtool.models.User;
import org.example.designmovieticketbookingtool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User getUser(int userid) {
        Optional<User> user = userRepository.findById(userid);
        if(user.isPresent()){
            return user.get();
        }

        throw new EntityNotPresentException("User not present in database");
    }
}
