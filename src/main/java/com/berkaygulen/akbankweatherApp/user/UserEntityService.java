package com.berkaygulen.akbankweatherApp.user;

import com.berkaygulen.akbankweatherApp.general.BaseEntityService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserEntityService extends BaseEntityService<User, UserRepository> {

    public UserEntityService(UserRepository repository) {
        super(repository);
    }
}
