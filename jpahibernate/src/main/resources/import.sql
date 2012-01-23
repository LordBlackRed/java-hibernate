insert into Editorial(id, nombre) values (1, 'editorial1')
insert into Editorial(id, nombre) values (2, 'editorial2')
insert into Editorial(id, nombre) values (3, 'editorial3')
		
insert into Autor(id, nombre) values (1, 'autor1')
insert into Autor(id, nombre) values (2, 'autor2')
		
insert into Cliente(id, nombre, DNI, direccion) values (1, 'cliente1', 'DNI1', 'direccion1')
insert into Cliente(id, nombre, DNI, direccion) values (2, 'cliente2', 'DNI2', 'direccion2')
		
insert into Libro(id, nombre, precio, fechaPublicacion, editorial_id) values (1, 'libro1', 10.50, '2009/12/12',1)
insert into Libro(id, nombre, precio, fechaPublicacion, editorial_id) values (2, 'libro2', 20.50, '2010/12/12',2)
insert into Libro(id, nombre, precio, fechaPublicacion, editorial_id) values (3, 'libro3', 30.50, '2011/12/12',3)
insert into Pedido(id, fecha, pagado, tipoPago, cliente_id) values (1,  '2011/12/12',true,'tarjeta', 1)
insert into Pedido(id, fecha, pagado, tipoPago, cliente_id) values (2,  '2012/12/12',false,'metalico', 2)
insert into PedidoLinea(id, cantidad, libro_id, pedido_id)  values (1, 5, 1, 1)
insert into PedidoLinea(id, cantidad, libro_id, pedido_id)  values (2, 10, 2, 1)
insert into LIBROS_AUTORES( libro_id, autor_id) values (1,1)
insert into LIBROS_AUTORES( libro_id, autor_id) values (2,1)
insert into LIBROS_AUTORES( libro_id, autor_id) values (2,2)






insert into Profesor (id, name) values (1, 'Juan Antonio')
insert into Profesor (id, name) values (2, 'Pepe')



insert into Alumno (id, name, nacimiento, profesor_id) values (1, 'Marta', '2009/12/12', 1)
insert into Alumno (id, name, nacimiento, profesor_id) values (2, 'Joaquin', '2009/12/12', 1)
insert into Alumno (id, name, nacimiento, profesor_id) values (3, 'Paco', '2009/12/12', 1)
insert into Alumno (id, name, nacimiento, profesor_id) values (4, 'Diego', '2009/12/12', 1)
insert into Alumno (id, name, nacimiento, profesor_id) values (5, 'Rafael', '2009/12/12', 1)
insert into Alumno (id, name, nacimiento, profesor_id) values (6, 'David', '2009/12/12', 2)
insert into Alumno (id, name, nacimiento, profesor_id) values (7, 'Andres', '2009/12/12',2)




insert into Ciudad (codigo) values ('Cádiz')
insert into Ciudad (codigo) values ('Sevilla')
insert into Ciudad (codigo) values ('Dos Hermanas')
insert into Ciudad (codigo) values ('Jerez de la Frontera')
insert into Ciudad (codigo) values ('Sanlúcar de Barrameda')

insert into Inmobiliaria (cif, nombre) values ('11111111A' , 'Tecnocasa')
insert into Inmobiliaria (cif, nombre) values ('22222222B' , 'InmoSur')
insert into Inmobiliaria (cif, nombre) values ('33333333C' , 'Espelucadores S.A.')
insert into Inmobiliaria (cif, nombre) values ('44444444D' , 'Pocero')

insert into Barrio (nombre, ciudad_idCiudad, inmobiliaria_idInmobiliaria) values ('Barrio1', 2, 3)
insert into Barrio (nombre, ciudad_idCiudad, inmobiliaria_idInmobiliaria) values ('Barrio2', 1, 3)
insert into Barrio (nombre, ciudad_idCiudad, inmobiliaria_idInmobiliaria) values ('Barrio3', 4, 4)
insert into Barrio (nombre, ciudad_idCiudad, inmobiliaria_idInmobiliaria) values ('Barrio4', 2, 1)

insert into Casa (cp, direccion, barrio_idBarrio) values (11540, 'Avda Piruleta' , 1)
insert into Casa (cp, direccion, barrio_idBarrio) values (11550, 'Avda Piruleta2' , 2)
insert into Casa (cp, direccion, barrio_idBarrio) values (11560, 'Calle Falsa 123' , 1)

insert into Habitacion (tieneVentana, casa_idCasa) values (false, 2)
insert into Habitacion (tieneVentana, casa_idCasa) values (false, 3)
insert into Habitacion (tieneVentana, casa_idCasa) values (true, 1)
insert into Habitacion (tieneVentana, casa_idCasa) values (false, 2)
insert into Habitacion (tieneVentana, casa_idCasa) values (false, 1)



insert into Color(htmlCode, nombre) values ('7FFF00', 'Chartreuse')
insert into Color(htmlCode, nombre) values ('00CED1', 'DarkTurquoise')
insert into Color(htmlCode, nombre) values ('FAFAD2', 'LightGoldenRodYellow')

insert into Usuario (nombre, nick, mail, clave, color_id) values ('Pepe', 'Pepito76', 'pepes@gmail.com', '123', 1)
insert into Usuario (nombre, nick, mail, clave, color_id) values ('Manolo', 'Manolo76', 'manolos@gmail.com', '123', 2)
insert into Usuario (nombre, nick, mail, clave, color_id) values ('Mila', 'Mila33', 'mila@hotmail.com', '123', 1)

insert into Chat (tema, fecha) values ('Cine', '2012-01-20')
insert into Chat (tema, fecha) values ('Parejas', '2011-12-15')

insert into Mensaje(texto, fecha, chat_id, usuario_id) values ('esto es un mensaje', '2012-01-20', 1, 1)
insert into Mensaje(texto, fecha, chat_id, usuario_id) values ('esto es otro mensaje', '2012-01-20', 1, 2)
insert into Mensaje(texto, fecha, chat_id, usuario_id) values ('esto es otro mensaje2', '2011-01-20', 2, 2)
insert into Mensaje(texto, fecha, chat_id, usuario_id) values ('esto es otro mensaje3', '2012-01-20', 1, 3)

