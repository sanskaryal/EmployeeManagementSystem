CREATE TABLE employees (
    employee_id VARCHAR(50) PRIMARY KEY, -- Unique identifier for the employee
    first_name VARCHAR(100) NOT NULL,   -- Employee's first name
    last_name VARCHAR(100) NOT NULL,    -- Employee's last name
    dob DATE NOT NULL,                  -- Employee's date of birth
    email VARCHAR(100) NOT NULL UNIQUE, -- Employee's email (unique)
    phone VARCHAR(15),                  -- Employee's phone number
    university_name VARCHAR(200),       -- University name (from EducationDetails)
    degree_type VARCHAR(100),           -- Degree type (e.g., Bachelor's, Master's)
    graduation_date DATE,               -- Graduation date
    transcript TEXT,                    -- Transcript (can store file path or text)
    visa_status VARCHAR(50),            -- Visa status (from VisaDetails)
    visa_start_date DATE,               -- Visa start date
    visa_end_date DATE,                 -- Visa end date
    visa_document TEXT                  -- Visa document (can store file path or text)
);
select * from employees
INSERT INTO employees (
    employee_id, first_name, last_name, dob, email, phone, 
    university_name, degree_type, graduation_date, transcript, 
    visa_status, visa_start_date, visa_end_date, visa_document
) VALUES (
    '001', 'John', 'Doe', '1990-05-15', 'john.doe@example.com', '1234567890',
    'Harvard University', 'Bachelor of Science', '2012-06-01', 'Transcript file path',
    'H1B', '2023-01-01', '2025-12-31', 'Visa document file path'
);

-- Add the middle_name column
--ALTER TABLE employees
--ADD COLUMN middle_name VARCHAR(100) AFTER first_name;
--
--ALTER TABLE employees
--DROP COLUMN middle_name;

