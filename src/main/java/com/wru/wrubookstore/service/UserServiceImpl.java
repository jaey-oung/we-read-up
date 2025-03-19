package com.wru.wrubookstore.service;

import com.wru.wrubookstore.dto.UserDto;
import com.wru.wrubookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public int count(int isMember) throws Exception {
        return userRepository.count(isMember);
    }

    @Override
    public List<UserDto> selectAll(int isMember) throws Exception {
        return userRepository.selectAll(isMember);
    }

    @Override
    public void deleteAll(int isMember) throws Exception {
        userRepository.deleteAll(isMember);
    }

    @Override
    public int insert(UserDto userDto) throws Exception {
        return userRepository.insert(userDto);
    }

    @Override
    public UserDto select(String email, int isMember) throws Exception {
        return userRepository.select(email, isMember);
    }

    @Override
    public int update(UserDto userDto) throws Exception {
        return userRepository.update(userDto);
    }

    @Override
    public int delete(String email, int isMember) throws Exception {
        return userRepository.delete(email, isMember);
    }
}
