Create table Pais
(COdPai int not null,
 NomPai char(35) not null,
 Constraint PK_Pais primary key (CodPai));

Insert into pais Values (1, 'Brasil');
Insert into pais Values (2, 'EUA');
Insert into pais Values (3, 'Chile');
Insert into pais Values (4, 'Portugal');
Insert into pais Values (5, 'Espanha');
Insert into pais Values (6, 'Suécia');
Insert into pais Values (7, 'Argentina');
Insert into pais Values (8, 'Bolívia');
Insert into pais Values (9, 'Peru');
Insert into pais Values (10, 'França');

Create table Autor
(CodAut int not null,
 NomAut char(35) not null,
 CodPai int not null,
 Constraint Pk_Autor primary key (CodAut),
 Constraint FK_Autor_Pais  foreign key (CodPai)
  references Pais);

insert into Autor values ( 1,'Machado de Assis',1);
insert into Autor values ( 2,'Navathe', 2);
insert into Autor values ( 3,'Jose Mauro de Vasconcelos',1);
insert into Autor values ( 4,'Elmasri', 2);
insert into Autor values ( 5,'Leandro Dupre', 1);
insert into Autor values ( 6,'José Lins do Rego',1);
insert into Autor values ( 7,'José Antônio', 19);
insert into Autor values (8,'José Mauro de Vasconcelos',1);
insert into Autor values (9,'Shamkant B. Navathe',5);
insert into Autor values (10,'Ramez Elmasri',5);
insert into Autor values (11,'Pablo Neruda',3);
insert into Autor values (12, 'Machado de Assis', 1); 
insert into Autor values (13, 'José Santos', 1); 
insert into Autor values (14, 'Maria José Duprê', 1); 
insert into Autor values (15, 'José de Alencar', 1);
insert into Autor values (16, 'Jô Soares', 1);

create table TipoUsuario 
(TipUsu char (1) not null, 
 DesTipUsu char (15) not null, 
 constraint PK_Tipo_usuario primary Key (TipUsu));

insert into Tipousuario values ('A', 'Aluno');
insert into Tipousuario values ('F', 'Funcionario');
insert into Tipousuario values ('P', 'Professor');
insert into Tipousuario values ('V', 'Visitante');

create table TipoObra 
(tipObr number not null, 
 DesTipObr char(25) not null, 
 constraint PK_Tipo_Obra primary Key (TipObr));

insert into TipoObra values (1, 'Periodico Cientifico');
insert into TipoObra values (2, 'Ficção');
insert into TipoObra values (3, 'Literatura');
insert into TipoObra values (4, 'Obra Cientifica');

Create table Unidade
(CodUni number (2) not null, 
 NomUni char (30) not null,
 constraint PK_Unidade primary key (CodUni));

insert into Unidade values (1, 'Coração Eucarístico'); 
insert into Unidade values (2, 'Betim');  
insert into Unidade values (3, 'São Gabriel');  
insert into Unidade values (4, 'Barreiro');  
insert into Unidade values (5, 'Poços de Caldas');

Create table Curso
(CodCur number (2) not null,
 NomCur char (25) not null,
 CodUni number (2) not null, 
 constraint PK_Curso primary key (CodCur),
 constraint FK_Curso_Unidade foreign key (CodUni) references Unidade);

insert into Curso values (1,'Sistemas de Informação', 4);
insert into Curso values (2,'Psicologia',1);
insert into Curso values (3,'História', 1);
insert into Curso values (4,'Sociologia', 1);
insert into Curso values (5,'Letras', 1);
insert into Curso values (6,'Ciência da Computação', 1);
insert into Curso values (7,'Engenharia da Computação', 3);
insert into Curso values (8,'Física', 1);
insert into Curso values (9,'Administração de Empresa', 4);
insert into Curso values (10,'Direito', 2);

create table Usuario
(CodUsu number (2) not null,
 NomUsu char (35) not null,
 SexUsu char (1) not null,
 CodCur number (2) not null,
 TipUsu char (1) not null,
 constraint PK_Usuario primary key (CodUsu),
 constraint FK_Usuario_Curso foreign key (CodCur) references Curso, 
 constraint FK_Usuario_tipo foreign key (TipUsu) references TIpoUsuario, 
 constraint CK_SexUsu check (SexUsu in ('F', 'M')));

