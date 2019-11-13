------------
--ȸ�� ���̺�
------------
create table mem(
    mem_id varchar2(40) constraint mem_id_pk primary key, -- ���̵�
    mem_pwd varchar2(32) not null, -- ��й�ȣ
    mem_ph varchar2(32), -- ��ȭ��ȣ
    mem_name varchar2(120), -- �̸�   
    mem_addr varchar2(200), -- �ּ�
    mem_filename varchar2(520), -- �����̸�
    mem_point number default 100, -- ����Ʈ
    mem_alive number default 1, -- Ż������(Ż��:0)
    mem_cdate date default sysdate, -- ���Գ�¥
    mem_ddate date -- Ż��¥
);

------------
--���� ���̺�
------------
create table qa(
    qa_num number constraint qa_num_pk primary key, -- ��ȣPK
    qa_subject varchar2(300), -- ����
    qa_readcount number, -- ��ȸ��
    qa_sysdate date default sysdate, -- �ۼ���¥
    qa_writer varchar2(120), -- ���̵�FK
    qa_filename varchar2(520), -- �����̸�
    qa_contents varchar2(4000), -- ����
    qa_alive number default 0-- ��������
);

----------------
--���� ��� ���̺�
----------------
create table qarep(
    qarep_num number constraint qarep_num_pk primary key, -- ��ȣPK
    qarep_qanum number constraint qarep_qanum_fk references qa(qa_num), -- �����Խ��� ��ȣFK
    qarep_date date default sysdate, -- �ۼ���¥
    qarep_contents varchar2(4000), -- ����
    qarep_writer varchar2(120) constraint qarep_writer_fk references mem(mem_id), -- ���̵�FK
    qarep_writerrep number constraint qarep_writerrep_fk references qa(qa_num), -- �θ��ۼ��� ��ȣ 
    qarep_alive number default 0, -- ��������
    qarep_numref number, -- ���� ����
    qarep_numref_lv number, -- ���� ����
    qarep_writerrepwriter varchar2(40) -- ������ �������� �����ϴ� �÷�.
);

------------
--�ŷ� ���̺�
------------
create table tra(
    tra_num number constraint tra_num_pk primary key, -- ��ȣPK
    tra_subject varchar2(300), -- ����
    tra_readcount number, -- ��ȸ��
    tra_sysdate date default sysdate, -- �ۼ���¥
    tra_writer varchar2(120), -- ���̵�FK
    tra_filename varchar2(520), -- �����̸�
    tra_contents varchar2(4000), -- ����
    tra_alive number, -- ��������
    tra_head varchar2(9) -- ��ϴ�,�˴ϴ�
);

----------------
--�ŷ� ��� ���̺�
----------------
create table trarep(
    trarep_num number constraint trarep_num_pk primary key, -- ��ȣPK
    trarep_tranum number constraint trarep_tranum_fk references tra(tra_num), -- �����Խ��� ��ȣFK
    trarep_date date default sysdate, -- �ۼ���¥
    trarep_contents varchar2(4000), -- ����
    trarep_writer varchar2(120), -- ���̵�FK
    trarep_writerrep number , -- �θ��ۼ��� ��ȣ
    trarep_alive number default 0, -- ��������
    trarep_numref number, -- ���� ����
    trarep_numref_lv number, -- ���� ����
    trarep_writerrepwriter varchar2(40) -- ������ �������� �����ϴ� �÷�
);

-----------------
--�����̸� ���̺�
-----------------
create table regName(
    regName varchar2(120) constraint regName_pk primary key, -- �����̸�PK
    regNameEng varchar2(50),
    regGmt varchar2(20),
    regflight number
);

-----------------
--���� ���̺�
-----------------
create table reg(
    reg_num number constraint reg_num_pk primary key, -- ��ȣPK
    reg_name varchar2(120) constraint reg_reg_Name_fk references regName(regName), -- �����̸�
    reg_subject varchar2(300), -- ����
    reg_contents varchar2(4000), -- ����
    reg_filename varchar2(520) -- �����̸�
);
CREATE SEQUENCE reg_num;

