package com.hyhy.springboot.homework.starter;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(Student.class)
public class AutoConfigurationStudent {
    private Student student;

    public AutoConfigurationStudent(Student student) {
        this.student = student;
    }

    @Bean
    public void getClassInfo(){
        new Klass().students.add(student);
    }

}
