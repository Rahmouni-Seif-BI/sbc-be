package com.example.IgniteSelfBudgetControlMultiUser.Services.Abstract;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;

import javax.validation.ValidationException;
import java.util.List;
public interface IAbstractService<T> {
    T load(Long id);
    List<T> getAll();
    T save(T entity) throws Exception;
    List<T> saveAll(List<T> entities) throws Exception;
    void delete(Long id);
}
