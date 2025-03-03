-- insert tbl_role
INSERT INTO tbl_role (id, name)
VALUES (1, 'sysadmin'),
       (2, 'admin'),
       (3, 'manager'),
       (4, 'user');

-- insert tbl_permission
INSERT INTO tbl_permission (id, name)
VALUES (1, 'Full Access'),
       (2, 'View'),
       (3, 'Add'),
       (4, 'Update'),
       (5, 'Delete'),
       (6, 'Upload'),
       (7, 'Import'),
       (8, 'Export'),
       (9, 'Send'),
       (10, 'Share');

-- sysadmin có tất cả quyền
INSERT INTO tbl_role_has_permission (role_id, permission_id)
SELECT 1, id
FROM tbl_permission;

-- admin có các quyền: View, Add, Update, Delete, Upload, Import, Export
INSERT INTO tbl_role_has_permission (role_id, permission_id)
VALUES (2, 2), -- View
       (2, 3), -- Add
       (2, 4), -- Update
       (2, 5), -- Delete
       (2, 6), -- Upload
       (2, 7), -- Import
       (2, 8);
-- Export

-- manager có các quyền: View, Add, Update, Delete
INSERT INTO tbl_role_has_permission (role_id, permission_id)
VALUES (3, 2), -- View
       (3, 3), -- Add
       (3, 4), -- Update
       (3, 5);
-- Delete

-- user có các quyền: View, Send, Share
INSERT INTO tbl_role_has_permission (role_id, permission_id)
VALUES (4, 2), -- View
       (4, 9), -- Send
       (4, 10); -- Share


INSERT INTO tbl_user (first_name, last_name, date_of_birth, gender, phone, email, username, password, status, type, created_at, updated_at)
SELECT
    'User' || generate_series(1, 100),
    'Test' || generate_series(1, 100),
    DATE '1980-01-01' + (random() * 15000)::int * INTERVAL '1 day',
    CASE WHEN random() > 0.5 THEN 'Male' ELSE 'Female' END,
    '+841234567' || lpad((random() * 999)::int::TEXT, 3, '0'),
    'user' || md5(random()::text) || '@example.com', -- Email ngẫu nhiên
    'user' || generate_series(1, 100),
    md5(random()::text),
    CASE WHEN random() > 0.8 THEN 'inactive' ELSE 'active' END,
    CASE WHEN random() > 0.5 THEN 'admin' ELSE 'member' END,
    NOW(), NOW();


INSERT INTO tbl_user_has_role (user_id, role_id)
SELECT id, 1 FROM tbl_user ORDER BY id LIMIT 1;

-- Gán 2 users tiếp theo làm admin
INSERT INTO tbl_user_has_role (user_id, role_id)
SELECT id, 2 FROM tbl_user ORDER BY id OFFSET 1 LIMIT 2;

-- Gán các user còn lại ngẫu nhiên vào manager (3) hoặc user (4)
INSERT INTO tbl_user_has_role (user_id, role_id)
SELECT id, CASE WHEN random() > 0.5 THEN 3 ELSE 4 END
FROM tbl_user ORDER BY id OFFSET 3;

INSERT INTO tbl_address (apartment_number, floor, building, street_number, street, city, country, address_type, user_id, created_at, updated_at)
SELECT
    CASE WHEN random() > 0.5 THEN (random() * 100)::int::TEXT ELSE NULL END,  -- Apartment số ngẫu nhiên hoặc NULL
    (random() * 20)::int,  -- Tầng (0 - 20)
    'Building ' || (random() * 10)::int,  -- Tòa nhà ngẫu nhiên
    (random() * 999)::int::TEXT,  -- Số nhà ngẫu nhiên
    'Street ' || (random() * 50)::int,  -- Đường ngẫu nhiên
    CASE WHEN random() > 0.5 THEN 'Hanoi' ELSE 'Ho Chi Minh' END,  -- Thành phố ngẫu nhiên
    'Vietnam',  -- Quốc gia cố định
    CASE WHEN random() > 0.7 THEN 'Work' WHEN random() > 0.4 THEN 'Home' ELSE 'Other' END,  -- Loại địa chỉ (Work/Home/Other)
    id,  -- user_id
    NOW(), NOW()
FROM (SELECT id FROM tbl_user ORDER BY random() LIMIT 100) AS user_sample;


