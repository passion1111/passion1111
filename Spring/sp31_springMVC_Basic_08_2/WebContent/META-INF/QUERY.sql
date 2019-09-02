create table card
(
  consumerId varchar(20),
  amount  varchar(20)
);

create table ticket
(
  consumerId varchar(20),
  countnum varchar(20)
);

ALTER TABLE ticket ADD CONSTRAINT ck_ticket_countnum check(countnum < 5);

--Spring 트랜잭션 활용하기
--1.DataSourceTransactionManager
    <beans:bean name="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<beans:property name="dataSource" ref="dataSource" />
	</beans:bean>

--2.transactionManager 객체를 JavaCode > DAO객체 안에서
   --TicketDao 안에 선언
   --PlatformTransactionManager transactionManager; 
   --PlatformTransactionManager 어떤 제품(Oracle, Ms-sql , mysql)
   --종속적이지 않은 설계를 위한 만든 인터페이스

--3.TicketDao injection transactionManager객체를 
	<beans:bean name="dao" class="com.javalec.spring_pjt_ex.dao.TicketDao" >
		<beans:property name="template" ref="template" />
		<beans:property name="transactionManager" ref="transactionManager" />
	</beans:bean>
	
--4. public void buyTicket(final TicketDto dto)  
    //추가코드
	TransactionDefinition definition = new DefaultTransactionDefinition();
	TransactionStatus status = transactionManager.getTransaction(definition);
		
	try{
		 실행함수(insert)
		 실행함수2(insert)
		 
		 //정상처리
		 transactionManager.commit(status);
	
	}catch(Exception e)
	{
	     //비정상 처리
	     transactionManager.rollback(status);
	}
   --단점 : 개발자의 실수 commit , rollback 처리를 하지 않을 경우 문제
	
	
	