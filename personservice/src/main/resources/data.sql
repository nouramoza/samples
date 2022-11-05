-- drop table if exists person CASCADE;
--
-- drop sequence if exists hibernate_sequence;
-- create sequence hibernate_sequence start with 1 increment by 1;
--
create table person (
                        id bigint not null,
                        first_name varchar(25) not null,
                        home_address varchar(255) not null,
                        last_name varchar(40) not null,
                        national_code varchar(10) not null,
                        phone_number varchar(11) not null,
                        primary key (id)
);
--
-- alter table person
--     add constraint UK_ognwg0gojjjt42dq7keq6py0x unique (national_code);


insert into person (id, first_name, last_name, national_code, phone_number,  home_address)
values (101, 'Noura', 'Mozafari', '2064865391', '09113149630', 'Tehran, Majidie');

insert into person (id, first_name, last_name, national_code, phone_number,  home_address) 
values (102, 'Ali', 'Rahimi', '7726019092', '09358371020', 'Tehran');

insert into person (id, first_name, last_name, national_code, phone_number,  home_address) 
values (103, 'Zahra', 'Ahmadi', '8372098371', '09330902983', 'Ahwaz');

insert into person (id, first_name, last_name, national_code, phone_number,  home_address) 
values (104, 'Hasan', 'Rezaee', '9802736251', '09358548790', 'Iran');

insert into person (id, first_name, last_name, national_code, phone_number,  home_address) 
values (105, 'Hoda', 'Salehi', '0093871019', '09127362817', 'Tehran');

insert into person (id, first_name, last_name, national_code, phone_number,  home_address) 
values (106, 'Hamid', 'Aghaee', '8729182032', '09359340909', 'Tehran');

