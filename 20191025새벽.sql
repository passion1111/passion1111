---- ���� 20191024  ���� 
---- �ƿ� ó�� ��� �ִ� �е��� drop �����ϰ� �ϸ�˴ϴ�!
drop table book_category;
drop table book;
drop table appendix;
drop table rental;
drop table new_book;
drop table discard_book;
drop table reservation;
select * from tbl_account_data;
CREATE TABLE tbl_account_data(
  ta_idx number NOT NULL,
  ta_id varchar(60) ,
  ta_pw varchar(300),
  ta_create_date timestamp ,
  ta_secret_key varchar(300) 

);
/
commit;
create table book_category ( --�����з�
    book_ctgr_num_db varchar2(100) , --�з���ȣ
    book_ctgr_name varchar2(200)  --�з���
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);
insert into book_category  values('000', '�ѷ�');
insert into book_category  values('100', 'ö��');
insert into book_category  values('200', '����');
insert into book_category  values('300', '��ȸ��');
insert into book_category  values('400', '���');
insert into book_category  values('500', '�ڿ�����');
insert into book_category  values('600', '�������');
insert into book_category  values('700', '����');
insert into book_category  values('800', '����');
insert into book_category  values('900', '����');

create table book ( --����
    book_num number, --������ȣ
    book_author varchar2(150), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --�ηϿ���
    book_ctgr_num varchar2(100), --�з���ȣ
    book_rsrv_status varchar2(50), --���࿩��
    book_rent_cnt number, --���� Ƚ��
    book_input_date date, --�Է���
    book_ctgr_num_db varchar2(100) --���� �з��� ���� �з���ȣ ��
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);

