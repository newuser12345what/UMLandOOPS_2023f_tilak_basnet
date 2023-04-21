
-- This is Default Database --
-- insurance_id;insurance_name --


CREATE TABLE insurances(
    insurance_id int,
    insurance_name varchar,
    primary key(insurance_id)
);

insert into insurances values
						(1,'MACIF'),
						(2,'MGEN'),
						(3,'MAAF'),
						(4,'ADREA'),
						(5,'APICIL');

select * from insurances;

-------------------********************--------------------

medication_code;medication_name;medication_comment



CREATE TABLE medications(
    medication_code int,
    medication_name varchar,
    medication_comment varchar,
    primary key(medication_code)
);

insert into medications values
	(1,'Advil','anti-inflammatory'),
	(2,'Doliprane','paracetamol'),
	(3,'Spasfon','antispasmodic'),
	(4,'Smecta','gastric dressing'),
	(5,'Strepsil','antiseptic');


--------------------*******************----------------

create table insurance(
pat_num_HC varchar,
pat_lastname varchar,
pat_firstname varchar,
pat_address varchar,
pat_tel varchar,
pat_insurance_id varchar,
pat_subscription_date date,
primary key(pat_num_HC)
);

insert into insurance values
('1256987452365','Martin','Bernard','Chatillon','0106060606',2,'01/10/2010'),
('1852458963215','Chalme','Antoine','Paris','0105050505',1,'01/01/2017'),
('1985236548520','Daulne','Paul','Puteaux','0107070707',3,'01/05/2008'),
('2365987542365','Solti','Anna','Montrouge','0108080808',4,'01/10/2010'),
('2658954875210','Dart','Pauline','Bourg la reine','0109090909',4,'01/01/2015'),
('2758965423102','Chalme','Julie','Paris','0105050505',1,'01/06/2017');

--------------------*******************-------------------

presc_id;presc_ref_pat;presc_code;presc_days

create table prescriptions(
		presc_id int,
		presc_ref_pat varchar,
		presc_code int,
		presc_days int
);
insert into prescriptions values
		(1,'2758965423102',1,2),
		(2,'1985236548520',2,4),
		(3,'1852458963215',1,10),
		(4,'2365987542365',4,5),
		(5,'1256987452365',4,5),
		(6,'2758965423102',1,2)
















