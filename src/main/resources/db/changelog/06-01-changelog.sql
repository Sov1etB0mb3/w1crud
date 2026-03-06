-- liquibase formatted sql

-- changeset khanhnt:1772768033715-1
CREATE TABLE category
(
    id          BIGINT      NOT NULL,
    name        VARCHAR(50) NOT NULL,
    description VARCHAR(100),
    CONSTRAINT pk_category PRIMARY KEY (id)
);

-- changeset khanhnt:1772768033715-2
CREATE TABLE product
(
    id       CHAR(10)    NOT NULL,
    name     VARCHAR(20) NOT NULL,
    quantity INTEGER     NOT NULL,
    price    DOUBLE PRECISION,
    cateid   BIGINT,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

-- changeset khanhnt:1772768033715-3
ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEID FOREIGN KEY (cateid) REFERENCES category (id);