insert into book values((select nvl(max(book_num)+1,100001) from book),'�̹� �ϸ�ġ ���� ; ������ �ű�','�ؽ�Ʈ�� ������','���̺극��',to_date('2016','YYYY'),'9788932318042 ','X',1,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��','UFO�� ��������','���̺극��',to_date('2017','YYYY'),'9788968560323 ','X',1.442,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̹��� ��','�������','���̺극��',to_date('2017','YYYY'),'9791187892502 ','X',3.3,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�Ѽ��� �� ; �ڼ��� �׸�','��̸� ���� ������ ���� ��� ����','���̺극��',to_date('2017','YYYY'),'9791170261735 ','X',4.03,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ������ �� ; ����� ��','���ۿ��� ���� ������ = Learning from Google deep learning','���̺극��',to_date('2017','YYYY'),'9788931456639 ','X',4.73,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ӹ���, ������, ��ȣ�� [��] ����','(��ĳ��Ʈ) ���� ���α׷��Ӵ�  : �˸��̸� ��� ��ۺ��� �� �е� ���� �� �����ϰ�. 2ź','���̺극��',to_date('2016','YYYY'),'9788968482908 ','X',5.04,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �׷罺 ���� ; ������ ; ���Ѱ� ; �ϼ��� [��]�ű�','(�عٴں��� �����ϴ�) ������ ���� : ������ �м��� ���� ���̽� ���α׷��ְ� ���С���� ����','���̺극��',to_date('2016','YYYY'),'9788966261819 ','X',5.7,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��ð��� ���� ; ������ ��??','(������ ������ ����)��Ȱ ���� ù����','���̺극��',to_date('2017','YYYY'),'9788968482861 ','X',5.8,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','ǥ����  : ǥ������ �����ο� ������ �۾���','���̺극��',to_date('2015','YYYY'),'9788932317328 ','X',11.2,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̻�� ����','���� å����� �����Դϴ�  : bookart��bookbinding','���̺극��',to_date('2017','YYYY'),'9788964391310 ','X',12.4,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̳������ �� ���� ; �ֹ��� �ű�','�̷��� å���� ��� �ֽ��ϴ�','���̺극��',to_date('2018','YYYY'),'9791186639689 ','X',13.04,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ���� ; ���հ��� �Ϲݴ��п� �ѹ����������������� �ű�','������� ������ ù����','���̺극��',to_date('2016','YYYY'),'9791155501757 ','X',15.12,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'2017 ��⵵ �缭����� ����','�缭���� å�̾߱�(2017)','���̺극��',to_date('2017','YYYY'),'9788993395662 ','X',18.3,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ѱ�����������ȸ ��������ȸ ������ ����','(�ֽ�) ������������ ����','���̺극��',to_date('2013','YYYY'),'9788976781659 ','X',20.1,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ڿ���, ȫ��ö ����','������ �濵��','���̺극��',to_date('2014','YYYY'),'9788993419474 ','X',23,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ����, C. ����Ŭ Ȧ, �ɺ� ĳ�� [��]���� ; ��???�� �ű�','(Now) �����¡ �������̼� : ��ȭ�� ���� ������ �˻��� ��� ��','���̺극��',to_date('2017','YYYY'),'9788958204626 ','X',25.25,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�뿵�� ����','������ ������ �������� ����  = Understanding the next generation digital library','���̺극��',to_date('2016','YYYY'),'9788959725328 ','X',26.9,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ϳ� ���ں�ġ ����  ; �躴ȭ �ű�','ȥ�� å �д� �ð� : �������ε� ���ι��� ���� ��','���̺극��',to_date('2012','YYYY'),'9788901142616 ','X',29.85,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ӿ쿵 �� ; ������ �׸�','��Ű�� ���� ����. 2-2, �ڵ� ����� ���״�ҵ�','���̺극��',to_date('2017','YYYY'),'9788926384251 ','X',30,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'Jon Richards ; Ed Simkins','Space','���̺극��',to_date('2013','YYYY'),'9780750278454 ','X',31,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ����  ; �ڿ��� �ű�','ȣ���̸� ������ ����������  : ������ ��Ÿ���� �Ѿ� ������ ���ϴ�','���̺극��',to_date('2015','YYYY'),'9788967351816 ','X',42,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'���缮 ��','(�̸� �� ��) �����μӹڹ���','���̺극��',to_date('2012','YYYY'),'9788970943671 ','X',69,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̺��� ����','(�ڹ����� ��ȭ�����濵 �Թ��ڸ� ����) �ڹ��� �濵�� ������','���̺극��',to_date('2014','YYYY'),'9788934969761 ','X',69.068,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ڼ��� ����','�Ƿ°� ��� : �ⷹ�� ���θ����� �ô�','���̺극��',to_date('2017','YYYY'),'9788936486174 ','X',70.4,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','������ �������� ����  : ����/��ġ/���θ���','���̺극��',to_date('2016','YYYY'),'9791187254034 ','X',72.6,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ; ������ �׸�','�޺����� ����Ʈ ������ : ������ ����ȭ','���̺극��',to_date('2017','YYYY'),'9788936442880 ','X',80,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ī���� ��ù�ġ ����  ; ������ �ű�','ö���� ������  : ����� ������ ��¥ ö��','���̺극��',to_date('2014','YYYY'),'9788920012921 ','X',100,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ; ������ �ű�','���, ö���Ѵ� : ������ ö���ڵ��� ������ ���� �̾߱�','���̺극��',to_date('2017','YYYY'),'9788959406517 ','X',109.9,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���̾߼� ���� ; ���¿� �ű�','���̻��а� ���� �� �Ҽ�','���̺극��',to_date('2017','YYYY'),'9788961473026 ','X',110,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��Ʈ�� ��Ʈ���Ͽ콺 ����  ; ������  ; �̼� [��] �ű�','ź�� ö��  : ������ ö���� �Ѿ','���̺극��',to_date('2017','YYYY'),'9788961472647 ','X',112,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ҽ� J. �ҽ� ���� ; �ڻ��� �ű�','���� ��ü�ϱ�','���̺극��',to_date('2017','YYYY'),'9788946063235 ','X',121.6,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Atul Gawande','Being mortal : medicine and what matters in the end','���̺극��',to_date('2014','YYYY'),'9781250081247 ','X',126.5,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ; ������ ��:','(���)�����������. [3], ���� : ݾ ���������','���̺극��',to_date('2017','YYYY'),'9788960716650 ','X',144.3,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','�� ���� �����ΰ�','���̺극��',to_date('2008','YYYY'),'9788954606684 ','X',151.5,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ȸ�� ���� ; ������ �ű�','���ڿ� ����','���̺극��',to_date('2017','YYYY'),'9788960515895 ','X',152.216,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ?���� �� ����  ; ������ �ű�','������μ��� 3��11','���̺극��',to_date('2012','YYYY'),'9788976823748 ','X',153.5,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ι�Ʈ ���� ����  ; ���ѿ� �ű�','������ ��ġ �ִ� ���ΰ�  : ��ũ���׽��� ������ ����','���̺극��',to_date('2014','YYYY'),'9788934968559 ','X',162.5,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ��������Ű ���� ; ������, ������ [��]�ű�','��ü : ���� ����� ����','���̺극��',to_date('2017','YYYY'),'9791188260201 ','X',165.77099,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���¿� ����','û�ʹ�� �ǹ� �̸��� �ƴϴ�  : ��ȣ������ ���� �б�','���̺�???��',to_date('2017','YYYY'),'9791159252488 ','X',174,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̹� ���� ����  ; �輺�� �ű�','�Ҹ��� ���̴� �����  : �������� Ǯ� �������� ���','���̺극��',to_date('2015','YYYY'),'9788965961734 ','X',181.29,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ȳ� ����','ȥ�� �ְ� ���� ����  : �� �� �� ��ó�� ���ܵ� ���ɿ� ���� �ɸ���','���̺극��',to_date('2016','YYYY'),'9788952782458 ','X',182.232,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̾� ��Ʃ��Ʈ-�ع��� ���� ; �̵���, ������, ������ [��] �ű�','��ȭ�� �ɸ���','���̺극��',to_date('2017','YYYY'),'9788952118875 ','X',183.7,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ũ-�˷� �з� ����  ; ������, �̼��� [��] �ű�','��ũ ��Ĳ ���̳�. 11, ���źм��� �� ���� �ٺ�����','���̺극��',to_date('2008','YYYY'),'9788955591828 ','X',188.5,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Mo Gawdat','Solve for happy NY','���̺극��',to_date('','YYYY'),'9781501154638 ','X',191.6,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�޸� C. ��ƿ�� ���� ; ������, ������ [��] �ű�','����, ��簡 �δ��� ���� �����߽��ϱ�?','���̺극��',to_date('2016','YYYY'),'9791186269435 ','X',195,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ; ��μ� �׸�','365 ���� �д� å ���� �� ��','���̺극��',to_date('2017','YYYY'),'9788914019806 ','X',199.8,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ô��� �佽�� ���� ; ������ �ű�','������ ö�� : ��� ������ ����ħ�� �ٽ�','���̺극��',to_date('2014','YYYY'),'9788934968627 ','X',201,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���翵 ����','�����ɸ����� ���� : �����ν��� ���Ǹ� �߽�����','���̺극��',to_date('2017','YYYY'),'9788930317573 ','X',201.8,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��] ��','������ �ô�, �ں� �����Ѵ�  : �ں� ���� ������ ����','���̺극��',to_date('2016','YYYY'),'9788941916093 ','X',202,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̺�� �н� ����  ; ���� �ű�','���ֿ��� ���� ����','���̺극��',to_date('2010','YYYY'),'9788961670517 ','X',204.21,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�޸� ���۷��� ����  ; ����� �ű�','�ڿ� ��¡  : ���ַ� Ž��','���̺극��',to_date('2014','YYYY'),'9788961471947 ','X',204.3,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̸� ȣ�� ���� ; �մ�ȣ �ű�','(��Ƶ��� ����)���� �ķ�','���̺극��',to_date('2009','YYYY'),'9788984750111 ','X',208,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���������̾� ����  ; ���� �ű�','������ �д´� ���� 5�� ���� ���絵��','���̺극��',to_date('2016','YYYY'),'9788994597690 ','X',209,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ѱ��������翬���� ������ ����','�ѱ����� ����  : 1984-2014 ��������� �����ϰ� ���� �ѱ� ������ ���� Ž����','���̺극��',to_date('2015','YYYY'),'9788993516111 ','X',209.11,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̿��� ��.�׸�','���� ���� �ΰ� ����. 1, ������ ������','���̺극��',to_date('2002','YYYY'),'9788900118667 ','X',219,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��] ����','�ƽþƽ�ȭ����  : ��ȭ, ������ �̾߱⸦ â���ϴ�','���̺극��',to_date('2016','YYYY'),'9788939207554 ','X',219.1,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�۾� ��  ; ������ �׸�','���»��ڰ� �� ��������','���̺극��',to_date('2008','YYYY'),'9788970945460 ','X',219.11,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�輺ö ����','(���ƽþ� ��ºұ� ������) �¶�  : �� ���ֿ� ����� �м��� Ž��','���̺극��',to_date('2011','YYYY'),'9788942363087 ','X',220.99,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ұ�������������ȸ ����','�ұ����� ù ����  : �ұ��� ����, ����, ��ȭ�� �ƿ츥 �ʽ��ڸ� ���� �ұ� �Թ���','���̺극��',to_date('2015','YYYY'),'9788974790967 ','X',221,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ����','����, �ɰ� ����','���̺극��',to_date('2013','YYYY'),'9788998946036 ','X',223.7,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ��  ; ����, �ұ��Ź��� [��] ����','������ ���  : 2,600���� ����� ��ȭ �׸��� ���� ���ؿ� �Ǽ��� ���� ���Ե��� ����� �ϻ� �̾߱�','???�̺극��',to_date('2016','YYYY'),'9791155800751 ','X',226.4,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�۱��� ����','�⵶�����̶�� �ݵ�� �о�� �� å 100','���̺극��',to_date('2016','YYYY'),'9791186404690 ','X',230.26,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ȼ��� �׷� ����  ; �ֿ�ȣ �ű�','����� ���� õ��  : �� �������� �ϴ����� �츮���� ���� �ֽô� ����!','���̺극��',to_date('2015','YYYY'),'9788932113913 ','X',231.22,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̽� �� ��  ; ���� ������ �׸�  ; ����� �ű�','(�츮 ģ�� ��������) ��Ȱ�ϼ̾��!','���̺극��',to_date('2016','YYYY'),'9788932114378 ','X',232,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��μ� ����','������ �������� ǳ��  : ��� �̽��� ��ȸ����','���̺극��',to_date('2017','YYYY'),'9788936503451 ','X',233.109,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ���ϴ� �� ����  ; ������, ������ [��] �ű�','(�� ���� �������� �ε��ϴ�) ������ �������','���̺극��',to_date('2015','YYYY'),'9788977823358 ','X',235.36,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ����Ʈ ����  ; ������ �ű�','�̰��� �����̴�','���̺극��',to_date('2017','YYYY'),'9788932814735 ','X',235.4,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ����ó�� ����  ; �ѹ��� �ű�.�ؼ�','��ȸ  : �� ��ȸ�� ���� �ϴ°�? ��ȸ�� ������ ���� �����ϴ°�?','���̺극��',to_date('2017','YYYY'),'9788928638000 ','X',236,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� [����]','�ϳ����� ����ô� ġ���� �ð�  : ���󿡼� �帮�� �⵵��','���̺극��',to_date('2017','YYYY'),'9788904165933 ','X',237.2,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ũ ä���� ���� ; ��ö�� �ű�','����ȸ ���� : ����ȸ ������ ������ ����','���̺극��',to_date('2017','YYYY'),'9788928638291 ','X',238.31,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ܽ��� ����  ; �ȵ���, �������� [��] ��ħ','������ȭ 15��  : ����� �ñ��� �ϴ� ������ ���� ��� ��','���̺극��',to_date('2012','YYYY'),'9788994963570 ','X',240,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ī�� ����Ÿ�� ��, ���ϸ�Ʈ ���︧ [��] ����  ; ������ �ű�','Ȳ�ݲ��� ���','���̺극��',to_date('2014','YYYY'),'9788954624022 ','X',244,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ǥ���� ����','ǥ������ ���� �̾߱�','���̺극��',to_date('2014','YYYY'),'9788997472826 ','X',250,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ڼ��� �� ; ������ �׸�','�ð����� ��Ƴ����','���̺극��',to_date('2010','YYYY'),'9788993242287 ','X',251,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���� ������ � �̾߱� . 1','���̺극��',to_date('2017','YYYY'),'9791185134406 ','X',259,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���͹� �ٽ�ī�󳭴� ����  ; ������ �ű�','�������� �����ϱ�','��??�극��',to_date('2016','YYYY'),'9788926874622 ','X',270,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�Ǻ��� ����','�ٶ��� ������ ���ϴ°�? : ������, �ι����� �˾ƺ��� �ٶ�','���̺극��',to_date('2017','YYYY'),'9791159877230 ','X',283,'���డ��',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ε�� ������ ����','���ɼ��� �߽�  = Interview with Kojin Karatani  : ����Ÿ�� ���� ���ͺ�','���̺극��',to_date('2015','YYYY'),'9788958202981 ','X',301,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'G.D.H. �� ���� ; ȫ��� �ű�','�ι�Ʈ ���� : ��������, ������ ����ü�� �Ǽ��� ��ȸ���Ű�','���̺극��',to_date('2017','YYYY'),'9791195567812 ','X',301.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����Ͽ� �׶��� ����  ; �̻��� �ű�.','�׶����� ���߼���. 1 :, ��ġ��','���̺극��',to_date('1999','YYYY'),'9788934001553 ','X',301.52,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�鿵�� ����','(�ٽ����忡��) ���ƽþƸ� �ٽ� ����  : ������ȸ�� ���� ��õ����','���̺극��',to_date('2013','YYYY'),'9788936482688 ','X',309.11,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�丶 ����Ƽ ����  ; ����, ��������[��] �ű�','21���� �ں�','���̺극��',to_date('2014','YYYY'),'9788967351274 ','X',321.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��� ����, ������ �� [��]���� ; ���ΰ� �ű�','(�뿹������ �ݴ��� ������)������ ���ϴ�','��???�극��',to_date('2016','YYYY'),'9791195718702 ','X',321.542,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���񽺸�����','���̺극��',to_date('2013','YYYY'),'9788958533641 ','X',323.16,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̷�ǳ ����','�ֽ�ȸ������','���̺극��',to_date('2016','YYYY'),'9788956614083 ','X',324.47,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','�ҹ����� �δ��̵� �繫����','���̺극��',to_date('2018','YYYY'),'9791186456637 ','X',325.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','����Ʈ���丮 = Smart factory : ��4�� ��������� �����','���̺극��',to_date('2017','YYYY'),'9788946070202 ','X',325.6,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ȸ������� ����','��ȸ �������� ����ִ� �������� �̾߱� : ��ȸ�� �������� Ű��� �ùα�����','���̺극��',to_date('2017','YYYY'),'9788952235763 ','X',326,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ȼ��� ����','���ε� Ʈ������ ��� ������ ���ΰ�  : �ٰ����� ���� ���� Ÿ�� ���󰡿� ����ϴ� ����Ͻ� ���� ����','���̺극��',to_date('2017','YYYY'),'9788947541695 ','X',326.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ֿ��� ����','�鼼�� �̾߱�  : ����, ����, �ѷ��� ������','���̺극��',to_date('2013','YYYY'),'9788959892389 ','X',326.39,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���˺� ����  ; ������ �ű�','ȭ������  = Currency wars. 1, ȭ������','���̺극��',to_date('2008','YYYY'),'9788925521190 ','X',327.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��Ǵ� ��Ÿ�ι��� ���� ; ������ �ű�','���ڵ鿡��, ������ ���̴�','���̺극��',to_date('2017','YYYY'),'9791195445653 ','X',327.8,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �׷�� ���� ; ��ȫ�� [��]����','�����а� ������å','���̺극��',to_date('2017','YYYY'),'9788968669613 ','X',329.01,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ����','��, ���ο� �߰�  : ���� � ������ ������ ����?','���̺극��',to_date('2017','YYYY'),'9788958204701 ','X',330,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̵��� ����','(�η��� ���⿡ ����) ��ȿ�� ����ũ���� ��ȭ','���̺극��',to_date('2015','YYYY'),'9788954431972 ','X',330.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ä�� ����','�ù��� ��ȭ���� = Civic Republicanism: : �ùδ���ȸ�� ��ȭ�� �ϱ�','���̺극��',to_date('2017','YYYY'),'9788946063426 ','X',331.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��] ����','������ �ι���  : ���ø� �д� 12���� �ü�','���̺극��',to_date('2016','YYYY'),'9788936472818 ','X',331.47,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Jean Clandinin �� ; ������ [��] ����','����Ƽ�� Ž���� ���ؿ� ��õ','���̺극��',to_date('2014','YYYY'),'9788925408972 ','X',331.9,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ϴ� ��  ; �ڿ��� �׸�','(���󿡼� ���� ���� ��,) �ڿ�����','��??�극��',to_date('2011','YYYY'),'9788964960493 ','X',334.14,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����Ÿ ��ī�븮 ���� ; ȫ���� �ű�','���γ���','���̺극��',to_date('2017','YYYY'),'9788935211869 ','X',334.6,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Roxane Gay','Bad Feminist','���̺극��',to_date('2014','YYYY'),'9780062282712 ','X',337.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Ryan Holiday','Summary of the obstacle is the way','���̺극��',to_date('2017','YYYY'),'9781545060612 ','X',338.3,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','������ ������ ��� : ��ƾ�Ƹ޸�ī ��ġ��ȸ�� ���忡�� ĳ�� 10���� �׸�','���̺극��',to_date('2017','YYYY'),'9788957694282 ','X',340.95,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ӵ���, ������ [��] ����','��Ʈ�������� ������ ź��  : ������ ���� ���� �Ƿ�, �ں�, ����, �׸��� �����','���̺극��',to_date('2015','YYYY'),'9788983717252 ','X',340.98,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��� ��ũȦ�� ���� ; �ڼ��� �ű�','�ٽ�, ������ �����ϴ�','���̺극��',to_date('2017','YYYY'),'9788950963576 ','X',341,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ʼ� ��ũ�� ���� ; ������ �ű�','�������ǿ� ���� ����','���̺극��',to_date('2017','YYYY'),'9788993166781 ','X',342.3,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ġ�� ��Ѹ� ����  ; ������ �ű�','������ �̾ƾ� �ϴ°�?  : ���ְ�ȭ���� ���� ��Ű�ƺ���?? ��ǥ ����','���̺극��',to_date('2017','YYYY'),'9791195824960 ','X',344.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'[���޸�] ������ ����','�ʸ������� = Filibuster  : ���������� ������','���̺극��',to_date('2016','YYYY'),'9791159031243 ','X',345.08,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������, �̼ҿ� [��] ����','���� ���� �ּ����� ��ġ ���','���̺극��',to_date('2014','YYYY'),'9788952770851 ','X',345.11,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ȫ�� ����','���������� ��ġ��  : �ѱ�, ������, �̱� ������ü�� ��ġ�� Ȱ���� �ֱ� ��ȭ','���̺극��',to_date('2015','YYYY'),'9788974183431 ','X',346.8,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ���ϸ���, ��Ƽ�� ���̽�, ��Ʈ���� ���� [��] ����  ; �Ͽ��� ...[��] �ű�','������ġ��','���̺극��',to_date('2015','YYYY'),'9788932472898 ','X',349,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ D. �轺 ����  ; ������ �ű�','(�� F. �ɳ׵���) ������ ����','���̺극��',to_date('2014','YYYY'),'9788950952938 ','X',349.09,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','��ȯ�ô��� ��  : ������ �����','���̺극��',to_date('1990','YYYY'),'9788936410049 ','X',349.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ֿ��� ����','������å��  : ��� ����� �����Ǵ°�?','���̺극��',to_date('2013','YYYY'),'9788934965695 ','X',349.11,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�񿵸� ����','�ŷ��� �߰�  : 30�� ������������ ������ 68���� ���','���̺극��',to_date('2016','YYYY'),'9788925558134 ','X',351.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�����  ��','������ʫ��?�����������ϼ','���̺극��',to_date('2017','YYYY'),'9787520303545 ','X',360.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ο� �Բ� �쳿','������ �̷�  : �л��� ������ �Բ� ���� ���� ��ġ ������ ��  : �츮�� ��� ������ �̷��� �� �� ������','���̺극��',to_date('2016','YYYY'),'9788935663002 ','X',370.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ���, �� �Ӱմ޷�, ���� ���� [��] ����  ; �ּ���, �����, �躴�� [��] �ű�','������Ʈ ���� ��� �� ���ΰ�?  : ö�п��� ��õ����, ������� ���� PBL�� ��� ��!','���̺극��',to_date('2017','YYYY'),'9788994655543 ','X',373.25,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�赿�� ��  ; ������, ������ [��] �׸�','������ �ܲ� ��Ų ��ȸ ������, ���� ��','���̺극��',to_date('2010','YYYY'),'9788927800620 ','X',375.43,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','4�� ����  : ���￩��, �� ���� ������ ���','���̺극��',to_date('2011','YYYY'),'9788952216380 ','X',376.7,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��]����','(���񱳻縦 ����)Ư�������� = Introduction to special education for preservice teachers','���̺극��',to_date('2014','YYYY'),'9788925408774 ','X',379,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������� ���ɿ� ���� ; ������ �ű�','��ɲ��� ���� ���� �ʴ´�','���̺극��',to_date('2017','YYYY'),'9788967260248 ','X',381.7,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��  ; ���淡 �׸�','(���� ����� ���� ����ִ�) �츮 �� �̾߱�','���̺극��',to_date('2015','YYYY'),'9788967493806 ','X',388,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�߸����� ��ġ���� ���� ; �ֿ�� �ű�','��� �ϱ��屳�� �ٶ� �Ϻ������� ����','���̺극��',to_date('2016','YYYY'),'9788967353544 ','X',390.913,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Shin Takahashi �� ; Iroha Inoue �׸� ; �輺�� �ű�','(��ȭ�� ���� ����)�������','���̺극��',to_date('2009','YYYY'),'9788931579819 ','X',412.85,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','������ ���б��� : ������ ���� ���ڿ���','���̺극��',to_date('2017','YYYY'),'9791195369959 ','X',427.62,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ���� ; �ѱ��������� ����ȫ����������ȸ �ű�','�� �ʸ� : �༺ õ������ ���̵� �ظ�','���̺극��',to_date('2016','YYYY'),'9788956057811 ','X',440.99,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ������ ���� ; Ű�� �׸� ; �ڴ��� �ű�','�ȵ��ȵ� ������ 24�ð�','����??����',to_date('2017','YYYY'),'9788943310912 ','X',448.75,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Charlotte Guillain, illustrated by Yuval Zommer','(The)Street beneath my feet','���̺극��',to_date('2017','YYYY'),'9781682971369 ','X',455,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̿��, �ѻ�ȣ [��] ��  ; �ø��� ��Ʃ���, �帲��ġ CC [��] �׸�','(��̵�ȭ) ������  : �ѹݵ��� ����','���̺극��',to_date('2012','YYYY'),'9788901140629 ','X',457,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ��Į����, ���� ���е� [��]���� ; ������ �ű�','����, ��迡 ���� : ���ڻ������� �ô밡 �ٰ��´�','���̺극��',to_date('2017','YYYY'),'9788967354589 ','X',472.19,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ó�� ��Ų�� �� ����  ; �� ��ϸ� ����  ; ������ �ű�','�ñ��� ����  : ������ ���� 21���� ���ϴ� ������ ����� ��ȭ, �׸��� ��÷�� �������','���̺극��',to_date('2017','YYYY'),'9788937889257 ','X',473,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ���� ; ��ȫǥ �ű�','��ȭ�ϴ� ��','���̺극��',to_date('2017','YYYY'),'9791128820045 ','X',474,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������򿬱��� ����  ; �̸�� �׸�','DMZ ������','���̺극��',to_date('2011','YYYY'),'9788991871878 ','X',477,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ; �̿��� �Ϸ���Ʈ','���հ� ������ ����� ??����','���̺극��',to_date('2016','YYYY'),'9788958075790 ','X',493,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��õ�� [��] ����','������ ����  : ���۲������濡�� ���� ������ �ι���','���̺극��',to_date('2017','YYYY'),'9788955619072 ','X',493.73,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����  ; ���ѿ� ��  ; ������ �׸�','(�������� ������) �̷�����  : �̷��ڵ��� Ư�޷��̽�','���̺극��',to_date('2010','YYYY'),'9788934936909 ','X',500,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Dorling Kindersley ��  ; UJ ����','������ �ٲٴ� �ְ��� ���� ���','���̺극��',to_date('2017','YYYY'),'9788930270687 ','X',504,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ������ ����  ; ����� �ű�','(30���� �߸�ǰ���� �д�) �����  : ��, ����, �ð迡�� �ö�ƽ, �ݵ�ü, ��ǻ�Ϳ� �̸������','���̺극��',to_date('2017','YYYY'),'9788984458512 ','X',507,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���������� ������-���ַ� ��  ; ���ڸ� �� �׸�  ; ��ȿ�� �ű�','�ֻ�� �� ������','���̺극��',to_date('2006','YYYY'),'9788909122726 ','X',508,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'� ��Ʈ�ν�Ű ����  ; ����ȣ �ű�','��ũ�� �� �� ������ �ް� �Ǿ���','���̺극��',to_date('2014','YYYY'),'9788934966500 ','X',509,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�׵� �˷�, �õ�� ��� [��] ����  ; õ��� �ű�','���� ��� ����','���̺극��',to_date('2001','YYYY'),'9788939204140 ','X',510.99,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Jennie Maizels, William Petty','My pop-up body book','���̺극��',to_date('2017','YYYY'),'9781406317923 ','X',511.1,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ϳ׽� �� �������� ����  ; ����� �ű�','�ŷ����� ���� ����  : ������ ����, ���忡 ���� ���� ���� ������Ʈ','���̺극��',to_date('2016','YYYY'),'9788937838743 ','X',511.116,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ����','(������ �����ǻ� ������) ������ �̾߱�','���̺극��',to_date('2017','YYYY'),'9791186692080 ','X',513.811,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���, �̼� ���� [��] ���� ; �ּ�ȯ, ������ [��] �ű�','�鿪�� ���','���̺극��',to_date('2017','YYYY'),'9791159430657 ','X',513.92,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�迵�� ����','��, �㸮 �ǰ��� ��� : ��, �㸮 �ǰ��� ���� �ʵ���','���̺극��',to_date('2017','YYYY'),'9788964897485 ','X',514.325,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ط��� M. ���۵� ����  ; ��ȫ�� �ű�','����� ���� 1.2�� �� �� �ִ�','���̺극��',to_date('2017','YYYY'),'9788973434930 ','X',515.73,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','(�ȶ�!) ���Ϳ� �Ʊ� �����  : �Ҿ�û�ҳ�� �ǻ� �ƺ��� �����ϱ�','���̺극��',to_date('2016','YYYY'),'9788997195862 ','X',516.9,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Alisa Vitti','Womancode','���̺극��',to_date('2014','YYYY'),'9780062130792 ','X',517.36,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ȣ ����','���� �Ǵ� �� �̾߱�','���̺극��',to_date('2014','YYYY'),'9788974836429 ','X',518,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ȣ ����','�ζٴ� ���� ���ٴ� ����  : ���ǻ簡 ���� �ɸ������� ġ���� ���ϴ�','���̺극��',to_date('2016','YYYY'),'9788965022596 ','X',519.38914,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���Ʊ� �� ; �輭�� �׸�','GMO','���̺극��',to_date('2017','YYYY'),'9791161720319 ','X',521,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'KBS����� <����, ���踦 �����ϴ�> ������ ����','(KBS �����) ����, ���踦 �����ϴ�  : ���ڴ� ���� �����ϴ°�','���̺극��',to_date('2014','YYYY'),'9788959402908 ','X',523.22,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ī�� �������� ���� ; ������ �ű�','��� : ���� ������ ġ���ϴ� ����� �Ĺ� 100����','���̺극��',to_date('2017','YYYY'),'9788998690274 ','X',525.48,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̿��� ����  ; ���� �׸�','������ ����ϸ� ö���ڰ� �ȴ�  : �������� �̺�����, �ݷ������� �Բ��Ѵٴ� ��','���̺극��',to_date('2017','YYYY'),'9788932029627 ','X',527.386,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �巺���� ���� ; ������ �ű� ; ���ν� ����','������ ??�� : �������� �̲��� �츮 ���� ��ȭ','���̺극��',to_date('2017','YYYY'),'9788934978954 ','X',530,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� �� ; �̰汹 �׸�','������ ������ �����Ϳ�','���̺극��',to_date('2015','YYYY'),'9788983947833 ','X',533.9,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �������� ����  ; ������ �ű�','���ع��� �ǹ� 100 : ��Ȱ����, �Ƿ�ǰ, ȭ��ǰ, ����깰, ����ǰ�� �󸶳� �����Ѱ�','���̺극��',to_date('2016','YYYY'),'9788964942703 ','X',539.979,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��] ����','�����ȹ�� = Rchitectural planing  design theory','���̺극��',to_date('2017','YYYY'),'9788970938332 ','X',540.1,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�϶�ġ ������Ű ��  ; ȫ���� ��','(���ʺ��� ����) ����ð�','���̺극��',to_date('2014','YYYY'),'9788962255911 ','X',542.8,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�赿�� ����','������ �ټ� �ñȰ� �� �ձ� : �������� �Ѿ��� ��� ����','���̺극��',to_date('2017','YYYY'),'9791195233489 ','X',549.1,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by David Macaulay, Neil Ardley','(The) Way things work now','���̺극��',to_date('2016','YYYY'),'9780544824386 ','X',550,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̺�� ���÷��� �ۡ��׸� ; �� �Ƶ鸮 �� ; �ڿ���, ��âȣ [��]�ű�','������ ����� ���� Now : �׸����� ���� ����ִ� ���� ����','���̺극��',to_date('2016','YYYY'),'9791195748013 ','X',551,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �ݵ��� ����  ; ��漷 �׸�','������ ���簡 �ñ��� : ���� �ڵ����� �����ϴ� �츮 ����','���̺극��',to_date('2017','YYYY'),'9788931381238 ','X',556.38,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ۺ��� , ������ , ������ [��]��','(2014) �װ��������� �� ����  = Aeronautical information manual','���̺극��',to_date('2014','YYYY'),'9788972870784 ','X',558.3,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ּ��� ����','PLC ���ʿ� ����  : �ʺ����� �ǹ�����','���̺극��',to_date('2015','YYYY'),'9788942914036 ','X',559.98,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�Ŵ뼷 ����','(�ʺ��ڰ� �����) AVR ����ũ�� ���μ��� �����ϱ�','���̺극��',to_date('2017','YYYY'),'9788931708936 ','X',559.99,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ��  ; ������ �','(�ʺ��ڸ� ����) ������� �Թ�','���̺극��',to_date('2017','YYYY'),'9788931525618 ','X',560,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� û  ; ���� �귢 [��] ����  ; ȫ���� �ű�','��������  : ����� ������ �Ǳ���� õ������ڵ��� �� ������ â���� ����','���̺극��',to_date('2015','YYYY'),'9788920930720 ','X',560.9,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �׾� ����  ; ������ �ű�','������ ���� �ٲٴ� ����','���̺극��',to_date('2016','YYYY'),'9791186000304 ','X',565,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Saito Masanori ���� ; �̿��� �ű�','(�׸� �� ������ ����)�ֽ� IT Ʈ����','���̺극��',to_date('2017','YYYY'),'9788956747354 ','X',567,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���籤 ����','������ ���','���̺극��',to_date('2016','YYYY'),'9791132100942 ','X',567.01,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ; ������ ; �̱�� ����','���ִ� ���Ŀ��� ������ �ִ� = Amazing Science in Delicious Foods','���̺극��',to_date('2017','YYYY'),'9788970938691 ','X',570,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���Ʊ� ����','���̿���Ŀ�� �´� = Bio hacker : ��������� ��ŷ�ϴ� ���η��� ���� ����','���̺극��',to_date('2015','YYYY'),'9788967352127 ','X',570.6,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��  ; ����� �׸�','(�ƺ��� �Բ��ϴ�) ����� ��̴�','���̺극��',to_date('2014','YYYY'),'9788984318342 ','X',584,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Ȳ��Ǫ, õ??[��] ����  ; ���� �ű�','�߱��� ��ܿ��� ĥõ ��  : ���� ������ �ڼ�ǰ ����  = China silk 7000 years : crystal of art science and technology','���̺극��',to_date('2016','YYYY'),'9788926871508 ','X',587.39,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���̰� ���� ; ������ ������ �׸� ; Ȳâ�� �ű�','����� ��� �¾���� : ���̵��� ������ �ٲٴ�','���̺극��',to_date('2017','YYYY'),'9788991550841 ','X',589,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������� ���ΰ� ����','�������� �츲�ϱ�  : �츲������� ���� �ִ� � ������ �츲 �̾߱�','���̺극��',to_date('2016','YYYY'),'9788925558561 ','X',591,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Emi ����  ; ������ �ű�','(Ourhome) ���� �������� ���� ����','���̺극��',to_date('2016','YYYY'),'9788959759743 ','X',591.1,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ȣ�� [��] ����','¡�۸��� ���ֿ� �� ���� �ϻ�  : ����, �� �ߵ� �� ���� �������� ���ǿ� ���Ͽ�','���̺극��',to_date('2017','YYYY'),'9788927808688 ','X',591.7,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������丮��ī���� ����','Dressmaking : ������ ���� ������ 10','���̺극��',to_date('2017','YYYY'),'9788996899853 ','X',592.2,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ���� ; �̻�� �ű�','���� �� ��Ÿ�� �� ������','���̺극��',to_date('2017','YYYY'),'9791196001827 ','X',593,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ŷ���� ���� ; �ż��� �ű�','�Ϻ��� Ŀ�� �� �� : ������ ����','���̺극��',to_date('2017','YYYY'),'9791156757061 ','X',594.3463,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���Ͽ� ����','���� ���� �ö������ũ','���̺극��',to_date('2017','YYYY'),'9791158461676 ','X',594.516,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������, �õ��� ��Ģ [��] ����','������ ���̴� ������ �׸��� ���� ����  : �����ϴ� ���̸� ����� ������ ������ ���','���̺극��',to_date('2015','YYYY'),'9788952773456 ','X',598.6,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ÿ��� Ű�� ����  ; ��ƿ� �ű�','(�� ���̿��� �������ִ�) ù ���� ����  : ���� ���̷� Ű���� ������ ����� �ڶ���','���̺극��',to_date('2011','YYYY'),'9788925544496 ','X',598.7,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ι�Ʈ S. �ڽ�, ������ ���� [��] ����  ; ������ �� �ű�','�� �о�� �� ���� ������ 31��  = Critical Terms for Art History','���̺극��',to_date('2015','YYYY'),'9788940805077 ','X',600.3,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��Ƽ�� ŷ ����  ; ������ �ű�','������ ����   : �� �츮�� ȣ�� ��ȭ�� �����ϴ°�','���̺극��',to_date('2010','YYYY'),'9788994210490 ','X',600.4,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̸��� ������Ű ���� ; ������ �ű�','����Ͽ� ����� = Antoni Gaudi : �����ذ� ���� õ�� ���డ','���̺극��',to_date('2017','YYYY'),'9791127405823 ','X',610.99,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���� ����  : ����ũ ������ ��� ����  = Eloge �� la lumi��re : la vie et lart du Fr. Marc','���̺극��',to_date('2016','YYYY'),'9791155220962 ','X',631.9,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ش� ī�� [��] ; ����ȯ �ű�','���ʼ� ���̺� : ������ ������ ��� ������ ���� �� �Ѹ��� õ��','���̺극��',to_date('2014','YYYY'),'9788937489020 ','X',639.5099,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������, ���߱� [��] ����','(������.���߱���) õõ�� �׸� �б�  : �Ҿ���� ������ ����� ���ο� �׸�����','���̺극��',to_date('2003','YYYY'),'9788901028224 ','X',650.4,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','�޲ٴ� �츮 ��ȭ','���̺극��',to_date('2005','YYYY'),'9788943305727 ','X',654,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ũ�������� ��ڼ� ����  ; ����ȣ �ű�','���� ����  : �츮�� �� ���ǿ� �������?','���̺극��',to_date('2015','YYYY'),'9788956054162 ','X',671.18,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','����� �鸮�� ����  : �ε� ������ ǳ���','���̺극��',to_date('2013','YYYY'),'9788957077702 ','X',673.5,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ������ ����  ; �躴ȭ �ű�','�ǳ��ǰ��� ����  : ���� ģ���� ������ ��ȭ','���̺극��',to_date('2013','YYYY'),'9788993818567 ','X',675.6,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ī �Ǽ�-������ ���� ; ������ �ű�','���༺�� ���� : ����???���� ������ ��ȯ�� ���ο� �����ս� ����','���̺극��',to_date('2017','YYYY'),'9788932029870 ','X',680.1,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','����� �ǰ�  = Dance  wellness','���̺극��',to_date('2016','YYYY'),'9791155165805 ','X',685.1,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�����','�� �ϳ��� ��� = Another Border Line : �дܽô��� ���ؾ� : ����� ������','���̺극��',to_date('2017','YYYY'),'9788974093914 ','X',688.4,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���纹 ; �̴޿�, ������ ��','������������ ����','���̺극��',to_date('2017','YYYY'),'9788956765891 ','X',692.07,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ����','(������ ���� ����) ������','���̺극��',to_date('2015','YYYY'),'9788956765303 ','X',695.5,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'[�����ۺ�]������ [��]','�츮������ ���빫��','���̺극��',to_date('2013','YYYY'),'9788969101440 ','X',698,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���뷹������ȸ ����','���� �ٴٳ���  : ���� �̷п��� ���� �Ǳ�ϼ�����','���̺극��',to_date('2016','YYYY'),'9788949304946 ','X',699.7,'���డ��',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ظ� G. ����ũ��Ʈ ����  ; ���� �ű�','���Ҹ��� ���Ͽ�','���̺극��',to_date('2016','YYYY'),'9791157830572 ','X',701.2,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̼��� �� ; ������ �׸�','��Ű�� ������� �򰥷�?!. 1, �Ҹ���','���̺극��',to_date('2015','YYYY'),'9788926398098 ','X',711.25,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���°� ��','����߱��� ����ü��� �ѱ��� ������ ���','���̺극��',to_date('2016','YYYY'),'9788960716377 ','X',721.1,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Otgontsetseg Damdinsuren ����','����� : ���� ����� �н� �����. 1','���̺극��',to_date('2017','YYYY'),'9791159011924 ','X',739.3,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Stanton H. Procter, Melanie Ann Procter [��] ��  ; ȫ���� �׸�','����100% �ʵ���','���̺극��',to_date('2008','YYYY'),'9788901079233 ','X',745,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','(������) �Ѽ�����  = Essence diccionario Coreano-Espa ol  : �ѱ���-�����ξ� ����','���̺극��',to_date('2014','YYYY'),'9788938707031 ','X',773.1,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ȯ ����','(��� �˸� ���̴�)�����ξ� �ܾ�','���̺극��',to_date('2018','YYYY'),'9788947542791 ','X',774,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�輱�� ����','�츮���� ��Ÿ �����ξ� ù����','���̺극��',to_date('2018','YYYY'),'9788997343270 ','X',775,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Isabel Lee ����','�������� �����ξ� Must Carry','���̺극��',to_date('2017','YYYY'),'9788960496415 ','X',777,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','������ǥ �����ξ� ȸȭ�ɷ���','���̺극��',to_date('2017','YYYY'),'9788997343232 ','X',777.5,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��','(The �ٸ�)����� ���������� = Portugues Brasileiro. Step 1','���̺극��',to_date('2017','YYYY'),'9788992281485 ','X',779,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ֺ��� ��','��! �ٴ� ��Ż���ƾ� ���� ù����','���̺극��',to_date('2016','YYYY'),'9788955187915 ','X',780,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Ȳ���� ����','(�ʺ��ڸ� ���� ����Ʈ) ��Ż���ƾ� �ܾ�','���̺극��',to_date('2017','YYYY'),'9788992683821 ','X',784,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��̾� ����.','ǥ�� ��Ż���ƾ� ����  = Grammatica Italiana  : ǰ���. 2','���̺극��',to_date('2017','YYYY'),'9788946063013 ','X',785,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Mr. Sun ���п����� ; �迵�� ; Margherita Besuschio [��]����','(�Ѵ��� ���δ�)��Ż���ƾ� ù���� : ȸȭ  ����','���̺극��',to_date('2017','YYYY'),'9788997221554 ','X',787,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���� ģ���� ���� ����å  : ���� �ž༺�� ��������','���̺극��',to_date('2017','YYYY'),'9788957993958 ','X',792.15,'���డ��',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ��轺 ����  ; ���μ� �ű�','���źм��� �̾߱� ����','���̺극��',to_date('2017','YYYY'),'9788932030043 ','X',801,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���丮�ڸ� ���Ͽ�Ģ : �Ź��� Ȱ���� ���丮�ڸ� â�۹�','���̺극��',to_date('2010','YYYY'),'9788920004032 ','X',802,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ֺ� ����','���Ҽ� �۰� �����̹� ���̵�','??�̺극��',to_date('2017','YYYY'),'9791186940266 ','X',802.02,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','�������� �۾���  = Travel writing  : ���׶� �����۰��� ��г�Ʈ','���̺극��',to_date('2016','YYYY'),'9788959130016 ','X',802.6,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ȥ�� �Ƹ����� �� ; ������ �ű�','�ҿ��� �̷������ �ű��� �ϱ�','���̺극��',to_date('2017','YYYY'),'9791186490709 ','X',803.8,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�念�� ����','��� ����� ���ΰ�  : �念�� ������ û����� ���� ���а� �λ� ����','���̺극��',to_date('2012','YYYY'),'9788959136803 ','X',804,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� Ŭ������, ��������, ���â �� ����','����ȭ ���� ��� �۾���  = (The) globalization world and the human community  : ��2011�� ��3ȸ ���ﱹ������������ ����','���̺극��',to_date('2011','YYYY'),'9788937484285 ','X',805,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ȯ [��]��','���б�����','���̺극��',to_date('2017','YYYY'),'9788974900236 ','X',807,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���� ����  ; ��ȭ�� �ű�','���� �ʸ�','���̺극��',to_date('2009','YYYY'),'9788963650180 ','X',808.2,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��Axt�� ������ ����','�̰��� ���� ������  : �Ҽ������� �Ҽ����� ���ͺ��ϴ�!','���̺극��',to_date('2017','YYYY'),'9788956601366 ','X',809.3,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���, �� ��° ���  : ������ �����','���̺극��',to_date('2017','YYYY'),'9788936463465 ','X',809.9,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����  ; ����� �ű�','�ٻ�ü�','���̺극��',to_date('2013','YYYY'),'9788936472320 ','X',811.35,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������: ����','�갳���� ��  : ���� ���ۡ��Ҽ���','���̺극��',to_date('2016','YYYY'),'9788930006330 ','X',813.62,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�輱�� ����','��� ���� �� ���İ� ����� ������  : ���� �輱�찡 ���κ����� ���� �ູ ����','���̺극��',to_date('2011','YYYY'),'9788935208814 ','X',816.6,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���������� ��  ; ����� �׸�  ; ������ �ű�','�� �Ѿ� ��','���̺극��',to_date('2017','YYYY'),'9788925560229 ','X',823.8,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����ġ�� ����  ; ������ �ű�','(����� ����ġ����)�Ҽ�(���)�д� ���','���̺극��',to_date('2011','YYYY'),'9788954616027 ','X',833.09,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ڼ��� ; �̼��� [��]���� ; �ڼ��� ; �ڻ�� [��]�׸�','�����¥�� = s? tich banh ch?ng banh giay','���̺극��',to_date('2017','YYYY'),'9791186908235 ','X',839.82,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Bill Bryson','(A) Walk in the Woods','���̺극��',to_date('2006','YYYY'),'9780307279460 ','X',844,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ĿƮ ���ϰ� ��??  ; ���� �ű�','�׷�, �� ���� ��� ����  : ������ �յ� �ʿ���','���̺극��',to_date('2017','YYYY'),'9788954644174 ','X',845,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ������ �� ���� ����  ; ������ �ű�','��Ż���� ����','���̺극��',to_date('2016','YYYY'),'9788949715209 ','X',856,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'īƮ�� ��Ÿ ����  ; �ڼ��� �ű�','���� ȥ�� �����ϴ� ����  : 7�� ���� 50������ Ȧ�� �����ϸ� ������ �͵�','���̺극��',to_date('2015','YYYY'),'9788901204772 ','X',858,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�츣�� �켼 ���� ; ������ �ű�','����ϴ� ����� �ູ�ϴ� : ����� ���Ͽ�','���̺극��',to_date('2017','YYYY'),'9791188047031 ','X',859,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������� ��� ���� ; ������ �ű�','������ �뷡','���̺극��',to_date('2016','YYYY'),'9788937475047 ','X',861,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ĺ�� �׷�� ����  ; ������ �ű�','����� �뷡','���̺극��',to_date('2016','YYYY'),'9788932028866 ','X',871,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ȣ��Ƽ�콺 ���� ; �賲�� �ű�','ī���� ��','���̺극��',to_date('2016','YYYY'),'9788937475016 ','X',892.2,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��� ���̾� ���� ; �ۼ��� �ű�','13�ð� : ��� ���̾� ����Ҽ�','���̺극��',to_date('2016','YYYY'),'9788950965754 ','X',893,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�߷����� ����??�� ����  ; ������ �ű�','���߷��� �����  : �߷����� ���̼��� ����Ҽ�','���̺극��',to_date('2017','YYYY'),'9788972758075 ','X',894,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ο� ����','������ ������ �ִ� : �������, �ð��� �Ѿ� �ο��� �߱��ϴ� �����','���̺극��',to_date('2017','YYYY'),'9788946420779 ','X',902.5,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������б� ���翬���� ��','���������  = Discovery of historical terms','���̺극��',to_date('2015','YYYY'),'9788952115119 ','X',903,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̱��� ����','�ﱹ���� �������','���̺극��',to_date('2017','YYYY'),'9788955083729 ','X',911.85,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','(��) �ι� �ﱹ��','���̺극��',to_date('2014','YYYY'),'9788967990411 ','X',912.033,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ���� ; ����ȯ, ��ö�� �� �ű�','������ ����, Ÿ�̺��̸� �ȴ�','���̺극��',to_date('2017','YYYY'),'9788965454458 ','X',912.4,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���¹� ����','�̰��������� ��������Ʈ 100','���̺극��',to_date('2017','YYYY'),'9788984354166 ','X',914.69,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ī���� ��ģ ����  ; �̱ٿ� �ű�','���޸�, Ȥ�� �ŵ��� ����','���̺극��',to_date('2009','YYYY'),'9788996244950 ','X',919.1,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�÷θ��� �ϸ��� ����  ; �Ѱ��� �ű�','1913�� ����??? ����','���̺극��',to_date('2013','YYYY'),'9788954622608 ','X',920.5,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Dan Jones','(The)Wars of the Roses : The Fall of the plantagenets and the rise of the Tudors','���̺극��',to_date('2015','YYYY'),'9780143127888 ','X',924.041,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ó� ����','������ ����  : ��ü, �켼, �ٱ׳�, �׸���','���̺극��',to_date('2015','YYYY'),'9791186000168 ','X',925.9,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�����Ϸ� ������Ű �� ; ���ö �ű�','����ũ�� ��ũ���̳��� ����','���̺극��',to_date('2017','YYYY'),'9788974828851 ','X',929.8,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','21���� �߾ӾƸ޸�ī�� �ܸ��  = Live from central America  : ������ ������ ����','���̺극��',to_date('2015','YYYY'),'9788946057685 ','X',944,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ȣ�� ����','��ſ� ���� : ������ �߸� ��ȭ�� ���� ��ƾ�Ƹ޸�ī�� ������ ����','���̺극��',to_date('2017','YYYY'),'9788937485084 ','X',950,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Kim MacQuarrie','(The) Last days of the Incas','���̺극��',to_date('2008','YYYY'),'9780743260503 ','X',955,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ϻ� ���� ����  ; ������ �ű�','(���踦 �д�) ȣ��','���̺극��',to_date('2014','YYYY'),'9791195201662 ','X',962,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�Ѿ���б� ���������������� ���þơ�����þ� ��������� ����','����þ������� ���ؼ� : ���ο� �ι������μ��� ����þ�','���̺극��',to_date('2016','YYYY'),'9788928509232 ','X',980.1,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ó�� �ν� ����  ; ����� ����','(���ϰ� �Բ���) �ú����� Ž�� ����  : ��氭, į��ī, ��ġ �ݵ� Ž�� ��� 1865, 1866, 1867','���̺극��',to_date('2016','YYYY'),'9791185614038 ','X',981.7,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���� ���� ; ���̽� ���츣��Ű �׸� ; ���� �ű�','ŰŰ�� ���迩��','���̺극��',to_date('2017','YYYY'),'9788991223707 ','X',982.6,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���丮 ����Ÿī ���� ; ������ �ű� ; ��ö�� ���� �� ����','�Ĺ��� ������ �����Ϻ��ΰ� �뿵 : ���丮 ������','���̺극��',to_date('2017','YYYY'),'9791187488460 ','X',991.3,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̹� ��꽺Ű �� ; ���ں� �Ƹ����� �׸� ; ���ȿ �ű�','�Ź� ����, ���� : ���̽� �θ��־�','���̺극��',to_date('2017','YYYY'),'9791160510676 ','X',992.6,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','(5��� ������) ���� �̾߱�','���̺극��',to_date('2002','YYYY'),'9788987787404 ','X',999.9,'���డ��',0,sysdate,900);

