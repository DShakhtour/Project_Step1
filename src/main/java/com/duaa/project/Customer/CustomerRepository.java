package com.duaa.project.Customer;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 interface CustomerRepository extends JpaRepository<Customer, Integer> {


}

