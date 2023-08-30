-- Insert SystemControl records
INSERT INTO t_system_control (name, status)
VALUES ('SYSTEM_CONTROL_1', true),
       ('SYSTEM_CONTROL_2', true),
       ('SYSTEM_CONTROL_3', true),
       ('SYSTEM_CONTROL_4', true),
       ('SYSTEM_CONTROL_5', true),
       ('SYSTEM_CONTROL_6', true),
       ('SYSTEM_CONTROL_7', true),
       ('SYSTEM_CONTROL_8', true),
       ('SYSTEM_CONTROL_9', true),
       ('SYSTEM_CONTROL_10', true),
       ('SYSTEM_CONTROL_12', true),
       ('SYSTEM_CONTROL_14', true),
       ('SYSTEM_CONTROL_15', true),
       ('SYSTEM_CONTROL_16', true)
ON CONFLICT (name) DO NOTHING;

-- Insert Permission records
INSERT INTO t_permission (name)
VALUES ('PERMISSION_1'),
       ('PERMISSION_2'),
       ('PERMISSION_3'),
       ('PERMISSION_4'),
       ('PERMISSION_6'),
       ('PERMISSION_8'),
       ('PERMISSION_12'),
       ('PERMISSION_13'),
       ('PERMISSION_14'),
       ('PERMISSION_15'),
       ('PERMISSION_16'),
       ('PERMISSION_17'),
       ('PERMISSION_18'),
       ('PERMISSION_19'),
       ('PERMISSION_26'),
       ('PERMISSION_28')
ON CONFLICT (name) DO NOTHING;

-- Insert Menu records
-- For simplicity, the parent menus are assigned IDs 1-7 and the submenus IDs 8-37
INSERT INTO t_menu (name, parent_id, system_control_name_required, permission_name_required)
VALUES ('menu_1', NULL, NULL, NULL),
       ('menu_2', NULL, NULL, NULL),
       ('menu_3', NULL, NULL, NULL),
       ('menu_4', NULL, NULL, NULL),
       ('menu_5', NULL, NULL, NULL),
       ('menu_6', NULL, NULL, NULL),
       ('menu_7', NULL, NULL, NULL),
       ('menu_1_1', 1, 'SYSTEM_CONTROL_2', 'PERMISSION_6'),
       ('menu_1_2', 1, 'SYSTEM_CONTROL_2', 'PERMISSION_6'),
       ('menu_2_1', 2, 'SYSTEM_CONTROL_3', 'PERMISSION_3'),
       ('menu_2_2', 2, 'SYSTEM_CONTROL_5', 'PERMISSION_4'),
       ('menu_2_3', 2, 'SYSTEM_CONTROL_4', 'PERMISSION_14'),
       ('menu_2_4', 2, 'SYSTEM_CONTROL_12', 'PERMISSION_15'),
       ('menu_3_1', 3, NULL, 'PERMISSION_8'),
       ('menu_3_2', 3, 'SYSTEM_CONTROL_8', 'PERMISSION_28'),
       ('menu_4_1', 4, 'SYSTEM_CONTROL_9', 'PERMISSION_26'),
       ('menu_4_2', 4, NULL, 'PERMISSION_18'),
       ('menu_4_3', 4, NULL, 'PERMISSION_19'),
       ('menu_5_1', 5, 'SYSTEM_CONTROL_14', 'PERMISSION_13'),
       ('menu_5_2', 5, 'SYSTEM_CONTROL_15', 'PERMISSION_1'),
       ('menu_5_3', 5, 'SYSTEM_CONTROL_16', 'PERMISSION_1'),
       ('menu_6_1', 6, 'SYSTEM_CONTROL_1', 'PERMISSION_17'),
       ('menu_6_2', 6, 'SYSTEM_CONTROL_1', 'PERMISSION_4'),
       ('menu_7_1', 7, 'SYSTEM_CONTROL_6', 'PERMISSION_2'),
       ('menu_7_2', 7, 'SYSTEM_CONTROL_7', 'PERMISSION_16'),
       ('menu_7_3', 7, 'SYSTEM_CONTROL_10', 'PERMISSION_12')
ON CONFLICT (name) DO NOTHING;
