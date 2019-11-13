---- ���� 20191024  ���� 
---- �ƿ� ó�� ��� �ִ� �е��� drop �����ϰ� �ϸ�˴ϴ�!
drop table book_category;
drop table book;
drop table appendix;
drop table rental;
drop table new_book;
drop table discard_book;
drop table reservation;

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
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ; ������ �׸�','�޺����� ����Ʈ ������ : ������ ������ȭ','���̺극��',to_date('2017','YYYY'),'9788936442880 ','X',80,'���డ��',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ī���� ��ù�ġ ����  ; ������ �ű�','ö���� ������  : ����� ������ ��¥ ö��','���̺극��',to_date('2014','YYYY'),'9788920012921 ','X',100,'���డ��',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ; ������ �ű�','����, ö���Ѵ� : ������ ö���ڵ��� ������ ���� �̾߱�','���̺극��',to_date('2017','YYYY'),'9788959406517 ','X',109.9,'���డ��',0,sysdate,100);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'���̸� ȣ�� ���� ; �մ�ȣ �ű�','(���Ƶ��� ����)���� �ķ�','���̺극��',to_date('2009','YYYY'),'9788984750111 ','X',208,'���డ��',0,sysdate,200);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'��μ� ����','������ �������� ǳ��  : ���� �̽��� ��ȸ����','���̺극��',to_date('2017','YYYY'),'9788936503451 ','X',233.109,'���డ��',0,sysdate,200);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'G.D.H. �� ���� ; ȫ��� �ű�','�ι�Ʈ ���� : ���������, ������ ����ü�� �Ǽ��� ��ȸ���Ű�','���̺극��',to_date('2017','YYYY'),'9791195567812 ','X',301.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����Ͽ� �׶��� ����  ; �̻��� �ű�.','�׶����� ���߼���. 1 :, ��ġ��','���̺극��',to_date('1999','YYYY'),'9788934001553 ','X',301.52,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�鿵�� ����','(�ٽ����忡��) ���ƽþƸ� �ٽ� ����  : ������ȸ�� ���� ��õ����','���̺극��',to_date('2013','YYYY'),'9788936482688 ','X',309.11,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�丶 ����Ƽ ����  ; ����, ��������[��] �ű�','21���� �ں�','���̺극��',to_date('2014','YYYY'),'9788967351274 ','X',321.2,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��� ����, ������ �� [��]���� ; ���ΰ� �ű�','(�뿹������ �ݴ��� ������)������ ���ϴ�','��???�극��',to_date('2016','YYYY'),'9791195718702 ','X',321.542,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���񽺸�����','���̺극��',to_date('2013','YYYY'),'9788958533641 ','X',323.16,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̷�ǳ ����','�ֽ�ȸ������','���̺극��',to_date('2016','YYYY'),'9788956614083 ','X',324.47,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','�ҹ����� �δ��̵� �繫����','���̺극��',to_date('2018','YYYY'),'9791186456637 ','X',325.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','����Ʈ���丮 = Smart factory : ��4�� ��������� �����','���̺극��',to_date('2017','YYYY'),'9788946070202 ','X',325.6,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ȸ������� ����','��ȸ �������� ����ִ� �������� �̾߱� : ��ȸ�� �������� Ű��� �ùα�����','���̺극��',to_date('2017','YYYY'),'9788952235763 ','X',326,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ȼ��� ����','���ε� Ʈ������ ��� ������ ���ΰ�  : �ٰ����� ���� ���� Ÿ���� ���󰡿� ����ϴ� ����Ͻ� ���� ����','���̺극��',to_date('2017','YYYY'),'9788947541695 ','X',326.2,'���డ��',0,sysdate,300);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','��ȯ�ô��� ����  : ������ �����','���̺극��',to_date('1990','YYYY'),'9788936410049 ','X',349.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ֿ��� ����','������å��  : ��� ����� �����Ǵ°�?','���̺극��',to_date('2013','YYYY'),'9788934965695 ','X',349.11,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�񿵸� ����','�ŷ��� �߰�  : 30�� ������������ ������ 68���� ���','���̺극��',to_date('2016','YYYY'),'9788925558134 ','X',351.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�����  ��','������ʫ��?�����������ϼ','���̺극��',to_date('2017','YYYY'),'9787520303545 ','X',360.1,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ο� �Բ� �쳿','������ �̷�  : �л��� ������ �Բ� ���� ���� ��ġ ������ ��  : �츮�� ��� ������ �̷��� �� �� ������','���̺극��',to_date('2016','YYYY'),'9788935663002 ','X',370.4,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ���, �� �Ӱմ޷�, ���� ���� [��] ����  ; �ּ���, �����, �躴�� [��] �ű�','������Ʈ ���� ��� �� ���ΰ�?  : ö�п��� ��õ����, ������� ���� PBL�� ��� ��!','���̺극��',to_date('2017','YYYY'),'9788994655543 ','X',373.25,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�赿�� ��  ; ������, ������ [��] �׸�','������ �ܲ� ��Ų ��ȸ ������, ���� ��','���̺극��',to_date('2010','YYYY'),'9788927800620 ','X',375.43,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','4�� ����  : ���￩��, �� ���� ������ ���','���̺극��',to_date('2011','YYYY'),'9788952216380 ','X',376.7,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ [��]����','(���񱳻縦 ����)Ư�������� = Introduction to special education for preservice teachers','���̺극��',to_date('2014','YYYY'),'9788925408774 ','X',379,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������� ���ɿ� ���� ; ������ �ű�','��ɲ��� ����� ���� �ʴ´�','���̺극��',to_date('2017','YYYY'),'9788967260248 ','X',381.7,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��  ; ���淡 �׸�','(���� ����� ���� ����ִ�) �츮 �� �̾߱�','���̺극��',to_date('2015','YYYY'),'9788967493806 ','X',388,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�߸����� ��ġ���� ���� ; �ֿ�� �ű�','��� �ϱ��屳�� �ٶ� �Ϻ������� ����','���̺극��',to_date('2016','YYYY'),'9788967353544 ','X',390.913,'���డ��',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Shin Takahashi �� ; Iroha Inoue �׸� ; �輺�� �ű�','(��ȭ�� ���� ����)�������','���̺극��',to_date('2009','YYYY'),'9788931579819 ','X',412.85,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','������ ���б��� : ������ ���� ���ڿ���','���̺극��',to_date('2017','YYYY'),'9791195369959 ','X',427.62,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ���� ; �ѱ��������� ����ȫ����������ȸ �ű�','�� �ʸ� : �༺ õ������ ���̵� �ظ�','���̺극��',to_date('2016','YYYY'),'9788956057811 ','X',440.99,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ������ ���� ; Ű�� �׸� ; �ڴ��� �ű�','�ȵ��ȵ� ������ 24�ð�','����??����',to_date('2017','YYYY'),'9788943310912 ','X',448.75,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Charlotte Guillain, illustrated by Yuval Zommer','(The)Street beneath my feet','���̺극��',to_date('2017','YYYY'),'9781682971369 ','X',455,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̿��, �ѻ�ȣ [��] ��  ; �ø��� ��Ʃ���, �帲��ġ CC [��] �׸�','(��̵�ȭ) ������  : �ѹݵ��� ����','���̺극��',to_date('2012','YYYY'),'9788901140629 ','X',457,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ��Į����, ���� ���е� [��]���� ; ������ �ű�','����, ��迡 ���� : ���ڻ������� �ô밡 �ٰ��´�','���̺극��',to_date('2017','YYYY'),'9788967354589 ','X',472.19,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ó�� ��Ų�� �� ����  ; �� ��ϸ� ����  ; ������ �ű�','�ñ��� ����  : ������ ���� 21���� ���ϴ� ������ ����� ��ȭ, �׸��� ��÷�� ��������','���̺극��',to_date('2017','YYYY'),'9788937889257 ','X',473,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ���� ���� ; ��ȫǥ �ű�','��ȭ�ϴ� ��','���̺극��',to_date('2017','YYYY'),'9791128820045 ','X',474,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������򿬱��� ����  ; �̸��� �׸�','DMZ ������','���̺극��',to_date('2011','YYYY'),'9788991871878 ','X',477,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ; �̿��� �Ϸ���Ʈ','���հ� ������ ����� ??����','���̺극��',to_date('2016','YYYY'),'9788958075790 ','X',493,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��õ�� [��] ����','������ ����  : ���۲������濡�� ���� ������ �ι���','���̺극��',to_date('2017','YYYY'),'9788955619072 ','X',493.73,'���డ��',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����  ; ���ѿ� ��  ; ������ �׸�','(�������� ������) �̷�����  : �̷��ڵ��� Ư�޷��̽�','���̺극��',to_date('2010','YYYY'),'9788934936909 ','X',500,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Dorling Kindersley ��  ; UJ ����','������ �ٲٴ� �ְ��� ���� ���','���̺극��',to_date('2017','YYYY'),'9788930270687 ','X',504,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� ������ ����  ; ������ �ű�','(30���� �߸�ǰ���� �д�) �����  : ��, ����, �ð迡�� �ö�ƽ, �ݵ�ü, ��ǻ�Ϳ� �̸������','���̺극��',to_date('2017','YYYY'),'9788984458512 ','X',507,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���������� ������-���ַ� ��  ; ���ڸ� �� �׸�  ; ��ȿ�� �ű�','�ֻ�� �� ������','���̺극��',to_date('2006','YYYY'),'9788909122726 ','X',508,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'� ��Ʈ�ν�Ű ����  ; ����ȣ �ű�','��ũ�� �� �� ������ �ް� �Ǿ���','���̺극��',to_date('2014','YYYY'),'9788934966500 ','X',509,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�׵� �˷�, �õ�� ���� [��] ����  ; õ��� �ű�','���� ��� ����','���̺극��',to_date('2001','YYYY'),'9788939204140 ','X',510.99,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Jennie Maizels, William Petty','My pop-up body book','���̺극��',to_date('2017','YYYY'),'9781406317923 ','X',511.1,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ϳ׽� �� �������� ����  ; ����� �ű�','�ŷ����� ���� ����  : ������ ����, ���忡 ���� ���� ���� ������Ʈ','���̺극��',to_date('2016','YYYY'),'9788937838743 ','X',511.116,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ����','(������ �����ǻ� ������) ������ �̾߱�','���̺극��',to_date('2017','YYYY'),'9791186692080 ','X',513.811,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ����, �̼� ���� [��] ���� ; �ּ�ȯ, ������ [��] �ű�','�鿪�� ���','���̺극��',to_date('2017','YYYY'),'9791159430657 ','X',513.92,'���డ��',0,sysdate,500);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ۺ��� , ������ , ������ [��]����','(2014) �װ��������� �� ����  = Aeronautical information manual','���̺극��',to_date('2014','YYYY'),'9788972870784 ','X',558.3,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ּ��� ����','PLC ���ʿ� ����  : �ʺ����� �ǹ�����','���̺극��',to_date('2015','YYYY'),'9788942914036 ','X',559.98,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�Ŵ뼷 ����','(�ʺ��ڰ� �����) AVR ����ũ�� ���μ��� �����ϱ�','���̺극��',to_date('2017','YYYY'),'9788931708936 ','X',559.99,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� �� ��  ; ������ �','(�ʺ��ڸ� ����) ������� �Թ�','���̺극��',to_date('2017','YYYY'),'9788931525618 ','X',560,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� û  ; ���� �귢 [��] ����  ; ȫ���� �ű�','��������  : ����� ������ �Ǳ���� õ������ڵ��� �� ������ â���� ����','���̺극��',to_date('2015','YYYY'),'9788920930720 ','X',560.9,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �׾� ����  ; ������ �ű�','������ ���� �ٲٴ� ����','���̺극��',to_date('2016','YYYY'),'9791186000304 ','X',565,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Saito Masanori ���� ; �̿��� �ű�','(�׸� �� ������ ����)�ֽ� IT Ʈ����','���̺극��',to_date('2017','YYYY'),'9788956747354 ','X',567,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���籤 ����','������ ���','���̺극��',to_date('2016','YYYY'),'9791132100942 ','X',567.01,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ; ������ ; �̱�� ����','���ִ� ���Ŀ��� ������ �ִ� = Amazing Science in Delicious Foods','���̺극��',to_date('2017','YYYY'),'9788970938691 ','X',570,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���Ʊ� ����','���̿���Ŀ�� �´� = Bio hacker : ���������� ��ŷ�ϴ� ���η��� ���� ������','���̺극��',to_date('2015','YYYY'),'9788967352127 ','X',570.6,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ��  ; ����� �׸�','(�ƺ��� �Բ��ϴ�) ����� ��̴�','���̺극��',to_date('2014','YYYY'),'9788984318342 ','X',584,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Ȳ��Ǫ, õ??[��] ����  ; ���� �ű�','�߱��� ��ܿ��� ĥõ ��  : ���� ������ �ڼ�ǰ ����  = China silk 7000 years : crystal of art science and technology','���̺극��',to_date('2016','YYYY'),'9788926871508 ','X',587.39,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���̰� ���� ; ������ ������ �׸� ; Ȳâ�� �ű�','������ ��� �¾���� : ���̵��� ������ �ٲٴ�','���̺극��',to_date('2017','YYYY'),'9788991550841 ','X',589,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������� ���ΰ� ����','�������� �츲�ϱ�  : �츲�������� ���� �ִ� � ������ �츲 �̾߱�','���̺극��',to_date('2016','YYYY'),'9788925558561 ','X',591,'���డ��',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Emi ����  ; ������ �ű�','(Ourhome) ���� �������� ���� ������','���̺극��',to_date('2016','YYYY'),'9788959759743 ','X',591.1,'���డ��',0,sysdate,500);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'�� Ŭ������, ��������, ���â �� ����','����ȭ ���� ��� �۾���  = (The) globalization world and the human community  : ��2011�� ��3ȸ ���ﱹ������������ ������','���̺극��',to_date('2011','YYYY'),'9788937484285 ','X',805,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����ȯ [��]��','���б�����','���̺극��',to_date('2017','YYYY'),'9788974900236 ','X',807,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ���� ����  ; ��ȭ�� �ű�','���� �ʸ�','���̺극��',to_date('2009','YYYY'),'9788963650180 ','X',808.2,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��Axt�� ������ ����','�̰��� ���� ������  : �Ҽ������� �Ҽ����� ���ͺ��ϴ�!','���̺극��',to_date('2017','YYYY'),'9788956601366 ','X',809.3,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','���, �� ��° ���  : ������ �����','���̺극��',to_date('2017','YYYY'),'9788936463465 ','X',809.9,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����  ; ����� �ű�','�ٻ�ü�','���̺극��',to_date('2013','YYYY'),'9788936472320 ','X',811.35,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������: ����','�갳���� ��  : ���� ���ۡ��Ҽ���','���̺극��',to_date('2016','YYYY'),'9788930006330 ','X',813.62,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�輱�� ����','��� ���� �� ���İ� ����� ������  : ���� �輱�찡 ���κ����� ���� �ູ ����','���̺극��',to_date('2011','YYYY'),'9788935208814 ','X',816.6,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���������� ��  ; ����� �׸�  ; ������ �ű�','�� �Ѿ� ��','���̺극��',to_date('2017','YYYY'),'9788925560229 ','X',823.8,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����ġ�� ����  ; ������ �ű�','(����� ����ġ����)�Ҽ�(���)�д� ���','���̺극��',to_date('2011','YYYY'),'9788954616027 ','X',833.09,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ڼ��� ; �̼��� [��]���� ; �ڼ��� ; �ڻ�� [��]�׸�','������¥�� = s? tich banh ch?ng banh giay','���̺극��',to_date('2017','YYYY'),'9791186908235 ','X',839.82,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Bill Bryson','(A) Walk in the Woods','���̺극��',to_date('2006','YYYY'),'9780307279460 ','X',844,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ĿƮ ���ϰ� ��??  ; ���� �ű�','�׷�, �� ���� ��� ����  : ������ �յ� �ʿ���','���̺극��',to_date('2017','YYYY'),'9788954644174 ','X',845,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���� ������ �� ���� ����  ; ������ �ű�','��Ż���� ����','���̺극��',to_date('2016','YYYY'),'9788949715209 ','X',856,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'īƮ�� ��Ÿ ����  ; �ڼ��� �ű�','���� ȥ�� �����ϴ� ����  : 7�� ���� 50������ Ȧ�� �����ϸ� ������ �͵�','���̺극��',to_date('2015','YYYY'),'9788901204772 ','X',858,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�츣�� �켼 ���� ; ������ �ű�','����ϴ� ����� �ູ�ϴ� : ����� ���Ͽ�','���̺극��',to_date('2017','YYYY'),'9791188047031 ','X',859,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�������� ��� ���� ; ������ �ű�','������ �뷡','���̺극��',to_date('2016','YYYY'),'9788937475047 ','X',861,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�ĺ��� �׷�� ����  ; ������ �ű�','����� �뷡','���̺극��',to_date('2016','YYYY'),'9788932028866 ','X',871,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'ȣ��Ƽ�콺 ���� ; �賲�� �ű�','ī���� ��','���̺극��',to_date('2016','YYYY'),'9788937475016 ','X',892.2,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��� ���̾� ���� ; �ۼ��� �ű�','13�ð� : ��� ���̾� �����Ҽ�','���̺극��',to_date('2016','YYYY'),'9788950965754 ','X',893,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�߷����� ����??�� ����  ; ������ �ű�','���߷��� �����  : �߷����� ���̼��� �����Ҽ�','���̺극��',to_date('2017','YYYY'),'9788972758075 ','X',894,'���డ��',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���ο� ����','������ ������ �ִ� : ��������, �ð��� �Ѿ� �ο��� �߱��ϴ� �����','���̺극��',to_date('2017','YYYY'),'9788946420779 ','X',902.5,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������б� ���翬���� ��','���������  = Discovery of historical terms','���̺극��',to_date('2015','YYYY'),'9788952115119 ','X',903,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�̱��� ����','�ﱹ���� �������','���̺극��',to_date('2017','YYYY'),'9788955083729 ','X',911.85,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'����� ����','(��) �ι� �ﱹ��','���̺극��',to_date('2014','YYYY'),'9788967990411 ','X',912.033,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ �� ���� ; ����ȯ, ��ö�� �� �ű�','������ ����, Ÿ�̺��̸� �ȴ�','���̺극��',to_date('2017','YYYY'),'9788965454458 ','X',912.4,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'���¹� ����','�̰��������� ��������Ʈ 100','���̺극��',to_date('2017','YYYY'),'9788984354166 ','X',914.69,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ī���� ��ģ ����  ; �̱ٿ� �ű�','���޸�, Ȥ�� �ŵ��� ����','���̺극��',to_date('2009','YYYY'),'9788996244950 ','X',919.1,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'�÷θ��� �ϸ��� ����  ; �Ѱ��� �ű�','1913�� ����??? ����','���̺극��',to_date('2013','YYYY'),'9788954622608 ','X',920.5,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Dan Jones','(The)Wars of the Roses : The Fall of the plantagenets and the rise of the Tudors','���̺극��',to_date('2015','YYYY'),'9780143127888 ','X',924.041,'���డ��',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'��ó� ����','������ �����  : ��ü, �켼, �ٱ׳�, �׸�����','���̺극��',to_date('2015','YYYY'),'9791186000168 ','X',925.9,'���డ��',0,sysdate,900);
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
insert into book values((select nvl(max(book_num)+1,100001) from book),'������ ����','(5��� ������) ������ �̾߱�','���̺극��',to_date('2002','YYYY'),'9788987787404 ','X',999.9,'���డ��',0,sysdate,900);

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

