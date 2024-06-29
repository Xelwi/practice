package com.FBI.FBI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.FBI.FBI.entity.FBI;
import com.FBI.FBI.repository.FBIRepository;

@SpringBootApplication
public class FbiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FbiApplication.class, args);
	}

	@Autowired
	private FBIRepository fbiRepository;

	@Override
	public void run(String... args) throws Exception {


		   FBI fbi1 = new FBI("Ramesh", "Fadatare", "ramesh@gmail.com");
		  fbiRepository.save(fbi1);

		  FBI fbi2 = new FBI("Sanjay", "Jadhav", "sanjay@gmail.com");
		  fbiRepository.save(fbi2);

		  FBI fbi3 = new FBI("tony", "stark", "tony@gmail.com");
		  fbiRepository.save(fbi3);


	}

}