

INSERT INTO class_entity (id, class_description, class_name, class_number, cum_dif,cumgpa,department,dislikes,likes) VALUES
(1, 'Students will be provided with experience in team design, implementation and testing of a large software project.', 'Software Projects',394,0.00,0.00,'CSC',5,10);


alter table student_course_map
    add constraint FKt0y1i7yyfeo81e8glftnm19gm
        foreign key (course_id)
            references class_entity;


alter table student_course_map
    add constraint FKclrhlb2br6oyhtx45lti04a4n
        foreign key (appuser_id)
            references app_user;