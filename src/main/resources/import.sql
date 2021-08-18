/* PUBLISHER */
INSERT INTO publisher (id,name) VALUES (1,'p1');
INSERT INTO publisher (id,name) VALUES (2,'p2');
INSERT INTO publisher (id,name) VALUES (3,'p3');
INSERT INTO publisher (id,name) VALUES (4,'p4');
INSERT INTO publisher (id,name) VALUES (5,'p5');
INSERT INTO publisher (id,name) VALUES (6,'p6');
INSERT INTO publisher (id,name) VALUES (7,'p7');
INSERT INTO publisher (id,name) VALUES (8,'p8');
INSERT INTO publisher (id,name) VALUES (9,'p9');
INSERT INTO publisher (id,name) VALUES (10,'p10');

/* AUTHOR */
INSERT INTO author (id,name,surname) VALUES (20,'Mark','Manson');
INSERT INTO author (id,name,surname) VALUES (21,'Mihaly','Csikszentmihalyi');
INSERT INTO author (id,name,surname) VALUES (22,'Robert','Wright');
INSERT INTO author (id,name,surname) VALUES (23,'Engin','Gectan');
INSERT INTO author (id,name,surname) VALUES (24,'Cal','Newport');
INSERT INTO author (id,name,surname) VALUES (25,'Daniel','Kahneman');
INSERT INTO author (id,name,surname) VALUES (26,'Matthew', 'Walker');

/* BOOK */
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (27,3,123,'The Subtle Art of Not Giving a F*ck','Non-Fiction',1);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (28,2,124,'Flow','Psychology',2);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (29,1,125,'Evolution of God','Theology',4);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (30,4,126,'Insan Olmak','Psychology',2);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (31,1,127,'Deep Work','Non-Fiction',5);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (32,1,128,'So Good They Cant Ignore You','Non-Fiction',5);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (33,5,129,'Thinking, Fast and Slow','Non-Fiction',7);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (34,2,130,'Why We Sleep?','Non-Fiction',9);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (35,2,131,'Digital Minimalism','Non-Fiction',5);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (36,3,132,'I, Robot','Fiction',6);
INSERT INTO book (id,count,isbn,title,genre,publisher_id) VALUES (37,1,133,'Midak Sokagi','Fiction',6);

/* BOOK_AUTHOR */
INSERT INTO book_author (book_id,author_id) VALUES (27,20);
INSERT INTO book_author (book_id,author_id) VALUES (28,21);
INSERT INTO book_author (book_id,author_id) VALUES (29,22);
INSERT INTO book_author (book_id,author_id) VALUES (30,23);
INSERT INTO book_author (book_id,author_id) VALUES (31,24);
INSERT INTO book_author (book_id,author_id) VALUES (32,24);
INSERT INTO book_author (book_id,author_id) VALUES (33,25);
INSERT INTO book_author (book_id,author_id) VALUES (34,26);
INSERT INTO book_author (book_id,author_id) VALUES (35,24);

/* USER */
INSERT INTO users (id,name,surname,email) VALUES (38,'u1','do1','u1@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (39,'u2','do2','u2@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (40,'u3','do3','u3@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (41,'u4','do4','u4@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (42,'u5','do5','u5@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (43,'u6','do6','u6@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (44,'u7','do7','u7@mail.com');
INSERT INTO users (id,name,surname,email) VALUES (45,'u8','do8','u8@mail.com');

/* BORROW */
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (46,null,null,null,27,38);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (47,null,null,null,27,39);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (48,null,null,null,28,39);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (49,null,null,null,29,40);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (50,null,null,null,30,41);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (51,null,null,null,30,44);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (52,null,null,null,31,45);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (53,null,null,null,31,42);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (54,null,null,null,32,42);
INSERT INTO borrow (id,borrow_date,due_date,return_date,book_id,user_id) VALUES (55,null,null,null,35,44);

