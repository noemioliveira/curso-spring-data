package br.com.noemi.curso;

import java.util.Arrays;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_2.perty.recipe.formatErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import scala.annotation.meta.setter;
import br.com.noemi.curso.entity.Address;
import br.com.noemi.curso.entity.Address.TypeAddress;
import br.com.noemi.curso.entity.Phone;
import br.com.noemi.curso.entity.Phone.TypePhones;
import br.com.noemi.curso.entity.Document;
import br.com.noemi.curso.entity.Person;
import br.com.noemi.curso.entity.User;
import br.com.noemi.curso.repository.AddressRepository;
import br.com.noemi.curso.repository.DocumentRepository;
import br.com.noemi.curso.repository.PersonRepository;
import br.com.noemi.curso.repository.PhoneRepository;
import br.com.noemi.curso.repository.UserRepository;

@SpringBootApplication
//@ImportResource(value = "spring-data.xml")
public class CursoSpringDataApplication  implements CommandLineRunner {

	@Autowired
	private AddressRepository  addressRepository ;
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataApplication.class, args);
	}

		
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
//		testeConfiguraton();
//		testeSave(); 
//		testeUpdate();
//		testeDelete();
//		testeSavePersons();
//		testeDeletePersons();
//		testeFindAndSort();
//		testeFindAllByIds();
//		testeExists();
//		testPagination();
	
//		testeByAge();
//		testeFirstNameLike();
//		testeFindByOrAnd();
//		testeFindBetween();
//		testFindLastAndBetweenAge();
		
//		testByGreaterAndLess();
//		testByGreaterAndLessEquals();
//		testeNyFirstNemGreaterThan();
	
//		testByStartAndEnd();
//		testByContaining();
//		testByAddressStartAndEnding();
//		testeFindByInAndNotIn();
//		testeByOrderBy();
//		testeIgnoreCase();
//		testByNotNullAndNull();
//		testPhoneByNuber();
//		testeFindByGreatesThanAndOrder();
//		findFirstName();
//		findFirstNameOrAge();
//		findFirstNameAndAge();
//		findPersonByCpfEndsWith();
//		findPersonByAges();
//		findPersonByNames();
//		findDocumentByCPFStrat();
//		findAddresPorCidade();
//		findAdressPorEnredco();
		
//		testeFunctioAddress();
//		testeProcedureCPF();
//		testeUpdatePhones();
//		deletePhone();
		
