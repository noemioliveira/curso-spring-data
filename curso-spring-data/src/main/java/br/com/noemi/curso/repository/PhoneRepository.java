package br.com.noemi.curso.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.noemi.curso.entity.Phone;
import br.com.noemi.curso.entity.Phone.TypePhones;

@Transactional(readOnly =true) //implicito por padrao do spring data
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	@Modifying
	@Transactional(readOnly = false)
	@Query("delete from Phone p where p.nuber like ?1")
	int deleteByPhoneNumber(String number);
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.nuber = ?1 where p.id = ?2")
	int setPhoneNumber(String number, Long id);
	
	
	@Modifying
	@Transactional(readOnly = false)
	@Query("update Phone p set p.type = ?1 where p.id = ?2")
	int setPhoneNumber(TypePhones type, Long id);
}

