CREATE OR REPLACE PROCEDURE create_schema_and_tables(schema_name VARCHAR)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Create schema if it does not exist
    EXECUTE format('CREATE SCHEMA IF NOT EXISTS %I', schema_name);

    -- Create a users table in the specified schema
    EXECUTE format('
        CREATE TABLE IF NOT EXISTS %I.users (
            id UUID PRIMARY KEY,
            username VARCHAR(50) NOT NULL,
            password VARCHAR(100) NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        )', schema_name);

     EXECUTE format('
               CREATE TABLE IF NOT EXISTS %I.books (
                   id UUID PRIMARY KEY,
                   name VARCHAR(200) NOT NULL,
                   description VARCHAR(500) NOT NULL,
                   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
               )', schema_name);


    -- Add more table creation commands as needed
END;
$$;
