create table ���[�U�}�X�^(
���[�UID char(3) primary key,
���[�U�� varchar(30),
�p�X���[�h varchar(8))

insert into ���[�U�}�X�^ values('001','�m������','aaa')

select * from ���[�U�}�X�^

create table ���i�}�X�^(
���iID int primary key,
���i�� varchar(50),
�J�e�S��ID char(2),
�d���P�� int,
�̔��P�� int,
�댯�݌ɐ� int,
�폜�t���O char(1))

insert into ���i�}�X�^ values(5,'�v�����[��DX','01',1500,2800,60,'0')

update ���i�}�X�^ set �J�e�S��ID = '03' where ���iID = 1

select * from ���i�}�X�^
order by ���iID

create table �J�e�S���}�X�^(
�J�e�S��ID char(2) primary key,
�J�e�S���� varchar(30))

insert into �J�e�S���}�X�^ values('03','�p�[�e�B�[�p')

select * from �J�e�S���}�X�^
order by �J�e�S��ID

commit

select ���iID,���i��,�J�e�S����,�d���P��,�̔��P��,�댯�݌ɐ�
from ���i�}�X�^ inner join �J�e�S���}�X�^
on ���i�}�X�^.�J�e�S��ID = �J�e�S���}�X�^.�J�e�S��ID
where �폜�t���O = '0'
order by ���iID

