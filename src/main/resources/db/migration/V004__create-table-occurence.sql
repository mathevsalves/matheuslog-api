CREATE TABLE occurence
(
    id            BIGINT   NOT NULL AUTO_INCREMENT,
    deliver_id    BIGINT   NOT NULL,
    description   TEXT     NOT NULL,
    register_date DATETIME NOT NULL,

    PRIMARY KEY (id)
);

ALTER TABLE occurence
    ADD CONSTRAINT fk_occurence_deliver FOREIGN KEY (deliver_id) REFERENCES deliver (id);
