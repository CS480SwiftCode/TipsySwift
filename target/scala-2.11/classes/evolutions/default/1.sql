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
  constraint pk_locations primary key (hash))
;

create table zipcodes (
  zipcode                   INT(5) auto_increment not null,
  latitude                  FLOAT(24),
  n_s                       CHAR(1),
  longitude                 FLOAT(24),
  e_w                       CHAR(1),
  constraint pk_zipcodes primary key (zipcode))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table locations;

drop table zipcodes;

SET FOREIGN_KEY_CHECKS=1;

