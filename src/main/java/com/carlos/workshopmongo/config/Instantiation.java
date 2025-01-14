package com.carlos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carlos.workshopmongo.domain.Post;
import com.carlos.workshopmongo.domain.User;
import com.carlos.workshopmongo.dto.AuthorDTO;
import com.carlos.workshopmongo.repository.PostRepository;
import com.carlos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GET"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/07/2024"), "Partiu Viajem", "Vou viajar para Sao Paulo!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/07/2024"), "Bom dia", "Arcodei feliz hoje!", new AuthorDTO (maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
