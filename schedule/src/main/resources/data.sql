drop table if exists students;
drop table if exists courses;
drop table if exists students_courses;
-- auto-generated definition
create table students
(
    id        int auto_increment
        primary key,
    name      varchar(255) not null,
    email     varchar(255) not null,
    age       int          null,
    birthdate datetime     not null
);


-- auto-generated definition
create table courses
(
    id          int auto_increment
        primary key,
    title       varchar(255) not null,
    description varchar(255) not null,
    lector      varchar(255) not null
);

-- auto-generated definition
create table students_courses
(
    student_id int not null,
    course_id  int not null,
    primary key (student_id, course_id)
);

create index students_courses_courses_id_fk
    on students_courses (course_id);



