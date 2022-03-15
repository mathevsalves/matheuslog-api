CREATE TABLE deliver
(
    id                  BIGINT         NOT NULL AUTO_INCREMENT,
    client_id           BIGINT         NOT NULL,
    fee                 DECIMAL(10, 2) NOT NULL,
    status              VARCHAR(20)    NOT NULL,
    order_date          DATETIME       NOT NULL,
    final_date          DATETIME,

    receiver_name       VARCHAR(60)    NOT NULL,
    receiver_address    VARCHAR(255)   NOT NULL,
    receiver_number     VARCHAR(30)    NOT NULL,
    receiver_complement VARCHAR(26)    NOT NULL,
    receiver_neighbor   VARCHAR(30)    NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE deliver
    ADD CONSTRAINT fk_deliver_client FOREIGN KEY (client_id) REFERENCES client (id);
