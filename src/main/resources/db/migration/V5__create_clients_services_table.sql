CREATE TABLE clients_services (
    id_client UUID,
    id_service UUID,
    FOREIGN KEY (id_client) REFERENCES client(id),
    FOREIGN KEY (id_service) REFERENCES services(id)
);