create table appendix ( --�η�
    apdx_code varchar(30),--�η��ڵ�
    apdx_book_num varchar2(30), --������ȣ
    apdx_name varchar(50) --�ηϸ�
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table rental (
    rent_num number, --�뿩��ȣ
    book_num number, --������ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rent_startdate date, --�뿩��
    rent_enddate date, --�ݳ���
    rent_appendix_status varchar2(10), --�ηϴ��⿩��
    rent_extension varchar2(10), --�뿩����
    rent_status varchar2(30)
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);

create table new_book ( --���� ���� ��û ���̺�
    new_book_num number, --�Ű� ��û ��ȣ
    new_book_num_sub number, --�Ű� ���� ��ȣ
    book_author varchar2(150), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_isbn varchar2(50), --isbn
    book_price number, --���� ����
    new_status varchar2(20), --��û ���� ����
    new_input_date date  --��û��
);

create table hope_book ( -- ��� ���� ���̺�
    hope_book_num number, --��� ���� ��ȣ
    book_author varchar2(150), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_isbn varchar2(50), --isbn
    book_price number, --���� ����
    hope_status varchar2(20), --���� ����
    hope_input_date date  --��û��
);

create table discard_book ( --���� ��� ��û ���̺�
       dis_book_num number, --��� ��û ��ȣ
       book_num number, --������ȣ
       dis_input_date date, --��� ��û��
       dis_status varchar2(30) --��û ���� ����
);
drop table reservation;
create table reservation (
    rent_num varchar2(30), -- �뿩��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20),   --�����ȣ
    rsrv_enddate date, --���� ����¥,
    book_num number
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);

