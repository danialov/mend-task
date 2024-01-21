CREATE TABLE IF NOT EXISTS chief_commander (
             id BIGINT AUTO_INCREMENT PRIMARY KEY,
             name VARCHAR(255) NOT NULL,
             vehicle VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS commander (
             id BIGINT AUTO_INCREMENT PRIMARY KEY,
             name VARCHAR(255) NOT NULL,
             commander_id BIGINT,
             vehicle VARCHAR(255) NOT NULL,
             FOREIGN KEY (commander_id) REFERENCES chief_commander(id)
);

CREATE TABLE IF NOT EXISTS warrior (
             id BIGINT AUTO_INCREMENT PRIMARY KEY,
             name VARCHAR(255) NOT NULL,
             commander_id BIGINT,
             weapon VARCHAR(255) NOT NULL,
             FOREIGN KEY (commander_id) REFERENCES commander(id)
);


INSERT INTO chief_commander (name, vehicle)
VALUES ('Chief Zoltar', 'Egged Bus'),
       ('Chief Yoltar', 'Merkava tank'),
       ('Chief Xoltan', 'Bird scooter'),
       ('Chief Voltar', 'Merkava tank'),
       ('Chief Goltar', 'Egged Bus');

INSERT INTO commander (name, commander_id, vehicle)
VALUES ('Commander Zorg', 1, 'Merkava tank'),
       ('Commander Korg', 1, 'Bird scooter'),
       ('Commander Borg', 1, 'Merkava tank'),
       ('Commander Lorg', 2, 'Bird scooter'),
       ('Commander Morgot', 2, 'Merkava tank'),
       ('Commander Porg', 2, 'Bird scooter'),
       ('Commander Forgon', 3, 'Merkava tank'),
       ('Commander Horg', 3, 'Bird scooter'),
       ('Commander Jorg', 3, 'Merkava tank'),
       ('Commander Vorg', 4, 'Bird scooter'),
       ('Commander Storg', 4, 'Merkava tank'),
       ('Commander Torg', 4, 'Bird scooter'),
       ('Commander Uorg', 5, 'Merkava tank'),
       ('Commander Vorg', 5, 'Bird scooter'),
       ('Commander Worg', 5, 'Merkava tank');

INSERT INTO warrior (name, commander_id, weapon)
VALUES ('Warrior X', 1, 'Water gun'),
       ('Warrior Y', 1, 'Pepper spray'),
       ('Warrior Z', 1, 'Chopsticks'),
       ('Warrior A1', 2, 'Water gun'),
       ('Warrior B1', 2, 'Pepper spray'),
       ('Warrior C1', 2, 'Chopsticks'),
       ('Warrior D1', 3, 'Water gun'),
       ('Warrior E1', 3, 'Pepper spray'),
       ('Warrior F1', 3, 'Chopsticks'),
       ('Warrior G1', 4, 'Water gun'),
       ('Warrior H1', 4, 'Pepper spray'),
       ('Warrior I1', 4, 'Chopsticks'),
       ('Warrior J1', 5, 'Water gun'),
       ('Warrior K1', 5, 'Pepper spray'),
       ('Warrior L1', 5, 'Chopsticks'),
       ('Warrior M1', 6, 'Water gun'),
       ('Warrior N1', 6, 'Pepper spray'),
       ('Warrior O1', 6, 'Chopsticks'),
       ('Warrior P1', 6, 'Water gun'),
       ('Warrior Q1', 7, 'Pepper spray'),
       ('Warrior R1', 7, 'Chopsticks'),
       ('Warrior S1', 7, 'Water gun'),
       ('Warrior T1', 7, 'Pepper spray'),
       ('Warrior U1', 8, 'Chopsticks'),
       ('Warrior V1', 8, 'Water gun'),
       ('Warrior W1', 8, 'Pepper spray'),
       ('Warrior X1', 8, 'Chopsticks'),
       ('Warrior Y1', 9, 'Water gun'),
       ('Warrior Z1', 9, 'Pepper spray'),
       ('Warrior A2', 9, 'Chopsticks'),
       ('Warrior B2', 9, 'Water gun');

