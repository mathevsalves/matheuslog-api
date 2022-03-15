CREATE TABLE client
(
    id        BIGINT       NOT NULL auto_increment,
    name      VARCHAR(60)  NOT NULL,
    email     VARCHAR(255) NOT NULL,
    telephone VARCHAR(20)  NOT NULL,
    PRIMARY KEY (id)
);
