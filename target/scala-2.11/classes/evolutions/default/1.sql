# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table locations (
  hash                      VARCHAR(64) not null,
  name                      VARCHAR(255),
  yelp_url                  VARCHAR(255),
  phone                     VARCHAR(10),
  latitude                  FLOAT(24),
  n_s                       CHAR(1),
  longitude                 FLOAT(24),
  e_w                       CHAR(1),
  rating                    INT(1),
  hours_of_op               BLOB NOT NULL,
  happy_hour_times          BLOB NOT NULL,
  constraint pk_locations primary key (hash))
;

create table zipcodes (
  zipcode                   INT(5) not null,
  latitude                  FLOAT(24),
  n_s                       CHAR(1),
  longitude                 FLOAT(24),
  e_w                       CHAR(1),
  constraint pk_zipcodes primary key (zipcode))
;

create sequence locations_seq;

create sequence zipcodes_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists locations;

drop table if exists zipcodes;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists locations_seq;

drop sequence if exists zipcodes_seq;

