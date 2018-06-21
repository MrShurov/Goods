/*insert for calculate test*/

INSERT INTO public.goods (goodid, goodname) VALUES (1, 'Ванны моечные разборные');
INSERT INTO public.goods (goodid, goodname) VALUES (2, 'Ванны моечные сварные');
INSERT INTO public.measures (measureid, measurename) VALUES (1, 'килограммы');
INSERT INTO public.measures (measureid, measurename) VALUES (2, 'литры');
INSERT INTO public.measures (measureid, measurename) VALUES (3, 'грамыы');
INSERT INTO public.measures (measureid, measurename) VALUES (4, 'штуки');
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (1, 1, 1, 'Лист 0,8 ст 430', true, null, 2.5);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (2, 1, 1, 'Лист 1,2 ст 430  ', true, null, 2.5);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (3, 1, 1, 'Лист 0,8 чёрн', true, null, 0.6);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (4, 1, 1, 'Лист 1,2 чёрн', true, null, 0.6);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (5, 1, 1, 'Лист 0,8 оцинк', true, null, 0.7);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (6, 1, 1, 'Лист 1,2 оцинк', true, null, 0.7);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (7, 1, 1, 'Тр. 25х25х1,2нерж', true, null, 3.3);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (8, 1, 1, 'Проволока сварочн.нерж.Ф1,2 кг', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (9, 1, 2, 'Газ аргон л', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (10, 1, 3, 'Вольфрам лантана Ф2 г', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (11, 1, 4, 'Опора пластиковая уголок 40х40 с грибком (Лида)', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (12, 1, 4, 'Сифон универсальный (по требованию заказчика)', false, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (13, 1, 1, 'Порошковая краска 7035 89/70220', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (14, 1, 4, 'Винт ww М5х16 КВ-РН', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (15, 1, 4, 'Гайка М5', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (16, 1, 4, 'Болт М6х40', true, null, 1);
INSERT INTO public.materials (materialid, goodid, measureid, materialname, mandatory, formula, price) VALUES (17, 1, 4, 'Гайка М6', true, null, 1);
INSERT INTO public.user (userid, username, password) VALUES (1, 'MrShurov', '123');
INSERT INTO public.user (userid, username, password) VALUES (2, '-Moral', '456');
INSERT INTO public.works (workid, workname, count, goodid) VALUES (1, 'Заготовительные', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (2, 'Штамповочные', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (3, 'Гибочные', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (4, 'Слесарно-сварочные (контактная сварка)', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (5, 'Слесарно-сварочные (каркас)', 2, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (6, 'Обварка', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (7, 'Полимерная', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (8, 'Слесарные(зачистка полировка)', 1, 1);
INSERT INTO public.works (workid, workname, count, goodid) VALUES (9, 'Транспортные', 1, 1);

/*Insert for login test*/

INSERT INTO public.role (role_id, role) VALUES (1, 'ADMIN');
INSERT INTO public.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO public.users (userid, enabled, password, username) VALUES (1, true, '$2a$04$KVH/IiPGThppCz3DEW.Z6.WL8M5qFE8uGpE/f5qbf.weITtG.mgJ.', 'Shurov');
