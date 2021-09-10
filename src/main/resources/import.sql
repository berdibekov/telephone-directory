insert into contacts (id, birth_date, first_name, patronymic, last_name) values (0, '2000-01-01', 'Александр', 'Сергеевич', 'Пушкин');
insert into contacts (id, birth_date, first_name, patronymic, last_name) values (1, '2000-01-01', 'Антон', 'Павлович', 'Чехов');
insert into contacts (id, birth_date, first_name, patronymic, last_name) values (2, '2000-01-01', 'Петр', 'Ильич', 'Чайковский');
insert into contacts (id, birth_date, first_name, patronymic, last_name) values (3, '2000-01-01', 'Лев', 'Николаевич', 'Толстой');

insert into ADRESSES(id, ADDRESS) values (0, 'address 0');
insert into ADRESSES(id, ADDRESS) values (1, 'address 1');
insert into ADRESSES(id, ADDRESS) values (2, 'address 2');
insert into ADRESSES(id, ADDRESS) values (3, 'address 3');
insert into ADRESSES(id, ADDRESS) values (4, 'address 4');

insert into CONTACTS_ADDRESSES(contact_id, addresses_id) values (0, 0);
insert into CONTACTS_ADDRESSES(contact_id, addresses_id) values (0, 1);
insert into CONTACTS_ADDRESSES(contact_id, addresses_id) values (1, 2);
insert into CONTACTS_ADDRESSES(contact_id, addresses_id) values (2, 3);
insert into CONTACTS_ADDRESSES(contact_id, addresses_id) values (3, 4);
