package com.eventus.api.service;

import com.eventus.api.domain.dto.UserDTO;
import com.eventus.api.domain.User;
import com.eventus.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public User save(UserDTO vO) {
        User user = new User();
        BeanUtils.copyProperties(vO, user);
        return repository.save(user);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Long id, UserDTO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        repository.save(bean);
    }

    public UserDTO getById(Long id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserDTO> query(UserDTO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
