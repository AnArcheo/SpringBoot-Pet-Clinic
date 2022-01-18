package springbootpetclinic;


import com.springframework.springbootpetclinic.SpringBootPetClinicApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootPetClinicApplication.class) // without it it will fail run contextLoads()
class SpringBootPetClinicApplicationTests {

    @Test
    void contextLoads() {
    }

}
