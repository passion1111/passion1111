---- 혜수 20191024  수정 
---- 아예 처음 디비 넣는 분들은 drop 제외하고 하면됩니다!
drop table book_category;
drop table book;
drop table appendix;
drop table rental;
drop table new_book;
drop table discard_book;
drop table reservation;

create table book_category ( --도서분류
    book_ctgr_num_db varchar2(100) , --분류기호
    book_ctgr_name varchar2(200)  --분류명
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);
insert into book_category  values('000', '총류');
insert into book_category  values('100', '철학');
insert into book_category  values('200', '종교');
insert into book_category  values('300', '사회학');
insert into book_category  values('400', '언어');
insert into book_category  values('500', '자연과학');
insert into book_category  values('600', '기술과학');
insert into book_category  values('700', '예술');
insert into book_category  values('800', '문학');
insert into book_category  values('900', '역사');

create table book ( --도서
    book_num number, --도서번호
    book_author varchar2(150), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --부록여부
    book_ctgr_num varchar2(100), --분류기호
    book_rsrv_status varchar2(50), --예약여부
    book_rent_cnt number, --대출 횟수
    book_input_date date, --입력일
    book_ctgr_num_db varchar2(100) --도서 분류에 넣을 분류기호 값
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);

insert into book values((select nvl(max(book_num)+1,100001) from book),'이반 일리치 지음 ; 정영목 옮김','텍스트의 포도밭','라이브레인',to_date('2016','YYYY'),'9788932318042 ','X',1,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'강윤팔 저','UFO의 구동원리','라이브레인',to_date('2017','YYYY'),'9788968560323 ','X',1.442,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'이문근 저','정형기법','라이브레인',to_date('2017','YYYY'),'9791187892502 ','X',3.3,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'한세희 글 ; 박선하 그림','어린이를 위한 디지털 과학 용어 사전','라이브레인',to_date('2017','YYYY'),'9791170261735 ','X',4.03,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'닛케이 빅데이터 저 ; 서재원 역','구글에서 배우는 딥러닝 = Learning from Google deep learning','라이브레인',to_date('2017','YYYY'),'9788931456639 ','X',4.73,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'임백준, 정도현, 김호광 [공] 지음','(팟캐스트) 나는 프로그래머다  : 알맹이만 쏙쏙 방송보다 더 밀도 높게 더 유용하게. 2탄','라이브레인',to_date('2016','YYYY'),'9788968482908 ','X',5.04,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'조엘 그루스 지음 ; 박은정 ; 김한결 ; 하성주 [공]옮김','(밑바닥부터 시작하는) 데이터 과학 : 데이터 분석을 위한 파이썬 프로그래밍과 수학·통계 기초','라이브레인',to_date('2016','YYYY'),'9788966261819 ','X',5.7,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'마스이 토시가츠 지음 ; 손정도 옮??','(손으로 익히며 배우는)생활 보안 첫걸음','라이브레인',to_date('2017','YYYY'),'9788968482861 ','X',5.8,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'남형두 지음','표절론  : 표절에서 자유로운 정직한 글쓰기','라이브레인',to_date('2015','YYYY'),'9788932317328 ','X',11.2,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'이상순 지음','나는 책만드는 여자입니다  : bookart＆bookbinding','라이브레인',to_date('2017','YYYY'),'9788964391310 ','X',12.4,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'이나이즈미 렌 지음 ; 최미혜 옮김','이렇게 책으로 살고 있습니다','라이브레인',to_date('2018','YYYY'),'9791186639689 ','X',13.04,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'장순휘 지음 ; 성균관대 일반대학원 한문고전번역협동과정 옮김','사고전서 이해의 첫걸음','라이브레인',to_date('2016','YYYY'),'9791155501757 ','X',15.12,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'2017 경기도 사서서평단 지음','사서들의 책이야기(2017)','라이브레인',to_date('2017','YYYY'),'9788993395662 ','X',18.3,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'한국문헌정보학회 편찬위원회 편집부 엮음','(최신) 문헌정보학의 이해','라이브레인',to_date('2013','YYYY'),'9788976781659 ','X',20.1,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'박영희, 홍기철 공저','도서관 경영론','라이브레인',to_date('2014','YYYY'),'9788993419474 ','X',23,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'맷 업슨, C. 마이클 홀, 케빈 캐넌 [공]지음 ; 노???영 옮김','(Now) 어메이징 인포메이션 : 만화로 배우는 정보와 검색의 모든 것','라이브레인',to_date('2017','YYYY'),'9788958204626 ','X',25.25,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'노영희 지음','차세대 디지털 도서관의 이해  = Understanding the next generation digital library','라이브레인',to_date('2016','YYYY'),'9788959725328 ','X',26.9,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'니나 상코비치 지음  ; 김병화 옮김','혼자 책 읽는 시간 : 무엇으로도 위로받지 못할 때','라이브레인',to_date('2012','YYYY'),'9788901142616 ','X',29.85,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'임우영 글 ; 정은정 그림','쿠키런 별별 대백과. 2-2, 코딩 월드와 버그대소동','라이브레인',to_date('2017','YYYY'),'9788926384251 ','X',30,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'Jon Richards ; Ed Simkins','Space','라이브레인',to_date('2013','YYYY'),'9780750278454 ','X',31,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'리링 지음  ; 박영순 옮김','호랑이를 산으로 돌려보내다  : 학자의 울타리를 넘어 실질을 논하다','라이브레인',to_date('2015','YYYY'),'9788967351816 ','X',42,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'심재석 글','(미리 가 본) 국립민속박물관','라이브레인',to_date('2012','YYYY'),'9788970943671 ','X',69,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'이보아 지음','(박물관학 문화예술경영 입문자를 위한) 박물관 경영과 마케팅','라이브레인',to_date('2014','YYYY'),'9788934969761 ','X',69.068,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'박성제 지음','권력과 언론 : 기레기 저널리즘의 시대','라이브레인',to_date('2017','YYYY'),'9788936486174 ','X',70.4,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'임종권 지음','프랑스 지식인의 세계  : 문학/정치/저널리즘','라이브레인',to_date('2016','YYYY'),'9791187254034 ','X',72.6,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'정제광 글 ; 국민지 그림','햇빛마을 아파트 동물원 : 정제광 장편동화','라이브레인',to_date('2017','YYYY'),'9788936442880 ','X',80,'예약가능',0,sysdate,'000');
insert into book values((select nvl(max(book_num)+1,100001) from book),'나카지마 요시미치 지음  ; 김윤희 옮김','철학의 교과서  : 당신이 몰랐던 진짜 철학','라이브레인',to_date('2014','YYYY'),'9788920012921 ','X',100,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'저부제 지음 ; 허유영 옮김','고로, 철학한다 : 찌질한 철학자들의 위대한 생각 이야기','라이브레인',to_date('2017','YYYY'),'9788959406517 ','X',109.9,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'퀑탱 메이야수 지음 ; 엄태연 옮김','형이상학과 과학 밖 소설','라이브레인',to_date('2017','YYYY'),'9788961473026 ','X',110,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'루트거 뤼트케하우스 지음  ; 공병혜  ; 이선 [공] 옮김','탄생 철학  : 죽음의 철학을 넘어서','라이브레인',to_date('2017','YYYY'),'9788961472647 ','X',112,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'닐스 J. 닐슨 지음 ; 박삼주 옮김','믿음 해체하기','라이브레인',to_date('2017','YYYY'),'9788946063235 ','X',121.6,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Atul Gawande','Being mortal : medicine and what matters in the end','라이브레인',to_date('2014','YYYY'),'9781250081247 ','X',126.5,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'陳澔 編 ; 정병섭 역:','(譯註)禮記集說大全. [3], 大學 : 附 正義·集註','라이브레인',to_date('2017','YYYY'),'9788960716650 ','X',144.3,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'한형조 지음','왜 조선 유학인가','라이브레인',to_date('2008','YYYY'),'9788954606684 ','X',151.5,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'남회근 지음 ; 설순남 옮김','맹자와 진심','라이브레인',to_date('2017','YYYY'),'9788960515895 ','X',152.216,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'쓰루미 ?스케 외 지음  ; 윤여일 옮김','사상으로서의 3·11','라이브레인',to_date('2012','YYYY'),'9788976823748 ','X',153.5,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'로버트 노직 지음  ; 김한영 옮김','무엇이 가치 있는 삶인가  : 소크라테스의 마지막 질문','라이브레인',to_date('2014','YYYY'),'9788934968559 ','X',162.5,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'뤼디거 자프란스키 지음 ; 오윤희, 육혜원 [공]옮김','니체 : 그의 사상의 전기','라이브레인',to_date('2017','YYYY'),'9791188260201 ','X',165.77099,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정승원 지음','청와대는 건물 이름이 아니다  : 기호학으로 세상 읽기','라이브???인',to_date('2017','YYYY'),'9791159252488 ','X',174,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'제이미 워드 지음  ; 김성훈 옮김','소리가 보이는 사람들  : 뇌과학이 풀어낸 공감각의 비밀','라이브레인',to_date('2015','YYYY'),'9788965961734 ','X',181.29,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'선안남 지음','혼자 있고 싶은 남자  : 말 못 한 상처와 숨겨둔 본심에 관한 심리학','라이브레인',to_date('2016','YYYY'),'9788952782458 ','X',182.232,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이언 스튜어트-해밀턴 지음 ; 이동영, 서은현, 우종인 [공] 옮김','노화의 심리학','라이브레인',to_date('2017','YYYY'),'9788952118875 ','X',183.7,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'자크-알렝 밀레 지음  ; 맹정현, 이수련 [공] 옮김','자크 라캉 세미나. 11, 정신분석의 네 가지 근본개념','라이브레인',to_date('2008','YYYY'),'9788955591828 ','X',188.5,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Mo Gawdat','Solve for happy NY','라이브레인',to_date('','YYYY'),'9781501154638 ','X',191.6,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'메리 C. 젠틸러 지음 ; 전영민, 이중학 [공] 옮김','지금, 상사가 부당한 일을 지시했습니까?','라이브레인',to_date('2016','YYYY'),'9791186269435 ','X',195,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이훈 글 ; 김민선 그림','365 매일 읽는 책 속의 한 줄','라이브레인',to_date('2017','YYYY'),'9788914019806 ','X',199.8,'예약가능',0,sysdate,100);
insert into book values((select nvl(max(book_num)+1,100001) from book),'올더스 헉슬리 지음 ; 조옥경 옮김','영원의 철학 : 모든 위대한 가르침의 핵심','라이브레인',to_date('2014','YYYY'),'9788934968627 ','X',201,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김재영 지음','종교심리학의 이해 : 죽음인식의 논의를 중심으로','라이브레인',to_date('2017','YYYY'),'9788930317573 ','X',201.8,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'서공석 [외] 글','고통의 시대, 자비를 생각한다  : 자비에 관한 통합적 성찰','라이브레인',to_date('2016','YYYY'),'9788941916093 ','X',202,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'데이비드 밀스 지음  ; 권혁 옮김','우주에는 신이 없다','라이브레인',to_date('2010','YYYY'),'9788961670517 ','X',204.21,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'메리 더글러스 지음  ; 방원일 옮김','자연 상징  : 우주론 탐구','라이브레인',to_date('2014','YYYY'),'9788961471947 ','X',204.3,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'아이린 호왓 지음 ; 손덕호 옮김','(고아들의 영웅)조지 뮬러','라이브레인',to_date('2009','YYYY'),'9788984750111 ','X',208,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'라이프사이언스 지음  ; 노경아 옮김','지도로 읽는다 세계 5대 종교 역사도감','라이브레인',to_date('2016','YYYY'),'9788994597690 ','X',209,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'한국갤럽조사연구소 편집부 엮음','한국인의 종교  : 1984-2014 여론조사로 생생하게 밝힌 한국 유일의 종교 탐구서','라이브레인',to_date('2015','YYYY'),'9788993516111 ','X',209.11,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이원복 글.그림','신의 나라 인간 나라. 1, 세계의 종교편','라이브레인',to_date('2002','YYYY'),'9788900118667 ','X',219,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'강정식 [외] 지음','아시아신화여행  : 신화, 끝없는 이야기를 창조하다','라이브레인',to_date('2016','YYYY'),'9788939207554 ','X',219.1,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'송언 글  ; 정보영 그림','저승사자가 된 강림도령','라이브레인',to_date('2008','YYYY'),'9788970945460 ','X',219.11,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김성철 지음','(동아시아 대승불교 중흥조) 승랑  : 그 생애와 사상의 분석적 탐구','라이브레인',to_date('2011','YYYY'),'9788942363087 ','X',220.99,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'불교교재편찬위원회 지음','불교와의 첫 만남  : 불교의 역사, 교리, 문화를 아우른 초심자를 위한 불교 입문서','라이브레인',to_date('2015','YYYY'),'9788974790967 ','X',221,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'원영 지음','계율, 꽃과 가시','라이브레인',to_date('2013','YYYY'),'9788998946036 ','X',223.7,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'자현 글  ; 석공, 불교신문사 [공] 사진','스님의 비밀  : 2,600년의 역사와 문화 그리고 때론 오해와 실수가 만들어낸 스님들의 수행과 일상 이야기','???이브레인',to_date('2016','YYYY'),'9791155800751 ','X',226.4,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'송광택 지음','기독교인이라면 반드시 읽어야 할 책 100','라이브레인',to_date('2016','YYYY'),'9791186404690 ','X',230.26,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'안셀름 그륀 지음  ; 최용호 옮김','당신은 나의 천사  : 매 순간마다 하느님이 우리에게 보내 주시는 선물!','라이브레인',to_date('2015','YYYY'),'9788932113913 ','X',231.22,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'로이스 록 글  ; 케이 위더슨 그림  ; 김경은 옮김','(우리 친구 예수님이) 부활하셨어요!','라이브레인',to_date('2016','YYYY'),'9788932114378 ','X',232,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'기민석 지음','구약의 민주주의 풍경  : 고대 이스라엘 의회제도','라이브레인',to_date('2017','YYYY'),'9788936503451 ','X',233.109,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'짐 와일더 외 지음  ; 손정훈, 안윤경 [공] 옮김','(더 깊은 성숙으로 인도하는) 예수님 마음담기','라이브레인',to_date('2015','YYYY'),'9788977823358 ','X',235.36,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'톰 라이트 지음  ; 백지윤 옮김','이것이 복음이다','라이브레인',to_date('2017','YYYY'),'9788932814735 ','X',235.4,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'존 프리처드 지음  ; 한문덕 옮김.해설','교회  : 왜 교회에 가야 하는가? 교회는 무엇을 위해 존재하는가?','라이브레인',to_date('2017','YYYY'),'9788928638000 ','X',236,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김민정 [지음]','하나님이 도우시는 치유의 시간  : 병상에서 드리는 기도문','라이브레인',to_date('2017','YYYY'),'9788904165933 ','X',237.2,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'마크 채프먼 지음 ; 노철래 옮김','성공회 신학 : 성공회 신학의 형성과 발전','라이브레인',to_date('2017','YYYY'),'9788928638291 ','X',238.31,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'잔스촹 지음  ; 안동준, 런샤오리 [공] 뒤침','도교문화 15강  : 당신이 궁금해 하는 도교에 관한 모든 것','라이브레인',to_date('2012','YYYY'),'9788994963570 ','X',240,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'카를 구스타프 융, 리하르트 빌헬름 [공] 지음  ; 이유경 옮김','황금꽃의 비밀','라이브레인',to_date('2014','YYYY'),'9788954624022 ','X',244,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'표영삼 지음','표영삼의 동학 이야기','라이브레인',to_date('2014','YYYY'),'9788997472826 ','X',250,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'박수현 글 ; 윤정주 그림','시골집이 살아났어요','라이브레인',to_date('2010','YYYY'),'9788993242287 ','X',251,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'권태훈 지음','봉우 선생의 仙 이야기 . 1','라이브레인',to_date('2017','YYYY'),'9791185134406 ','X',259,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'스와미 바스카라난다 지음  ; 이현숙 옮김','힌두이즘 이해하기','라??브레인',to_date('2016','YYYY'),'9788926874622 ','X',270,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'권병기 지음','꾸란은 무엇을 말하는가? : 주제별, 인물별로 알아보는 꾸란','라이브레인',to_date('2017','YYYY'),'9791159877230 ','X',283,'예약가능',0,sysdate,200);
insert into book values((select nvl(max(book_num)+1,100001) from book),'인디고 연구소 지음','가능성의 중심  = Interview with Kojin Karatani  : 가라타니 고진 인터뷰','라이브레인',to_date('2015','YYYY'),'9788958202981 ','X',301,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'G.D.H. 콜 지음 ; 홍기빈 옮김','로버트 오언 : 산업혁명기, 협동의 공동체를 건설한 사회혁신가','라이브레인',to_date('2017','YYYY'),'9791195567812 ','X',301.4,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'안토니오 그람시 지음  ; 이상훈 옮김.','그람시의 옥중수고. 1 :, 정치편','라이브레인',to_date('1999','YYYY'),'9788934001553 ','X',301.52,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'백영서 지음','(핵심현장에서) 동아시아를 다시 묻다  : 공생사회를 위한 실천과제','라이브레인',to_date('2013','YYYY'),'9788936482688 ','X',309.11,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'토마 피케티 지음  ; 장경덕, 유엔제이[공] 옮김','21세기 자본','라이브레인',to_date('2014','YYYY'),'9788967351274 ','X',321.2,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'재닛 윌렌, 마조리 간 [공]지음 ; 김인경 옮김','(노예제도에 반대한 여성들)자유를 말하다','라???브레인',to_date('2016','YYYY'),'9791195718702 ','X',321.542,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이유재 지음','서비스마케팅','라이브레인',to_date('2013','YYYY'),'9788958533641 ','X',323.16,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이래풍 지음','주식회사제도','라이브레인',to_date('2016','YYYY'),'9788956614083 ','X',324.47,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'안춘수 지음','불법행위 부당이득 사무관리','라이브레인',to_date('2018','YYYY'),'9791186456637 ','X',325.4,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정동곤 지음','스마트팩토리 = Smart factory : 제4차 산업혁명의 출발점','라이브레인',to_date('2017','YYYY'),'9788946070202 ','X',325.6,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'전국사회교사모임 지음','사회 선생님이 들려주는 공정무역 이야기 : 사회적 감수성을 키우는 시민교과서','라이브레인',to_date('2017','YYYY'),'9788952235763 ','X',326,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'안세영 지음','도널드 트럼프와 어떻게 협상할 것인가  : 다가오는 무역 전쟁 타고난 협상가와 상대하는 비즈니스 협상 전략','라이브레인',to_date('2017','YYYY'),'9788947541695 ','X',326.2,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'최영수 지음','면세점 이야기  : 쇼핑, 관광, 한류의 최전선','라이브레인',to_date('2013','YYYY'),'9788959892389 ','X',326.39,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'쑹훙빙 지음  ; 차혜정 옮김','화폐전쟁  = Currency wars. 1, 화폐전쟁','라이브레인',to_date('2008','YYYY'),'9788925521190 ','X',327.2,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'어맨다 스타인버그 지음 ; 최이현 옮김','여자들에게, 문제는 돈이다','라이브레인',to_date('2017','YYYY'),'9791195445653 ','X',327.8,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조나단 그루버 지음 ; 김홍균 [외]지음','재정학과 공공정책','라이브레인',to_date('2017','YYYY'),'9788968669613 ','X',329.01,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김융희 외 지음','눈, 새로운 발견  : 나는 어떤 눈으로 세상을 볼까?','라이브레인',to_date('2017','YYYY'),'9788958204701 ','X',330,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이도흠 지음','(인류의 위기에 대한) 원효와 마르크스의 대화','라이브레인',to_date('2015','YYYY'),'9788954431972 ','X',330.4,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'임채원 지음','시민적 공화주의 = Civic Republicanism: : 시민대집회와 광화문 일기','라이브레인',to_date('2017','YYYY'),'9788946063426 ','X',331.2,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'류보선 [외] 지음','서울의 인문학  : 도시를 읽는 12가지 시선','라이브레인',to_date('2016','YYYY'),'9788936472818 ','X',331.47,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Jean Clandinin 저 ; 염지숙 [외] 공역','내러티브 탐구의 이해와 실천','라이브레인',to_date('2014','YYYY'),'9788925408972 ','X',331.9,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김하늘 글  ; 박영찬 그림','(세상에서 가장 쉬운 일,) 자원봉사','라??브레인',to_date('2011','YYYY'),'9788964960493 ','X',334.14,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'후지타 다카노리 지음 ; 홍성민 옮김','과로노인','라이브레인',to_date('2017','YYYY'),'9788935211869 ','X',334.6,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Roxane Gay','Bad Feminist','라이브레인',to_date('2014','YYYY'),'9780062282712 ','X',337.2,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Ryan Holiday','Summary of the obstacle is the way','라이브레인',to_date('2017','YYYY'),'9781545060612 ','X',338.3,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'박정훈 지음','역설과 반전의 대륙 : 라틴아메리카 정치사회의 현장에서 캐낸 10가지 테마','라이브레인',to_date('2017','YYYY'),'9788957694282 ','X',340.95,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'임동근, 김종배 [공] 지음','메트로폴리스 서울의 탄생  : 서울의 삶을 만들어낸 권력, 자본, 제도, 그리고 욕망들','라이브레인',to_date('2015','YYYY'),'9788983717252 ','X',340.98,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'토드 부크홀츠 지음 ; 박세연 옮김','다시, 국가를 생각하다','라이브레인',to_date('2017','YYYY'),'9788950963576 ','X',341,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조너선 마크스 지음 ; 고현석 옮김','인종주의에 물든 과학','라이브레인',to_date('2017','YYYY'),'9788993166781 ','X',342.3,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'모리치오 비롤리 지음  ; 김재중 옮김','누구를 뽑아야 하는가?  : 민주공화국을 위한 마키아벨리?? 투표 강령','라이브레인',to_date('2017','YYYY'),'9791195824960 ','X',344.1,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'[더휴먼] 편집부 엮음','필리버스터 = Filibuster  : 민주주의의 최전선','라이브레인',to_date('2016','YYYY'),'9791159031243 ','X',345.08,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'양윤선, 이소영 [공] 지음','나를 위한 최소한의 정치 상식','라이브레인',to_date('2014','YYYY'),'9788952770851 ','X',345.11,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'윤홍근 지음','이익집단의 정치학  : 한국, 스웨덴, 미국 경제단체의 정치적 활동과 최근 변화','라이브레인',to_date('2015','YYYY'),'9788974183431 ','X',346.8,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'존 베일리스, 스티브 스미스, 퍼트리샤 오언스 [공] 편저  ; 하영선 ...[등] 옮김','세계정치론','라이브레인',to_date('2015','YYYY'),'9788932472898 ','X',349,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'제프리 D. 삭스 지음  ; 이종인 옮김','(존 F. 케네디의) 위대한 협상','라이브레인',to_date('2014','YYYY'),'9788950952938 ','X',349.09,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'리영희 지음','전환시대의 논리  : 리영희 평론집','라이브레인',to_date('1990','YYYY'),'9788936410049 ','X',349.1,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'최영진 지음','新조선책략  : 어떻게 역사는 역전되는가?','라이브레인',to_date('2013','YYYY'),'9788934965695 ','X',349.11,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'목영만 지음','신뢰의 발견  : 30년 행정전문가가 밝히는 68가지 비밀','라이브레인',to_date('2016','YYYY'),'9788925558134 ','X',351.1,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'唐洲雁  著','法治國家建?理論與實踐硏究','라이브레인',to_date('2017','YYYY'),'9787520303545 ','X',360.1,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조인원 함께 펴냄','내안의 미래  : 학생과 총장이 함께 묻는 문명 정치 대학의 길  : 우리는 어떻게 역사의 미래가 될 수 있을까','라이브레인',to_date('2016','YYYY'),'9788935663002 ','X',370.4,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'존 라머, 존 머겐달러, 수지 보스 [공] 지음  ; 최선경, 장밝은, 김병식 [공] 옮김','프로젝트 수업 어떻게 할 것인가?  : 철학에서 실천까지, 교사들을 위한 PBL의 모든 것!','라이브레인',to_date('2017','YYYY'),'9788994655543 ','X',373.25,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김동찬 글  ; 최윤선, 장정오 [공] 그림','질문을 꿀꺽 삼킨 사회 교과서, 역사 편','라이브레인',to_date('2010','YYYY'),'9788927800620 ','X',375.43,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이윤우 지음','4년 먼저  : 서울여상, 그 놀라운 성공의 비밀','라이브레인',to_date('2011','YYYY'),'9788952216380 ','X',376.7,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정동영 [외]지음','(예비교사를 위한)특수교육학 = Introduction to special education for preservice teachers','라이브레인',to_date('2014','YYYY'),'9788925408774 ','X',379,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'고이즈미 다케오 지음 ; 박현석 옮김','사냥꾼의 고기는 썩지 않는다','라이브레인',to_date('2017','YYYY'),'9788967260248 ','X',381.7,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'윤소희 글  ; 유경래 그림','(슈퍼 히어로 보다 재미있는) 우리 신 이야기','라이브레인',to_date('2015','YYYY'),'9788967493806 ','X',388,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'야마모토 시치헤이 지음 ; 최용우 옮김','어느 하급장교가 바라본 일본제국의 육군','라이브레인',to_date('2016','YYYY'),'9788967353544 ','X',390.913,'예약가능',0,sysdate,300);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Shin Takahashi 글 ; Iroha Inoue 그림 ; 김성훈 옮김','(만화로 쉽게 배우는)선형대수','라이브레인',to_date('2009','YYYY'),'9788931579819 ','X',412.85,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김찬중 지음','초전도 과학교실 : 눈으로 보는 양자역학','라이브레인',to_date('2017','YYYY'),'9791195369959 ','X',427.62,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'프레드 볼츠 지음 ; 한국여성과총 교육홍보출판위원회 옮김','목성 너머 : 행성 천문학자 하이디 해멀','라이브레인',to_date('2016','YYYY'),'9788956057811 ','X',440.99,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'폴 마르탱 지음 ; 키코 그림 ; 박대진 옮김','똑딱똑딱 지구는 24시간','라이??레인',to_date('2017','YYYY'),'9788943310912 ','X',448.75,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Charlotte Guillain, illustrated by Yuval Zommer','(The)Street beneath my feet','라이브레인',to_date('2017','YYYY'),'9781682971369 ','X',455,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이용규, 한상호 [공] 글  ; 올리브 스튜디오, 드림써치 CC [공] 그림','(어린이동화) 점박이  : 한반도의 공룡','라이브레인',to_date('2012','YYYY'),'9788901140629 ','X',457,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'짐 알칼릴리, 존조 맥패든 [공]지음 ; 김정은 옮김','생명, 경계에 서다 : 양자생물학의 시대가 다가온다','라이브레인',to_date('2017','YYYY'),'9788967354589 ','X',472.19,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'리처드 도킨스 외 지음  ; 존 브록만 엮음  ; 이한음 옮김','궁극의 생명  : 위대한 석학 21인이 말하는 생명의 기원과 진화, 그리고 최첨단 생명과학','라이브레인',to_date('2017','YYYY'),'9788937889257 ','X',473,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'제럴드 폴락 지음 ; 김홍표 옮김','진화하는 물','라이브레인',to_date('2017','YYYY'),'9791128820045 ','X',474,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'생태지평연구소 지음  ; 이명애 그림','DMZ 원정대','라이브레인',to_date('2011','YYYY'),'9788991871878 ','X',477,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'서민 글 ; 이우일 일러스트','노빈손과 위험한 기생충 ??구소','라이브레인',to_date('2016','YYYY'),'9788958075790 ','X',493,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김천아 [외] 지음','벌레의 마음  : 예쁜꼬마선충에게 배우는 생명의 인문학','라이브레인',to_date('2017','YYYY'),'9788955619072 ','X',493.73,'예약가능',0,sysdate,400);
insert into book values((select nvl(max(book_num)+1,100001) from book),'현영석 원작  ; 이한울 글  ; 서석근 그림','(모험으로 만나는) 미래과학  : 미래자동차 특급레이싱','라이브레인',to_date('2010','YYYY'),'9788934936909 ','X',500,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Dorling Kindersley 편  ; UJ 번역','세상을 바꾸는 최고의 과학 기술','라이브레인',to_date('2017','YYYY'),'9788930270687 ','X',504,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조 지무쇼 엮음  ; 고원진 옮김','(30가지 발명품으로 읽는) 세계사  : 술, 바퀴, 시계에서 플라스틱, 반도체, 컴퓨터에 이르기까지','라이브레인',to_date('2017','YYYY'),'9788984458512 ','X',507,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'프랑수아즈 라스투앵-포주롱 글  ; 벵자맹 쇼 그림  ; 이효숙 옮김','주사는 왜 맞을까','라이브레인',to_date('2006','YYYY'),'9788909122726 ','X',508,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'헨리 페트로스키 지음  ; 백이호 옮김','포크는 왜 네 갈퀴를 달게 되었나','라이브레인',to_date('2014','YYYY'),'9788934966500 ','X',509,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'테드 알렌, 시드니 고든 [공] 지음  ; 천희상 옮김','닥터 노먼 베쑨','라이브레인',to_date('2001','YYYY'),'9788939204140 ','X',510.99,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Jennie Maizels, William Petty','My pop-up body book','라이브레인',to_date('2017','YYYY'),'9781406317923 ','X',511.1,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'요하네스 폰 보르스텔 지음  ; 배명자 옮김','매력적인 심장 여행  : 생명의 엔진, 심장에 관한 놀라운 지식 프로젝트','라이브레인',to_date('2016','YYYY'),'9788937838743 ','X',511.116,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'허준 지음','(뇌혈관 전문의사 허준의) 뇌졸중 이야기','라이브레인',to_date('2017','YYYY'),'9791186692080 ','X',513.811,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'수잔 블룸, 미셸 벤더 [공] 지음 ; 최세환, 지영미 [공] 옮김','면역의 배신','라이브레인',to_date('2017','YYYY'),'9791159430657 ','X',513.92,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김영범 지음','목, 허리 건강의 비밀 : 목, 허리 건강을 위한 필독서','라이브레인',to_date('2017','YYYY'),'9788964897485 ','X',514.325,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'해럴드 M. 페퍼드 지음  ; 최홍규 옮김','당신의 눈도 1.2가 될 수 있다','라이브레인',to_date('2017','YYYY'),'9788973434930 ','X',515.73,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'오상민 지음','(똑똑!) 닥터오 아기 진료실  : 소아청소년과 의사 아빠의 육아일기','라이브레인',to_date('2016','YYYY'),'9788997195862 ','X',516.9,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Alisa Vitti','Womancode','라이브레인',to_date('2014','YYYY'),'9780062130792 ','X',517.36,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조길호 지음','약이 되는 약 이야기','라이브레인',to_date('2014','YYYY'),'9788974836429 ','X',518,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정연호 지음','널뛰는 감정 날뛰는 생각  : 한의사가 동양 심리학으로 치유를 말하다','라이브레인',to_date('2016','YYYY'),'9788965022596 ','X',519.38914,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김훈기 글 ; 김서영 그림','GMO','라이브레인',to_date('2017','YYYY'),'9791161720319 ','X',521,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'KBS스페셜 <종자, 세계를 지배하다> 제작팀 지음','(KBS 스페셜) 종자, 세계를 지배하다  : 종자는 누가 소유하는가','라이브레인',to_date('2014','YYYY'),'9788959402908 ','X',523.22,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'카즈 힐드브란드 지음 ; 차유진 옮김','허브 : 몸과 마음을 치유하는 향긋한 식물 100가지','라이브레인',to_date('2017','YYYY'),'9788998690274 ','X',525.48,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이원영 지음  ; 봉현 그림','동물을 사랑하면 철학자가 된다  : 만남부터 이별까지, 반려동물과 함께한다는 것','라이브레인',to_date('2017','YYYY'),'9788932029627 ','X',527.386,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'에릭 드렉슬러 지음 ; 임지원 옮김 ; 이인식 해제','급진적 ??요 : 나노기술이 이끄는 우리 삶의 변화','라이브레인',to_date('2017','YYYY'),'9788934978954 ','X',530,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김수희 글 ; 이경국 그림','죽음의 먼지가 내려와요','라이브레인',to_date('2015','YYYY'),'9788983947833 ','X',533.9,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'사이토 가쓰히로 지음  ; 장은정 옮김','유해물질 의문 100 : 생활세제, 의료품, 화장품, 농수산물, 공산품은 얼마나 안전한가','라이브레인',to_date('2016','YYYY'),'9788964942703 ','X',539.979,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'오승주 [외] 지음','건축계획론 = Rchitectural planing  design theory','라이브레인',to_date('2017','YYYY'),'9788970938332 ','X',540.1,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'하라구치 히데아키 저  ; 홍정석 역','(기초부터 배우는) 건축시공','라이브레인',to_date('2014','YYYY'),'9788962255911 ','X',542.8,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김동욱 지음','서울의 다섯 궁궐과 그 앞길 : 유교도시 한양의 행사 공간','라이브레인',to_date('2017','YYYY'),'9791195233489 ','X',549.1,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by David Macaulay, Neil Ardley','(The) Way things work now','라이브레인',to_date('2016','YYYY'),'9780544824386 ','X',550,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'데이비드 맥컬레이 글·그림 ; 닐 아들리 글 ; 박영재, 김창호 [공]옮김','도구와 기계의 원리 Now : 그림으로 보는 재미있는 과학 원리','라이브레인',to_date('2016','YYYY'),'9791195748013 ','X',551,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'글터 반딧불 지음  ; 장경섭 그림','바퀴의 역사가 궁금해 : 멋진 자동차를 좋아하는 우리 아이','라이브레인',to_date('2017','YYYY'),'9788931381238 ','X',556.38,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'송병흠 , 유병선 , 최진국 [공]편역','(2014) 항공운항정보 및 절차  = Aeronautical information manual','라이브레인',to_date('2014','YYYY'),'9788972870784 ','X',558.3,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'최선욱 편저','PLC 기초와 응용  : 초보에서 실무까지','라이브레인',to_date('2015','YYYY'),'9788942914036 ','X',559.98,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'신대섭 지음','(초보자가 만드는) AVR 마이크로 프로세서 따라하기','라이브레인',to_date('2017','YYYY'),'9788931708936 ','X',559.99,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'岩本 洋 著  ; 朴漢宗 譯','(초보자를 위한) 전기기초 입문','라이브레인',to_date('2017','YYYY'),'9788931525618 ','X',560,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'데릭 청  ; 에릭 브랙 [공] 지음  ; 홍성완 옮김','전자정복  : 상상이 현실이 되기까지 천재과학자들이 써 내려간 창조의 역사','라이브레인',to_date('2015','YYYY'),'9788920930720 ','X',560.9,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'안자이 테쓰 지음  ; 박은지 옮김','공간을 쉽게 바꾸는 조명','라이브레인',to_date('2016','YYYY'),'9791186000304 ','X',565,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Saito Masanori 지음 ; 이영란 옮김','(그림 한 장으로 보는)최신 IT 트렌드','라이브레인',to_date('2017','YYYY'),'9788956747354 ','X',567,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이재광 편저','데이터 통신','라이브레인',to_date('2016','YYYY'),'9791132100942 ','X',567.01,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이준 ; 윤정한 ; 이기원 공저','맛있는 음식에는 과학이 있다 = Amazing Science in Delicious Foods','라이브레인',to_date('2017','YYYY'),'9788970938691 ','X',570,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김훈기 지음','바이오해커가 온다 = Bio hacker : 생명공학을 해킹하는 신인류에 관한 보고서','라이브레인',to_date('2015','YYYY'),'9788967352127 ','X',570.6,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'우종욱 글  ; 김미정 그림','(아빠와 함께하는) 목공은 즐겁다','라이브레인',to_date('2014','YYYY'),'9788984318342 ','X',584,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'황넝푸, 천??[공] 지음  ; 이희영 옮김','중국의 비단역사 칠천 년  : 역대 직조와 자수품 연구  = China silk 7000 years : crystal of art science and technology','라이브레인',to_date('2016','YYYY'),'9788926871508 ','X',587.39,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'에린 헤이거 지음 ; 페이지 개리슨 그림 ; 황창원 옮김','레고는 어떻게 태어났을까 : 아이디어로 세상을 바꾸다','라이브레인',to_date('2017','YYYY'),'9788991550841 ','X',589,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'옆집새댁 조민경 지음','옆집새댁 살림일기  : 살림고수보다 센스 있는 어린 새댁의 살림 이야기','라이브레인',to_date('2016','YYYY'),'9788925558561 ','X',591,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Emi 지음  ; 김현영 옮김','(Ourhome) 내가 편해지는 물건 고르기','라이브레인',to_date('2016','YYYY'),'9788959759743 ','X',591.1,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김호정 [외] 지음','징글맞은 연애와 그 후의 일상  : 연애, 그 견딜 수 없는 적나라한 진실에 대하여','라이브레인',to_date('2017','YYYY'),'9788927808688 ','X',591.7,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'소잉팩토리아카데미 지음','Dressmaking : 여성복 소잉 레시피 10','라이브레인',to_date('2017','YYYY'),'9788996899853 ','X',592.2,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'가랑스 도레 지음 ; 이상미 옮김','러브 × 스타일 × 라이프','라이브레인',to_date('2017','YYYY'),'9791196001827 ','X',593,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'래니 킹스턴 지음 ; 신소희 옮김','완벽한 커피 한 잔 : 원두의 과학','라이브레인',to_date('2017','YYYY'),'9791156757061 ','X',594.3463,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'유하영 지음','마이 위시 플라워케이크','라이브레인',to_date('2017','YYYY'),'9791158461676 ','X',594.516,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'신유미, 시도니 벤칙 [공] 지음','프랑스 아이는 말보다 그림을 먼저 배운다  : 생각하는 아이를 만드는 프랑스 교육의 비밀','라이브레인',to_date('2015','YYYY'),'9788952773456 ','X',598.6,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'러시워스 키더 지음  ; 김아영 옮김','(내 아이에게 가르쳐주는) 첫 정의 수업  : 착한 아이로 키워야 위대한 어른으로 자란다','라이브레인',to_date('2011','YYYY'),'9788925544496 ','X',598.7,'예약가능',0,sysdate,500);
insert into book values((select nvl(max(book_num)+1,100001) from book),'로버트 S. 넬슨, 리차드 시프 [공] 지음  ; 정연심 외 옮김','꼭 읽어야 할 예술 비평용어 31선  = Critical Terms for Art History','라이브레인',to_date('2015','YYYY'),'9788940805077 ','X',600.3,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'스티븐 킹 지음  ; 조재형 옮김','죽음의 무도   : 왜 우리는 호러 문화에 열광하는가','라이브레인',to_date('2010','YYYY'),'9788994210490 ','X',600.4,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이리에 마사유키 지음 ; 김진아 옮김','안토니오 가우디 = Antoni Gaudi : 지중해가 낳은 천재 건축가','라이브레인',to_date('2017','YYYY'),'9791127405823 ','X',610.99,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김정신 지음','빛의 찬미  : 마르크 수사의 삶과 예술  = Eloge ┬ la lumi┴re : la vie et lart du Fr. Marc','라이브레인',to_date('2016','YYYY'),'9791155220962 ','X',631.9,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'리앤더 카니 [저] ; 안진환 옮김','조너선 아이브 : 위대한 디자인 기업 애플을 만든 또 한명의 천재','라이브레인',to_date('2014','YYYY'),'9788937489020 ','X',639.5099,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조이한, 진중권 [공] 지음','(조이한.진중권의) 천천히 그림 읽기  : 잃어버린 감성을 깨우는 새로운 그림감상','라이브레인',to_date('2003','YYYY'),'9788901028224 ','X',650.4,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'윤열수 지음','꿈꾸는 우리 민화','라이브레인',to_date('2005','YYYY'),'9788943305727 ','X',654,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'크리스토프 드뢰서 지음  ; 전대호 옮김','음악 본능  : 우리는 왜 음악에 빠져들까?','라이브레인',to_date('2015','YYYY'),'9788956054162 ','X',671.18,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정강현 지음','당신이 들리는 순간  : 인디 음악의 풍경들','라이브레인',to_date('2013','YYYY'),'9788957077702 ','X',673.5,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'제러미 시프먼 지음  ; 김병화 옮김','실내악과의 만남  : 가장 친밀한 음악적 대화','라이브레인',to_date('2013','YYYY'),'9788993818567 ','X',675.6,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'에리카 피셔-리히테 지음 ; 김정숙 옮김','수행성의 미학 : 현대???술의 혁명적 전환과 새로운 퍼포먼스 미학','라이브레인',to_date('2017','YYYY'),'9788932029870 ','X',680.1,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'나경아 지음','무용과 건강  = Dance  wellness','라이브레인',to_date('2016','YYYY'),'9791155165805 ','X',685.1,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'엄상빈','또 하나의 경계 = Another Border Line : 분단시대의 동해안 : 엄상빈 사진집','라이브레인',to_date('2017','YYYY'),'9788974093914 ','X',688.4,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'서재복 ; 이달원, 김현우 저','스포츠교육학 강의','라이브레인',to_date('2017','YYYY'),'9788956765891 ','X',692.07,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'윤태훈 외 지음','(누구나 쉽게 배우는) 스쿼시','라이브레인',to_date('2015','YYYY'),'9788956765303 ','X',695.5,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'[온이퍼브]편집부 [편]','우리나라의 전통무예','라이브레인',to_date('2013','YYYY'),'9788969101440 ','X',698,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'현대레저연구회 지음','정통 바다낚시  : 기초 이론에서 부터 실기완성까지','라이브레인',to_date('2016','YYYY'),'9788949304946 ','X',699.7,'예약가능',0,sysdate,600);
insert into book values((select nvl(max(book_num)+1,100001) from book),'해리 G. 프랭크퍼트 지음  ; 이윤 옮김','개소리에 대하여','라이브레인',to_date('2016','YYYY'),'9791157830572 ','X',701.2,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이서현 글 ; 서정은 그림','쿠키런 맞춤법이 헷갈려?!. 1, 소리편','라이브레인',to_date('2015','YYYY'),'9788926398098 ','X',711.25,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김태경 저','상고중국어 음운체계와 한국어 어휘의 어원','라이브레인',to_date('2016','YYYY'),'9788960716377 ','X',721.1,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Otgontsetseg Damdinsuren 지음','몽골어 : 기초 몽골어 학습 비법서. 1','라이브레인',to_date('2017','YYYY'),'9791159011924 ','X',739.3,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Stanton H. Procter, Melanie Ann Procter [공] 글  ; 홍성지 그림','기초100% 초등영어문법','라이브레인',to_date('2008','YYYY'),'9788901079233 ','X',745,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김충식 편저','(엣센스) 한서사전  = Essence diccionario Coreano-Espa ol  : 한국어-스페인어 사전','라이브레인',to_date('2014','YYYY'),'9788938707031 ','X',773.1,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'지성환 지음','(영어를 알면 보이는)스페인어 단어','라이브레인',to_date('2018','YYYY'),'9788947542791 ','X',774,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김선이 지음','우리들의 메타 스페인어 첫걸음','라이브레인',to_date('2018','YYYY'),'9788997343270 ','X',775,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Isabel Lee 지음','여행자의 스페인어 Must Carry','라이브레인',to_date('2017','YYYY'),'9788960496415 ','X',777,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'임주인 지음','국가대표 스페인어 회화능력자','라이브레인',to_date('2017','YYYY'),'9788997343232 ','X',777.5,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'유민정 저','(The 바른)브라질 포르투갈어 = Portugues Brasileiro. Step 1','라이브레인',to_date('2017','YYYY'),'9788992281485 ','X',779,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'최보선 저','착! 붙는 이탈리아어 독학 첫걸음','라이브레인',to_date('2016','YYYY'),'9788955187915 ','X',780,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'황정은 지음','(초보자를 위한 컴팩트) 이탈리아어 단어','라이브레인',to_date('2017','YYYY'),'9788992683821 ','X',784,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김미애 지음.','표준 이탈리아어 문법  = Grammatica Italiana  : 품사론. 2','라이브레인',to_date('2017','YYYY'),'9788946063013 ','X',785,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'Mr. Sun 어학연구소 ; 김영린 ; Margherita Besuschio [공]지음','(한눈에 보인다)이탈리아어 첫걸음 : 회화  문법','라이브레인',to_date('2017','YYYY'),'9788997221554 ','X',787,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'박형대 지음','나름 친절한 헬라어 문법책  : 헬라어 신약성경 직독직해','라이브레인',to_date('2017','YYYY'),'9788957993958 ','X',792.15,'예약가능',0,sysdate,700);
insert into book values((select nvl(max(book_num)+1,100001) from book),'피터 브룩스 지음  ; 박인성 옮김','정신분석과 이야기 행위','라이브레인',to_date('2017','YYYY'),'9788932030043 ','X',801,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조정래 지음','스토리텔링 육하원칙 : 신문을 활용한 스토리텔링 창작법','라이브레인',to_date('2010','YYYY'),'9788920004032 ','X',802,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김휘빈 지음','웹소설 작가 서바이벌 가이드','??이브레인',to_date('2017','YYYY'),'9791186940266 ','X',802.02,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정숙영 지음','여행자의 글쓰기  = Travel writing  : 베테랑 여행작가의 비밀노트','라이브레인',to_date('2016','YYYY'),'9788959130016 ','X',802.6,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'혼다 아리아케 글 ; 김지연 옮김','소원이 이루어지는 신기한 일기','라이브레인',to_date('2017','YYYY'),'9791186490709 ','X',803.8,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'장영희 지음','어떻게 사랑할 것인가  : 장영희 교수의 청춘들을 위한 문학과 인생 강의','라이브레인',to_date('2012','YYYY'),'9788959136803 ','X',804,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'르 클레지오, 가오싱젠, 김우창 외 지음','세계화 속의 삶과 글쓰기  = (The) globalization world and the human community  : 〈2011년 제3회 서울국제문학포럼〉 논문집','라이브레인',to_date('2011','YYYY'),'9788937484285 ','X',805,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'구인환 [외]저','문학교육론','라이브레인',to_date('2017','YYYY'),'9788974900236 ','X',807,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'유진 오닐 지음  ; 오화섭 옮김','지평선 너머','라이브레인',to_date('2009','YYYY'),'9788963650180 ','X',808.2,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'『Axt』 편집부 지음','이것이 나의 도끼다  : 소설가들이 소설가를 인터뷰하다!','라이브레인',to_date('2017','YYYY'),'9788956601366 ','X',809.3,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김지은 지음','어린이, 세 번째 사람  : 김지은 평론집','라이브레인',to_date('2017','YYYY'),'9788936463465 ','X',809.9,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'정약용 지음  ; 송재소 옮김','다산시선','라이브레인',to_date('2013','YYYY'),'9788936472320 ','X',811.35,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'지은이: 김상렬','헛개나무 집  : 김상렬 연작·소설집','라이브레인',to_date('2016','YYYY'),'9788930006330 ','X',813.62,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김선우 지음','어디 아픈 데 없냐고 당신이 물었다  : 시인 김선우가 오로빌에서 보낸 행복 편지','라이브레인',to_date('2011','YYYY'),'9788935208814 ','X',816.6,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'차오원쉬엔 글  ; 김송이 그림  ; 전수정 옮김','산 넘어 산','라이브레인',to_date('2017','YYYY'),'9788925560229 ','X',823.8,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'히라노 게이치로 지음  ; 양윤옥 옮김','(히라노 게이치로의)소설(小說)읽는 방법','라이브레인',to_date('2011','YYYY'),'9788954616027 ','X',833.09,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'박선미 ; 이서현 [공]지음 ; 박선미 ; 박상우 [공]그림','반쯩반짜이 = s? tich banh ch?ng banh giay','라이브레인',to_date('2017','YYYY'),'9791186908235 ','X',839.82,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Bill Bryson','(A) Walk in the Woods','라이브레인',to_date('2006','YYYY'),'9780307279460 ','X',844,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'커트 보니것 지??  ; 김용욱 옮김','그래, 이 맛에 사는 거지  : 졸업을 앞둔 너에게','라이브레인',to_date('2017','YYYY'),'9788954644174 ','X',845,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'요한 볼프강 폰 괴테 지음  ; 곽복록 옮김','이탈리아 기행','라이브레인',to_date('2016','YYYY'),'9788949715209 ','X',856,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'카트린 지타 지음  ; 박성원 옮김','내가 혼자 여행하는 이유  : 7년 동안 50개국을 홀로 여행하며 깨달은 것들','라이브레인',to_date('2015','YYYY'),'9788901204772 ','X',858,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'헤르만 헤세 지음 ; 정현규 옮김','사랑하는 사람은 행복하다 : 사랑에 관하여','라이브레인',to_date('2017','YYYY'),'9791188047031 ','X',859,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'프랑수아 비용 지음 ; 김준현 옮김','유언의 노래','라이브레인',to_date('2016','YYYY'),'9788937475047 ','X',861,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'파블로 네루다 지음  ; 고혜선 옮김','모두의 노래','라이브레인',to_date('2016','YYYY'),'9788932028866 ','X',871,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'호라티우스 지음 ; 김남우 옮김','카르페 디엠','라이브레인',to_date('2016','YYYY'),'9788937475016 ','X',892.2,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'디온 메이어 지음 ; 송섬별 옮김','13시간 : 디온 메이어 장편소설','라이브레인',to_date('2016','YYYY'),'9788950965754 ','X',893,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'발레리아 루이??리 지음  ; 엄지영 옮김','무중력의 사람들  : 발레리아 루이셀리 장편소설','라이브레인',to_date('2017','YYYY'),'9788972758075 ','X',894,'예약가능',0,sysdate,800);
insert into book values((select nvl(max(book_num)+1,100001) from book),'강인욱 지음','진실은 유물에 있다 : 고고학자, 시공을 넘어 인연을 발굴하는 사람들','라이브레인',to_date('2017','YYYY'),'9788946420779 ','X',902.5,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'서울대학교 역사연구소 편','역사용어사전  = Discovery of historical terms','라이브레인',to_date('2015','YYYY'),'9788952115119 ','X',903,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'이근직 지음','삼국유사 요모조모','라이브레인',to_date('2017','YYYY'),'9788955083729 ','X',911.85,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'김경한 지음','(평설) 인물 삼국지','라이브레인',to_date('2014','YYYY'),'9788967990411 ','X',912.033,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'왕즈훙 외 지음 ; 곽규환, 한철민 외 옮김','저항의 도시, 타이베이를 걷다','라이브레인',to_date('2017','YYYY'),'9788965454458 ','X',912.4,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'강승문 지음','싱가포르역사 다이제스트 100','라이브레인',to_date('2017','YYYY'),'9788984354166 ','X',914.69,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'제카리아 시친 지음  ; 이근영 옮김','수메르, 혹은 신들의 고향','라이브레인',to_date('2009','YYYY'),'9788996244950 ','X',919.1,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'플로리안 일리스 지음  ; 한경희 옮김','1913년 세기??? 여름','라이브레인',to_date('2013','YYYY'),'9788954622608 ','X',920.5,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Dan Jones','(The)Wars of the Roses : The Fall of the plantagenets and the rise of the Tudors','라이브레인',to_date('2015','YYYY'),'9780143127888 ','X',924.041,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'노시내 지음','스위스 방명록  : 니체, 헤세, 바그너, 그리고…','라이브레인',to_date('2015','YYYY'),'9791186000168 ','X',925.9,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'미하일로 흐루셉스키 저 ; 허승철 옮김','코자크와 우크라이나의 역사','라이브레인',to_date('2017','YYYY'),'9788974828851 ','X',929.8,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'림수진 엮음','21세기 중앙아메리카의 단면들  = Live from central America  : 내전과 독재의 상흔','라이브레인',to_date('2015','YYYY'),'9788946057685 ','X',944,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'임호준 지음','즐거운 식인 : 서구의 야만 신화에 대한 라틴아메리카의 유쾌한 응수','라이브레인',to_date('2017','YYYY'),'9788937485084 ','X',950,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'by Kim MacQuarrie','(The) Last days of the Incas','라이브레인',to_date('2008','YYYY'),'9780743260503 ','X',955,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'일사 샤프 지음  ; 김은지 옮김','(세계를 읽다) 호주','라이브레인',to_date('2014','YYYY'),'9791195201662 ','X',962,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'한양대학교 아태지역연구센터 러시아·유라시아 연구사업단 엮음','유라시아주의의 재해석 : 새로운 인문지리로서의 유라시아','라이브레인',to_date('2016','YYYY'),'9788928509232 ','X',980.1,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'리처드 부시 지음  ; 정재겸 역주','(순록과 함께한) 시베리아 탐험 일지  : 흑룡강, 캄차카, 축치 반도 탐사 기록 1865, 1866, 1867','라이브레인',to_date('2016','YYYY'),'9791185614038 ','X',981.7,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'섀넌 존스 지음 ; 케이시 우헤르스키 그림 ; 윤영 옮김','키키의 세계여행','라이브레인',to_date('2017','YYYY'),'9788991223707 ','X',982.6,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'핫토리 마사타카 엮음 ; 우정미 옮김 ; 차철욱 역주 및 해제','식민지 조선의 이주일본인과 통영 : 핫토리 겐지로','라이브레인',to_date('2017','YYYY'),'9791187488460 ','X',991.3,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'에이미 노브스키 글 ; 이자벨 아르스노 그림 ; 길상효 옮김','거미 엄마, 마망 : 루이스 부르주아','라이브레인',to_date('2017','YYYY'),'9791160510676 ','X',992.6,'예약가능',0,sysdate,900);
insert into book values((select nvl(max(book_num)+1,100001) from book),'조용현 지음','(5백년 내력의) 명문가 이야기','라이브레인',to_date('2002','YYYY'),'9788987787404 ','X',999.9,'예약가능',0,sysdate,900);

create table appendix ( --부록
    apdx_code varchar(30),--부록코드
    apdx_book_num varchar2(30), --도서번호
    apdx_name varchar(50) --부록명
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table rental (
    rent_num number, --대여번호
    book_num number, --도서번호
    mem_id varchar2(20), --회원번호
    rent_startdate date, --대여일
    rent_enddate date, --반납일
    rent_appendix_status varchar2(10), --부록대출여부
    rent_extension varchar2(10), --대여연장
    rent_status varchar2(30)
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);

create table new_book ( --도서 구입 신청 테이블
    new_book_num number, --신간 신청 번호
    new_book_num_sub number, --신간 하위 번호
    book_author varchar2(150), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_isbn varchar2(50), --isbn
    book_price number, --도서 가격
    new_status varchar2(20), --신청 승인 상태
    new_input_date date  --신청일
);

create table hope_book ( -- 희망 도서 테이블
    hope_book_num number, --희망 도서 번호
    book_author varchar2(150), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_isbn varchar2(50), --isbn
    book_price number, --도서 가격
    hope_status varchar2(20), --승인 상태
    hope_input_date date  --신청일
);

insert into hope_book values(1,	'글배우',	'지쳤거나 좋아하는 게 없거나',	'강한별',	TO_DATE('2019/09/04','YYYY-MM-DD'),	'1196797706 9791196797706', 13500,	'신청 완료',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(2,	'조남주',	'82년생 김지영(오늘의 젊은 작가 13)(양장본 HardCover)',	'민음사',	TO_DATE('2016/10/14','YYYY-MM-DD'),	'8937473135 9788937473135',	13000,	'신청 완료',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(3,	'임홍택',	'90년생이 온다','웨일북(whalebooks)',	TO_DATE('2018/11/16','YYYY-MM-DD'),	'1188248677 9791188248674',	14000,	'신청 완료',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(4,	'유발 하라리',	'사피엔스',	'김영사',	TO_DATE('2015/11/24','YYYY-MM-DD'),	'8934972467 9788934972464',	22000,'	신청 완료',	TO_DATE('2019/10/01','YYYY-MM-DD'));
insert into hope_book values(5,	'김영하',	'여행의 이유',	'문학동네',	TO_DATE('2019/04/17','YYYY-MM-DD'),	'8954655971 9788954655972',	13500,'	신청 완료',	TO_DATE('2019/10/24','YYYY-MM-DD'));
insert into hope_book values(6,	'이병률',	'혼자가 혼자에게',	'달'	, TO_DATE('2019/09/19','YYYY-MM-DD'),	'1158161026 9791158161026',	15500,	'신청 완료',	TO_DATE('2019/10/24','YYYY-MM-DD'));
insert into hope_book values(7,	'박종훈',	'2020 부의 지각변동',	'21세기북스',	TO_DATE('2019/07/05','YYYY-MM-DD'),'	895098198X 9788950981983',	17000,	'신청 완료',	TO_DATE('2019/10/24','YYYY-MM-DD'));

create table discard_book ( --도서 폐기 신청 테이블
       dis_book_num number, --폐기 신청 번호
       book_num number, --도서번호
       dis_input_date date, --폐기 신청일
       dis_status varchar2(30) --신청 승인 상태
);

insert into discard_book values(3, '100268', TO_DATE('2019/10/24','YYYY-MM-DD'), '신청 완료');
insert into discard_book values(2, '100267', TO_DATE('2019/10/24','YYYY-MM-DD'), '신청 완료');
insert into discard_book values(1, '100266', TO_DATE('2019/10/24','YYYY-MM-DD'), '신청 완료');
commit;
create table reservation (
    rent_num varchar2(30), -- 대여번호
    mem_id varchar2(20), --회원번호
    rsrv_num number(20),   --예약번호
    rsrv_enddate date --예약 끝날짜
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);

--정보입력 날짜 랜덤 커리
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

--렌털횟수 랜덤 커리
update book set book_rent_cnt = round(dbms_random.value(12, 50),0);

select book_rent_cnt from book;

commit;
----수아
drop table department;
create table department (
    dept_code varchar2(20),
    dept_name varchar2(30),
    CONSTRAINT dept_code_pk PRIMARY KEY(dept_code)
);
insert into department values('000', '관장');
insert into department values('001', '총무부');
insert into department values('002', '교육부');
insert into department values('003', '정보부');

-- 삭제예정
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
values(1000001,'강수아','01068618619','서울시,이문동','02451','000','9501072222222','F',sysdate-3000,null,'koongmom@librain.org','관장',10000000,'하나','111111111111','950107');
insert into employee_management
values(1000002,'이소영','01011111111','서울시,동동동','02451','001','9901012222222','F',sysdate-2000,null,'soyoung@librain.org','팀장',3000000,'하나','111111111111','990101');
insert into employee_management
values(1000003,'남민지','01022222222','고촌,고촌','02451','002','9901012222222','F',sysdate-1000,null,'zzangmom@librain.org','팀장',3000000,'하나','111111111111','990101');
insert into employee_management
values(1000004,'문혜수','01033333333','양주,술은 양주가 최고','02451','002','9901012222222','F',sysdate-2400,null,'hyesudaldal@librain.org','사원',2500000,'하나','111111111111','990101');
insert into employee_management
values(1000005,'박예원','01044444444','예원이집,집집','02451','003','9901012222222','F',sysdate-1300,null,'nanyewoni@librain.org','팀장',3000000,'하나','111111111111','990101');
insert into employee_management
values(1000006,'김승수','01055555555','종로,비트캠프','02451','003','9901011222222','M',sysdate-3700,null,'iamseungsu@librain.org','사원',2500000,'하나','111111111111','990101');
insert into employee_management
values(1000007,'한예슬','01012341234','종로,비트캠프','02451','001','9901012222222','F',sysdate-3700,null,'asdf@librain.org','사원',2500000,'하나','111111111111','990101');
insert into employee_management
values(1000008,'제니','01034563456','종로,비트캠프','02451','001','9901012222222','F',sysdate-3700,null,'qwer@librain.org','사원',2500000,'하나','111111111111','990101');
insert into employee_management
values(1000009,'손나은','01045674567','종로,비트캠프','02451','002','9901012222222','F',sysdate-3700,null,'zxcv@librain.org','사원',2500000,'하나','111111111111','990101');
insert into employee_management
values(1000010,'정우성','01056785678','종로,비트캠프','02451','003','9901012222222','M',sysdate-3700,null,'abab@librain.org','사원',2500000,'하나','111111111111','990101');
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
    sal_total number, -- 총 급여
    sal_real number, -- 실제로 받는 급여
    sal_national_pension number, -- 국민연금 4.5
    sal_health_insurance number, -- 건강보험 3.23
    sal_longterm_care_insurance number, -- 장기요양 건보 8.51
    sal_employment_insurance number, -- 고용보험 0.65
    sal_income_tax number, -- 소득세 0.7375
    sal_local_income_tax number, -- 소득세 10퍼
    sal_deducted number, -- 공제액 합
    sal_basic_pay number, -- 기본급 200만원정도
    sal_bonus number,
    sal_food_pay number, -- 식대 15만원
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
-----------------------소영
select * from table board;
drop table board;

create table board( -- 게시판 테이블
board_no number not null,      --게시물 번호
board_title varchar2(200) not null,   --제목
board_content varchar2(4000),      --내용
board_writer varchar2(50) not null,   --이름
board_regdate date default sysdate,   --작성일자
board_updatedate date default sysdate
--,board_viewcnt number default 0   --조회수
);

alter table board add constraint pk_board
primary key (board_no);

drop sequence seq_board;
create sequence seq_board;
--------------------------------------------------------
--더미 입력
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
insert into board (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '테스트제목', '테스트내용', 'user00');
commit;

-----------------------------------
--파일첨부 테이블 생성

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

create table notice( --공지게시판
board_no number not null,      --게시물 번호
board_title varchar2(200) not null,   --제목
board_content varchar2(4000),      --내용
board_writer varchar2(50) not null,   --이름
board_regdate date default sysdate,   --작성일자
board_updatedate date default sysdate
);


alter table notice add constraint pk_notice
primary key (board_no);

-------------- 더미 입력
insert into notice (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '필독', '공지사항을 꾸준히 확인하세요', 'admin');
commit;
insert into notice (board_no, board_title, board_content, board_writer) 
values(seq_board.nextval, '게시판 이용 규칙', '공지사항과 사내소식만을 업데이트 합니다. 업무와 관련 없는 이야기는 삼가해주세요.', 'admin');
commit;
-------------------승수 
drop table Facilities;
drop table Facilities_inspection;
create table Facilities( --시설물
Fac_serialnum number  ,          --일련번호 PK
Fac_name varchar2(30),         -- 시설물 
Fac_address varchar2(30) ,   --위치
Fac_status varchar2(30),
Fac_category varchar2(30)
);
create table Facilities_inspection(   --시설물 점검
FacIn_serialnum  number ,                           --점검한것 Facilities의 fk
FacIn_name varchar2(30),                --시설물 이름
FacIn_address varchar2(30),               --시설물 장소                 --시설물 상태
FacIn_Inspection_Date date default sysdate,    -- 점검일 
FacIn_Inspection_Due_Date date                 --점검예정일 
);


commit;


insert into  Facilities values(1,'책상','1층열람실','고장','목재');
insert into  Facilities values(2 ,'책상','1층열람실','정상 ','목재');
insert into  Facilities values(3,'책상','1층열람실','정상 ','목재');
insert into  Facilities values(4,'팩스','1층열람실','정상 ','가전제품');
insert into  Facilities values(5,'프린터','1층열람실','정상 ','가전제품');
insert into  Facilities values(6,'컴퓨터','2관시설팀','고장 ','가전제품');
insert into  Facilities values(7,'컴퓨터','3관2층','정상 ','가전제품');
insert into  Facilities values(8,'컴퓨터','1층열람실','정상 ','가전제품');
insert into  Facilities values(9,'의자','1층열람실','정상 ','목재');
insert into  Facilities values(9,'','1층열람실','정상 ','목재');



--시설더미 
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(1,'엘레베이터','1관',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(2,'에스컬레이터','1관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'에스컬레이터','2관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'에스컬레이터','3관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(4,'엘레베이터','2관',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(5,'소화기','2관',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(6,'소화기','2관1층',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(7,'소화기','2관2층',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(8,'소화기','2관3층',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(9,'소화기','2관4층',sysdate,sysdate+3);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(10,'소화기','2관5층',sysdate,sysdate+5);


commit;


create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type) 
is
begin
 case when f_name='엘레베이터' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='계량기' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
        
      when f_name='소화기' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+20,facin_address=f_address where FacIn_serialnum=f_number;
        when f_name='분전함' then
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
 case when f_name='엘레베이터' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '엘레베이터',sysdate,sysdate+180 ,f_address);
      when f_name='계량기' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '계량기',sysdate,sysdate+30 ,f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date ,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), f_name,sysdate,sysdate+f_cycle,f_address);
 
 end case;
end;
/

commit;

drop table member;

create table member( -- 회원
    mem_id varchar2(50), --회원아이디
    mem_pw varchar2(50), --회원비밀번호
    mem_name varchar2(30), --회원이름
    mem_jumin varchar2(30), --주민번호
    mem_address varchar2(200), --회원주소
    mem_address_number varchar2(20), --우편번호
    mem_phone varchar2(50), --회원폰번호
    mem_email varchar2(50), --회원이메일
    mem_rank number default 2 -- 권한 변경(1. 블랙리스트/ 2. 일반회원/ 3. 국가유공자)
   --constraint member_pk primary key (mem_id)
);

insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('nmj', 'ming0729!123', '남민지', '9307292111111', '경기도 김포시 고촌읍 수기로 67-50, 119동 802호', '10130', '01085340280', 'ming_0729@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pyw', '4321', '박예원', '9711112111111', '서울시 종로구 비트캠프', '11111', '01011111111', 'pyw@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('captainss', '1234', '김승수', '9310131111111', '서울시 종로구의 어느 고시원', '01111', '01022222222', 'kss@naver.com');

insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lsy', '2345', '이소영', '9707111111111', '서울시 영등포구 오피스텔', '58642','01012342345', 'soso@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ksa', '5432', '강수아', '9511111111111', '서울시 양천구 ', '52325', '01012673421', 'sooa@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('mhs', '3456', '문혜수', '9611111111111', '서울시 강남구', '35473', '01011112222', 'hyesoo@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kdw', '6543', '강동원', '8111111111111', '서울시 강북구', '34578', '01011113333', 'dongwon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jws', '4567', '정우성', '7311111111111', '서울시 송파구', '95463', '01011114444', 'sung@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jdg', '7654', '장동건', '7211111111111', '서울시 성북구', '34865', '01011115555', 'shotgun@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kth', '5678', '김태형', '8211111111111', '경기도 광명시', '89658', '01011116666', 'hyunbin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('cew', '8765', '차은우', '9711111111111', '서울시 중구', '53257', '01011117777', 'dongmin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('dks', '6789', '도경수', '9311111111111', '서울시 강동구', '35278', '01011118888', 'kyungsoo@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jjh', '9876', '주지훈', '8211111111111', '서울시 도봉구', '94214', '01011119999', 'jihoon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjk', '1122', '송중기', '8511111111111', '서울시 중랑구', '73241', '01011111122', 'joongki@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hjw', '1133', '하정우', '7811111111111', '서울시 강서구', '86552', '01011111133', 'letswalk@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ljj', '1144', '이정재', '7311111111111', '서울시 구로구', '56345', '01011111144', 'kingjae@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jjs', '1155', '조정석', '8011111111111', '서울시 관악구', '31278', '01011111155', 'yongnam@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jcw', '1166', '지창욱', '8711111111111', '서울시 금천구', '75648', '01011111166', 'changwook@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kjh', '1177', '김지훈', '8111111111111', '서울시 성동구', '64245', '01011111177', 'kjihoon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjs', '1188', '소지섭', '7711111111111', '서울시 용산구', '56378', '01011111188', 'cowjis@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('skj', '1199', '서강준', '9311111111111', '서울시 서대문구', '35424', '01011111199', 'westliver@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('yjk', '1233', '여진구', '9711111111111', '서울시 동대문구', '86543', '01011112211', 'jinggu@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kms', '2546', '김민석', '9011111111111', '서울시 노원구', '64785', '01011112233', 'minseok@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('jyh', '7543', '정윤호', '8611111111111', '서울시 강북구', '12576', '01011112244', 'passionjyh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hmh', '7553', '황민현', '9511111111111', '서울시 은평구', '52158', '01011112255', 'hwngje@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pjh', '4676', '박지훈', '9911111111111', '서울시 동작구', '76355', '01011112266', 'winkjh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('pcy', '4673', '박찬열', '9211111111111', '서울시 성북구', '35468', '01011112277', 'real_pcy@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hsw', '3464', '하성운', '9411111111111', '서울시 송파구', '21348', '01011112288', 'hacloud@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kmj', '9774', '김민주', '0111111111111', '서울시 강남구', '18576', '01011112299', 'miguri@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kjh', '6845', '김지호', '9711111111111', '서울시 송파구', '34185', '01011113311', 'kingjiho@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ayj', '6545', '안유진', '0311111111111', '서울시 노원구', '67523', '01011113322', 'anujin@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kty', '5415', '김태연', '8911111111111', '서울시 도봉구', '37586', '01011113355', 'tangtang@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kyr', '5638', '권유리', '8911111111111', '서울시 강북구', '16854', '01011113366', 'yulyuri@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lya', '5241', '임윤아', '9011111111111', '서울시 중랑구', '81385', '01011113377', 'yoona@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('csy', '5447', '최수영', '8911111111111', '서울시 광진구', '33153', '01011113388', 'choiswim@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khy', '2148', '김효연', '8911111111111', '서울시 동작구', '53158', '01011113399', 'hyoyeon@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sjh', '3541', '서주현', '9111111111111', '서울시 구로구', '56905', '01011115511', 'westjh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lsg', '3267', '이순규', '8911111111111', '서울시 강서구', '31058', '01011115522', 'leesgu@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('hmy', '1206', '황미영', '8911111111111', '서울시 양천구', '63410', '01011115533', 'stafanih@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khn', '1024', '강하늘', '8911111111111', '서울시 동대문구', '35740', '01011115544', 'kangsky@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('khj', '5855', '공효진', '8011111111111', '서울시 중구', '50576', '01011115566', 'ballhj@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('lmh', '3212', '이민호', '8711111111111', '서울시 서대문구', '07645', '01011115577', 'leemh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('psh', '7832', '박신혜', '9011111111111', '서울시 성북구', '63205', '01011115588', 'parksh@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ljs', '8723', '이종석', '8911111111111', '서울시 은평구', '86405', '01011115599', 'leebells@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kwb', '5436', '김우빈', '8911111111111', '서울시 강동구', '94520', '01011116611', 'cowbean@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('sma', '8652', '신민아', '8411111111111', '서울시 관악구', '34210', '01011116622', 'godma@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('bsj', '7514', '배수지', '9411111111111', '서울시 금천구', '67520', '01011116633', 'boatsj@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('kms', '8527', '김명수', '9211111111111', '서울시 은평구', '50864', '01011116655', 'myungs@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('shs', '3748',  '신혜선', '8911111111111', '서울시 용산구', '64105', '01011117788', 'godhs@naver.com');
insert into member(mem_id,mem_pw,mem_name,mem_jumin,mem_address,mem_address_number,mem_phone,mem_email) values('ppg', '4162', '박보검', '9311111111111', '서울시 송파구', '46876', '01011118956', 'bogummy@naver.com');

commit;


delete from Facilities where fac_name is null;
select * from Facilities;




 create or replace procedure proc_rentaldelayed
    is
    
    begin
    
     for delayedlist in (select * from rental where rent_enddate<sysdate) loop -- 책 반납안한사람들
    update member set deadline_rent_stop=nvl(deadline_rent_stop,sysdate)+1 where mem_id=delayedlist.mem_id;
    
    end loop;
     end; 
     /
     exec proc_rentaldelayed();
     exec proc_deadlinecheck();
     select * from rental;
     select     * from member;
     
     commit;
     
     --대출정지 해제
     create or replace procedure proc_deadlinecheck
    is
    
    begin
    
     for deadlinecheck in (select * from member where deadline_rent_stop<sysdate) loop -- 책 반납 안했던사람들
    update member set book_loanable='대출가능' where mem_id=deadlinecheck.mem_id;
    
    end loop;
     end; 
     /
     exec proc_deadlinecheck();
     /
     
     
     select * from wqodqwopdkqwo;
    ALTER table member add(DEADLINE_RENT_STOP date,book_loanable varchar2(20) default '대출가능');
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
      DBMS_OUTPUT.PUT_LINE('부서명 : '||hohoho.dd2 );
     --   insert into test2(dd,dd2) values(1||hohoho.dd  ,  1||hohoho.dd2);
    end loop;
    
    close hoijja;
      
    end;
    /
    
    create or replace procedure proc_proc_proc
    is
    
    begin
    proc_proc_proc();
    
    end;
    /
    commit;
   exec  proc_pipa_proc();
   exec proc_proc_proc();
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

-- not null이거나 , index 컬럼을 pk로 설정시  where이 없어도  index를 탄다.


select /*+INDEX_desc(test2 index_test2test2)  */ namename,namename2 from test2;
select /*+INDEX_asc(test2 index_test2test2)  */ namename,namename2 from test2;
select * from test2;


select /*+INDEX_asc(test2 index_test2test2)  */ * from test2 where 'a'<namename;
select * from test2;


select * from test2;


select * from reservation;
--예약한 기록은 0 으로 바꿈 
select * from reservation;
select * from rental;
-- rental 기록은 예약안함으로 바꿈 

-- 
select * from rental;
select * from book;


select * from (select b.*, nvl(r.rent_status,'대여가능') rent from 
(select * from book order by book_num desc) b join (select book_num, rent_status from rental where rent_startdate in 
(select max(rent_startdate) 
from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '대여중') r on (b.book_num = r.book_num));

select * from ( select rownum rnum, b.*, nvl2(rent_status,'대여가능','대여가능') rent from 
(select * from book where book_num = 100001) b left outer join 
(select book_num, rent_status from rental where   rent_startdate in 
(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
(b.book_num = r.book_num)) ;
select * from rental;





select * from ( select rownum rnum, b.*, nvl2(rent_status,'대여가능','대여가능') rent from 
(select * from book where book_num = 100001) b left outer join 
(select book_num, rent_status from rental where   rent_startdate in 
(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
(b.book_num = r.book_num)) ;

select * from ( select rownum rnum, b.*,(case when r.rent_status='반납' then '대여가능'
                                                     when r.rent_status is null then '대여가능'
                            else '대여중' end)  rent from 
													(select * from book where book_num = 100001) b left outer join 
																							(select book_num, rent_status from rental where   rent_startdate in 
																							(select max(rent_startdate) from rental group by book_num)   and rent_num in (select max(rent_num) from rental group by book_num)  ) r on
																							(b.book_num = r.book_num)) ;l
       
        select * from
          ( select rownum rnum, b.*, nvl(rent_status,'대여가능') rent
                  from  (select * from book where book_num = #{ book_num }) b
                  left outer join (select book_num, rent_status from rental
                                  where rent_startdate in (select max(rent_startdate) from rental  group by book_num) 
                                  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
                  on (b.book_num = r.book_num));
                  
       
 select * from
          ( select rownum rnum, b.*, (case when r.rent_status='반납' then '대여가능'
                                                     when r.rent_status is null then '대여가능'
                                                     when r.rent_status ='예약중' then '예약중' 
                            else '대여중' end) rent
                  from  (select * from book where book_num = 100001) b
                  left outer join (select book_num, rent_status from rental
                                  where rent_startdate in (select max(rent_startdate) from rental  group by book_num) 
                                  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
                  on (b.book_num = r.book_num))
;
select * from member;
select * from (select b.*, nvl(r.rent_status,'대여가능') rent ,rent_num  from (select * from book order by book_num desc) b join (select book_num, rent_status ,rent_num from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '대여중' or rent_status='예약중') r on (b.book_num = r.book_num)) ;
commit;
select * from rental;
select * from rental;
select * from (select b.*, nvl(r.rent_status,'대여가능') rent from (select * from book order by book_num desc) b join (select book_num, rent_status from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '대여중' or rent_status='예약중') r on (b.book_num = r.book_num)) ;
 insert into rental values((select nvl(max(rent_num)+1,1) from rental), 100001, 'nmj', sysdate, sysdate+7, 'X', 'X', '예약중');
 select * from rental
 select * from reservation;
 select * from reservation,rental;
 select count(*) from reservation where book_num =100001;
 
 select * from (select b.*, nvl(r.rent_status,'대여가능') rent from (select * from book order by book_num desc) b join (select book_num, rent_status from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id ='nmj' and rent_status = '대여중' or (rent_status='예약중' and  rental.mem_id ='nmj') ) r on (b.book_num = r.book_num))