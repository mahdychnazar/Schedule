package com.project.schedule.api;

import com.project.schedule.persistence.repository.StudentRepo.StudentRepo;
import com.project.schedule.persistence.repository.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepoTest {

    @Autowired
    private StudentRepo repository;

    @Test
    public void shouldFindAllUsers() {

        List<Student> students = repository.findAll();
        assertThat(students).hasSize(0);
    }

    @Test
    public void shouldAddNewStudent() {

        Student studentModel = Student.builder()
                .id(1L)
                .name("Nazar")
                .age(18)
                .email("nazar@email.com")
                .birthDate(LocalDateTime.parse("2002-06-21T12:02"))
                .build();
        repository.save(studentModel);
        assertEquals(repository.findByName("Nazar").get().getAge(), 18);
    }

    @Test
    public void shouldRemoveStudent() {

        Student studentModel = Student.builder()
                .id(1L)
                .name("Nazar")
                .age(18)
                .email("nazar@email.com")
                .birthDate(LocalDateTime.parse("2002-06-21T12:02"))
                .build();
        Student studentModel1 = Student.builder()
                .id(2L)
                .name("Yevhen")
                .age(20)
                .email("yevhen@email.com")
                .birthDate(LocalDateTime.parse("2002-06-21T12:02"))
                .build();
        repository.save(studentModel);
        repository.save(studentModel1);
        repository.delete(studentModel);
        assertEquals(repository.findAll().size(), 1);
    }

}