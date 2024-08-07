package br.com.fiap.apinextgen.service;

import br.com.fiap.apinextgen.model.User;
import br.com.fiap.apinextgen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return verifyExistence(id);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        verifyExistence(id);
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User verifyExistence(Long id) {
        return userRepository.findById(id)
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "não existe usuário com o id informado"));
    }
}
