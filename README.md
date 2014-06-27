PostgreSQL_project
==================

JDBC experimentation using PostgreSQL



To build the database tables
========================
1) create a DB using pgadminIII called postgres with username postgres and password as cmpe226
2) run the following sql commands on pgadminIII

CREATE TABLE station
(
  primary_id varchar(128) NOT NULL,
  secondary_id varchar (128),
  station_name varchar (128),
  state varchar(64),
  country varchar (128),
  latitude varchar (128),
  longitude varchar (128),
  elevation varchar (128),
  mesowest_network_id varchar (128),
  network_name varchar (128),
  status varchar(128),
  CONSTRAINT station_pkey PRIMARY KEY (primary_id)
)

CREATE TABLE weather
(
  stationname  varchar(128)NOT NULL references station(primary_id),
  forcasttime  varchar(128) NOT NULL,
  mnet numeric,
  latitude numeric,
  longitude numeric,
  elevation numeric,
  temperature numeric,
  sknt numeric,
  drct numeric,
  gust numeric,
  pmsl numeric,
  altitude numeric,
  dewpoint numeric,
  relativehumidity numeric,
  weathercode numeric,
  percitipation numeric,
PRIMARY KEY(stationname,forcasttime)
 )

To run the program
========================
1) move mesowestTxData on c:/
2) Save karki root folder in EclipseData folder
3) Create a new java project in Eclipse and name karki
4) project file will contain src files
5) set the path files and drivers
6) main() function is on CSVFile class
7) from CSVFile class, run as a java program.
