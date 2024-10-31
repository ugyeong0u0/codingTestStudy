-- 코드를 입력하세요
SELECT
    ANIMAL_TYPE
    ,NAME
    ,SEX_UPON_INTAKE
    FROM(
        
        SELECT ANIMAL_ID,ANIMAL_TYPE
        ,SEX_UPON_INTAKE
            ,CASE WHEN NAME IS NULL
            THEN 'No name'
            ELSE NAME
            END NAME
        FROM ANIMAL_INS
        -- ORDER BY 1 ASC
    ) 
    ORDER BY ANIMAL_ID ASC