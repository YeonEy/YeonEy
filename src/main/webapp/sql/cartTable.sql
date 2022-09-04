 --장바구니 테이블
   drop table cart purge;
  create table cart
  (  num NUMBER(6) PRIMARY KEY, --장바구니 번호
     userid VARCHAR2(10), --사용자 id
     gCode varchar2(20) not null, --상품 코드
     gName varchar2(50) not null, --상품 이름
     gPrice NUMBER(6) not null, --상품 가격
     gSize CHAR(1) not null, -- 상품 사이즈
     gColor VARCHAR2(10) not null, --상품 색
     gAmount NUMBER(2) not null, --상품 수량
     gImage varchar2(20) not null --상품 이미지
  );   
   
  alter table cart
  add CONSTRAINT cart_userid_fk FOREIGN KEY(userid)
   REFERENCES member(userid) ON DELETE CASCADE;
   
  alter table cart
  add CONSTRAINT cart_gCode_fk FOREIGN KEY(gCode)
   REFERENCES goods(gCode) ON DELETE CASCADE;    
   
    create sequence cart_seq; --장바구니 번호 시퀀스