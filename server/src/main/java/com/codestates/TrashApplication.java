package com.codestates;

import com.codestates.Maker.MakersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TrashApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TrashApplication.class, args);
		MakersRepository makersRepository = context.getBean(MakersRepository.class);

//		try {
//			makersRepository.saveData();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}

