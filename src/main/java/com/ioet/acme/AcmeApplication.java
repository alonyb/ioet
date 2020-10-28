package com.ioet.acme;

import com.ioet.acme.repository.EmployeeRepository;
import com.ioet.acme.repository.InEmployeeRepository;
import com.ioet.acme.service.WorkTime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//@SpringBootApplication
public class AcmeApplication {

    public static void main(String[] args) {
//		SpringApplication.run(AcmeApplication.class, args);
        InEmployeeRepository repository = new EmployeeRepository();
		WorkTime workTime = new WorkTime(repository);
        {
            try {
                File file = new File("sample.txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                StringBuffer sb = new StringBuffer();
                String line;
                while ((line = br.readLine()) != null) {
                    workTime.getSalary(line);
                }
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
