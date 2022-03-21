CREATE TABLE cars (id INTEGER PRIMARY KEY ,brand TEXT,model TEXT,cost NUMERIC );
CREATE TABLE drivers (id INTEGER PRIMARY KEY ,name TEXT,age INTEGER ,license BOOLEAN,car_id INTEGER REFERENCES cars(id));

SELECT student.name, student.age,faculty.name FROM student LEFT JOIN faculty ON student.faculty_id = faculty.id;
SELECT student.name FROM avatar INNER JOIN student ON avatar.student_id = student.id;