----����
drop table department;
create table department (
    dept_code varchar2(20),
    dept_name varchar2(30)
    --CONSTRAINT dept_code_pk PRIMARY KEY(department_code)
);
insert into department values('000', '����');
insert into department values('001', '�ѹ���');
insert into department values('002', '������');
insert into department values('003', '������');

drop table sal_check;
create table sal_check (
    sal_ck_no number,
    emp_no number,
    sal_ck_year varchar2(20),
    sal_ck_month varchar2(20),
    sal_ck_check varchar2(20)
    --constraint pay_no_pk primary key(pay_check_no)
);

drop table employee_management;
create table employee_management(
    emp_no number,
    emp_name varchar2(15),
    emp_telephone varchar2(30),
    emp_address varchar2(200),
    emp_address_number varchar2(20),
    emp_dept_code varchar2(20),
    emp_jumin varchar2(25),
    emp_gender varchar2(10),
    emp_join_date date,
    emp_retire_date date,
    emp_email varchar2(30),
    emp_position varchar2(30),
    emp_basic_pay number,
    emp_bank_name varchar2(50),
    emp_account_number varchar2(30),
    emp_password varchar2(100)
    --CONSTRAINT emp_num_pk PRIMARY KEY(emp_num),
    --constraint emp_dept_fk FOREIGN KEY(department_code) REFERENCES department_table(department_code)
);
insert into employee_management
values(1000001,'������','01068618619','�����,�̹���','02451','000','9501072222222','F',sysdate-3000,null,'koongmom@librain.org','����',10000000,'�ϳ�','111111111111','950107');
insert into employee_management
values(1000002,'�̼ҿ�','01011111111','�����,������','02451','001','9901012222222','F',sysdate-2000,null,'soyoung@librain.org','����',3000000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000003,'������','01022222222','����,����','02451','002','9901012222222','F',sysdate-1000,null,'zzangmom@librain.org','����',3000000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000004,'������','01033333333','����,���� ���ְ� �ְ�','02451','002','9901012222222','F',sysdate-2400,null,'hyesudaldal@librain.org','���',2500000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000005,'�ڿ���','01044444444','��������,����','02451','003','9901012222222','F',sysdate-1300,null,'nanyewoni@librain.org','����',3000000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000006,'��¼�','01055555555','����,��Ʈķ��','02451','003','9901011222222','M',sysdate-3700,null,'iamseungsu@librain.org','���',2500000,'�ϳ�','111111111111','990101');
commit;