insert into Usuario values (1,'Maria Luiza Pereira','F',1,'P');
insert into Usuario values (2,'Mário José Silveira','M',1,'P');
insert into Usuario values (3,'Dalmo Lucas jardim','M',2,'A');
insert into Usuario values (4,'Helena Albuquerque','F',2,'A');
insert into Usuario values (5,'Juarez Perez','M',3,'F');
insert into Usuario values (6,'Saulo Castro Silva','M',2,'P');
insert into Usuario values (7,'Lucas Rodrigo Arantes','M',3,'P');
insert into Usuario values (8,'Cíntia Maria Silva ','F',6,'A');
insert into Usuario values (9,'Cecília Andrade Albuquerque','F',8,'A');
insert into Usuario values (10,'Renato Paula Braga','M',2,'A');
insert into Usuario values (11,'Rafael Andrade','M',3,'A');
insert into Usuario values (12,'José Marcos Silva','M',3,'F');
insert into Usuario values (13,'Maria Eduarda de Silva Santos','F',2,'F');
insert into Usuario values (14,'Luz Maria Pellegrini','F',2,'P');
insert into Usuario values (15,'Leandro Paula Braga','M',1,'P');
insert into Usuario values (16,'Lucas Faria','M',1,'A');
insert into Usuario values (17,'Renata Gonzalez Albuquerque e Silva','F',7,'P');
insert into Usuario values (18,'Cassia Abrantes Juarez','F',3,'A');
insert into Usuario values (19,'Luiz Gustavo Pontes','M',1,'P');
insert into Usuario values (20,'Lauro Samuel Andrade','M',1,'F');

create table Obra
(CodObr number (2) not null,
 NomObr char (35) not null,
 TipObr number (1) not null,
 constraint PK_Obra primary key (CodObr),
 constraint FK_Obra_TipoObra foreign key (TipObr) references TipoObra);

insert into Obra values (1,'Estado de Minas',1);
insert into Obra values (2,'IEEC',3);
insert into Obra values (3,'Sistemas de Banco de Dados',2);
insert into Obra values (4,'Luna Brava',3);
insert into Obra values (5,'Entidade e Relacionamentos',2);
insert into Obra values (6,'Vinte poemas de Amor',3);
insert into Obra values (7,'Canção General',3);
insert into Obra values (8,'Cem sonetos de Amor',3);
insert into Obra values (9,'Meu pé de Laranja Lima',2);
insert into Obra values (10,'Doidão',2);
insert into Obra values (11, 'Menino do Engenho', 3);
insert into Obra values (12,'Doidinho',3);
insert into Obra values (13,'Iracema',3);
insert into Obra values (14,'O Guarani',3);
insert into Obra values (15,'Senhora',3);
insert into Obra values (16,'Lucíola', 3);
insert into Obra values (17,'A pata da Gazela',3);
insert into Obra values (18,'Encarnação',3);
insert into Obra values (19,'Luz e Sombra',3);
insert into Obra values (20,'Os Rodrigues',3);
insert into Obra values (21,'D. Lola',3);
insert into Obra values (22,'O Estado de São Paulo',1);
insert into Obra values (23,'A Folha de São Paulo',3);
insert into Obra values (24,'Jardín de invierno',3);
insert into Obra values (25,'Tentativa del hombre infinito',3);
insert into Obra values (26,'Crepuscularioo',3);

Create table Autoria
(CodObr number(2) not null,
 CodAut number(2) not null,
 constraint PK_Autoria primary key (CodObr, CodAut),
 constraint  FK_Autoria_Autor foreign key (CodAut) references Autor,
 constraint FK_Autor_Obra foreign key (CodObr) references Obra on delete cascade);

