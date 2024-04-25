package org.example.test;

import com.cmeza.sdgenerator.annotation.SDGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@SDGenerator(
		entityPackage = "org.example.test.models",
		repositoryPackage = "org.example.test.repositories",
		repositoryPostfix = "Repository",
		lombokAnnotations = true,
		withComments = false,
		withJpaSpecificationExecutor = false
)
@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
