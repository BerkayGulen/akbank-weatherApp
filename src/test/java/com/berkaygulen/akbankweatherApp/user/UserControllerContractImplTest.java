package com.berkaygulen.akbankweatherApp.user;
import com.berkaygulen.akbankweatherApp.errorMessages.UserErrorMessages;
import com.berkaygulen.akbankweatherApp.general.BusinessException;
import com.berkaygulen.akbankweatherApp.user.dto.UserDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserSaveRequestDTO;
import com.berkaygulen.akbankweatherApp.user.dto.UserUpdateRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerContractImplTest {

    @Mock
    private UserEntityService userEntityService;

    @InjectMocks
    private UserControllerContractImpl userControllerContract;




    @Test
    void shouldSave() {
        Long id = 15L;
        String password = "1231234";

        UserSaveRequestDTO request = Mockito.mock(UserSaveRequestDTO.class);
        User user = Mockito.mock(User.class);

        Mockito.when(user.getId()).thenReturn(id);
        Mockito.when(request.password()).thenReturn(password);

        Mockito.when(userEntityService.save(Mockito.any())).thenReturn(user);

        UserDTO result = userControllerContract.save(request);

        Mockito.verify(userEntityService).save(Mockito.any());
        assertEquals(id,result.id());



    }

    @Test
    void shouldFindAll() {
        User user = Mockito.mock(User.class);
        List<User> userList = new ArrayList<>();
        userList.add(user);

        Mockito.when(userEntityService.findAll()).thenReturn(userList);

        List<UserDTO> userDTOList = userControllerContract.findAll();
        assertEquals(1,userDTOList.size());
    }

    @Test
    void shouldNotFindAllWhenUserListIsEmpty() {
        List<User> userList = new ArrayList<>();

        Mockito.when(userEntityService.findAll()).thenReturn(userList);

        BusinessException businessException = assertThrows(BusinessException.class, () -> userControllerContract.findAll());
        assertEquals(UserErrorMessages.USER_NOT_FOUND,businessException.getBaseErrorMessage());

    }


    @Test
    void shouldFindById() {
        Long id = 15L;
        User user = new User();
        user.setId(id);

        Optional<User> optionalUser = Optional.of(user);

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);

        UserDTO userDTO = userControllerContract.findById(Mockito.anyLong());

        assertEquals(id,userDTO.id());

    }

    @Test
    void shouldNotFindByIdWhenUserDoesNotExists() {
        Long id = 15L;
        Mockito.when(userEntityService.findById(Mockito.any())).thenReturn(Optional.empty());

        BusinessException businessException = assertThrows(BusinessException.class, () -> userControllerContract.findById(Mockito.anyLong()));
        assertEquals(UserErrorMessages.USER_NOT_FOUND,businessException.getBaseErrorMessage());

    }


    @Test
    void shouldDelete() {
        Long id = 15L;
        User user = Mockito.mock(User.class);

        Optional<User> optionalUser = Optional.of(user);
        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);

        Mockito.doNothing().when(userEntityService).delete(id);

        userControllerContract.delete(id);
        Mockito.verify(userEntityService).delete(id);




    }
    @Test
    void shouldNotDeleteWhenDeleteMethodThrowsException() {

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        BusinessException businessException = assertThrows(BusinessException.class, () -> userControllerContract.delete(Mockito.anyLong()));
        assertEquals(UserErrorMessages.USER_NOT_FOUND,businessException.getBaseErrorMessage());

    }

    @Test
    void shouldUpdateUserWhenUserDoesNotExists() {
        Long id = 15L;
        User user = Mockito.mock(User.class);
        UserUpdateRequestDTO request = Mockito.mock(UserUpdateRequestDTO.class);
        Mockito.when(user.getId()).thenReturn(id);

        Optional<User> optionalUser = Optional.of(user);

        Mockito.when(userEntityService.findById(Mockito.anyLong())).thenReturn(optionalUser);

        UserDTO userDTO = userControllerContract.updateUser(Mockito.anyLong(),request);

        assertEquals(id,userDTO.id());
    }
    @Test
    void shouldNotUpdateUser() {
        Long id = 15L;
        UserUpdateRequestDTO request = Mockito.mock(UserUpdateRequestDTO.class);

        Mockito.when(userEntityService.findById(Mockito.any())).thenReturn(Optional.empty());

        BusinessException businessException = assertThrows(BusinessException.class, () -> userControllerContract.updateUser(Mockito.anyLong(),request));
        assertEquals(UserErrorMessages.USER_NOT_FOUND,businessException.getBaseErrorMessage());

    }
}