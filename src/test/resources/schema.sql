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
--
--
create table student_course_map (
                                    course_id bigint not null,
                                    appuser_id bigint not null
);
--
--


create table app_user (
                          id bigint not null,
                          app_user_role varchar(255),
                          email varchar(255),
                          enabled boolean,
                          first_name varchar(255),
                          last_name varchar(255),
                          locked boolean,
                          password varchar(255),
                          primary key (id)
);