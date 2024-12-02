
CREATE PROCEDURE create_my_dynamic_schema(schema_name TEXT)
LANGUAGE plpgsql
AS $$
BEGIN

   EXECUTE format('CREATE  SCHEMA IF NOT EXISTS %I', schema_name);

END;
$$;