//		findFirstLastName();
//		findTopAge();
//		findFirst3AndTop3();
		testeUser();
		}

		private void testeUser() {
		User user=  new User();
		user.setUsername("noemiUser");
		user.setPassword("1234");
		
		
		if(user.isNew()){
			userRepository.save(user);
//			System.out.println(user.toString());
		}
		
		User user2= userRepository.findOne(user.getId());
		System.out.println(user2.toString());
	}


		private void findFirst3AndTop3() {
		 List<Person> top = personRepository.findTop3ByOrderByAgeAsc();
		 top.forEach(System.out::println);
		 
		 List<Person> first = personRepository.findFirst3ByOrderByFirstNameAsc();
		 first.forEach(System.out::println);
	}


		private void findTopAge() {
			Person p1 = personRepository.findTopByOrderByAgeAsc();
			System.out.println("Primeiro idade  = " + p1);
			
			
			System.out
			.println("----------------------------------------------------------");
			
			Person p2 = personRepository.findTopByOrderByAgeDesc();
			System.out.println("Primeiro Idade  = " + p2);
			
		
	}


		private void findFirstLastName() {
		Person p1 = personRepository.findFirstByOrderByLastNameAsc();
		System.out.println("Primeiro Nome  = " + p1);
		
		System.out
		.println("----------------------------------------------------------");
		
		Person p2 = personRepository.findFirstByOrderByLastNameDesc();
		System.out.println("Ultimo Nome= " + p2);
	}


		private void deletePhone() {
			
			int result = phoneRepository.deleteByPhoneNumber("9568-3321");
			System.out.println("result = " + result);
			
		}

	

	private void testeUpdatePhones() {
		
//		int result = phoneRepository.setPhoneNumber("3333-3333", 4L);
//		System.out.println("result = " + result);
		
		
		int result =
				phoneRepository.setPhoneNumber(TypePhones.CELULAR, 1L);
			System.out.println("result = " + result);
	}


	private void testeProcedureCPF() {
		// TODO Auto-generated method stub
		String doc = documentRepository.repalceCPF(1l);
		System.out.println("CPF "+doc);
		
		String doc2 = documentRepository.procedureReplaceCPF(1l);
		System.out.println("CPF "+doc2);
	}


	private void testeFunctioAddress() {
		// TODO Auto-generated method stub
		String ad1 = addressRepository.functionConcatenaEndereco(4l);
		System.out.println(ad1);	
		
		String ad2 = addressRepository.functioNativeQueryConcatenaEndereco(2l);
		System.out.println(ad2);
		
//		List<String> addresses =  addressRepository.functioListNativeQueryConcatenaEndereco(1l,2l,4l);
//		addresses.forEach(System.out::println);
	}


	private void findAdressPorEnredco() {
		
		Address ad1  = addressRepository.buscaPorEndereco("Curitiba", "Rua da PAZ");
		System.out.println(ad1.toString());	
		
		Address ad2  = addressRepository.buscaPorCidadeRua("Sao Jose dos Pinhais", "Rua da PAZ");
		System.out.println(ad2.toString());	
		
		
	}


	private void findAddresPorCidade() {
		List<Address> ad =addressRepository.buscaPorCidade("Curitiba");
		ad.forEach(System.out::println);
		
	}


	private void findDocumentByCPFStrat() {
		List<Document> doc = documentRepository.findByCPFStartsWith("0");
		doc.forEach(System.out::println);
	}


	private void findPersonByNames() {
	   List<Person> person = personRepository.findByFirstNames("Noemi","Nely","Raphael");
	   person.forEach(System.out::println);
	}


	private void findPersonByAges() {
		List<Person>person = personRepository.findByAgeBetween(29, 40);
		person.forEach(System.out::println);
		
	}


	private void findPersonByCpfEndsWith() {
		List<Person> person = personRepository.findByCPFEndsWith("99");
		person.forEach(System.out::println);
	}


	private void findFirstNameAndAge() {
		List<Person> person = personRepository.findByFirstNameAndAge( 33,"Noemi");
		person.forEach(System.out::println);
		
		
	}


	private void findFirstNameOrAge() {
	
		List<Person> person = personRepository.findByFirstNameOrAge("Noemi", 29);
		person.forEach(System.out::println);
		
	}


	private void findFirstName() {
		List<Person> persons = personRepository.findByFirstName("Noemi");
		persons.forEach(System.out::println);
	}


	private void testeFindByGreatesThanAndOrder() {
		List<Person> p1 = personRepository.findByAgeGreaterThanOrderByFirstNameAscLastNameAsc(29);
		p1.forEach(System.out::println);
		
	}


	private void testPhoneByNuber() {
		List<Person> p1 = personRepository.findByPhonesNuberStartingWith("30");
		p1.forEach(System.out::println);
	}


	private void testByNotNullAndNull() {
		List<Person> p1 = personRepository.findByDocumentIsNull();
		p1.forEach(System.out::println);
		
		System.out
		.println("----------------------------------------------------------");

		
		List<Person> p2 = personRepository.findByDocumentIsNotNull();
		p2.forEach(System.out::println);
	}


	private void testeIgnoreCase() {
		List<Person> p1 = personRepository.findByFirstNameIgnoreCase("noemi");
		p1.forEach(System.out::println);
		
	}


	private void testeByOrderBy() {
		
		List<Address> al = addressRepository.findByCityOrderByTypeDesc("Curitiba");
		al.forEach(System.out::println);
	}


	private void testeFindByInAndNotIn() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByAgeIn(2, 34, 21);
		p1.forEach(System.out::println);

		System.out
				.println("----------------------------------------------------------");

		List<Person> p2 = personRepository.findByAgeNotIn(2,34,21);
		p2.forEach(System.out::println);
	}

	private void testByAddressStartAndEnding() {
		
		List<Address> a1 = addressRepository
				.findByCityStartingWithOrStreetEndingWith("Curitiba", "Paz");
		
		a1.forEach(System.out::println);
		
	}
