package com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract;

import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface  IAbstractController<T> {
    ResponseEntity<T> load(Long id);
    ResponseEntity<List<T>> getAll() throws Exception;
    ResponseEntity<T> save(T entity) throws Exception;
    ResponseEntity<List<T>> saveAll(List<T> entities) throws Exception;
    void delete(Long id) throws Exception;

}
