package com.example.customermsdemo.repository;

import com.example.customermsdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    @Modifying
    @Query(value = "update customers set balance = balance - :amount where id=:id", nativeQuery = true)
    void decreaseBalanceById(@Param("id") Long id, @Param("amount") double amount);

    @Modifying
    @Query(value = "update customers set balance = balance + :amount where id=:id", nativeQuery = true)
    void increaseBalanceById(@Param("id") Long id, @Param("amount") double amount);
}
