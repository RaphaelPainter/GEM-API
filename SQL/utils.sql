SELECT * FROM pg_catalog.pg_tables where schemaname = 'public';
DROP TABLE adherent;
DROP TABLE activity;DROP TABLE "activity_type";
commit;

select * from gem_adherent;

INSERT INTO gem_adherent (login, password)
VALUES ('l','p');