insert into Autoria values (12, 1); 
insert into Autoria values (11, 1);
insert into Autoria values (3, 4); 
insert into Autoria values (6, 5);
insert into Autoria values (7, 5);
insert into Autoria values (8,5);
insert into Autoria values (3,2); 
insert into Autoria values (3,4); 
insert into Autoria values (13, 7);
insert into Autoria values (14, 7);
insert into Autoria values (15, 7);
insert into Autoria values (16, 7);
insert into Autoria values (10, 2);
insert into Autoria values (9, 3);
insert into Autoria values (4, 2);
insert into Autoria values (24, 5);
insert into Autoria values (25, 5);
insert into Autoria values (26, 5);
insert into Autoria values (19, 8);
insert into Autoria values (20, 5);
insert into Autoria values (21, 8);
insert into Autoria values (17, 7);
insert into Autoria values (18, 7);

create table Editora
(CodEdi number(2) not null,
 NomEdi char(35) not null,
 constraint PK_Editora primary key (CodEdi));
insert into Editora values (1, 'Editora Atlas');
insert into Editora values (2, 'Editora FTC');
insert into Editora values (3, 'Editora LTC');
insert into Editora values (4, 'Editora Vozes');
insert into Editora values (5, 'Editora Cascais');
insert into Editora values (6, 'Ediouro');
insert into Editora values (7, 'Editora Cortez');
insert into Editora values (8, 'Brasiliense');
insert into Editora values (9, 'Editora Ateliê');
insert into Editora values (10, 'Editora Ática');
create table Exemplar
(NumExe number(2) not null,
 CodObr number(2) not null,
 AnoEdi number(4) not null,
 CodEdi number(2) not null, 
 CodUni number(2) not null, 
 ValExe number(6,2) not null,
 constraint PK_Exemplar primary key (NumExe),
 constraint FK_Exemplar_Editora foreign key (CodEdi) references Editora, 
 constraint FK_Exemplar_Obra foreign key (CodObr) references Obra,
 constraint FK_Exemplar_Unidade foreign key (CodUni) references Unidade);

insert into Exemplar values(1, 1, 2009, 1, 1, 120.50);
insert into Exemplar values(2, 1, 2010, 1, 1, 110);
insert into Exemplar values(3, 1, 2011, 1, 2, 110.30);
insert into Exemplar values(4, 1, 2011, 1, 2, 130);
insert into Exemplar values(5, 1, 2009, 2, 3, 80.80);
insert into Exemplar values(10, 2, 2008, 2, 1, 90);
insert into Exemplar values(6, 2, 2010, 3, 1, 80.80);
insert into Exemplar values(7, 3, 2011, 3, 1, 50);
insert into Exemplar values(8, 3, 2012, 5, 2, 70.90);
insert into Exemplar values(9, 3, 2009, 3, 4, 50);
create table Emprestimo 
(codUsu number(2) not null, 
 NumExe number(2) not null, 
 DatEmp date default sysdate, 
 DatPreDev date default (sysdate + 10), 
 DatDev date, 
 constraint PK_Emprestimo primary key (codUsu, NumExe, DatEmp), 
 constraint FK_Emprestimo_Exemplar foreign key (NumExe) references Exemplar, 
 constraint FK_Emprestimo_Usuario foreign key (codUsu) references Usuario, 
 constraint CK_DatDev check (DatDev is null or DatDev >= DatEmp));
alter session set nls_date_format='ddmmyyyy';

insert into Emprestimo values (1, 2, '01092009', '11092009', '08092009');
insert into Emprestimo values (3, 1, default, default, null);
insert into Emprestimo values (2, 2, '01092010', '11092010', '08092010');
insert into Emprestimo values (4, 5, default, default, null);
insert into Emprestimo values (4, 2, '01092011', '11092011', '08092011');
insert into Emprestimo values (3, 1, '01012013', '10012013', '08012013');
insert into Emprestimo values (1, 2, '01022012', '11022012', '08022012');
insert into Emprestimo values (3, 3, '01092011', '11092011', '08092011');
insert into Emprestimo values (2, 3, '01012012', '11012012', '08012012');
insert into Emprestimo values (1, 4, '01032012', '11032012', '08032012');
insert into Emprestimo values (1, 8, '01102011', '11102011', '08102011');

COMMIT;