drop table commute_management;
create table commute_management(
    cmt_no number,
    emp_no number,
    cmt_status varchar2(100),
    cmt_year number,
    cmt_month number,
    cmt_DAY number,
    cmt_hour number,
    cmt_minute number,
    cmt_second number
    --CONSTRAINT cmt_no_pk PRIMARY KEY(commute_no)
);

drop table salary_management;
create table salary_management(
    sal_no number,
    emp_no number,
    sal_total number, -- �� �޿�
    sal_real number, -- ������ �޴� �޿�
    sal_national_pension number, -- ���ο��� 4.5
    sal_health_insurance number, -- �ǰ����� 3.23
    sal_longterm_care_insurance number, -- ����� �Ǻ� 8.51
    sal_employment_insurance number, -- ��뺸�� 0.65
    sal_income_tax number, -- �ҵ漼 0.7375
    sal_local_income_tax number, -- �ҵ漼 10��
    sal_deducted number, -- ������ ��
    sal_basic_pay number, -- �⺻�� 200��������
    sal_bonus number,
    sal_food_pay number, -- �Ĵ� 15����
    sal_year number,
    sal_month number
    --constraint pay_emp_fk FOREIGN KEY(emp_num) REFERENCES human_resource_management(emp_num)
);

-----------------------�ҿ�
select * from table board;
drop table board;

