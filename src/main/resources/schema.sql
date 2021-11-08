DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
  id        UUID    PRIMARY KEY,
  name      varchar NOT NULL,
  surname   varchar NOT NULL
);

CREATE TABLE account (
  id            UUID       PRIMARY KEY,
  balance       decimal    NOT NULL,
  creation_date timestamp  NOT NULL,
  customer_id   varchar    NOT NULL  references customer(id)
);

CREATE TABLE transaction (
  id                UUID  PRIMARY KEY,
  amount            decimal,
  account_id        varchar NOT NULL references account(id),
  transaction_date  timestamp NOT NULL
);