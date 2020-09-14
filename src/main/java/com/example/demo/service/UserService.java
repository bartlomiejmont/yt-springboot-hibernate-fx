package com.example.demo.service;

import com.example.demo.model.QUser;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

    public Optional<User> getUserByLogin(String login){
        JPAQuery<Object> query = new JPAQuery<>(entityManager);
        QUser qUser = QUser.user;
        User user = query.select(qUser)
                .from(qUser)
                .where(qUser.login.eq(login))
                .fetchOne();
        return Optional.ofNullable(user);
    }

    public boolean isPasswordMatching(String login, String password){
        Optional<User> user = getUserByLogin(login);

        return user.map(u -> password.equals(u.getPassword())).orElse(false);
    }

}
