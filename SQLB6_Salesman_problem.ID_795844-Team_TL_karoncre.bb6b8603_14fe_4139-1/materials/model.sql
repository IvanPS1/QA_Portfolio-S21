create table tour ( 
    id bigint primary key ,
    point1 varchar not null,
    point2 varchar not null,
    cost integer not null 
);

insert into tour values (1, 'a', 'b', 10), 
                        (2, 'a', 'c', 15),
                        (3, 'a', 'd', 20),
                        (4, 'b', 'a', 10),
                        (5, 'b', 'c', 35),
                        (6, 'b', 'd', 25),
                        (7, 'c', 'a', 15),
                        (8, 'c', 'b', 35),
                        (9, 'c', 'd', 30),
                        (10, 'd', 'a', 20),
                        (11, 'd', 'b', 25),
                        (12, 'd', 'c', 30);