package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;



    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "anirudh",
            "abc",
            "prutha"
    })
    public void testFindByUserName(String name){

        assertNotNull(userRepository.findByUserName(name), "Failed for "+ name);
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArguementsProvider.class)
    public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }



    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,5,10"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
