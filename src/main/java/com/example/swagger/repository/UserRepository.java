package com.example.swagger.repository;

import com.example.swagger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wensiao
 * @create 2018-07-31 16:13
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {

    User findByName(String name);
    /**
     * 分页查询加模糊查询
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

}