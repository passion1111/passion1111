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

ALTER TABLE ticket 
ADD CONSTRAINT ck_ticket_countnum check(countnum < 5);


--카드결제와 티켓구매는 하나의 논리적단위로
--두개의 처리가 (commit or rollback)





