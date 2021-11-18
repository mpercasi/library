package com.example.library.repository;

import com.example.library.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //List<Customer> findCustomerByDNI(String dni);

    //Native Query
    @Query(value = "SELECT * FROM CUSTOMERS WHERE dni=:dni", nativeQuery = true)
    List<Customer> findCustomerByDNI(String dni);

    @Query(value = "UPDATE CUSTOMERS SET name=:name, address=:address WHERE dni=:dni", nativeQuery = true)
    void updateCustomer(String name, String dni, String address);

    @Query(value = "DELETE FROM CUSTOMERS WHERE dni=:dni", nativeQuery = true)
    void deleteCustomer(String dni);
}
