package com.bitcoin.bitcoin.repository;

import java.util.List;
import java.util.Optional;

import com.bitcoin.bitcoin.model.NotificationState;
import com.bitcoin.bitcoin.model.TransactionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bitcoin.bitcoin.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	
	Optional<Order> findByRandomToken(String token);
	List<Order> findByTransactionStatus(TransactionStatus status);
	List<Order> findByNotification(NotificationState state);

}
