package com.leposava.frequency;

import com.leposava.frequency.client.RandomTextClient;
import com.leposava.frequency.controller.FrequencyController;
import com.leposava.frequency.entity.RandomText;
import com.leposava.frequency.repository.RandomTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FrequencyApplication {



	public static void main(String[] args) {
		SpringApplication.run(FrequencyApplication.class, args);
	}

}