------------
--���� ���̺�
------------
create table loc(
    loc_name varchar2(120) constraint loc_name_pk primary key, -- �����̸�
    loc_contents varchar2(4000), -- ����
    loc_filename varchar2(520), -- �����̸�
    loc_regname varchar2(120) constraint loc_regname_fk references regName(regName), -- �����̸�FK
    loc_writer varchar2(120) constraint loc_writer_fk references mem(mem_id) -- �ۼ���FK
);

------------
--���� ���̺�
------------
create table rev(
    rev_num number constraint rev_num_pk primary key, -- ��ȣPK
    rev_date date default sysdate, -- �ۼ���¥
    rev_writer varchar2(120) constraint rev_writer_fk references mem(mem_id), -- ���̵�FK
    rev_contents varchar2(4000), -- ����
    rev_alive number, -- ��������
    rev_score number, -- ����
    rev_locname varchar2(120) references loc(loc_name) -- �����̸�FK
);
CREATE SEQUENCE rev_num;

select * from mem;
insert into mem(mem_id, mem_pwd, mem_ph, mem_name, mem_addr, mem_filename, mem_point, mem_alive, mem_cdate, mem_ddate) 
values('���Թ�', '1111', '010-1111-1111', '���Թ�', '����', '����', 100, 1, '2019-08-07', null);
insert into mem(mem_id, mem_pwd, mem_ph, mem_name, mem_addr, mem_filename, mem_point, mem_alive, mem_cdate, mem_ddate) 
values('�輼��', '2222', '010-2222-2222', '�輼��', '����', '����', 100, 1, '2019-08-07', null);
insert into mem(mem_id, mem_pwd, mem_ph, mem_name, mem_addr, mem_filename, mem_point, mem_alive, mem_cdate, mem_ddate) 
values('��¼�', '3333', '010-3333-3333', '��¼�', '����', '����', 100, 1, '2019-08-07', null);
insert into mem(mem_id, mem_pwd, mem_ph, mem_name, mem_addr, mem_filename, mem_point, mem_alive, mem_cdate, mem_ddate) 
values('�ڿ���', '4444', '010-4444-4444', '�ڿ���', '����', '����', 100, 1, '2019-08-07', null);

