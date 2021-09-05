CREATE TABLE IF NOT EXISTS "event" IF(
	"id" serial NOT NULL UNIQUE,
	"organizer" int NOT NULL,
	"event_name" char NOT NULL,
	"event_date" DATE,
	"event_date_range" DATE,
	"event_address" char NOT NULL,
	"event_type" int NOT NULL,
	"event_image" bytea NOT NULL,
	CONSTRAINT "event_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE IF NOT EXISTS "event_type" (
	"id" serial NOT NULL,
	"event_type_description" char NOT NULL,
	CONSTRAINT "event_type_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

CREATE TABLE IF NOT EXISTS "organizer" (
	"id" serial NOT NULL,
	"organizer_name" char NOT NULL,
	"login_name" char(50) NOT NULL,
	"password" char(50) NOT NULL,
	CONSTRAINT "organizer_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "event" ADD CONSTRAINT "event_fk0" FOREIGN KEY ("organizer") REFERENCES "organizer"("id");
ALTER TABLE "event" ADD CONSTRAINT "event_fk1" FOREIGN KEY ("event_type") REFERENCES "event_type"("id");
CREATE SEQUENCE JPA_SEQUENCE START WITH 1 INCREMENT BY 1;