SELECT * FROM pg_catalog.pg_tables where schemaname = 'public';
DROP TABLE adherent;
DROP TABLE activity;DROP TABLE "activity_type";
commit;

select * from gem_adherent;

delete  from gem_adherent;

INSERT INTO gem_adherent (login, password, role)
VALUES ('user','user',1);

INSERT INTO gem_adherent (login, password, role)
VALUES ('referent','referent',2);

INSERT INTO gem_adherent (login, password, role)
VALUES ('admin','admin',3);


