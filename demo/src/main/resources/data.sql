-- Inserting sample customers
INSERT INTO customer (name, email) VALUES ('John Doe', 'john.doe@example.com');
INSERT INTO customer (name, email) VALUES ('Jane Smith', 'jane.smith@example.com');

-- Inserting sample suppliers
INSERT INTO supplier (name, contact_info) VALUES ('Supplier One', 'contact@supplier1.com');
INSERT INTO supplier (name, contact_info) VALUES ('Supplier Two', 'contact@supplier2.com');

-- Inserting sample medicines
INSERT INTO medicine (name, manufacturer, supplier_id) VALUES ('Medicine A', 'Manufacturer A', 1);
INSERT INTO medicine (name, manufacturer, supplier_id) VALUES ('Medicine B', 'Manufacturer B', 2);

-- Inserting sample pharmacists
INSERT INTO pharmacist (name, license_number) VALUES ('Pharmacist One', 'LIC001');
INSERT INTO pharmacist (name, license_number) VALUES ('Pharmacist Two', 'LIC002');

-- Inserting sample orders
INSERT INTO "order" (order_date, status, pharmacist_id) VALUES ('2023-06-21', 'Pending', 1);
INSERT INTO "order" (order_date, status, pharmacist_id) VALUES ('2023-06-22', 'Completed', 2);

-- Inserting sample prescriptions
INSERT INTO prescription (description, customer_id) VALUES ('Prescription 1 for John Doe', 1);
INSERT INTO prescription (description, customer_id) VALUES ('Prescription 2 for Jane Smith', 2);

-- Linking prescriptions with medicines
INSERT INTO prescription_medicine (prescription_id, medicine_id) VALUES (1, 1);
INSERT INTO prescription_medicine (prescription_id, medicine_id) VALUES (2, 2);
