package co.develhope.crud;

import co.develhope.crud.entities.Student;
import co.develhope.crud.repositories.StudentRepository;
import co.develhope.crud.services.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void TestsetStudentIsWorkingStatus() throws Exception {
        Student student = new Student();
        student.setName("ale");
        student.setSurname("gob");
        student.setWorking(false);

        //salvo sul db e controlle che lo student non sia null e che abbia un id
        Student studentDB = studentRepository.save(student);
        assertThat(studentDB).isNotNull();
        assertThat(studentDB.getId()).isNotNull();

        //uso il service x cambiare il working status x controllare il funzionamento dei services e controllo: se e null, se ha un id e se isWorking e' true
        Student studentFromService = studentService.setStudentIsWorkingStatus(student.getId(), true);
        assertThat(studentFromService).isNotNull();
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.isWorking()).isTrue();

        //usa la repository e controllo se essa funziona confrontando i dati dello stesso user con l'user base e l'user preso con il service
        Student studentFromRepository = studentRepository.findById(student.getId()).get();
        assertThat(studentFromRepository).isNotNull();
        assertThat(studentFromRepository.getId()).isNotNull();
        assertThat(studentFromRepository.getId()).isEqualTo(student.getId());
        assertThat(studentFromRepository.isWorking()).isTrue();
    }
}
