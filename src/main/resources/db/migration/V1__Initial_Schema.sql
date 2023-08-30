-- Create the user table if not exists
CREATE TABLE IF NOT EXISTS t_user (
                                      id SERIAL PRIMARY KEY,
                                      username VARCHAR(255),
    password VARCHAR(255),
    role_id BIGINT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
    );

-- Create the role table if not exists
CREATE TABLE IF NOT EXISTS t_role (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255),
    description TEXT,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
    );

-- Create the permission table if not exists
CREATE TABLE IF NOT EXISTS t_permission (
                                            id SERIAL PRIMARY KEY,
                                            name VARCHAR(255),
    description TEXT,
    role_id BIGINT REFERENCES t_role(id),
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
    );

-- Create the menu table if not exists
CREATE TABLE IF NOT EXISTS t_menu (
                                      id SERIAL PRIMARY KEY,
                                      name VARCHAR(255),
    parent_id BIGINT REFERENCES t_menu(id),
    permission_name_required VARCHAR(255),
    system_status_name_required VARCHAR(255),
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
    );

-- Create the system status table if not exists
CREATE TABLE IF NOT EXISTS t_system_status (
                                               id SERIAL PRIMARY KEY,
                                               name VARCHAR(255),
    status BOOLEAN,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP
    );

-- Optional: Indexes, constraints, etc. can be added
