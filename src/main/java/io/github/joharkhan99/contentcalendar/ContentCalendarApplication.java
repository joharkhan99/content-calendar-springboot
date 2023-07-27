package io.github.joharkhan99.contentcalendar;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ContentCalendarApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(ContentCalendarApplication.class, args);
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
