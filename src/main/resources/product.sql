drop table if exists Product_seq;
Create table Product_seq
(
    id   int not null,
    constraint pk_Product_seq primary key (id)
)
;

drop table if exists Product;
Create table Product
(
    id   int not null,
    name  varchar(90),
    price double,
    constraint pk_product primary key (id)
)
;