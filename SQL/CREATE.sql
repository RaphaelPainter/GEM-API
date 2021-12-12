CREATE TABLE "user" (
                        id SERIAL,
                        login VARCHAR,
                        password VARCHAR,
                        date_created TIMESTAMP,
                        email VARCHAR,
                        last_login TIMESTAMP,
                        PRIMARY KEY(id)
);

drop table "user";
commit;