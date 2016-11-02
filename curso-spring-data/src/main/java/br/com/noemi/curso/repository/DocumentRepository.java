package br.com.noemi.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.com.noemi.curso.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
//	@Procedure(name ="docs.procedureReplaceCPF")
	@Procedure
	String procedureReplaceCPF(@Param("ID_IN") Long id);

	@Procedure( procedureName ="procReplaceCPF")
//	@Procedure("procReplaceCPF")
	String repalceCPF(Long id);
	
	@Query("select d from #{#entityName} d where d.cpf like :start%")
	List<Document> findByCPFStartsWith(@Param("start")String start);
}
