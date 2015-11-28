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

create table swag_zone (
  id                        bigint auto_increment not null,
  latitude                  FLOAT(24),
  n_s                       CHAR(1),
  longitude                 FLOAT(24),
  e_w                       CHAR(1),
  constraint pk_swag_zone primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table locations;

drop table swag_zone;

SET FOREIGN_KEY_CHECKS=1;

