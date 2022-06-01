set search_path to project_app;

insert into user_roles (name) values ('ADMIN'), ('BASIC_USER'), ('PREMIUM_USER');

insert into app_users (first_name, last_name, email, username, password, role_id)
values 
('Tester', 'McTesterson', 'tester@revature.com', 'tester99', 'p4$$W0RD', 1),
('T', 'TEST', 'test@test.com', 'tester5', 'password', 3);

insert into categories (name) 
values ('Abstract'), ('People'), ('Animals'), ('Nature'), ('Cityscapes');

insert into artwork (art_title, artist, descrip, price, seller_id, category_id)
values 
  ('TestA', 'Sam', 'Style and Size', 'NOT FOR SALE', 2, 2),
  ('2Test', 'Five', '1942', '$723', 3,5),
  ('ATest', 'Five', 'Los Angeles Skyline', '$500', 3, 5),
  ('Testtest', 'V', 'Purple Wolf', '$50', 2, 3),
  ('TestJ', 'Abe', 'Thoughts', '$18,000', 3, 1),
  ('Qtest', 'Jack', 'Field', 'NOT FOR SALE', 2, 4);
	
insert into collections (name, owner_id, category_id)
values 
  ('Test Cities', 2, 5);

insert into indiv_collection (collection_id, artwork_id)
values
(1,2),
(1,3);
  
order by price;
   