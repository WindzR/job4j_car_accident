INSERT INTO types(name) VALUES ('Две машины'), ('Машина и человек'), ('Машина и велосипед'), ('Одно транспортное средство');
INSERT INTO rules(name) VALUES ('Статья. 1'), ('Статья. 2'), ('Статья. 3'),
                               ('Статья. 4'), ('Статья. 5'), ('Статья. 6');

INSERT INTO accident (id, name, description, created, address, type_id) VALUES (1, 'Авария',  'Столкновение 2х легковых транспотных средств', '2021-12-22 08:05:00', 'Москва, Проспект Мира 112', 1);
INSERT INTO accident (id, name, description, created, address, type_id) VALUES (2, 'Превышение скоростного режима',  'Превышение скоростного режима более чем на 20 км/ч', '2021-12-22 08:05:00', 'Москва, Ярославское шоссе, 13 км', 4);
INSERT INTO accident (id, name, description, created, address, type_id) VALUES (3, 'Отсутствие необходимых СНИП',  'Отсутствие необходимых лекарств в аптечке', '2021-12-22 08:05:00', 'г.Мытищи, Ярославское шоссе , 16 км', 4);

INSERT INTO accident_rules(id, accident_id, rules_id) VALUES (1 , 1 , 2);
INSERT INTO accident_rules(id, accident_id, rules_id) VALUES (2 , 1 , 3);
INSERT INTO accident_rules(id, accident_id, rules_id) VALUES (3 , 2 , 4);
INSERT INTO accident_rules(id, accident_id, rules_id) VALUES (4 , 3 , 6);