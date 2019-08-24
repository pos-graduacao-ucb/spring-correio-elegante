package br.com.guedes.elegantez.services;

import br.com.guedes.elegantez.domain.User;
import br.com.guedes.elegantez.dto.UserDTO;
import br.com.guedes.elegantez.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(String id) {
        Optional<User> user= repository.findById(id);

        return user.orElseThrow(() -> new RuntimeException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail(),
                        objDto.getPassword(), objDto.getAge(), objDto.getGenre());
    }
}
