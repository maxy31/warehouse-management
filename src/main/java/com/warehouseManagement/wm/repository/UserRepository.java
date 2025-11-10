package com.warehouseManagement.wm.repository;

import com.warehouseManagement.wm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNo (String no);

    @Query("SELECT u FROM User u WHERE " +
            // use LIKE SQL to 'no' and 'name'
            "(:no IS NULL OR u.no LIKE CONCAT('%', :no, '%')) AND " +
            "(:name IS NULL OR u.name LIKE CONCAT('%', :name, '%')) AND " +
            "(:age IS NULL OR u.age = :age) AND " +
            "(:sex IS NULL OR u.sex = :sex) AND " +
            "(:phone IS NULL OR u.phone = :phone) AND " +
            "(:roleId IS NULL OR u.roleId = :roleId) AND " +
            "(:isValid IS NULL OR u.isValid = :isValid)")
    List<User> searchUser(
            @Param("no") String no,
            @Param("name") String name,
            @Param("age") Integer age,
            @Param("sex") Integer sex,
            @Param("phone") String phone,
            @Param("roleId") Integer roleId,
            @Param("isValid") String isValid
    );
}
