
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (1, 'Poland', '4', 'Sharaton');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (2, 'DE', '3', 'Deutsche hotel');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (3, 'Poland', '4', 'Astoria Gold Hotel');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (4, 'Poland', '4', 'BEST WESTERN Efekt Express Kraków ');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (5, 'Hungary', '5', 'Queen''s Court Hotel & Residence');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (6, 'Italy', '3', 'Amedeo');
INSERT INTO app_hotel.hotel (id, country, rate, title) VALUES (7, 'Italy', '100/200', 'Amedeo');

INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (1, 1);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (1, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (1, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (2, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (2, 1);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (2, 1);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (2, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (3, 1);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (4, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (5, 1);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (5, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (3, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (5, 2);
INSERT INTO app_hotel.hotel_room (hotel_id, room_id) VALUES (6, 2);


INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (2, 'Krakow', 'dsfsd@sdfa.com', '+481264525987', 'Krakowska', '45', 'www.hotelkrakow.pl', 1);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (3, 'DE', 'sdfsd@sdaf.pl', '+3215365425888', 'JoinStreeat', '2', 'www.wp.pl', 2);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (4, 'Kraków', 'hotel@krakow.pl', '+481264552879', 'ul.Józefa ', '24', 'www.bg.pl', 3);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (5, 'Kraków', 'hotelKrak@krak.pl', '+481247585879', 'ul.Opolska', '14', 'www.op.pl', 4);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (6, 'Budapeszt', 'hungary@hotel.hu', '+351564589789', 'Dob utca ', '63', 'www.hu.com', 5);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (7, 'Rzym', 'rzym@Wp.it', '+281645989789', 'Via Principe Amedeo,', '11', 'www.italy.com', 6);
INSERT INTO app_hotel.address (id, city, email, phone, street, street_number, url, hotel_id) VALUES (8, 'Rzym', 'rzym@Wp.it', '+281645989789', 'Via Principe Amedeo,', '100/200', 'www.italy.com', 7);

-- INSERT INTO app_hotel.room (id, bad, capacity, type) VALUES (1, 'łożko', '2', 'standard');
-- INSERT INTO app_hotel.room (id, bad, capacity, type) VALUES (2, 'dostawka', '1', 'dodatkowe');
