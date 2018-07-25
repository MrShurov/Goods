/*insert for calculate test*/

INSERT INTO public.goods (goodid, goodname) VALUES (1, 'Ванны моечные разборные');
INSERT INTO public.goods (goodid, goodname) VALUES (2, 'Ванны моечные сварные');
INSERT INTO public.measures (measureid, measurename) VALUES (1, 'килограммы');
INSERT INTO public.measures (measureid, measurename) VALUES (2, 'литры');
INSERT INTO public.measures (measureid, measurename) VALUES (3, 'грамыы');
INSERT INTO public.measures (measureid, measurename) VALUES (4, 'штуки');
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (1, 'Лист 0,8 ст 430', 2.5, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (2, 'Лист 1,2 ст 430', 2.5, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (3, 'Лист 0,8 чёрн', 0.6, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (4, 'Лист 1,2 чёрн', 0.6, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (5, 'Лист 0,8 оцинк', 0.7, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (6, 'Лист 1,2 оцинк', 0.7, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (7, 'Тр. 25х25х1,2нерж', 3.3, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (8, 'Проволока сварочн.нерж.Ф1,2 кг', 1, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (9, 'Газ аргон л', 1, 1, 2);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (10, 'Вольфрам лантана Ф2 г', 1, 1, 3);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (11, 'Опора пластиковая уголок 40х40 с грибком (Лида)', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (12, 'Сифон универсальный', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (13, 'Порошковая краска 7035 89/70220', 1, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (14, 'Винт ww М5х16 КВ-РН', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (15, 'Гайка М5', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (16, 'Болт М6х40', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (17, 'Гайка М6', 1, 1, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (19, 'Проволока сварочн.нерж.Ф 0,8', 1, 2, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (20, 'Углекислота  л', 1, 2, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (18, 'Уголок 1,5 390.002.101', 1, 2, 4);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (21, 'Лист 1,5 чёрн', 1, 1, 1);
INSERT INTO public.materials (materialid, materialname, price, goodid, measureid) VALUES (22, 'Проволока  Св08Г2С-0', 1, 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (1, 'Заготовительные', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (2, 'Штамповочные', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (3, 'Гибочные', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (4, 'Слесарно-сварочные (контактная сварка)', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (5, 'Слесарно-сварочные (каркас)', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (6, 'Обварка', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (7, 'Полимерная', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (8, 'Слесарные(зачистка полировка)', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (9, 'Транспортные', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (10, 'Комплектовочные', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (11, 'Упаковочные', 1, 1);

/*Insert for login test*/

INSERT INTO public.users (userid, enabled, password, username) VALUES (1, true, '$2a$04$KVH/IiPGThppCz3DEW.Z6.WL8M5qFE8uGpE/f5qbf.weITtG.mgJ.', 'Shurov');
INSERT INTO public.role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO public.role (role_id, role) VALUES (2, 'USER');
INSERT INTO public.user_role (user_id, role_id) VALUES (1, 1);
