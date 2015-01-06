/*
	 -- BDO Resto --
designed by Bodart Gilles
--------------------------
*/
alter table ALIMENT
	drop constraint ALIMENTFK;

	alter table SOUSCATEGORIE
	drop constraint CATEGORIEFK;
	
	alter table COMMANDE
	drop constraint COMMANDEFK;

	alter table LISTEINGREDIENT
	drop constraint LISTEINGREDIENTRECETTEFK;

	alter table LISTEINGREDIENT
	drop constraint LISTEINGREDIENTALIMENTFK;



drop table ALIMENT;
drop table CATEGORIE;
drop table SOUSCATEGORIE;
drop table RECETTE;
drop table LISTEINGREDIENT;
drop table COMMANDE;
drop table SEQUENCES;

create table ALIMENT (
	aliId integer primary key,
	aliNom varchar (255) not null,
	aliFou varchar (255),
	aliCat integer not null,
	aliPrix numeric(10,4) not null,
	aliUnit varchar (255)
	);
	
create table CATEGORIE (
	catId integer primary key,
	catNom varchar (255) not null,
	constraint CATEGORIEUnique unique (catNom)
	);

create table SOUSCATEGORIE (
	sousCatId integer primary key,
	sousCatNom varchar (255) not null,
	categorie integer not null,
	constraint SOUSCATEGORIEUnique unique (sousCatNom)
	);


create table RECETTE (
	recId integer primary key,
	recNom varchar (255) not null,
	recLstIng integer,
	recPrix numeric(10,4),
	recNbCouv integer
	);
	
create table LISTEINGREDIENT (
	lstId integer,
	lstNo integer,
	lstAli integer,
	lstAliQte integer,
	lstAliQteUnite varchar(255),

	constraint LISTEINGREDIENTPK primary key (lstId,lstNo),
	constraint 	LISTEINGREDIENTUNique unique (lstId,lstAli)
	);

create table LISTERECETTE (
	lstId integer,
	lstNo integer,
	lstRct integer,
	lstRctQte integer,

	constraint LISTERECETTEPK primary key (lstId,lstNo),
	constraint 	LISTERECETTEUNIQUE unique (lstId,lstRct)
	);

create table COMMANDE (
	comId integer primary key,
	comNom varchar(255) not null,
	comLstRec integer ,
	comPrix numeric(10,4)
	);

create table SEQUENCES (
     id varchar(50) not null,
     valeur numeric(10) not null,
     constraint IDSEQUENCE primary key (id));


	alter table ALIMENT
	add constraint ALIMENTFK foreign key (aliCat) references SOUSCATEGORIE;

	alter table SOUSCATEGORIE
	add constraint CATEGORIEFK foreign key (categorie) references CATEGORIE;
	
	alter table COMMANDE
	add constraint COMMANDEFK foreign key (comRec) references RECETTE;

	--alter table LISTEINGREDIENT
	--add constraint LISTEINGREDIENTRECETTEFK foreign key (lstId) references RECETTE;
	
	alter table LISTEINGREDIENT
	add constraint LISTEINGREDIENTALIMENTFK foreign key (lstAli) references ALIMENT;
	

	-- Insertion de valeurs --

	Insert Into SEQUENCES values('Categorie', 0);
	Insert Into SEQUENCES values('Aliment', 0);
	Insert Into SEQUENCES values('SousCategorie', 0);
	Insert Into SEQUENCES values('Recette', 0);
	Insert Into SEQUENCES values('ListeIngredient', 0);
	Insert Into SEQUENCES values('ListeRecette', 0);
	Insert Into SEQUENCES values('NumLigne', 0);
	Insert Into SEQUENCES values('Commande', 0);
