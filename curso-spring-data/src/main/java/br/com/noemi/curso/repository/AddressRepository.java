package br.com.noemi.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.noemi.curso.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
//	@Query(value ="select funcConcatAddress(?1)",nativeQuery = true )
//	List<String> functioListNativeQueryConcatenaEndereco(Long...id);
	
	//Usando a fuction com @Query
	@Query(value ="select funcConcatAddress(?1)",nativeQuery = true )
	String  functioNativeQueryConcatenaEndereco(Long id);
	
	//Usando a fuction com @NamedQuery
	String  functionConcatenaEndereco(Long id);
	
	@Query( value ="select * from addresses where city like?1 and  street like ?2",
			nativeQuery = true)
	Address buscaPorCidadeRua(String city, String street);
	
	//usando NamedNativeQueries
	Address  buscaPorEndereco(String city,String Street);
	
	//Usando @NamedQuery na  entidade
	List<Address> buscaPorCidade(String cidade);

	// busca por city e ordena de forma descendente
	List<Address> findByCityOrderByTypeDesc(String city);

	// busca por city ou street conforme a igualdade da sequencia de caracteres
	List<Address> findByCityStartingWithOrStreetEndingWith(String city,
			String street);

	// busca por street conforme o parametro coincida com qualquer parte do
	// campo street
	List<Address> findByStreetContaining(String street);

	// busca por street conforme o termino da palavra
	List<Address> findByStreetEndingWith(String street);

	// busca por city conforme o inicio da palavra
	List<Address> findByCityStartingWith(String city);

}
