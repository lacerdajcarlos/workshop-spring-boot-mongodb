package com.carlos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlos.workshopmongo.domain.User;
import com.carlos.workshopmongo.dto.UserDTO;
import com.carlos.workshopmongo.repository.UserRepository;
import com.carlos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		if (!repo.existsById(id)) {
			throw new IllegalArgumentException("Recurso com ID " + id + " não encontrado.");
		}
		repo.deleteById(id);
	}
	public User update(User obj) {
	    User existingUser = repo.findById(obj.getId())
	        .orElseThrow(() -> new IllegalArgumentException("Usuário com ID " + obj.getId() + " não encontrado."));

	    updateData(existingUser, obj);
	    return repo.save(existingUser);
	}

	private void updateData(User existingUser, User obj) {
	    existingUser.setName(obj.getName());
	    existingUser.setEmail(obj.getEmail());
	}


	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
