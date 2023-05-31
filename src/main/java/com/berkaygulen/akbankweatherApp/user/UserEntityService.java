package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
@Getter
@Setter
public class UserEntityService extends BaseEntityService<User, UserRepository> {

    public UserEntityService(UserRepository repository) {
        super(repository);
    }

    public User findUserUsername(String username){
        return getRepository().findByUsername(username);
    }
    public User findUserEmail(String email){
        return getRepository().findByEmail(email);
    }

}