insert into regname(regname, regNameEng, regGmt, regflight) values ('����', 'new york', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�Ͽ���', 'hawaii', '-10', 9);
insert into regname(regname, regNameEng, regGmt, regflight) values ('Ķ�����Ͼ�', 'califonia', '-8', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�������', 'Delaware', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��Ǻ��̴Ͼ�', 'Pennsylvania', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('������', 'New Jersey', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('������', 'Georgia', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ڳ�Ƽ��', 'Connecticut', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�Ż��߼���', 'Massachusetts', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�޸�����', 'Maryland', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��콺ĳ�Ѷ��̳�', 'South Carolina', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��������', 'New Hampshire', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�����Ͼ�', 'Virginia', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�뽺ĳ�Ѷ��̳�', 'North Carolina', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ε���Ϸ���', 'Rhode Island', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('����Ʈ', 'Vermont', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('����Ű', 'Kentucky', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�׳׽�', 'Tennessee', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�����̿�', 'Ohio', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�������ֳ�', 'Louisiana', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ε�ֳ�', 'Indiana', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�̽ý���', 'Mississippi', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ϸ�����', 'Illinois', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ٶ�踶', 'Alabama', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('����', 'Maine', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���ָ�', 'Missouri', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��ĭ��', 'Arkansas', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�̽ð�', 'Michigan', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�÷θ���', 'Florida', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ػ罺', 'Texas', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���̿���', 'Iowa', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�����ܽ�', 'Wisconsin', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�̳׼�Ÿ', 'Minnesota', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('������', 'Oregon', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('ĵ�ڽ�', 'Kansas', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('����Ʈ�����Ͼ�', 'West Virginia	', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�׹ٴ�', 'Nevada', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�׺귡��ī', 'Nebraska', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ݷζ�', 'Colorado', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�뽺����Ÿ', 'North Dakota', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��콺����Ÿ', '	South Dakota', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���³�', '	Montana', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('������', 'Washington', '-5', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���̴�ȣ', '	Idaho', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���̿���', 'Wyoming', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��Ÿ', 'Utah', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('��Ŭ��ȣ��', 'Oklahoma', '-6', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('���߽���', 'New Mexico', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�ָ�����', 'Arizona', '-7', 15);
insert into regname(regname, regNameEng, regGmt, regflight) values ('�˷���ī', 'Alaska', '-8', 15);

insert into reg(reg_num, reg_name, reg_subject, reg_contents, reg_filename) values(reg_num.NEXTVAL, '����', '����� ��ȭ', '�̱� �ִ��� �ױ� ����, �̱��� ��ǥ�ϴ� �뵵�� ����! �̱� ���� 13��State �� �ϳ��� ���忡 ���ϸ� ���� �ֿ� �����Ͽ� ���� ��New York City, NYC��� �θ���. 1524�� ��Ż������ ���ػ� �����ݴ� �����ڳ뿡 ���� ó�� �߰ߵ� ���� �̹��ڵ��� ���� �� ������ ���� ������ ������ �̷����. 1664�� ������ ���� ���ɵǸ� ��� ������ �� ���� 2���� ���� ��ũYork ������ ��ġ���� �Ѿ�� ����New York�̶�� �̸��� �����. �� ����Big Apple, ������ ����The Capital Of The World, ����� �ʴ� ����The City That Never Sleeps �� �پ��� ���� ������ �ִ� ��! 1790����� �̱��� ���������� ����� �̱����� �α��� ���� ���� �������� ���� ��ȭ�� ������ �߽�! ������ ������� ���� �ɸ°� �� ������ ����, ����, ��ȸ, ����, �̵��, ��� �� ������ �о��� ������� ���� ���̶� �ص� ������ �ƴϴ�. 1946�� ���� ����(UN)�� ���ΰ� �� ������ ������ ��ġ���� ����Ǵ� ���ð� �Ǿ���. ������ ���Ż��� ����Ͽ� �����̾� ������Ʈ ����, ��Ʈ�� ��ũ, ��Ʈ������ź �ڹ���, Ÿ�ӽ� ������ �� ������ �̸��� ������ �˸��� ������ ���� ��ũ�� ��ġ�ϰ� �ִ�. ������ ������ �����ڿ��� �� �� �� �湮�ϰ� ���� ����, ���� ���÷� ������ �ظ��� ��õ�� ���� �������� �����ϰ� �ִ�.', '����.jpg');
insert into reg(reg_num, reg_name, reg_subject, reg_contents, reg_filename) values(reg_num.NEXTVAL, '����', '����', '�뼭��� �ٷ� �̾����� ��彼 ���� ���� �־� ���ټ��� �پ ������ ������ Ȱ���� �̷���� ����. ���� ��ü ������ ����ư, ����ư ���Ϸ���, �� ���Ϸ��� �� ������ ���� ������ ���� �ô� �ٽ� �ټ� ���� ��ġ��Borough�� ������. ����ưManhattan, ���Ŭ��Brooklyn, ����Queens, ��ս� Bronx, ����ư ���Ϸ���Staten Island�� �̷���� ������ �� ��ġ���� Ư���� ���� �����ϰ� �ִ�.', '������ ���Ż�.jpg');
insert into reg(reg_num, reg_name, reg_subject, reg_contents, reg_filename) values(reg_num.NEXTVAL, '����', '������ ����', '������ ����� ���� �������� ��ü�� �츮 ����� ����ϸ� ��, ����, ����, �ܿ� ������� ��� �ִ�. �ٸ� �츮 ���� ���� ������ �ܿ��� �� �� �� ���̴�. Ư�� �ܿ��� ��������� ��� �������µ�, ���� ���� ���̷� �δ� �ٶ��� �������� ü�� ����� ���� ��º��� ����. �׷��� ������ �ܿ￡ ������ �湮�� ������ ���� �����ϰ� ���� �� ���Դ� ���� ��õ. 5�������� �߿� ����� �����ִ� ���� �����Ƿ� ��������. 
������ 7~8���� �ְ� ����� 30���� �����ϸ� 35������ ������ ���� ���� �ִ�. �뵵���θ�ŭ �Ÿ��� ��ũ��Ʈ�� ����� �� ������ ü������� ���� �ö󰣴�. ������ �츮 ���� ���� ������ ���� ���������� ���� ���� �޺��� �ش� �Ϳ� �źΰ��� ���ٸ� ���ƴٴϴ� ���� ũ�� �������� ���� �� �ִ�. ���� �ڿܼ� �������� �Ǻθ� ��ȣ�ϴ� ���� �ʼ�! ������ ���� �������� ������ ũ�� �ʴٴ� ���� Ư¡�̸� �帶�� ���� ������ ������ ���� ���� �ҳ��Ⱑ ������ ��찡 �ִ�. ������ ����� ���� ����� ���� ����� ì�� �ٴ���.', '����.jpg');
insert into reg(reg_num, reg_name, reg_subject, reg_contents, reg_filename) values(reg_num.NEXTVAL, '����', '���ϰ� ����', '������ �� ������ ������ ������ ���� ���� ������ �̱� ���� �����Ͽ��� ����. �������� �ָ��� ��� ��¥�� �Ű� ���ų� ������ ������ �ָ��̳� ���ʿ� ������ �ٿ� ���� Floationg Holiday�� �����ϴ� ��쵵 �ִ�. ���� ��� 7�� 4�� ���� ������� ������̸� �ݿ����� ����, �Ͽ����̸� �������� �����̴�. �̱� ���������� ��������ϰ� �߼�������, ��ź���� �������� ��Ը��� ������ ����ȴ�. Ư�� �������� ��� ���� ������ ������ �˸��� ��ȣź�̱⵵ �ϴ�. ', '�Ƶ�����.jpg');

insert into loc(loc_name, loc_contents, loc_filename, loc_regname, loc_writer) values('������ ���Ż�', '������� �������. ������ ���� �̱��� �ǹ��ϴ� ��¡���� ����Ƽ ���� ��ǳ����ϰ� ���ִ�. �̱� ���� 100�ֳ��� ����� ���������� ������ �־�����, �۰��� �������� �ٸ����, ����� ���� ž�� ������ �ͽ�Ÿ�� ������ �þҴ�. �����տ��� ȶ����, �޼տ��� �������𼭸� ��� �ִ� �� ������ ���ο��� ���������Ͱ�, �հ����� �����밡 ��ġ�Ǿ� ������, ��ħ�� ���� �ڹ������� ��ǰ� �ִ�. ���η� �� �� �ִ� �ο��� �ð��� ���ѵǰ� �ֱ� ������ ���������� �ʼ��̴�. �ּ� 2~3���� ���� ���ͳ� ������ ���ؼ��� ���η� �� �� �ִ�. �� ũ�Ⱑ ���� �� �ȿ����� ������ ����� ���� �� ������ �丮�� Ÿ�� �� �� �̸� ������.', '������ ���Ż�.jpg', '����', '���Թ�');
insert into loc(loc_name, loc_contents, loc_filename, loc_regname, loc_writer) values('Ÿ�ӽ�����', '���� ������ �ʼ� �������� ������ ���帶ũ! ���� Ÿ�ӽ� ���簡 �̰����� �����ϸ鼭 Ÿ�� �������� �̸��� ���� �ƴ�. �ﰢ�� ����� ���忡 ȭ���� �׿»��ΰ� ���� �������� �����ڸ� ��Ȥ��Ų��.���迡�� ���� ��� ����� ��� �����ε� �����ϸ� ���� �Ｚ, LG ���� ������ �ִ�. �����ڰ� ���� ���� ������ ���̱� ������ ������ ���Ϳ� ���� ���ǰ �� �� �پ��� ���Ÿ��� �����ϴ�. ����� ����Ǿ��ִ� ��ε���̸� ���� ��ġ�� ���忡�� ������ ������ ���� �־� 24�ð� ȭ���� ������ �������� ���̴�.', 'Ÿ�ӽ�����.jpg', '����', '���Թ�');
insert into loc(loc_name, loc_contents, loc_filename, loc_regname, loc_writer) values('��ε����', '���� ����Ʈ����� �Բ� ���� �������� �̲��� �ִ� ��ε����! ������ ������ �������� ȭ���ϰ� �������� ���̴�. Ÿ�ӽ� ������ �ֺ����� 50���� ���ϴ� ������ ������ ���� �����ûӸ� �ƴ϶� �ұ��� ������ �ִ�. ��κ� ������ Ƽ���� ���� �����Ǳ� ������ �ִ��� �̸� �ð��� ���� �����ؾ� �Ѵ�. ������ ���忡 ���� �ϴ� ����� Ÿ�ӽ� ����� �ִ� Ƽ�Ϻν��� �̿��ϴ� ����� ������ ���ͳ� ���ŵ� �����ϴ� ��������.', '��ε����.jpg', '����', '���Թ�');
insert into loc(loc_name, loc_contents, loc_filename, loc_regname, loc_writer) values('���� ���ǰŷ���', '�� ��Ʈ��Ʈ�� ���� �����̶�� �� �� �ִ� ���� ���ǰŷ���. ������ ��ȭ���� �����߾��� �̰��� ���� �ִ� �Ը��� ���ǰŷ��ҷ� ��ǳ����� �ǹ��� Ŀ�ٶ� �����Ⱑ Ư¡�̴�. ���� ������ �����Ǿ� ������ ������ ��ǥ�ϴ� ����� ��ŭ �ܺ� ��� ������ ��� ����.', '���� ���ǰŷ���.jpg', '����', '���Թ�');

insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-01-19', '���Թ�', 'ĳ����', '1', 5, '������ ���Ż�');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-02-02', '���Թ�', 'ĳ����', '1', 4, '������ ���Ż�');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-03-03', '���Թ�', '���ƿ�', '1', 3, '������ ���Ż�');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-03-27', '���Թ�', '��վ�', '1', 2, '������ ���Ż�');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-03-30', '���Թ�', '�ູ��', '1', 1, '������ ���Ż�');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-03-06', '���Թ�', 'ĳ����', '1', 5, 'Ÿ�ӽ�����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-04-07', '���Թ�', 'ĳ����', '1', 5, 'Ÿ�ӽ�����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-04-08', '���Թ�', '���ƿ�', '1', 5, 'Ÿ�ӽ�����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-04-09', '���Թ�', '��վ�', '1', 5, 'Ÿ�ӽ�����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-04-13', '���Թ�', '�ູ��', '1', 1, 'Ÿ�ӽ�����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-05-01', '���Թ�', 'ĳ����', '1', 3, '��ε����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-05-07', '���Թ�', 'ĳ����', '1', 3, '��ε����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-05-17', '���Թ�', '���ƿ�', '1', 3, '��ε����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-06-21', '���Թ�', '��վ�', '1', 3, '��ε����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-07-10', '���Թ�', '�ູ��', '1', 1, '��ε����');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-07-13', '���Թ�', 'ĳ����', '1', 1, '���� ���ǰŷ���');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-07-21', '���Թ�', 'ĳ����', '1', 1, '���� ���ǰŷ���');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-08-01', '���Թ�', '���ƿ�', '1', 1, '���� ���ǰŷ���');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-08-07', '���Թ�', '��վ�', '1', 2, '���� ���ǰŷ���');
insert into rev(rev_num, rev_date, rev_writer, rev_contents, rev_alive, rev_score, rev_locname) values(REV_NUM.nextval, '2019-08-09', '���Թ�', '�ູ��', '1', 1, '���� ���ǰŷ���');

commit;

select * from mem;
insert into mem(mem_id,mem_pwd) values('1','1');