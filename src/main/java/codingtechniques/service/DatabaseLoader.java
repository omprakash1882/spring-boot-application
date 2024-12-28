package codingtechniques.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import codingtechniques.model.Student;
import codingtechniques.repository.StudentRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private final StudentRepository studentRepository;
	

	public DatabaseLoader(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		
		this.studentRepository.save(new Student("Aliyu", "Sahabo", "Mathematics"));
		this.studentRepository.save(new Student("Yasir", "Yusuf", "Physics"));
		
	}
	
	

}
