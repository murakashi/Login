create table ユーザマスタ(
ユーザID char(3) primary key,
ユーザ名 varchar(30),
パスワード varchar(8))

insert into ユーザマスタ values('001','可士村謙太','aaa')

select * from ユーザマスタ

create table 商品マスタ(
商品ID int primary key,
商品名 varchar(50),
カテゴリID char(2),
仕入単価 int,
販売単価 int,
危険在庫数 int,
削除フラグ char(1))

insert into 商品マスタ values(5,'プラレールDX','01',1500,2800,60,'0')

update 商品マスタ set カテゴリID = '03' where 商品ID = 1

select * from 商品マスタ
order by 商品ID

create table カテゴリマスタ(
カテゴリID char(2) primary key,
カテゴリ名 varchar(30))

insert into カテゴリマスタ values('03','パーティー用')

select * from カテゴリマスタ
order by カテゴリID

commit

select 商品ID,商品名,カテゴリ名,仕入単価,販売単価,危険在庫数
from 商品マスタ inner join カテゴリマスタ
on 商品マスタ.カテゴリID = カテゴリマスタ.カテゴリID
where 削除フラグ = '0'
order by 商品ID

