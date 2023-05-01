package com.xoriant.bank.poc.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.xoriant.bank.poc.entity.Transaction;

@Repository
public interface TransactionDao extends CrudRepository<Transaction, Long>{

//	@Modifying
//	@Transactional
//	@Query(value="insert into transaction(transaction_date,transaction_description,transaction_type,transaction_amount)values(?1,?2,?3,?4)")
//	void insert2(LocalDate transaction_date, String transaction_description,TransactionType transaction_type,
//			double transaction_amount);
	
}
