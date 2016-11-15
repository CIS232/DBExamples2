# DBExamples2

## Column Data Types:
| SQL Data Type  | Corresponding Java Data Type | Notes                                                         |
|----------------|------------------------------|---------------------------------------------------------------|
| INTEGER or INT | int                          |                                                               |
| CHAR(n)        | String                       | fixed-length of n characters                                  |
| VARCHAR(n)     | String                       | variable-length up to n characters                            |
| REAL           | float                        |                                                               |
| DOUBLE         | double                       |                                                               |
| DECIMAL(t, d)  | java.math.BigDecimal         | t total digits and d digits appearing after the decimal point |
| DATE           | java.sql.Date                |                                                               |

## Select statements from a single table:

### No filter:

```SQL
SELECT columnName1, columnName2, ...
FROM tableName
```
  
## With filter:

```SQL
SELECT columnName1, columnName2, ...
FROM tableName
WHERE condition
```

## WHERE filter

Select, update, delete all can use a `WHERE` filter specified after the table name.

When dealing with string types, you can use `=` to get exact matches or `LIKE` to use wildcards. Example of exact match:

```SQL
SELECT *
FROM Coffee
WHERE ProdNum = '14-001'
```

Wildcard match to get all coffees with product number starting with `14-`:

```SQL
SELECT *
FROM Coffee
WHERE ProdNum LIKE '14-%'
```

You can use `AND` and `OR` to combine conditions and use `()` to group conditions.