//
	private void testByContaining() {
		
		List<Address> a1 = addressRepository.findByStreetContaining("XV");
		a1.forEach(System.out::println);
		
	}

	private void testByStartAndEnd() {
		
		List<Address> a1 = addressRepository.findByCityStartingWith("Curitiba");
		a1.forEach(System.out::println);
		
		System.out.println(" --- --- --- --- --- ---");
		
		List<Address> a2 = addressRepository.findByStreetEndingWith("Novembro");
		a2.forEach(System.out::println);
		
	}
	private void testeNyFirstNemGreaterThan() {
		
//		List<Person> p1 =  personRepository.findByFirstNameGreaterThan("Julia Eduarda");
//		p1.forEach(System.out::println);
		
		List<Person> p1 =  personRepository.findByFirstNameGreaterThan("N");
		p1.forEach(System.out::println);
	}


	private void testByGreaterAndLessEquals() {
		// TODO Auto-generated method stub
		List<Person> p1 =  personRepository.findByAgeGreaterThanEqual(34);
		p1.forEach(System.out::println);
		
		System.out
		.println("----------------------------------------------------------");
		
		List<Person> p2 =  personRepository.findByAgeLessThanEqual(34);
		p2.forEach(System.out::println);
	}


	private void testByGreaterAndLess() {
		// TODO Auto-generated method stub
		List<Person> p1 =  personRepository.findByAgeGreaterThan(28);
		p1.forEach(System.out::println);
		
		System.out
		.println("----------------------------------------------------------");
		
		List<Person> p2 =  personRepository.findByAgeLessThan(28);
		p2.forEach(System.out::println);
	}


	private void testFindLastAndBetweenAge() {
		// TODO Auto-generated method stub
		List<Person> persons= personRepository.findByLastNameAndAgeBetween("Sobanski", 2, 60);
		persons.forEach(System.out::println);
	}


	private void testeFindBetween() {
		// TODO Auto-generated method stub
		List<Person> persons= personRepository.findByAgeBetween(2,40);
		persons.forEach(System.out::println);
	}


	private void testeFindByOrAnd() {
		// TODO Auto-generated method stub
		Person p1 = personRepository.findByFirstNameAndLastName("Nely", "Fernandes");
		System.out
		.println(p1.toString());
		
		
		System.out
		.println("----------------------------------------------------------");
		
		List<Person> persons = personRepository.findByAgeOrFirstName(63, "Noemi");
		persons.forEach(System.out::println);
		
	}


	private void testeFirstNameLike() {
		// TODO Auto-generated method stub
		List<Person> p1 = personRepository.findByFirstNameLike("Noemi");
		p1.forEach(System.out::println);

		System.out
				.println("----------------------------------------------------------");
		
		List<Person> p2 = personRepository.findByFirstNameNotLike("Noemi");
		p2.forEach(System.out::println);

	}

	private void testeByAge() {
		// TODO Auto-generated method stub
		
		List<Person> p1 = personRepository.findByAge(24);
		p1.forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------");
		
		List<Person> p2 = personRepository.findByAgeNot(24);
		p2.forEach(System.out::println);
		
		
	}


	private void testPagination() {
		// TODO Auto-generated method stub
		
		Page<Person>  pages =
				personRepository.findAll(new PageRequest(0, 3));
		pages.getContent().forEach(System.out::println);
		
		pages =personRepository.findAll(new PageRequest(1, 3));
		pages.getContent().forEach(System.out::println);
		
		pages =personRepository.findAll(new PageRequest(2, 3));
		pages.getContent().forEach(System.out::println);
		
		pages =personRepository.findAll(new PageRequest(3, 3));
		pages.getContent().forEach(System.out::println);
	}


	private void testeExists() {
		// TODO Auto-generated method stub
		 
		boolean p1 = personRepository.exists(5l);
		System.out.println("P1 is" + p1);
		
		
		boolean p2 = personRepository.exists(50l);
		System.out.println("P2 is" + p2);
	}


	private void testeFindAllByIds() {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findAll(Arrays.asList(1l,3l,4l,5l));
		persons.forEach(System.out::println);
	}


	// ordenacao  Spring data
	private void testeFindAndSort() {
		// TODO Auto-generated method stub
		
		Order orderAssc =new Order(Direction.ASC, "lastName");
		Order orderDesc =new Order(Direction.DESC, "firstName");
		
		Sort sort = new Sort(orderAssc,orderDesc);
		
		List<Person> persons = personRepository.findAll(sort);
		
		persons.forEach(System.out::println);
		
	}


	private void testeDeletePersons() {
		// TODO Auto-generated method stub
		
//		
//		Person p1 = personRepository.findOne(14l);
//		Person p2 = personRepository.findOne(17l);
//		Person p3 = personRepository.findOne(18l);
//		
//		//p/ cada operacao de delete Spring abre trasacao comita e  fecha
//		personRepository.delete(Arrays.asList(p1,p2,p3));
		
		System.out.println("----------------------------------------------------------");
		
		Person p4 = personRepository.findOne(19l);
		Person p5 = personRepository.findOne(20l);
		Person p6 = personRepository.findOne(21l);
		
		//deleta TUDO/TODOS  em uma trasacao so
		personRepository.deleteInBatch(Arrays.asList(p4,p5,p6));
	
		
	}


	private void testeSavePersons() {
		// TODO Auto-generated method stub
		Person p1 = new  Person();
		p1.setFirstName("Carla");
		p1.setLastName("Fernandes");
		p1.setAge(43);
		p1.setDocument(new  Document("065.565.676-89", 69807892));
		
		Person p2 = new  Person();
		p2.setFirstName("Camila");
		p2.setLastName("da Silva");
		p2.setAge(23);
		p2.setDocument(new  Document("165.445.676-89", 857507893));
		
		
		Person p3 = new  Person();
		p3.setFirstName("Julio");
		p3.setLastName("Fernandes");
		p3.setAge(3);
		p3.setDocument(new  Document("361.565.676-39", 49807642));

		Person p4 = new  Person();
		p4.setFirstName("Bruno");
		p4.setLastName("Galhasso");
		p4.setAge(33);
		p4.setDocument(new  Document("065.222.676-11", 87807892));
		
		Person p5 = new  Person();
		p5.setFirstName("Herry");
		p5.setLastName("Castelli");
		p5.setAge(63);
		p5.setDocument(new  Document("556.335.676-89", 5907891));
		
		
		// sem  spring data
//		List<Person> persons= Arrays.asList(p1,p2,p3,p4,p5);
//		for(Person p : persons){
//			
//			personRepository.save(p);
//		}
		
		//com Spring data
//		personRepository.save(Arrays.asList(p1,p2,p3,p4,p5));
		
		//pra mostra a  lista
		List<Person>  persons = personRepository.save(Arrays.asList(p1,p2,p3,p4,p5));
		persons.forEach(System.out::println);
		
	}


	private void testeDelete() {
		// TODO Auto-generated method stub
		personRepository.delete(16l);
		
		Person person =  personRepository.findOne(15l);
		
		personRepository.delete(person);
		
		
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
	}


	private void testeUpdate() {
		// TODO Auto-generated method stub
		Person person = personRepository.findOne(16l);
		System.out.println(person.toString());
		
		person.setLastName("Fernandes de Oliveira ");
		
		
		personRepository.save(person);
		
		 Person person2=  personRepository.findOne(16l);
		
		System.out.println(person2.toString());
	}


	private void testeSave() {
		// TODO Auto-generated method stub
		Person person = new  Person();
		person.setFirstName("Nely");
		person.setLastName("Fenandes");
		person.setAge(63);
		person.setDocument(new  Document("065.555.666-89", 65547892));
		
		Address address = new Address();
		address.setCity("Sao Jose dos Pinhais");
		address.setStreet("Ruas das Valquirias, 55");
		address.setType(TypeAddress.RESIDENCIAL);
		
		person.setAddress(Arrays.asList(address)); //coloca  na lista um  ou mais  enderecos
		person.addPhone(new Phone(TypePhones.CELULAR,"9988-7766"));
		
		personRepository.save(person);
		
		Person p2 = personRepository.findOne(person.getId());
		
	}



	private void testeConfiguraton() {
		// TODO Auto-generated method stub
		
		List<Person> persons = personRepository.findAll();
		// for each java 8
		persons.forEach(System.out::println);

		Long totalPerson = personRepository.count();

		System.out.println("Total of Person" + totalPerson);
		
		Long totalAdress = addressRepository.count();

		System.out.println("Total of Address" + totalAdress);
		
		Long totalDocument =documentRepository.count();

		System.out.println("Total of Document" + totalDocument);
		
		Long totalPhone = phoneRepository.count();

		System.out.println("Total of Phone" + totalPhone);

	}
}
