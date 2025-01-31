DROP TABLE IF EXISTS "public"."movies";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."movies" (
    "id" varchar(255) NOT NULL,
    "created_at" timestamp,
    "update_at" timestamp,
    "duration" float8,
    "genre" varchar(255),
    "title" varchar(255),
    PRIMARY KEY ("id")
);

INSERT INTO "public"."movies" ("id", "created_at", "update_at", "duration", "genre", "title") VALUES
('322b8351-ac9a-4e3c-a738-372aa949dc77', '2025-01-31 05:50:23.062145', '2025-01-31 05:50:23.062145', 2.2, 'drama', 'Avatar 3');
INSERT INTO "public"."movies" ("id", "created_at", "update_at", "duration", "genre", "title") VALUES
('b99a5c3c-bc69-4702-a1bc-0623ba14771f', '2025-01-31 05:50:43.892358', '2025-01-31 05:50:43.892358', 2.8, 'accion', 'Capitan America');

DROP TABLE IF EXISTS "public"."users";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."users" (
    "id" varchar(255) NOT NULL,
    "created_at" timestamp,
    "update_at" timestamp,
    "email" varchar(255),
    "lastname" varchar(255),
    "name" varchar(255),
    "phone" varchar(255),
    PRIMARY KEY ("id")
);

INSERT INTO "public"."users" ("id", "created_at", "update_at", "email", "lastname", "name", "phone") VALUES
('c6130495-31c2-4bc6-9352-dc76b45468e5', '2025-01-31 05:51:15.472915', '2025-01-31 05:51:15.472915', 'maria.sanchez@gmail.com', 'sanchez', 'Maria', '3002565478');
INSERT INTO "public"."users" ("id", "created_at", "update_at", "email", "lastname", "name", "phone") VALUES
('0fa83136-57cc-407e-a036-a6e1f6a93afd', '2025-01-31 05:51:33.06512', '2025-01-31 05:51:33.06512', 'andres123@gmail.com', 'suarez', 'Andres', '316585658');

DROP TABLE IF EXISTS "public"."tickets";
-- This script only contains the table creation statements and does not fully represent the table in the database. It's still missing: indices, triggers. Do not use it as a backup.

-- Table Definition
CREATE TABLE "public"."tickets" (
    "id" varchar(255) NOT NULL,
    "created_at" timestamp,
    "update_at" timestamp,
    "end_time" timestamp,
    "seat" varchar(255),
    "start_time" timestamp,
    "movie_id" varchar(255),
    "user_id" varchar(255),
    CONSTRAINT "fkorolxf50nkk7qbxuextweuhrh" FOREIGN KEY ("movie_id") REFERENCES "public"."movies"("id"),
    CONSTRAINT "fk4eqsebpimnjen0q46ja6fl2hl" FOREIGN KEY ("user_id") REFERENCES "public"."users"("id"),
    PRIMARY KEY ("id")
);

INSERT INTO "public"."tickets" ("id", "created_at", "update_at", "end_time", "seat", "start_time", "movie_id", "user_id") VALUES
('f3f54e6d-d8ce-4f13-8be8-7feab686cc46', '2025-01-31 05:53:36.626557', '2025-01-31 05:53:36.626557', '2025-01-30 16:00:00', 'E23', '2025-01-30 15:00:00', 'b99a5c3c-bc69-4702-a1bc-0623ba14771f', '0fa83136-57cc-407e-a036-a6e1f6a93afd');
