-- 코드를 입력하세요
SELECT ANIMAL_ID,
        NAME
    FROM (
        SELECT I.ANIMAL_ID,
                I.NAME,
        I.DATETIME
        FROM ANIMAL_INS I
            , ANIMAL_OUTS O
        WHERE 1=1 
            AND I.ANIMAL_ID	= O.ANIMAL_ID
            AND I.DATETIME > O.DATETIME
        ORDER BY I.DATETIME ASC
    )