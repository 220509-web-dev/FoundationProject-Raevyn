set search_path to art_app;

insert into app_users (first_name, last_name, email, username, password)
values
('Tester', 'McTesterson', 'tester2@revature.com', 'tester99', 'p4$$W0RD'),
('T', 'TEST', 'test@test.com', 'tester5', 'password'),
('Ana', 'Testo', 'tests@testing.com', 'tester7', 'p@sswOrd');

insert into categories (name)
values ('None'), ('People'), ('Animals'), ('Nature'), ('Cityscapes');

insert into artwork (art_title, artist, descrip, price, user_id, category_id)
values
  ('TestA', 'Sam', 'Style and Size', 'NOT FOR SALE', 2, 2),
  ('2Test', 'Five', '1942', '$723', 7,5),
  ('ATest', 'Five', 'Los Angeles Skyline', '$500', 7, 5),
  ('Testtest', 'V', 'Purple Wolf', '$50', 2, 3),
  ('TestJ', 'Abe', 'Thoughts', '$18,000', 7, 1),
  ('Qtest', 'Jack', 'Field', 'NOT FOR SALE', 2, 4);

insert into collections (name, owner_id, category_id)
values
 ('Test Cities', 2, 5);

insert into indiv_collection (collection_id, artwork_id)
values
(1,44),
(1,45);

select * from artwork

