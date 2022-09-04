--주문 테이블
     create table orderInfo
  (  num NUMBER(6) PRIMARY KEY,  --주문번호 시퀀스 사용
     userid VARCHAR2(10), --주문한 회원
     gCode varchar2(20) not null, --주문 상품코드
     gName varchar2(50) not null, 
     gPrice NUMBER(6) not null,
     gSize CHAR(1) not null,
     gColor VARCHAR2(10) not null,
     gAmount NUMBER(2) not null,
     gImage varchar2(20) not null,
     orderName VARCHAR2(10) NOT NULL, --배송자 이름
     post VARCHAR2(5) NOT NULL,
     addr1 VARCHAR2(500) NOT NULL,
     addr2 VARCHAR2(500) NOT NULL,
     phone VARCHAR2(11) NOT NULL,
     payMethod VARCHAR2(30) NOT NULL, --결제수단
     orderDay DATE  DEFAULT SYSDATE
  );   
  alter table orderInfo
  add CONSTRAINT orderInfo_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   