insert into hope_book values(1,	'�۹��',	'���ưų� �����ϴ� �� ���ų�',	'���Ѻ�',	TO_DATE('2019/09/04','YYYY-MM-DD'),	'1196797706 9791196797706', 13500,	'��û �Ϸ�',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(2,	'������',	'82��� ������(������ ���� �۰� 13)(���庻 HardCover)',	'������',	TO_DATE('2016/10/14','YYYY-MM-DD'),	'8937473135 9788937473135',	13000,	'��û �Ϸ�',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(3,	'��ȫ��',	'90����� �´�','���Ϻ�(whalebooks)',	TO_DATE('2018/11/16','YYYY-MM-DD'),	'1188248677 9791188248674',	14000,	'��û �Ϸ�',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(4,	'���� �϶�',	'���ǿ���',	'�迵��',	TO_DATE('2015/11/24','YYYY-MM-DD'),	'8934972467 9788934972464',	22000,'	��û �Ϸ�',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(5,	'�迵��',	'������ ����',	'���е���',	TO_DATE('2019/04/17','YYYY-MM-DD'),	'8954655971 9788954655972',	13500,'	��û �Ϸ�',	TO_DATE('2019/10/24','YYYY-MM-DD'));
insert into hope_book values(6,	'�̺���',	'ȥ�ڰ� ȥ�ڿ���',	'��'	, TO_DATE('2019/09/19','YYYY-MM-DD'),	'1158161026 9791158161026',	15500,	'��û �Ϸ�',	TO_DATE('2019/10/24','YYYY-MM-DD'));
insert into hope_book values(7,	'������',	'2020 ���� ��������',	'21����Ͻ�',	TO_DATE('2019/07/05','YYYY-MM-DD'),'	895098198X 9788950981983',	17000,	'��û �Ϸ�',	TO_DATE('2019/10/24','YYYY-MM-DD'));

create table discard_book ( --���� ��� ��û ���̺�
       dis_book_num number, --��� ��û ��ȣ
       book_num number, --������ȣ
       dis_input_date date, --��� ��û��
       dis_status varchar2(30) --��û ���� ����
);

insert into discard_book values(3, '100268', TO_DATE('2019/10/24','YYYY-MM-DD'), '��û �Ϸ�');
insert into discard_book values(2, '100267', TO_DATE('2019/10/24','YYYY-MM-DD'), '��û �Ϸ�');
insert into discard_book values(1, '100266', TO_DATE('2019/10/24','YYYY-MM-DD'), '��û �Ϸ�');
commit;
create table reservation (
    book_num varchar2(30), -- å��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20),   --�����ȣ
    rsrv_enddate date --���� ����¥
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);
drop table reservation;
--�����Է� ��¥ ���� Ŀ��
update book set book_input_date = to_date(round(dbms_random.value(20170101, 20170131),0),'yyyymmdd')
where (book_num between round(dbms_random.value(100001, 100268),0) and round(dbms_random.value(100001, 100268),0));

update book set book_input_date = to_date(round(dbms_random.value(20190801, 20190831),0),'yyyymmdd')
where (book_num between round(dbms_random.value(100001, 100268),0) and round(dbms_random.value(100001, 100268),0));

update book set book_input_date = to_date(round(dbms_random.value(20180601, 20180630),0),'yyyymmdd')
where (book_num between round(dbms_random.value(100001, 100268),0) and round(dbms_random.value(100001, 100268),0));

update book set book_input_date = to_date(round(dbms_random.value(20190501, 20180630),0),'yyyymmdd')
where (book_num between round(dbms_random.value(100001, 100268),0) and round(dbms_random.value(100001, 100268),0));

update book set book_input_date = to_date(round(dbms_random.value(20191001, 20191031),0),'yyyymmdd')
where (book_num between round(dbms_random.value(100001, 100268),0) and round(dbms_random.value(100001, 100268),0));

--����Ƚ�� ���� Ŀ��
update book set book_rent_cnt = round(dbms_random.value(12, 50),0);

select book_rent_cnt from book;

commit;
----����
drop table department;
create table department (
    dept_code varchar2(20),
    dept_name varchar2(30),
    CONSTRAINT dept_code_pk PRIMARY KEY(dept_code)
);
insert into department values('000', '����');
insert into department values('001', '�ѹ���');
insert into department values('002', '������');
insert into department values('003', '������');

-- ��������
drop table sal_check;
create table sal_check (
    sal_ck_no number,
    emp_no number,
    sal_ck_year varchar2(20),
    sal_ck_month varchar2(20),
    sal_ck_check varchar2(20),
    constraint sal_ck_no primary key(sal_ck_no)
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
    emp_password varchar2(100),
    CONSTRAINT emp_no_pk PRIMARY KEY(emp_no),
    constraint emp_dept_fk FOREIGN KEY(emp_dept_code) REFERENCES department(dept_code)
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
insert into employee_management
values(1000007,'�ѿ���','01012341234','����,��Ʈķ��','02451','001','9901012222222','F',sysdate-3700,null,'asdf@librain.org','���',2500000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000008,'����','01034563456','����,��Ʈķ��','02451','001','9901012222222','F',sysdate-3700,null,'qwer@librain.org','���',2500000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000009,'�ճ���','01045674567','����,��Ʈķ��','02451','002','9901012222222','F',sysdate-3700,null,'zxcv@librain.org','���',2500000,'�ϳ�','111111111111','990101');
insert into employee_management
values(1000010,'���켺','01056785678','����,��Ʈķ��','02451','003','9901012222222','M',sysdate-3700,null,'abab@librain.org','���',2500000,'�ϳ�','111111111111','990101');
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
    cmt_second number,
    CONSTRAINT cmt_no_pk PRIMARY KEY(cmt_no),
    constraint cmt_emp_fk FOREIGN KEY(emp_no) REFERENCES employee_management(emp_no)
);

Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (0,1000001,'on',2019,10,7,8,57,16);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (1,1000001,'off',2019,10,7,18,57,19);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (2,1000002,'on',2019,10,7,8,5,19);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (3,1000002,'off',2019,10,7,18,2,55);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (4,1000001,'off',2019,10,7,18,4,47);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (5,1000001,'on',2019,10,10,8,28,19);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (6,1000001,'off',2019,10,10,11,28,20);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (7,1000001,'on',2019,10,11,8,36,11);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (8,1000001,'off',2019,10,11,18,19,10);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (9,1000001,'on',2019,10,14,8,19,11);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (10,1000001,'off',2019,10,14,18,1,6);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (11,1000001,'on',2019,10,15,8,18,12);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (12,1000001,'off',2019,10,15,18,18,15);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (13,1000001,'on',2019,10,16,8,55,5);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (14,1000001,'off',2019,10,16,20,55,6);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (15,1000001,'on',2019,10,17,8,38,3);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (16,1000001,'off',2019,10,17,20,38,4);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (17,1000001,'on',2019,10,18,8,53,5);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (18,1000001,'off',2019,10,18,20,53,9);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (19,1000001,'on',2019,10,22,17,53,7);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (20,1000001,'off',2019,10,22,17,53,9);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (21,1000001,'on',2019,10,23,12,51,26);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (22,1000001,'off',2019,10,23,12,51,27);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (23,1000001,'on',2019,10,24,8,25,46);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (24,1000001,'off',2019,10,24,18,25,47);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (25,1000002,'on',2019,10,24,8,53,30);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (26,1000002,'off',2019,10,24,15,27,43);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (27,1000003,'on',2019,10,24,8,37,30);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (28,1000003,'off',2019,10,24,19,38,41);
Insert into COMMUTE_MANAGEMENT (CMT_NO,EMP_NO,CMT_STATUS,CMT_YEAR,CMT_MONTH,CMT_DAY,CMT_HOUR,CMT_MINUTE,CMT_SECOND) values (29,1000001,'off',2019,10,24,19,38,43);
commit;

drop table salary_management;
create table salary_management(
    sal_no number,
    emp_no number,
    sal_total number, -- �� �޿�
    sal_real number, -- ������ �޴� �޿�
    sal_national_pension number, -- ���ο��� 4.5
    sal_health_insurance number, -- �ǰ����� 3.23
    sal_longterm_care_insurance number, -- ����� �Ǻ� 8.51
    sal_employment_insurance number, -- ���뺸�� 0.65
    sal_income_tax number, -- �ҵ漼 0.7375
    sal_local_income_tax number, -- �ҵ漼 10��
    sal_deducted number, -- ������ ��
    sal_basic_pay number, -- �⺻�� 200��������
    sal_bonus number,
    sal_food_pay number, -- �Ĵ� 15����
    sal_year number,
    sal_month number,
    constraint pay_emp_fk FOREIGN KEY(emp_no) REFERENCES employee_management(emp_no)
);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (0,1000001,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (1,1000002,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (2,1000003,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (3,1000004,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (4,1000005,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (5,1000006,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (6,1000007,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (7,1000008,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (8,1000009,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
Insert into SALARY_MANAGEMENT (SAL_NO,EMP_NO,SAL_TOTAL,SAL_REAL,SAL_NATIONAL_PENSION,SAL_HEALTH_INSURANCE,SAL_LONGTERM_CARE_INSURANCE,SAL_EMPLOYMENT_INSURANCE,SAL_INCOME_TAX,SAL_LOCAL_INCOME_TAX,SAL_DEDUCTED,SAL_BASIC_PAY,SAL_BONUS,SAL_FOOD_PAY,SAL_YEAR,SAL_MONTH) values (9,1000010,924091,828750,40909,29364,2499,5909,15145,1515,95341,909091,0,15000,2019,10);
commit;
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
insert into notice (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '�Խ��� �̿� ��Ģ', '�������װ� �系�ҽĸ��� ������Ʈ �մϴ�. ������ ���� ���� �̾߱�� �ﰡ���ּ���.', 'admin');
commit;
-------------------�¼� 
drop table Facilities;
drop table Facilities_inspection;
create table Facilities( --�ü���
Fac_serialnum number  ,          --�Ϸù�ȣ PK
Fac_name varchar2(30),         -- �ü��� 
Fac_address varchar2(30) ,   --��ġ
Fac_status varchar2(30),
Fac_category varchar2(30)
);
create table Facilities_inspection(   --�ü��� ����
FacIn_serialnum  number ,                           --�����Ѱ� Facilities�� fk
FacIn_name varchar2(30),                --�ü��� �̸�
FacIn_address varchar2(30),               --�ü��� ���                 --�ü��� ����
FacIn_Inspection_Date date default sysdate,    -- ������ 
FacIn_Inspection_Due_Date date                 --���˿����� 
);


commit;


insert into  Facilities values(1,'å��','1��������','����','����');
insert into  Facilities values(2 ,'å��','1��������','���� ','����');
insert into  Facilities values(3,'å��','1��������','���� ','����');
insert into  Facilities values(4,'�ѽ�','1��������','���� ','������ǰ');
insert into  Facilities values(5,'������','1��������','���� ','������ǰ');
insert into  Facilities values(6,'��ǻ��','2���ü���','���� ','������ǰ');
insert into  Facilities values(7,'��ǻ��','3��2��','���� ','������ǰ');
insert into  Facilities values(8,'��ǻ��','1��������','���� ','������ǰ');
insert into  Facilities values(9,'����','1��������','���� ','����');
insert into  Facilities values(9,'','1��������','���� ','����');



--�ü����� 
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(1,'����������','1��',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(2,'�����÷�����','1��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'�����÷�����','2��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'�����÷�����','3��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(4,'����������','2��',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(5,'��ȭ��','2��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(6,'��ȭ��','2��1��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(7,'��ȭ��','2��2��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(8,'��ȭ��','2��3��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(9,'��ȭ��','2��4��',sysdate,sysdate+3);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(10,'��ȭ��','2��5��',sysdate,sysdate+5);


commit;

create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type) 
is
begin
 case when f_name='����������' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='�跮��' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
        
      when f_name='��ȭ��' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+20,facin_address=f_address where FacIn_serialnum=f_number;
        when f_name='������' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+180,facin_address=f_address where FacIn_serialnum=f_number;
      
        else
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number)
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-sysdate),facin_address=f_address where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/

create or replace procedure facin_insert( f_name   in facilities_inspection.facin_name%type,
                                           f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0
                                          )
is
begin
 case when f_name='����������' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '����������',sysdate,sysdate+180 ,f_address);
      when f_name='�跮��' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '�跮��',sysdate,sysdate+30 ,f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date ,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), f_name,sysdate,sysdate+f_cycle,f_address);
 
 end case;
end;
/

commit;

drop table member;

create table member( -- ȸ��
    mem_id varchar2(50), --ȸ�����̵�
    mem_pw varchar2(50), --ȸ����й�ȣ
    mem_name varchar2(30), --ȸ���̸�
    mem_jumin varchar2(30), --�ֹι�ȣ
    mem_address varchar2(200), --ȸ���ּ�
    mem_address_number varchar2(20), --������ȣ
    mem_phone varchar2(50), --ȸ������ȣ
    mem_email varchar2(50), --ȸ���̸���
    mem_rank number default 2 -- ���� ����(1. ��������Ʈ/ 2. �Ϲ�ȸ��/ 3. ����������)
   --constraint member_pk primary key (mem_id)
);

insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('nmj', 'ming0729!123', '������', '9307292111111', '��⵵ ������ ������ ����� 67-50, 119�� 802ȣ', '10130', '01085340280', 'ming_0729@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pyw', '4321', '�ڿ���', '9711112111111', '����� ���α� ��Ʈķ��', '11111', '01011111111', 'pyw@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('captainss', '1234', '��¼�', '9310131111111', '����� ���α��� ��� ���ÿ�', '01111', '01022222222', 'kss@naver.com');

insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lsy', '2345', '�̼ҿ�', '9707111111111', '����� �������� ���ǽ���', '58642','01012342345', 'soso@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ksa', '5432', '������', '9511111111111', '����� ��õ�� ', '52325', '01012673421', 'sooa@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('mhs', '3456', '������', '9611111111111', '����� ������', '35473', '01011112222', 'hyesoo@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kdw', '6543', '������', '8111111111111', '����� ���ϱ�', '34578', '01011113333', 'dongwon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jws', '4567', '���켺', '7311111111111', '����� ���ı�', '95463', '01011114444', 'sung@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jdg', '7654', '�嵿��', '7211111111111', '����� ���ϱ�', '34865', '01011115555', 'shotgun@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kth', '5678', '������', '8211111111111', '��⵵ ������', '89658', '01011116666', 'hyunbin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('cew', '8765', '������', '9711111111111', '����� �߱�', '53257', '01011117777', 'dongmin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('dks', '6789', '�����', '9311111111111', '����� ������', '35278', '01011118888', 'kyungsoo@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jjh', '9876', '������', '8211111111111', '����� ������', '94214', '01011119999', 'jihoon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjk', '1122', '���߱�', '8511111111111', '����� �߶���', '73241', '01011111122', 'joongki@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hjw', '1133', '������', '7811111111111', '����� ������', '86552', '01011111133', 'letswalk@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ljj', '1144', '������', '7311111111111', '����� ���α�', '56345', '01011111144', 'kingjae@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jjs', '1155', '������', '8011111111111', '����� ���Ǳ�', '31278', '01011111155', 'yongnam@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jcw', '1166', '��â��', '8711111111111', '����� ��õ��', '75648', '01011111166', 'changwook@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kjh', '1177', '������', '8111111111111', '����� ������', '64245', '01011111177', 'kjihoon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjs', '1188', '������', '7711111111111', '����� ��걸', '56378', '01011111188', 'cowjis@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('skj', '1199', '������', '9311111111111', '����� ���빮��', '35424', '01011111199', 'westliver@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('yjk', '1233', '������', '9711111111111', '����� ���빮��', '86543', '01011112211', 'jinggu@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kms', '2546', '��μ�', '9011111111111', '����� �����', '64785', '01011112233', 'minseok@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jyh', '7543', '����ȣ', '8611111111111', '����� ���ϱ�', '12576', '01011112244', 'passionjyh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hmh', '7553', 'Ȳ����', '9511111111111', '����� ����', '52158', '01011112255', 'hwngje@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pjh', '4676', '������', '9911111111111', '����� ���۱�', '76355', '01011112266', 'winkjh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pcy', '4673', '������', '9211111111111', '����� ���ϱ�', '35468', '01011112277', 'real_pcy@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hsw', '3464', '�ϼ���', '9411111111111', '����� ���ı�', '21348', '01011112288', 'hacloud@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kmj', '9774', '�����', '0111111111111', '����� ������', '18576', '01011112299', 'miguri@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kjh', '6845', '����ȣ', '9711111111111', '����� ���ı�', '34185', '01011113311', 'kingjiho@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ayj', '6545', '������', '0311111111111', '����� �����', '67523', '01011113322', 'anujin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kty', '5415', '���¿�', '8911111111111', '����� ������', '37586', '01011113355', 'tangtang@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kyr', '5638', '������', '8911111111111', '����� ���ϱ�', '16854', '01011113366', 'yulyuri@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lya', '5241', '������', '9011111111111', '����� �߶���', '81385', '01011113377', 'yoona@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('csy', '5447', '�ּ���', '8911111111111', '����� ������', '33153', '01011113388', 'choiswim@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khy', '2148', '��ȿ��', '8911111111111', '����� ���۱�', '53158', '01011113399', 'hyoyeon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjh', '3541', '������', '9111111111111', '����� ���α�', '56905', '01011115511', 'westjh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lsg', '3267', '�̼���', '8911111111111', '����� ������', '31058', '01011115522', 'leesgu@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hmy', '1206', 'Ȳ�̿�', '8911111111111', '����� ��õ��', '63410', '01011115533', 'stafanih@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khn', '1024', '���ϴ�', '8911111111111', '����� ���빮��', '35740', '01011115544', 'kangsky@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khj', '5855', '��ȿ��', '8011111111111', '����� �߱�', '50576', '01011115566', 'ballhj@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lmh', '3212', '�̹�ȣ', '8711111111111', '����� ���빮��', '07645', '01011115577', 'leemh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('psh', '7832', '�ڽ���', '9011111111111', '����� ���ϱ�', '63205', '01011115588', 'parksh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ljs', '8723', '������', '8911111111111', '����� ����', '86405', '01011115599', 'leebells@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kwb', '5436', '����', '8911111111111', '����� ������', '94520', '01011116611', 'cowbean@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sma', '8652', '�Źξ�', '8411111111111', '����� ���Ǳ�', '34210', '01011116622', 'godma@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('bsj', '7514', '�����', '9411111111111', '����� ��õ��', '67520', '01011116633', 'boatsj@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kms', '8527', '�����', '9211111111111', '����� ����', '50864', '01011116655', 'myungs@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('shs', '3748',  '������', '8911111111111', '����� ��걸', '64105', '01011117788', 'godhs@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ppg', '4162', '�ں���', '9311111111111', '����� ���ı�', '46876', '01011118956', 'bogummy@naver.com');

commit;


delete from Facilities where fac_name is null;
select * from Facilities;




 create or replace procedure proc_rentaldelayed
    is
    
    begin
    
     for delayedlist in (select * from rental where rent_enddate<sysdate) loop -- å �ݳ����ѻ����
    update member set deadline_rent_stop=nvl(deadline_rent_stop,sysdate)+1 where mem_id=delayedlist.mem_id;
    
    end loop;
     end; 
     /
     exec proc_rentaldelayed();
     exec proc_deadlinecheck();
     select * from rental;
     select     * from member;
     
     commit;
     
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
     
     
    ALTER table member add(DEADLINE_RENT_STOP date,book_loanable varchar2(20) default '���Ⱑ��');
     select * from member;
    update member set deadline_rent_stop=deadline_rent_stop+1 where mem_id='nmj';
    
    
    create or replace procedure proc_pipa(pipa out sys_refcursor)
    is
    
    begin
        open pipa  for  select * from test2 ;
    end;
    /
    
    create or replace procedure proc_pipa_proc
    is
    hoijja sys_refcursor;
    hohoho test2%rowtype;
    begin 
       
    proc_pipa(hoijja);
    loop
   fetch   hoijja into hohoho;
    exit when hoijja%notfound;
      DBMS_OUTPUT.PUT_LINE('�μ��� : '||hohoho.dd2 );
     --   insert into test2(dd,dd2) values(1||hohoho.dd  ,  1||hohoho.dd2);
    end loop;
    
    close hoijja;
      
    end;
    /
    
  
    commit;
   exec  proc_pipa_proc();
   
    set serveroutput on;
    select count(*) from test2 ;
    
    
    select * from test2;
    drop table test2;
    
    
    create table test2(
    namename varchar2(30) not null
   ,namename2 number 
    );
    drop table test2;    
    insert into test2 values('a',1);
    insert into test2 values('b',2);
    insert into test2 values('c',3);
    
    select * from test2 order by namename desc;

drop index index_test2test2;
drop table test2;
CREATE INDEX index_test2test2 ON test2 (namename desc);
select * from test2;

-- not null�̰ų� , index �÷��� pk�� ������  where�� ���  index�� ź��.


select /*+INDEX_desc(test2 index_test2test2)  */ namename,namename2 from test2;
select /*+INDEX_asc(test2 index_test2test2)  */ namename,namename2 from test2;
select * from test2;


select /*+INDEX_asc(test2 index_test2test2)  */ * from test2 where 'a'<namename;
select * from test2;


select * from test2;


select * from reservation;
--������ ����� 0 ���� �ٲ� 
select * from reservation;
select * from rental;
-- rental ����� ����������� �ٲ� 

-- 
select * from rental;
select * from book;


select * from (select b.*, nvl(r.rent_status,'�뿩����') rent from 
(select * from book order by book_num desc) b join (select book_num, rent_status from rental where rent_startdate in 
(select max(rent_startdate) 
from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��') r on (b.book_num = r.book_num));

select * from ( select rownum rnum, b.*, nvl2(rent_status,'�뿩����','�뿩����') rent from 
(select * from book where book_num = 100001) b left outer join 
(select book_num, rent_status from rental where   rent_startdate in 
(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
(b.book_num = r.book_num)) ;
select * from rental;





select * from ( select rownum rnum, b.*, nvl2(rent_status,'�뿩����','�뿩����') rent from 
(select * from book where book_num = 100001) b left outer join 
(select book_num, rent_status from rental where   rent_startdate in 
(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
(b.book_num = r.book_num)) ;

select * from ( select rownum rnum, b.*,(case when r.rent_status='�ݳ�' then '�뿩����'
                                                     when r.rent_status is null then '�뿩����'
                            else '�뿩��' end)  rent from 
													(select * from book where book_num = 100001) b left outer join 
																							(select book_num, rent_status from rental where   rent_startdate in 
																							(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
																							(b.book_num = r.book_num)) ;l
       
        select * from
          ( select rownum rnum, b.*, nvl(rent_status,'�뿩����') rent
                  from  (select * from book where book_num = #{ book_num }) b
                  left outer join (select book_num, rent_status from rental
                                  where rent_startdate in (select max(rent_startdate) from rental  group by book_num) 
                                  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
                  on (b.book_num = r.book_num));
                  
       
 select * from
          ( select rownum rnum, b.*, (case when r.rent_status='�ݳ�' then '�뿩����'
                                                     when r.rent_status is null then '�뿩����'
                                                     when r.rent_status ='������' then '������' 
                            else '�뿩��' end) rent
                  from  (select * from book where book_num = 100001) b
                  left outer join (select book_num, rent_status from rental
                                  where rent_startdate in (select max(rent_startdate) from rental  group by book_num) 
                                  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
                  on (b.book_num = r.book_num))
;
select * from member;
select * from (select b.*, nvl(r.rent_status,'�뿩����') rent ,rent_num  from (select * from book order by book_num desc) b join (select book_num, rent_status ,rent_num from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��' or rent_status='������') r on (b.book_num = r.book_num)) ;
commit;
select * from
select * from rental;
select * from rental;
select * from (select b.*, nvl(r.rent_status,'�뿩����') rent from (select * from book order by book_num desc) b join (select book_num, rent_status from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��' or rent_status='������') r on (b.book_num = r.book_num)) ;
 insert into rental values((select nvl(max(rent_num)+1,1) from rental), 100001, 'nmj', sysdate, sysdate+7, 'X', 'X', '������');
 select * from rental
 select * from reservation;
 select * from reservation,rental;
 select count(*) from reservation where book_num =100001;
 
 
 
 select * from (select b.*, nvl(r.rent_status,'�뿩����') rent,mem_id from (select * from book order by book_num desc) b join (select book_num, rent_status,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and  rental.mem_id ='nmj') ) r on (b.book_num = r.book_num))
; 
 select * from reservation;
 select * from rental;
 
 
 --�����߱���
 desc reservation;
 insert into reservation values(#{book_num}, #{mem_id},(select count(*) from reservation where book_num=#{book_num})+1 );
 select * from rental,(select count(*) from test22)  ;
 select b.*,aa from book b  inner join (select count(*) over(partition by(rental.book_num)) aa,book_num from rental )rental on b.book_num=rental.book_num;
 select * from reservation where book_num=100001;
 --�뿩�� or ������  --�����ѻ���� �ڽ��̸� ���Ⱑ������ üũ 
 
 -- ���� �����ϴ»���� 5���� �Ѱų� �����ߴµ� �� �����ҷ����ϸ� �̹� �������Դϴ�.��� �ϱ� 
 
 --������ҵ� ���߿� ����.
 

 --�������1������ �������ִ����ʰ��Ǹ� rental�� �Ѿ��. �������1���� ������.
 
 --insert into reservation values(book_num,mem_id,(select count(*) from reservation where book_num=#{book_num{);
 
 
 select * from test22;
 select * from reservation;
 
 --selectkey�� �̿��ؼ� ���� before�� ���� �˾Ƴ��� ������� 0 �̸� ������Ʈ�ȵƴٴ��ǹ̴ϱ� ����Ұ�.
 commit;
 rent_num, mem_id, rsrv_num=1
 select * from test22;
 select * from( select *  from rental r,test22);
 select * from reservation;
 insert into rental values((select nvl(max(rent_num)+1,1) from rental), 100001, 'nmj', sysdate, sysdate+2, 'X', 'X', '������');
 
 
 
 insert into test22 values(3333333333333333);
 select * from test22;
 
 
 
 
 CREATE OR REPLACE TRIGGER triger_test_test_test_test_test_test_test
       after
       insert ON rental
       FOR EACH ROW
	   
	   BEGIN
       if :new.namename=3 then 
       DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.namename);
       else
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.namename);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.namename);
        end if;
     END;
     /
     drop trigger TEST_TEST_TEST_TEST_TEST;
     commit;
     select * from dept;
     select * from test22;
     
     create table test22(
     namename number );
     /
     set serveroutput on;
     insert into test22 values(1);
     
     update test22 set namename=1;
     
  select * from
         (select  b.*, nvl(r.rent_status,'�뿩����') rent,rent_num,mem_id
                 from  (select * from book order by book_num desc) b
                join  (select book_num, rent_status ,rent_num,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num)  and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and rental.mem_id ='nmj') ) r
                   on (b.book_num = r.book_num))  ;
     
     
select * from member;
select * from reservation;

select * from rental;

;
drop table reservation;
select * from test22;



commit;
select * from reservation;
  select * from
          ( select rownum rnum, b.*, (case when r.rent_status='�ݳ�' then '�뿩����'
                                                     when r.rent_status is null then '�뿩����'
                                                     when r.rent_status ='������' then '������' 
                            else '�뿩��' end) rent, nvl(rscount,0) reservationcount
                  from  (select * from book where book_num =100001) b
                  left outer join (select book_num, rent_status from rental
                                  where rent_startdate in (select max(rent_startdate) from rental  group by book_num) 
                                  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
                  on (b.book_num = r.book_num) left outer join (select  count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn   on rsvn.book_num=r.book_num    );
 
 
                  
                  select * from reservation;
--å �ݳ� ����1�� ��Ż�� �� �ѱ� �̋� ��Ż�� ���ܵѰ��ΰ�? 

select * from rental join reservation on rental.mem_id=reservation.mem_id where rental.mem_id='nmj';

select a.*,count(b.book_num) over() from member a join  reservation b on a.mem_id=b.mem_id     where a.mem_id='nmj';
select a.*,ct from member a join  (select count(*) ct,mem_id from reservation where mem_id='nmj' group by mem_id) b on a.mem_id=b.mem_id     where a.mem_id='nmj';
  select * from
         (select  b.*, nvl(r.rent_status,'�뿩����') rent,rent_num,mem_id ,rscount
                 from  (select * from book order by book_num desc) b
                join  (select book_num, rent_status ,rent_num,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num)  and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and rental.mem_id ='nmj') ) r
                   on (b.book_num = r.book_num) 
                   left outer join (select  count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn   on rsvn.book_num=r.book_num )       
  
  
 --ȸ���˻�����
 select mem_id,mem_name,mem_phone,mem_address,mem_email,mem_rank,book_loanable, to_char(deadline_rent_stop,'yyyymmdd')  deadline_rent_stop  ,
                                                                case when deadline_rent_stop>sysdate and book_loanable='���Ⱑ��' then 0
                                                                else
                                                                      case when mem_rank=2 then 7  -- ����Ұ� �Ǵ�
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end
                                                                end      TotalLoanable_Number,
                                                                case when deadline_rent_stop>sysdate and book_loanable='���Ⱑ��' then 0
                                                                else       
                                                                      case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end    -(select count(*) from rental where mem_id='nmj' and rent_status='�뿩��')
                                                                end     CurrentLoanable_Number from member where mem_id like '%nmj';
                                                               



select * from ( select rownum rnum, b.*, 
(case when r.rent_status='�ݳ�' then '�뿩����' when r.rent_status is null then '�뿩����' when r.rent_status ='������' then '������' else '�뿩��' end) rent,
nvl(rscount,0) reservationcount from (select * from book where book_num =100001) b 
left outer join (select book_num, rent_status from rental where rent_startdate in 
(select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on 
(b.book_num = r.book_num) 
left outer join (select count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn on rsvn.book_num=r.book_num ) ;                               
select * from rental;

create or replace trigger test_test_test_test_test
after update on rental
for each row 
when ( new.rent_status = '�ݳ�')
declare
counting number;

begin
    select count(*) into counting from reservation where book_num=:new.book_num and rsrv_num=1;
    if counting=1 then 
    insert into rental values(
    
            DBMS_OUTPUT.PUT_LINE('d');
         
   
end;
/
select * from rental;
 
 select * from rental;
 
 select * from test22;
 
 
 
 update test22 set namename=2 where namename=2;
 drop trigger test_test_test_test_test333;
 create or replace trigger test_test_test_test_test333
after update on test22
for each row 
when ( new.namename = 2)
declare
counting number;

begin
   -- select count(*) into counting from reservation where book_num=:new.book_num and rsrv_num=1;
        insert into test222 values(3);
        insert into test222 values(4);
            DBMS_OUTPUT.PUT_LINE('d');
         
   
end;
/
create or replace trigger tri_testtri_testtri_testtri_testtri_testtri_testtri_testtri_test
after insert on test222
for each row
when (new.name222=3)
begin

    insert into test22 values(878787);
end;
/
/
select * from dual;
select * from test222;
create table test222(
name222 number);




commit;
select * from rental;
select * from reservation;
insert into rental values(1,100002,'nmj',null,null,'X','X','������');
insert into reservation values(100002,'nmj',1,sysdate+2); --�������1���ϋ� reservation�� rental ���ÿ� ����� 1.   rental���� �����2. �����ؾ��Ұ�. reservation�� �ȳ���Ÿ� enddate���̺� �ʿ����

--�����Ѱͺ��� ������  ����  -- ���� X�ϋ� O�� �ٲٰ� sysdate + 7 ���ٰ�.
--,������              --  �����ڼ��� 5���̻��Ͻ� ���̻� ������ϰ��Ұ�. 
                       --���� rsrvcount��� ���� �÷����� �����ڼ��� ��������. 
 select * from reservation;
 --�����ҷ���å�� �̹� �����ϰ��ִ°��� �ƴ���.
 select count(*) from reservation where rsrv_num >0 and book_num=100001;
 --���� 0�� �ʰ��ϸ� �̹� �����ߴٴ� ���̴� ����Ұ� 
 
 
 --�ݳ������� ����1��-> insert into ������ and update 
 
 --
 
 --
 
 
 select * from rental;
 --������å
 insert  into reservation(book_num,mem_id,rsrv_num) values(100001,'nmj',(select count(rsrv_num)+1 from reservation where book_num=100001));
--�ݳ��ҋ� �����ѻ�� insert��Ű�� �ش�å 1�� delete�Ұ�. 
--�ش�å �����ڼ����Ұ�.
 select count(*) from reservation where rsrv_num >0 and book_num=100001; --�̰��� 0�� �ʰ��ϸ� 
 --selectkey�� rsrv_num=1�������� 
 --rsrv_num=1 reservation ����
 --rsrv_num +2���� 1�� �����.
 
 
 select * from reservation;
 declare
 hohohoho varchar2(30);
 begin
    select mem_id into hohohoho from reservation where book_num=100002 and rsrv_num=1;
  DBMS_OUTPUT.PUT_LINE('dd'||hohohoho);
 
 end;
 /
 set serveroutput on;
 --notnull Ȯ��
 
 select * from reservation;
 select * from rental;
 desc reservation;
 insert into reservation values(100001,'byw',2,null);
 
 select * from rental;
 exec proc_returnbook(100001);
 
 --�ݳ������� �����ڸ� rental ���̺��� insert���Ŀ� reservation������� �����ϳ��� ����Ը���� �������ڰ� ������ �׳� �ݳ��� �ǰ� �����.
 --���� �����ð� �������ڰ� ����������ÿ� Ŀ���� ��� �̾Ƴ��� �Ʒ��� procedure�� �����Ű�� ��.
 declare
 
 begin 
  if 5<6 and 7<8 then   DBMS_OUTPUT.PUT_LINE('�μ��� : ');
  end if;
 
 end ;
 /
 set serveroutput on;
 
select * from reservation where book_num=100002 and rsrv_num>0 order by rsrv_num;
 create or replace procedure proc_returnbook(p_book_num in number)
 is
 updatecount number; -- for�� count���� 
 reservationcount number; --�ݳ��Ǵ�å�� �����ڼ� 
 begin
 updatecount:=0;

    update rental set rent_enddate = sysdate, rent_status = '�ݳ�' where book_num =  p_book_num;
    
    select count(*) into reservationcount from reservation where book_num=p_book_num and rsrv_num>0;
    if reservationcount>0 then 
    
    for temp_cursor in (select * from reservation where book_num=p_book_num and rsrv_num>0)
    loop
        if updatecount=0 then 
        insert into rental values((select nvl(max(rent_num)+1,1) from rental),  p_book_num, temp_cursor.mem_id, sysdate, sysdate+2, 'X', 'X', '������');
        update reservation set rsrv_num=0 where book_num=p_book_num and rsrv_num=temp_cursor.rsrv_num;
        else
        --ù������ ī��Ʈ 0�̴� ������ ���� �״��� 1���ʹ� �� ���� ����
        update reservation set rsrv_num=updatecount where rsrv_num=temp_cursor.rsrv_num and book_num=p_book_num;
        end if;
    
    updatecount:=updatecount+1;
    end loop;
    end if;
 
 end;
 /
 
 -- �ݳ��ҋ� �Ʒ��� ������Ʈ������ �ٲٱ�.
 select * from rental where book_num=100003 and rent_num=(select max(rent_num) from rental where book_num=100003);
 
 
 select * from rental;
 desc rental;
                       
--��ĥ�� rentbookcheck�� rentmembookcheck�� ����.


desc rental;
select * from rental;
  insert into rental values((select nvl(max(rent_num)+1,1) from rental),  100010, 'nmj', sysdate-4, sysdate-2, 'X', 'X', '������');
--���� �����ð��� �����ߴµ� �Ⱥ���������� �ݳ�ó�����Ŀ� ������������ ����ó���ϱ�.

create or replace procedure proc_reservation(p_book_num in number)
 is
 updatecount number;
 reservationcount number;
 begin
 updatecount:=0;

    update rental set rent_enddate = sysdate, rent_status = '�ݳ�' where book_num =  p_book_num;
    
    select count(*) into reservationcount from reservation where book_num=p_book_num and rsrv_num>0;
    if reservationcount>0 then 
    
    for temp_cursor in (select * from reservation where book_num=p_book_num and rsrv_num>0)
    loop
        if updatecount=0 then 
        insert into rental values((select nvl(max(rent_num)+1,1) from rental),  p_book_num, temp_cursor.mem_id, sysdate, sysdate+2, 'X', 'X', '������');
        update reservation set rsrv_num=0 where book_num=p_book_num and rsrv_num=temp_cursor.rsrv_num;
        else
        --ù��?�� ī��Ʈ 0�̴� ������ ���� �״��� 1���ʹ� �� ���� ����
        update reservation set rsrv_num=updatecount where rsrv_num=temp_cursor.rsrv_num and book_num=p_book_num;
        end if;
    
    updatecount:=updatecount+1;
    end loop;
    end if;
    commit;
    exception when others then rollback;
 
 end;
 /
create or replace procedure proc_rentservation_auto_return
is

begin
   --�������ߴµ� �����Ⱓ���� �Ⱥ���������� ������ ������Ŀ���� ����
  for returnlist in (select * from rental where rent_status='������' and rent_enddate<sysdate)
  loop
  
  proc_reservation(returnlist.book_num);
  
  end loop;
end;
/
exec proc_rentservationautoreturn();
select * from rental;

--������������ �ø��� ,������������ Ǯ���ֱ� ���� ¥��  ���Ŀ� ����ä���ֱ�

select * from member;
select * from rental;
create or replace procedure proc_rentstop
is

begin
 -- �ݳ����ѻ�� üũ�� �ٽ� ���̵�� �˻��Ұ��ΰ�  �ƴϸ� ���ν��� ���� ������ϰ� ó���Ұ��ΰ�. �׳� ���̵� ������ϰ� �߰���Ű��.
    for temp_cursor in (select * from rental where rent_status='�뿩��' and rent_enddate<sysdate)
    loop
  update  member set deadline_rent_stop=case when deadline_rent_stop is null then sysdate+1 
                                when deadline_rent_stop<sysdate then sysdate+1
                                else deadline_rent_stop+1
                                end,book_loanable='����Ұ�',mem_rank=0 where mem_id=temp_cursor.mem_id;
 
    end loop;
end;
/

create table testdate(
testdate date,
hohoho number
);
drop table testdate;
insert into testdate values(null,1);
update testdate set testdate=case when testdate is null then sysdate+1 
                                when testdate<sysdate then sysdate+1
                                else testdate+1
                                end,hohoho=3;
select * from testdate;
update testdate set testdate= sysdate-100;


--������������ Ǯ������� ��� 

select * from member;
create or replace  procedure proc_rent_available
is

begin
    for temp_cursor in (select * from member where deadline_rent_stop<sysdate and book_loanable='����Ұ�')
    loop
    update member set book_loanable='���Ⱑ��' where mem_id=temp_cursor.mem_id;
    
    end loop;


end;
/




select rent_extension from rental;    
  select * from
         (select  b.*, nvl(r.rent_status,'�뿩����') rent,rent_num,mem_id, nvl(rscount,0) reservationcount,rent_extension
                 from  (select * from book order by book_num desc) b
                join  (select book_num, rent_status ,rent_num,mem_id,rent_extension from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num)  and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and rental.mem_id ='nmj') ) r
                   on (b.book_num = r.book_num) 
                   left outer join (select  count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn   on rsvn.book_num=r.book_num )  ;
                   
select * from member;  
select * from rental;



   update rental set rent_enddate=rent_enddate+7 where rent_num=(select max(rent_num) from rental where book_num=100003); 
update rental set rent_enddate=rent_enddate+7 where rent_num=(select max(rent_num) from rental where book_num=100003); 
update rental set rent_enddate=rent_enddate+7 where rent_num=(select max(rent_num) from rental where book_num=100003);


select * from reservation;

delete from reservation;
commit;

 select count(*) from (select * from rental where rent_status='�뿩��' and mem_id='nmj' and book_num=100004) rental
 
 
        left outer join (select * from reservation where book_num=100004 and rsrv_num>0 and mem_id='nmj')reservation on rental.mem_id=reservation.mem_id;
   													
                                                select * from reservation;
select * from reservation inner join (select mem_id,book_num from rental where rent_status='�뿩��')rental on rental.mem_id=reservation.mem_id where rental.book_num=100002 and rsrv_num>0 and rental.mem_id='nmj' ;
select count(*) from reservation where book_num=100002 and rsrv_num>0;
select count(*) from reservation where book_num=100002 and rsrv_num>0;
select * from  rental;
--������å�� 
select * from (select b.*, nvl(r.rent_status,'�뿩����') rent,rent_num,mem_id, nvl(rscount,0) reservationcount,rent_extension,rent_enddate 
from (select * from book order by book_num desc) b join (select book_num, rent_status ,rent_num,mem_id ,case when rent_extension='X' then '���尡��' else '����Ұ�' end rent_extension ,
case when rent_status='�뿩��' or rent_status='������' then 
            to_char(rent_enddate) 
     else null
end rent_enddate 


from rental where rent_startdate in 
(select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and rental.mem_id ='nmj') ) r on (b.book_num = r.book_num) left outer join (select count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn on rsvn.book_num=r.book_num ) 
;

select * from ( select rownum rnum, b.*, (case when r.rent_status='�ݳ�' then '�뿩����' when r.rent_status is null then '�뿩����' 
                                               when r.rent_status ='������' then '������' else '�뿩��' end) rent, nvl(rscount,0) reservationcount,
                                                (case when r.rent_status='�ݳ�' then null 
                                               when r.rent_status='������'or r.rent_status='�뿩��' then to_char(r.rent_enddate)
                                               end) rent_enddate from 
                                                                     (select * from book where book_num =100001) b 
left outer join (select book_num, rent_status,rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on (b.book_num = r.book_num) left outer join (select count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn on rsvn.book_num=r.book_num );

select * from member;
select * from (select b.*, nvl(r.rent_status,'�뿩����') rent,rent_num,mem_id, nvl(rscount,0) reservationcount,rent_extension,rent_enddate from (select * from book order by book_num desc) b join (select book_num, rent_status ,rent_num,mem_id ,case when rent_extension='X' then '���尡��' else '����Ұ�' end rent_extension ,to_char(rent_enddate) rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '�뿩��' or (rent_status='������' and rental.mem_id ='nmj') ) r on (b.book_num = r.book_num) left outer join (select count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn on rsvn.book_num=r.book_num );


--�����ҋ� �����ڰ� ������ �ٷ� ���������� �ٲٰ� �ƴϸ� insert into �������� �ٲܰ�.

select rent_status from ( select r.*
                                from (select * from book where book_num =100001) b left outer join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on (b.book_num = r.book_num))  ;
create or replace procedure proc_reservationbook(p_mem_id in varchar2,
                                                 p_book_num in number)
is
check_rentstatus varchar2(20);

begin
--å�� ���°� �ݳ��̸� insert into ������~~~ 
select rent_status into check_rentstatus from ( select r.*
                                from (select * from book where book_num =p_book_num) b left outer join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on (b.book_num = r.book_num))  ;
                                --å�� ó�� 
    if check_rentstatus='�ݳ�' or check_rentstatus is null then
            insert into rental values((select nvl(max(rent_num)+1,1) from rental),  p_book_num, p_mem_id, sysdate, sysdate+2, 'X', 'X', '������');
   else
             insert  into reservation(book_num,mem_id,rsrv_num) values(p_book_num,p_mem_id,(select count(rsrv_num)+1 from reservation where book_num=p_mem_id));
    end if;
--�ݳ��� �ƴϸ� insert into reservation+1
   
    --�����߻��� �ѹ�
    exception when others then
    
    rollback;
end;
/
exec proc_reservationbook('nmj',11);
set serveroutput on;

 select * from rental;  
 select * from reservation;
 select * from ( select rownum rnum, b.*, (case when r.rent_status='�ݳ�' then '�뿩����' when r.rent_status is null then '�뿩����' when r.rent_status ='������' then '������' else '�뿩��' end) rent, nvl(rscount,0) reservationcount, (case when r.rent_status='�ݳ�' then null when r.rent_status='������'or r.rent_status='�뿩��' then to_char(r.rent_enddate) end) rent_enddate,mem_id from (select * from book where book_num =100002) b left outer join (select book_num, rent_status,rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rent_num in (select max(rent_num) from rental group by book_num) ) r on (b.book_num = r.book_num) left outer join (select count(*) over(partition by(book_num) ) rscount, book_num from reservation) rsvn on rsvn.book_num=r.book_num );
