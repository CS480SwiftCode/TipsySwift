# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table locations (
  id                        bigint auto_increment not null,
  name                      VARCHAR(255),
  yelp_url                  VARCHAR(255),
  address                   VARCHAR(255),
  city                      VARCHAR(255),
  state                     VARCHAR(255),
  zip_code                  VARCHAR(255),
  phone                     VARCHAR(10),
  latitude                  FLOAT(24),
  longitude                 FLOAT(24),
  rating                    INT(1),
  happy_hour_times          BLOB NOT NULL,
  constraint uq_locations_yelp_url unique (yelp_url),
  constraint pk_locations primary key (id))
;

create table swag_zone (
  id                        bigint auto_increment not null,
  coordinates               VARCHAR(255),
  constraint uq_swag_zone_coordinates unique (coordinates),
  constraint pk_swag_zone primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table locations;

drop table swag_zone;

SET FOREIGN_KEY_CHECKS=1;