create table board( -- �Խ��� ���̺�
board_no number not null,      --�Խù� ��ȣ
board_title varchar2(200) not null,   --����
board_content varchar2(4000),      --����
board_writer varchar2(50) not null,   --�̸�
board_regdate date default sysdate,   --�ۼ�����
board_updatedate date default sysdate
--,board_viewcnt number default 0   --��ȸ��
);

alter table board add constraint pk_board
primary key (board_no);

drop sequence seq_board;
create sequence seq_board;
--------------------------------------------------------
--���� �Է�
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�׽�Ʈ����', '�׽�Ʈ����', 'user00');
commit;

-----------------------------------
--����÷�� ���̺� ����

select * from tbl_attach;
drop tbl_attach;

create table tbl_attach (
	uuid varchar2(100) not null,
	uploadPath varchar2(200) not null,
	fileName varchar2(100) not null,
	filetype char(1) default 'I',
	board_no number(10,0)
);

alter table tbl_attach add constraint pk_attach primary key(uuid);

--------------------------------------------------------

select * from table notice;
drop table notice;

create table notice( --�����Խ���
board_no number not null,      --�Խù� ��ȣ
board_title varchar2(200) not null,   --����
board_content varchar2(4000),      --����
board_writer varchar2(50) not null,   --�̸�
board_regdate date default sysdate,   --�ۼ�����
board_updatedate date default sysdate
);


