package co.develhope.crud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import co.develhope.crud.controllers.StudentController;
import co.develhope.crud.entities.Student;
import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private StudentController studentController;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void studentControllerLoads(){
        assertThat(studentController).isNotNull();
    }


   //controllo che student non e' null
   //metto la risposta della chiamata post dentro studentJSON
   //lo ritorno
   private MvcResult APIPostStudent1(Student student) throws Exception {
        if(student==null) return null;
        String studentJSON = objectMapper.writeValueAsString(student);
        return this.mockMvc.perform(post("/student")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(studentJSON))
               .andDo(print())
               .andExpect(status().isOk())
               .andReturn();
   }

   //metto la chiamata post di APIPostStudent(student) in mvcResult creando 1 student nel db
   //lo metto dentro studentFromResponse
   //faccio i check
   //lo ritorno
   private Student createStudentWithParam2(Student student) throws Exception {
        MvcResult mvcResult = APIPostStudent1(student);
        Student studentResponse = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Student.class);
        assertThat(studentResponse).isNotNull();
        assertThat(studentResponse.getId()).isNotNull();
        return studentResponse;
   }


   //salvo 1 user sul db e check che esista (faccio anche le 2 funzioni sopra
   private Student createAStudent3() throws Exception {
        Student student = new Student();
        student.setName("ale");
        student.setSurname("gob");
        student.setWorking(true);
        return createStudentWithParam2(student);
   }

   private MvcResult createStudentOnDB() throws Exception {
       Student student = new Student();
       student.setName("ale");
       student.setSurname("gob");
       student.setWorking(true);
       return APIPostStudent1(student);
   }

   private Student getStudentFromId(Long id) throws Exception {
       MvcResult result = this.mockMvc.perform(get("/student/"+id))
               .andDo(print())
               .andExpect(status().isOk())
               .andReturn();
       try{
           String studentJSON = result.getResponse().getContentAsString();
           Student student = objectMapper.readValue(studentJSON, Student.class);
           assertThat(student).isNotNull();
           assertThat(student.getId()).isNotNull();
           return student;
       }catch (Exception e){
           return  null;
       }
   }





   @Test
    void TestcreateStudent() throws Exception {
        Student student = createAStudent3();
   }


   @Test
   void TestgetSingleStudent() throws Exception {
        Student student = createAStudent3();                         //creo 1 student sul db
        Student studentFromAPI = getStudentFromId(student.getId()); //faccio la get di 1 studente x id dal controller
        if(studentFromAPI!=null) assertThat(studentFromAPI.getId()).isEqualTo(student.getId()); //li comparo
   }


    @Test
    void TestgetStudentList() throws Exception {
        createAStudent3();
        MvcResult mvcResult = this.mockMvc.perform(get("/student/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        List<Student> students = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        System.out.println("students in db are "+students.size());
        assertThat(students.size()).isNotZero();
    }


    @Test
    void TestupdateStudent() throws Exception {
        Student student = createAStudent3();
        String newName = "boh";
        student.setName(newName);

        String studentJSON = objectMapper.writeValueAsString(student);

        MvcResult result = this.mockMvc.perform(put("/student/"+student.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(studentJSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

        assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
        assertThat(studentFromResponse.getName()).isEqualTo(newName);

        Student getStudent = getStudentFromId(student.getId());
        assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
        assertThat(studentFromResponse.getName()).isEqualTo(newName);
    }



    @Test
    void deleteStudent() throws Exception {
        Student student = createAStudent3();
        assertThat(student.getId()).isNotNull();

        this.mockMvc.perform(delete("/student/"+student.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Student studentFromResponse = getStudentFromId(student.getId());
        assertThat(studentFromResponse).isNull();
    }


    @Test
    void changeStudentWorkStatus() throws Exception {
        Student student = createAStudent3();
        assertThat(student.getId()).isNotNull();

        MvcResult result = this.mockMvc.perform(put("/student/"+student.getId()+"/work?working=true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        //qui testo che quello che result non sia null, abbia un id e abbia isWorking true
        Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
        assertThat(studentFromResponse).isNotNull();
        assertThat(studentFromResponse.getId()).isEqualTo(student.getId());
        assertThat(studentFromResponse.isWorking()).isEqualTo(true);

        //qui faccio una get dell'usr appena modificato e testo che non sia null, che abbia id e che isWorking sia true
        Student studentFromGet = getStudentFromId(student.getId());
        assertThat(studentFromGet).isNotNull();
        assertThat(studentFromGet.getId()).isEqualTo(student.getId());
        assertThat(studentFromGet.isWorking()).isEqualTo(student.isWorking());
        assertThat(studentFromGet.isWorking()).isEqualTo(true);
    }










//lezione in springtheory/21_testCRUD/testCRUD
//soluzione in downloadFF/New Folder/crud test






}
