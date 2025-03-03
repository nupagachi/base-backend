-- Tạo cơ sở dữ liệu
CREATE DATABASE user_management;


-- Tạo bảng tbl_user
CREATE TABLE tbl_user
(
    id            SERIAL PRIMARY KEY,
    first_name    VARCHAR(100),
    date_of_birth DATE,
    gender        VARCHAR(10),
    last_name     VARCHAR(100),
    phone         VARCHAR(20),
    email         VARCHAR(255) UNIQUE,
    username      VARCHAR(100) UNIQUE,
    password      TEXT,
    status        VARCHAR(50),
    type          VARCHAR(50),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Tạo bảng tbl_address
CREATE TABLE tbl_address
(
    id               SERIAL PRIMARY KEY,
    apartment_number VARCHAR(50),
    floor            VARCHAR(10),
    building         VARCHAR(100),
    street_number    VARCHAR(50),
    street           VARCHAR(255),
    city             VARCHAR(100),
    country          VARCHAR(100),
    address_type     VARCHAR(50),
    user_id          INT REFERENCES tbl_user (id) ON DELETE CASCADE,
    created_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tạo bảng tbl_role
CREATE TABLE tbl_role
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

-- Tạo bảng tbl_permission
CREATE TABLE tbl_permission
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE
);

-- Tạo bảng tbl_user_has_role
CREATE TABLE tbl_user_has_role
(
    id      SERIAL PRIMARY KEY,
    user_id INT REFERENCES tbl_user (id) ON DELETE CASCADE,
    role_id INT REFERENCES tbl_role (id) ON DELETE CASCADE,
    UNIQUE (user_id, role_id)
);

-- Tạo bảng tbl_role_has_permission
CREATE TABLE tbl_role_has_permission
(
    id            SERIAL PRIMARY KEY,
    role_id       INT REFERENCES tbl_role (id) ON DELETE CASCADE,
    permission_id INT REFERENCES tbl_permission (id) ON DELETE CASCADE,
    UNIQUE (role_id, permission_id)
);
