-- Create Menu table
CREATE TABLE IF NOT EXISTS t_menu (
                                      id BIGSERIAL PRIMARY KEY,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      name VARCHAR(255) UNIQUE,
                                        parent_id BIGINT,
                                        permission_name_required VARCHAR(255),
                                        system_control_name_required VARCHAR(255)
    );

-- Create Permission table
CREATE TABLE IF NOT EXISTS t_permission (
                                            id BIGSERIAL PRIMARY KEY,
                                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            name VARCHAR(255) UNIQUE
    );

-- Create Role table
CREATE TABLE IF NOT EXISTS t_role (
                                      id BIGSERIAL PRIMARY KEY,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      name VARCHAR(255) UNIQUE
    );

-- Create RolePermission table
CREATE TABLE IF NOT EXISTS t_role_permission (
                                                 id BIGSERIAL PRIMARY KEY,
                                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                 role_id BIGINT,
                                                 permission_id BIGINT
);

-- Create SystemControl table
CREATE TABLE IF NOT EXISTS t_system_control (
                                                id BIGSERIAL PRIMARY KEY,
                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                name VARCHAR(255) UNIQUE,
                                                status BOOLEAN
    );
