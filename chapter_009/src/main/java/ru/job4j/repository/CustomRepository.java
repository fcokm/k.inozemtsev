package ru.job4j.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import ru.job4j.model.AbstactCarSpecific;



@NoRepositoryBean
public interface CustomRepository<T extends AbstactCarSpecific> extends CrudRepository<T, Integer> {
}
