package br.com.fiap.apinextgen.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T create(T entity);

    public T update(Long id, T entity);

    public void delete(Long id);

    public T verifyExistence(Long id);
}
