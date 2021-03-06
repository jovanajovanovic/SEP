-- clients
insert into client (id, first_name, last_name, date_of_birth, address, city, id_card_number)
values (1, 'Mika', 'Mikic', '1985-04-11', 'Nikole Tesle 98', 'Novi Sad', '1104858540301');

insert into client (id, first_name, last_name, date_of_birth, address, city, id_card_number)
values (3, 'Djura', 'Djuric', '1985-04-11', 'Nikole Tesle 99', 'Novi Sad', '1104858540302');

insert into client (id, first_name, last_name, date_of_birth, address, city, id_card_number)
values (2, 'Stefan', 'Stefanovic', '1975-04-21', 'Bulevar Oslobodjenja 2', 'Novi Sad', '2104758562301');


-- business
insert into business (id, organization_name, company_registration_number, purpose)
values (1, 'Scientific magazines org', '412809418011230022', 'Subscription earnings');

insert into business (id, organization_name, company_registration_number, purpose)
values (2, 'Scientific magazines org 2', '412809418011230023', 'Subscription earnings 2');


-- merchants
insert into merchant (id, merchant_id, merchant_password, business_id)
values (1, 'c0d179c0-25c7-11ea-978f-2e728ce88125', 'ca371c40-25c7-11ea-978f-2e728ce88125', 1);

insert into merchant (id, merchant_id, merchant_password, business_id)
values (2, 'c0d179c0-25c7-11ea-978f-2e728ce88126', 'ca371c40-25c7-11ea-978f-2e728ce88126', 2);


-- cards
insert into card (id, card_brand, pan, cardholder_name, cvv, expiry_date, blocked)
values (1, 'VISA', '4123450118636944', 'Mika Mikic', '567', '2021-06-01', false);

insert into card (id, card_brand, pan, cardholder_name, cvv, expiry_date, blocked)
values (2, 'VISA', '4123450128636942', 'Stefan Stefanovic', '345', '2021-05-01', false);

insert into card (id, card_brand, pan, cardholder_name, cvv, expiry_date, blocked)
values (3, 'VISA', '4123450118636969', 'Djura Djuric', '234', '2021-07-01', false);


-- bank accounts
insert into bank_account(id, client_id, card_id, balance, business_id)
values (1, 1, 1, 4500, 1);

insert into bank_account(id, client_id, card_id, balance, business_id)
values (3, 3, 3, 10000, 2);

insert into bank_account(id, client_id, card_id, balance)
values (2, 2, 2, 2000);


-- update foreign keys
update client set bank_account_id=1 where id = 1;
update client set bank_account_id=2 where id = 2;
update client set bank_account_id=3 where id = 3;

update business set bank_account_id=1 where id = 1;
update business set merchant_id=1 where id=1;

update business set bank_account_id=3 where id = 2;
update business set merchant_id=2 where id=2;

update card set bank_account_id=1 where id=1;
update card set bank_account_id=2 where id=2;
update card set bank_account_id=3 where id=3;