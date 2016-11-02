package br.com.noemi.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.noemi.curso.entity.Person;


public interface PersonRepository  extends JpaRepository<Person, Long>{
	
	List<Person> findTop3ByOrderByAgeAsc();
	
	List<Person> findFirst3ByOrderByFirstNameAsc();
	
	Person findTopByOrderByAgeAsc();
	
	Person findTopByOrderByAgeDesc();
	
	Person findFirstByOrderByLastNameDesc();
	
	Person findFirstByOrderByLastNameAsc();
	
	@Query("select p from Person p where   p.firstName in :names order by p.age asc")
	List<Person> findByFirstNames(@Param("names") String ... firstName);
	
	@Query("select p from Person p where p.age >= :min  and p.age <= :max")
	List<Person> findByAgeBetween(@Param("min")Integer start,@Param("max")Integer end);
	
	@Query("select p from Person p where p.document.cpf like  %?1")
	List<Person> findByCPFEndsWith(String value);
	
	@Query("select p from Person p where p.firstName like ?2 and  p.age like ?1")
	List<Person>	findByFirstNameAndAge(Integer age ,String firstName);
	
	@Query("select p from Person p where p.firstName like ?1 or  p.age like ?2")
	List<Person> findByFirstNameOrAge(String firstName,Integer age);
	
	@Query("select p from Person p where p.firstName like ?1")
	List<Person> findByFirstName(String firstName);
	
	//busca por Age maior que(parametro) e ordena por FirstName e depois ordena(se hover empate ) por LastName
	List<Person> findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(Integer Idade);
	
	//busca por number via  phones  mapeadp  em person
	List<Person> findByPhonesNuberStartingWith(String nuber); 
	
	//Busca por  linha na  tabela onde o  campo Ducument NAO Null
	List<Person> findByDocumentIsNotNull();
	//Busca por  linha na  tabela onde o  campo Ducument esta Nulo
	List<Person> findByDocumentIsNull();
	
	//Busca  por  firstName ignorando letras mauiscula  e  minusculas
	List<Person> findByFirstNameIgnoreCase(String firstName);
	
	//Busca por Age baseada em uma lista de parametros que  sera negada
	List<Person> findByAgeNotIn(Integer...ages);
	
	//Busca por Age baseada em uma lista de parametros
	List<Person> findByAgeIn(Integer...ages);
	
	// Busca por First name maior que  o valor informado
	List<Person> findByFirstNameGreaterThan(String firstName);
	
	//Busca por age Maior  e  igual parametros passado
		List<Person> findByAgeGreaterThanEqual(Integer age);
		
		//Busca por age Menor e  igual parametros passado
		List<Person> findByAgeLessThanEqual(Integer age);
	
	
	//Busca por age Maior parametros passado
	List<Person> findByAgeGreaterThan(Integer age);
	
	//Busca por age Menor parametros passado
		List<Person> findByAgeLessThan(Integer age);
	
	List<Person> findByLastNameAndAgeBetween(String lastName,int max, int min);
	
	//Busca por age entre o parametros passado idade minima e maxima
	List<Person> findByAgeBetween(int min, int max);
	
	//busca (firstNme, LastName) por um  ou outro paramentro passado
	List<Person> findByAgeOrFirstName(Integer age, String firsrName);
	
	//busca (firstNme, LastName)  pelos 2 paramentros passados 
	//(no banco tem um index p/ colocar um  primeiro Nome com um  sobrenome um vez apenas  na banco sem repetir
	Person findByFirstNameAndLastName(String firstName, String LastName);
	//Busca  por first 	 igual do  parametro fornecido
	List<Person> findByFirstNameLike(String firstName);
	
	//Busca  por first 	 diferente do  parametro fornecido
	List<Person> findByFirstNameNotLike(String firstName);
	
	//busca por Age igual do  parametro fornecido
	List<Person> findByAge(Integer age);

	//busca por Age diferente do  parametro fornecido
	List<Person> findByAgeNot(Integer age);
	
	
}
