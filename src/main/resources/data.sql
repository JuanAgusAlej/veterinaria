--Veterinaria
insert into Veterinaria (name, matricula, email) values ('Dr.Diego','123abc','drgiego@example.com');
insert into Veterinaria (name, matricula, email) values ('Dr.Juan','111aaa','drjuan@example.com');
insert into Veterinaria (name, matricula, email) values ('Dr.Sergio','999zzz','drsergio@example.com');
insert into Veterinaria (name, matricula, email) values ('Dr.Maxi','222bbb','drmaxi@example.com');

--Vacunas
insert into vacuna (name, fecha_Vencimiento) values ('Vacuna contra la rabia','2026-01-10');
insert into vacuna (name, fecha_Vencimiento) values ('Vacuna contra Covid','2026-04-10');
insert into vacuna (name, fecha_Vencimiento) values ('Vacuna Quintuple','2026-03-10');
insert into vacuna (name, fecha_Vencimiento) values ('Vacuna parvaviruse','2026-02-10');

--Mascotas
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Leonidas','Planta','Macho','2023-01-10',4);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Canela','Perro','Hembra','2023-01-10',2);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Bondiola','Gato','Macho','2023-01-10',3);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Miguel de Guemes','Perro','Macho','2023-01-10',1);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Milo','Perro','Macho','2023-01-10',1);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Gala','Gata','Macho','2023-01-10',2);
insert into mascota (name,especie,sexo, fecha_Nacimiento, veterinario_id) values ('Bati','Perro','Macho','2023-01-10',1);

--Mascotas con vacunas
insert into Mascota_Vacuna (mascota_id, vacuna_id) values (3,2);
insert into Mascota_Vacuna (mascota_id, vacuna_id) values (2,3);
insert into Mascota_Vacuna (mascota_id, vacuna_id) values (1,4);
insert into Mascota_Vacuna (mascota_id, vacuna_id) values (5,2);