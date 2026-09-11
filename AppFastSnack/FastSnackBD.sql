CREATE DATABASE IF NOT EXISTS FastSnackBD;
USE FastSnackBD;

-- =========================
-- TABLA PERSONA
-- =========================
CREATE TABLE Persona (
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- =========================
-- TABLA CLIENTE
-- =========================
CREATE TABLE Cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT NOT NULL,
    direccion VARCHAR(200) NOT NULL,

    FOREIGN KEY (id_persona)
    REFERENCES Persona(id_persona)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- =========================
-- TABLA PRODUCTO
-- =========================
CREATE TABLE Producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

-- =========================
-- TABLA PEDIDO
-- =========================
CREATE TABLE Pedido (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    estado ENUM(
        'PENDIENTE',
        'EN_PREPARACION',
        'ENVIADO',
        'ENTREGADO',
        'CANCELADO'
    ) NOT NULL DEFAULT 'PENDIENTE',
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL DEFAULT 0,

    FOREIGN KEY (id_cliente)
    REFERENCES Cliente(id_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- =========================
-- TABLA DETALLE_PEDIDO
-- =========================
CREATE TABLE Detalle_Pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_pedido)
    REFERENCES Pedido(id_pedido)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    FOREIGN KEY (id_producto)
    REFERENCES Producto(id_producto)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- =========================
-- DATOS DE PRUEBA
-- =========================

INSERT INTO Persona(nombre, telefono)
VALUES ('Allison Perez', '0999999999');

INSERT INTO Cliente(id_persona, direccion)
VALUES (1, 'Guayaquil - Ecuador');

INSERT INTO Producto(nombre, precio)
VALUES 
('Hamburguesa', 5.50),
('Hotdog', 2.50),
('Chuzo', 2.50),
('Choclo', 1.50),
('Cola', 1.00),
('Agua', 1.00);

INSERT INTO Pedido(id_cliente, estado, total)
VALUES (1, 'PENDIENTE', 8.50);

INSERT INTO Detalle_Pedido(id_pedido, id_producto, cantidad, precio, subtotal)
VALUES
(1, 1, 1, 5.50, 5.50),
(1, 2, 1, 2.50, 2.50);