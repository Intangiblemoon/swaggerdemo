package com.example.swagger.repository;

import com.example.swagger.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author wensiao
 * @create 2018-07-31 16:13
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {


    /**
     * 按id更新
     * @param name
     * @param age
     * @param id
     * @return
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update user p set p.name =?1,p.age =?2 where p.id = ?3",nativeQuery = true)
    int updateStatusById( String name, Integer age, Integer id);

}