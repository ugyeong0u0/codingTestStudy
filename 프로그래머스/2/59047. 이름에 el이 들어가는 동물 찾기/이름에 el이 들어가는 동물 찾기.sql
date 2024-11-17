-- 코드를 입력하세요
SELECT ANIMAL_ID,
        NAME
    FROM ANIMAL_INS
    WHERE 1=1 
        AND UPPER(NAME) LIKE '%EL%' AND ANIMAL_TYPE = 'Dog'
    order by 2