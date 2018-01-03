connect 'jdbc:derby:AgendaEMail;create=true';
create table adrese(
  id int generated always as identity(start with 1, increment by 1) primary key,
  nume char(20) not null,
  email char(30) not null
);
