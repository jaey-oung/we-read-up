package com.wru.wrubookstore.repository;

import com.wru.wrubookstore.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryImplTest {

    @Autowired
    UserRepository userRepository;
    UserDto userDto;

    @BeforeEach
    public void init() throws Exception {
        userDto = new UserDto("tester@gmail.com", "pwd", "tester");
    }

    // 테스트 완료 - count(), selectAll(), deleteAll(), insert(), select()
    @Test
    @Transactional
    public void insertAndSelectTest() throws Exception {
        // 모든 비회원 삭제
        userRepository.deleteAll();
        assertEquals(0, userRepository.selectAll().size());
        assertEquals(0, userRepository.count());

        // 비회원이 존재하지 않음
        assertNull(userRepository.select("tester@gmail.com"));

        // 새로운 비회원 추가
        assertEquals(1, userRepository.insert(userDto));
        assertEquals(1, userRepository.selectAll().size());
        assertEquals(1, userRepository.count());

        // 데이터가 정상적으로 조회되는지 확인
        UserDto selectedUser = userRepository.select("tester@gmail.com");

        assertNotNull(selectedUser);
        assertEquals("tester@gmail.com", selectedUser.getEmail());
        assertEquals("pwd", selectedUser.getPassword());
        assertEquals("tester", selectedUser.getName());
    }

    // 테스트 완료 - count(), selectAll(), deleteAll(), insert(), select(), update()
    @Test
    @Transactional
    public void updateTest() throws Exception {
        // 모든 비회원 삭제
        userRepository.deleteAll();
        assertEquals(0, userRepository.selectAll().size());
        assertEquals(0, userRepository.count());

        // 비회원이 존재하지 않음
        assertNull(userRepository.select("tester@gmail.com"));

        // 새로운 비회원 추가
        assertEquals(1, userRepository.insert(userDto));
        assertEquals(1, userRepository.selectAll().size());
        assertEquals(1, userRepository.count());

        // 데이터가 정상적으로 조회되는지 확인
        UserDto selectedUser = userRepository.select("tester@gmail.com");

        assertNotNull(selectedUser);

        // 같은 비회원인지 확인
        assertEquals(userDto.getEmail(), selectedUser.getEmail());
        assertEquals(userDto.getPassword(), selectedUser.getPassword());
        assertEquals(userDto.getName(), selectedUser.getName());

        // 해당 비회원 정보 수정
        selectedUser.setPassword("pwd2");
        assertEquals(1, userRepository.update(selectedUser));

        // 수정된 정보 확인
        UserDto updatedUser = userRepository.select("tester@gmail.com");
        assertEquals("pwd2", updatedUser.getPassword());
    }

    // 테스트 완료 - count(), selectAll(), deleteAll(), insert(), select(), delete()
    @Test
    @Transactional
    public void deleteTest() throws Exception {
        // 모든 비회원 삭제
        userRepository.deleteAll();
        assertEquals(0, userRepository.selectAll().size());
        assertEquals(0, userRepository.count());

        // 비회원 데이터가 존재하지 않음
        assertNull(userRepository.select("tester@gmail.com"));

        // 새로운 비회원 추가
        assertEquals(1, userRepository.insert(userDto));
        assertEquals(1, userRepository.selectAll().size());
        assertEquals(1, userRepository.count());

        // 데이터가 정상적으로 조회되는지 확인
        UserDto selectedUser = userRepository.select("tester@gmail.com");

        assertNotNull(selectedUser);

        // 해당 비회원 삭제
        assertEquals(1, userRepository.delete("tester@gmail.com"));

        // 삭제 결과 확인
        selectedUser = userRepository.select("tester@gmail.com");
        assertNull(selectedUser);
    }

}
