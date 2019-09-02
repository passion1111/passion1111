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
	
	
---------------------------------------------
SpringMVC_Basic_08_3 TEST 하기
--jdbcTemplate 활용한 것처럼 
--Transaction  처리 관련 Template 제공
--TransactionTemplate 클래스 사용하기

1. 객체 생성
    <beans:bean name="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
		<beans:property name="transactionManager" ref="transactionManager"></beans:property>
	</beans:bean>
	
	<beans:bean name="dao" class="com.javalec.spring_pjt_ex.dao.TicketDao" >
		<beans:property name="template" ref="template" />
		<!-- transactionManager 에서  transactionTemplate  주입 전환 -->
		<beans:property name="transactionTemplate" ref="transactionTemplate" />
	</beans:bean>
	
2.  TicketDao.java 에 추가
    TransactionTemplate transactionTemplate;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
3.   아래를 사용하는 함수 모양이 :  public void....
    //CASE : public void buyTicket(final TicketDto dto){}

    //1. TransactionCallbackWithoutResult 결과값이 없는 경우
    //final TicketDto dto 상수값 설정 (변경 없다는 보장)	
	
	transactionTemplate.execute(new TransactionCallbackWithoutResult() 
	{
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) 
			{
				실행함수1(insert);
				실행함수2(insert);
			}
	}	
	
4. 
   아래를 사용하는 함수 모양이 : public String .....
   //CASE : public String buyTicket(final TicketDto dto){}
   //2.TransactionCallback<String> 트랜잭션 처리 후 결과값이 있다면
  
  transactionTemplate.execute(new TransactionCallback<String>() {
   @Override
   public String doInTransaction(TransactionStatus arg0) {
 			     실행함수1(insert);
				 실행함수2(insert);
    return "return value";
   }
  })
	
//개발자가  commit or rollback 처리를 명시적으로 하지 않아도 되요
=============================
*SpringMVC_Basic_08_4_Annotation 처리하기

1. xml 추가 코드
   xmlns:tx="http://www.springframework.org/schema/tx"
   http://www.springframework.org/schema/tx
   http://www.springframework.org/schema/tx/spring-tx-3.0.xsd>

2. 
   <!-- 트랜잭션 처리 한방에 해결하기   @Transactional 에 트랜잭션을 적용해라 -->
   <tx:annotation-driven transaction-manager="transactionManager" />
   <beans:bean name="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<beans:property name="dataSource" ref="dataSource" />
   </beans:bean>

3. 
   import org.springframework.transaction.annotation.Transactional;
   @Transactional
   public void buyTicket(TicketDto dto) {}
   
4. WHY :   @Transactional 내부적으로 AOP (Proxy) 를 사용하기 위해서
   /SpringMVC_Basic_08_4_Annotation/WebContent/WEB-INF/lib/aopalliance-1.0.jar  
   

5. try{}catch(Execption e) { }   
   예외를 처리하면  @Transactional 적용안되요
   
   해결
   public void buyTicket(TicketDto dto) throws SQLException
   함수를 실행한 Controller 있는 함수안에서
   
   try {
			dao.buyTicket(ticketDto);
	   } catch (Exception e) {
			System.out.println(e.getMessage());
	   }
   
   