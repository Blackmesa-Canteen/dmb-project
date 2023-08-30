-- Create Menu table
CREATE TABLE IF NOT EXISTS public.t_menu (
                                      id BIGSERIAL PRIMARY KEY,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      name VARCHAR(255) UNIQUE,
                                        parent_id BIGINT,
                                        permission_name_required VARCHAR(255),
                                        system_control_name_required VARCHAR(255)
    );

-- Create Permission table
CREATE TABLE IF NOT EXISTS public.t_permission (
                                            id BIGSERIAL PRIMARY KEY,
                                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                            name VARCHAR(255) UNIQUE
    );

-- Create Role table
CREATE TABLE IF NOT EXISTS public.t_role (
                                      id BIGSERIAL PRIMARY KEY,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      name VARCHAR(255) UNIQUE
    );

-- Create RolePermission table
CREATE TABLE IF NOT EXISTS public.t_role_permission (
                                                 id bigserial NOT NULL,
                                                 created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                                 updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                                 role_id int8 NULL,
                                                 permission_id int8 NULL,
                                                 CONSTRAINT t_role_permission_pkey PRIMARY KEY (id),
    CONSTRAINT t_role_permission_fk FOREIGN KEY (role_id) REFERENCES public.t_role(id) ON DELETE CASCADE,
    CONSTRAINT t_role_permission_fk_1 FOREIGN KEY (permission_id) REFERENCES public.t_permission(id) ON DELETE CASCADE
    );

-- Create SystemControl table
CREATE TABLE IF NOT EXISTS public.t_system_control (
                                                id BIGSERIAL PRIMARY KEY,
                                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                                name VARCHAR(255) UNIQUE,
                                                status BOOLEAN
    );
