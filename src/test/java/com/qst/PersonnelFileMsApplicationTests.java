package com.qst;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonnelFileMsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void s(){
        int data[] = new int[10];
        for (int i =0 ; i<10; i++ ){
            data[i] = i;
        }
        for (int i =0 ; i<10; i++ ){
            System.out.println(data[i]);
        }
        int x = 9;
        System.out.println(x/2);
    }
}
