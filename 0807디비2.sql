------------
--ȸ�� ���̺�
------------
select * from mem;
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