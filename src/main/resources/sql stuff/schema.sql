CREATE TABLE class_entity (
                              id bigint not null,
                              class_description varchar(1000),
                              class_name varchar(255),
                              class_number integer not null,
                              cum_dif double not null,
                              cumgpa double not null,
                              department varchar(255),
                              dislikes integer not null,
                              likes integer not null,
                              primary key (id)
                          );