alter table notice add constraint pk_notice
primary key (board_no);

-------------- ���� �Է�
insert into notice (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�ʵ�', '���������� ������ Ȯ���ϼ���', 'admin');
commit;
-------------------�¼� 
create table Facilities( --�ü���
Fac_serialnum number  ,          --�Ϸù�ȣ PK
Fac_name varchar2(30),         -- �ü��� 
Fac_address varchar2(30) ,   --��ġ
Fac_status varchar2(30),
Fac_category varchar2(30)
);

create table Facilities_inspection(   --�ü��� ����
FacIn_serialnum  number ,                           --�����Ѱ� Facilities�� fk
FacIn_name varchar2(30),    
FacIn_INSPECTION_DATE date default sysdate,    -- ������ 
FacIn_INSPECTION_DUE_DATE date
);
create table pay_management(
    pay_no number,
    pay_emp_no varchar2(10),
    pay_division varchar2(20),
    pay_total_pay number,
    pay_real_pay number,
    pay_income_tax number,
    pay_residence_tax number,
    pay_health_insurance number,
    pay_unemployment_insurance number,
    pay_nation_pension number,
    pay_etx_pay number,
    pay_basic_pay number,
    pay_bonus number,
    pay_incentive_pay number,
    pay_food_pay number,
    pay_transportation_pay number
    --constraint pay_emp_fk FOREIGN KEY(emp_num) REFERENCES human_resource_management(emp_num)
);

drop table member;

create table member( -- ȸ��
    mem_id varchar2(50), --ȸ�����̵�
    mem_pw varchar2(50), --ȸ����й�ȣ
    mem_name varchar2(30), --ȸ���̸�
    mem_jumin varchar2(30), --�ֹι�ȣ
    mem_address varchar2(200), --ȸ���ּ�
    mem_address_number varchar2(20), --�����ȣ
    mem_phone varchar2(50), --ȸ������ȣ
    mem_email varchar2(50), --ȸ���̸���
    mem_rank number default 2 -- ���� ����(1. ������Ʈ/ 2. �Ϲ�ȸ��/ 3. ����������)
   --constraint member_pk primary key (mem_id)
);

insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('nmj', '1234', '������', '930729-2111111', '��⵵ ������ ������ ����� 67-50, 119�� 802ȣ', '10130', '010-8534-0280', 'ming_0729@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pyw', '4321', '�ڿ���', '971111-2111111', '����� ���α� ��Ʈķ��', '010-1111-1111', '11111', 'pyw@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('captainss', '1234', '��¼�', '931013-1111111', '����� ���α��� ��� ��ÿ�', '01111', '010-2222-2222', 'kss@naver.com');

commit;
select * from member;
select * from rental;
select * from reservation;
ALTER table member add(DEADLINE_RENT_STOP date,book_loanable varchar2(20) default '���Ⱑ��');
select * from employee_management;

create table reservation (
    rent_num varchar2(30), -- �뿩��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20),   --�����ȣ
    rsrv_enddate date, --���� ����¥,
    book_num number
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);




















--
  
  
   --å �ݳ����ѻ�� ������� ����
 create or replace procedure proc_rentaldelayed
    is
    
    begin
     for delayedlist in (select * from rental where rent_enddate<sysdate and rent_status='�뿩��' ) loop -- å �ݳ� ���ϴ� �����.
    update member set deadline_rent_stop=nvl(deadline_rent_stop,sysdate)+1,book_loanable='��������' where mem_id=delayedlist.mem_id;
    
    end loop;
     end; 
     /
     exec proc_rentaldelayed();
     select * from member;
     
     --�������� ����
     create or replace procedure proc_deadlinecheck
    is
    
    begin
    
     for deadlinecheck in (select * from member where deadline_rent_stop<sysdate) loop -- å �ݳ� ���ߴ������
    update member set book_loanable='���Ⱑ��' where mem_id=deadlinecheck.mem_id;
    
    end loop;
     end; 
     /
     exec proc_deadlinecheck();
     /
     
     
     
     
     
     
     update member set deadline_rent_stop=sysdate-10 ,book_loanable='��������' where mem_id='nmj';
     select * from book;
     select * from rental;
     select * from member where deadline_rent_stop<sysdate;
     
     
     
     
     --�����ߴµ� å ������ �ȿ��� �����
   create or replace procedure proc_reservationdelayed(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from rental where rent_enddate<sysdate and rent_status ='������' ; -- �����ߴµ� �Ⱥ��� �����
   
     end;
       
     
     --���ν��� �����ߴµ� ������ذ��� ���� �������� ����
     
declare 
    bbbook_num rental.book_num%type;
    mem_id   rental.mem_id%type;
    ho sys_refcursor;
    countvalues  rental%rowtype;
    hoho number;
    onecheck number;
begin
    proc_reservationdelayed(ho); 
    --�뿩 ���� ����� ���   out������ �Ѹ���.
loop
 fetch ho into countvalues;  -- 
  exit when ho%notfound;
    delete * from rental 

   -- ���ο� ���ν��� �ϳ��� ������ ������.
    select  count(*) into hoho  from reservation where book_num=countvalues.book_num;   --���� ���� �����
    select count(*) into onecheck from reservation where rsrv_num=1 and book_num= countvalues.book_num;
    --update test3 set val=0 where val=1 and varc in('not');   -- varc�� enddate<sysdate�� �����  
      --�ش�å �������� ��� ���

     --å �Ⱥ�������̶� �׳� ��������.
     --reservation ���̺��� �ְ� rental���� ����. �Ǵ� rental�� �־����
    delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
    delete from rental where book_num=countvalues.book_num and rent_status='������';
   --1���λ�� �Ǵ��ϱ�
   
    if 1=onecheck then
         insert into rental(RENT_NUM ,       
BOOK_NUM              ,
MEM_ID               ,
RENT_STARTDATE        ,      
RENT_ENDDATE           ,       
RENT_APPENDIX_STATUS   ,
RENT_EXTENSION          ,
RENT_STATUS    )

        values( (select max(rent_num)+1 from rental) , countvalues.book_num
        ,  (select mem_id from reservation where rsrv_num=1 and  book_num =countvalues.book_num)
        ,sysdate
        ,sysdate+2
        ,'X'
        ,'X'
        ,'������'); 
        --�Ʒ� ����
      --
--      insert into reservation    1���� �Ҵ�
        end if;
    
  
    
    --���� �Ϸ�Ǹ� ����1���� ��������.
        for i in 1..hoho  loop
        update reservation set rsrv_num=i where rsrv_num=i+1; 
      
            --ù ������ �����Ը����
       
       
    
        
       DBMS_OUTPUT.put_line('����� = '||i ||'�׸��� ho2�� val= ' );
--     
       end loop;  --foreach end loop
    end loop;
    close ho;
    end;
    /
    select * from reservation;
     select * from rental;
     
     select * from rental;
     select * from reservation;
     
     --å �ݳ����ڸ��� 
     --����  ��� <-- delete 
     select * from (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date, decode(rent_enddate,null,'�뿩��','�뿩����') rent,rent_status , rentalmem_id  from (select * from book where book_num = 100001) b left outer join (select book_num, nvl(to_char(rent_enddate),null) rent_enddate,rent_status , rental.mem_id rentalmem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on (b.book_num = r.book_num)) 
/
select * from book left outer join rental on book.book_num =rental.book_num left outer join reservation on rental.book_num=reservation.book_num;
--
select * from book;
select * from rental;
select * from book  left outer join rental on rental.book_num=book.book_num    where rental.book_num = (select max(rental.book_num) from rental where rental.book_num=100011) ;
select * from book;
--���⿩��, ���忩��,���డ�ɿ���
delete from rental where  rent_status = '������';
    select rent_status from rental;
    select * from rental;
    select * from book;
    
    
select * from reservation;

select count(*) from reservation where book_num =100001; 
--���� �������� -> ���� 
select * from rental;

