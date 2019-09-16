
--�ŷ� ��� ���̺�
----------------
drop table trarep;
create table trarep(
    trarep_num number , -- ��ȣPK
    trarep_tranum number , -- �����Խ��� ��ȣFK
    trarep_date date default sysdate, -- �ۼ���¥
    trarep_contents varchar2(4000), -- ����
    trarep_writer varchar2(120) , -- ���̵�FK
    trarep_writerrep number , -- �θ��ۼ��� ��ȣ
    
    trarep_alive number default 0, -- ��������
    trarep_numref number, -- ���� ����
    trarep_numref_lv number -- ���� ����
);
insert into trarep(trarep_num,trarep_tranum,trarep_date,trarep_contents,trarep_writer,trarep_writerrep,trarep_alive,
trarep_numref,trarep_numref_lv) values(1,1,sysdate,'�ȳ�','qdw',1,0,0,0);  --ù ���
rollback;

insert into trarep(trarep_num,trarep_tranum,trarep_date,trarep_contents,trarep_writer,trarep_writerrep,trarep_alive,
trarep_numref,trarep_numref_lv) values(5,1,sysdate,'�ȳ�','ù����',2,0,1,3);
select*from trarep;
                                                --�۹�ȣ                                       --��������        --����
select *from trarep where trarep_tranum=1 START WITH trarep_writerrep = 0 connect by prior trarep_num=trarep_writerrep order siblings by trarep_num desc;

select *from trarep where  trarep_tranum=1 order by trarep_writerrep desc, trarep_numref asc ,trarep_numref_lv asc;


qarep_num number constraint qarep_num_pk primary key, -- ��ȣPK
    qarep_qanum number constraint qarep_qanum_fk references qa(qa_num), -- �����Խ��� ��ȣFK
    qarep_date date default sysdate, -- �ۼ���¥
    qarep_contents varchar2(4000), -- ����
    qarep_writer varchar2(120) constraint qarep_writer_fk references mem(mem_id), -- ���̵�FK
    qarep_writerrep number constraint qarep_writerrep_fk references qa(qa_num), -- �θ��ۼ��� ��ȣ 
    qarep_alive number default 0, -- ��������
    qarep_numref number, -- ���� ����
    qarep_numref_lv number -- ���� ����
);
trarep_num number , -- ��ȣPK
    trarep_tranum number , -- �����Խ��� ��ȣFK
    trarep_date date default sysdate, -- �ۼ���¥
    trarep_contents varchar2(4000), -- ����
    trarep_writer varchar2(120) , -- ���̵�FK
    trarep_writerrep number , -- �θ��ۼ��� ��ȣ
    
    trarep_alive number default 0, -- ��������
    trarep_numref number, -- ���� ����
    trarep_numref_lv number -- ���� ����
commit;
insert into trarep(trarep_num,trarep_tranum,trarep_contents,trarep_writer,trarep_writerrep,trarep_numref,trarep_numref_lv) values(1,1,'1','���̵�',1,1,1);
select* from trarep;
select count(*) from trarep where trarep_tranum=1 ;
desc trarep;

select * from trarep;
select count(*) from trarep where trarep_writerrep=2 and trarep_numref=1;

create table mem(
    mem_id varchar2(40) constraint mem_id_pk primary key, -- ���̵�
    mem_pwd varchar2(32) not null, -- ��й�ȣ
    mem_ph varchar2(32), -- ��ȭ��ȣ
    mem_name varchar2(120), -- �̸�   
    mem_addr varchar2(200), -- �ּ�
    mem_filename varchar2(520), -- �����̸�
    mem_point number default 100, -- ����Ʈ
    mem_alive number default 0, -- Ż������
    mem_cdate date default sysdate, -- ���Գ�¥
    mem_ddate date -- Ż��¥
);















create table tra(
    tra_num number , -- ��ȣPK
    tra_subject varchar2(300), -- ����
    tra_readcount number, -- ��ȸ��
    tra_date date default sysdate, -- �ۼ���¥
    tra_writer varchar2(120) , -- ���̵�FK
    tra_filename varchar2(520), -- �����̸�
    tra_contents varchar2(4000), -- ����
    tra_alive number, -- ��������
    tra_head varchar2(9) -- ��ϴ�,�˴ϴ�
);
update tra set tra_subject='dd',tra_contents='dddd',tra_filename='dddd' where tra_num=1;
commit;
update tra set tra_readcount=tra_readcount+1 where tra_num=1;
select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
    tra_head from(select * from tra order by tra_num desc))where 0<rnum ; 
    
    select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
    tra_head from(select * from tra where tra_subject='22' order by tra_num desc))where 0<rnum ;

order by tra_num desc;
select * from tra;
insert into tra(tra_num,tra_subject,tra_readcount,tra_writer,tra_filename,tra_contents,tra_alive,tra_head) 
values(2,'22',1,'���̵�','�̸�','����',0,'��');
select * from tra;



select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,tra_head from(select * from tra order by tra_num desc))where 5>=rnum and rnum>=0;

select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
	                		   tra_head from(select * from tra order by tra_num desc))where 100>=rnum and rnum>=0;
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,     tra_head from(select * from tra  order by tra_num desc))where 5>=rnum and rnum>=0