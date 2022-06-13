package com.duaa.project.payments;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 interface PaymentsRepository extends JpaRepository<Payments, Integer> {



}
