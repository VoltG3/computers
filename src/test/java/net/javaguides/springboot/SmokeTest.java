package net.javaguides.springboot;

import net.javaguides.springboot.controller.DepartmentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private DepartmentController controller;

    @Test
    public void contextLoads() {
        frameTable();
        assertThat(controller).isNotNull();
    }

    public void frameTable() {
        System.out.println("###########################");
        System.out.println("#  SmokeTest              #");
        System.out.println("###########################");
    }

    }