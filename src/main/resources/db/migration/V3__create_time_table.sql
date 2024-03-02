CREATE TABLE time (
    id UUID PRIMARY KEY,
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    finish_time TIME NOT NULL,
    id_client UUID,
    FOREIGN KEY (id_client) REFERENCES client(id)
);