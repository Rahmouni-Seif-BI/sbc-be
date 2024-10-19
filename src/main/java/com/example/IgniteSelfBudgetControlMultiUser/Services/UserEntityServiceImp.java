package com.example.IgniteSelfBudgetControlMultiUser.Services;

import com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract.IAbstractService;
import com.example.IgniteSelfBudgetControlMultiUser.ABC.Mappers.UserMapper;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.UserDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.UserEntity;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Repositories.IUserEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserEntityServiceImp  implements IUserEntityService, IAbstractService<UserEntity>, UserDetailsService {

    @Autowired
    IUserEntityRepository iUserEntityRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = iUserEntityRepository.findUserEntityByLogin(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Convert your UserEntity to a Spring Security UserDetails object
        return new org.springframework.security.core.userdetails.User(
                userEntity.getLogin(),
                userEntity.getPass(),
                new ArrayList<>()  // You can replace this with roles or authorities
        );
    }

    public UserDTO login(String login, String pass) {
        UserEntity userEntity = iUserEntityRepository.getUserEntityByLoginAndPass(login, pass);
        UserDTO userDTO = userMapper.toUserDto(userEntity);
        return userDTO;
    }

    @Override
    public UserEntity load(Long id) {

        UserEntity UserEntity = iUserEntityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        return UserEntity;
    }

    @Override
    public List<UserEntity> getAll() {
        return   iUserEntityRepository.findAll();
    }

    @Override
    public UserEntity save(UserEntity entity) throws Exception {
        return null;
    }

    @Override
    public List<UserEntity> saveAll(List<UserEntity> entities) throws Exception {

        return iUserEntityRepository.saveAll(entities);
    }

    @Override
    public void delete(Long id) {
        iUserEntityRepository.deleteById(id);
    }

}
