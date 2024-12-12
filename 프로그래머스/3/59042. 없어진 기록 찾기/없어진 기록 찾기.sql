-- 코드를 입력하세요
SELECT ANIMAL_ID,
        NAME
        FROM ANIMAL_OUTS
        WHERE ANIMAL_ID NOT IN(
        
        SELECT I.ANIMAL_ID
            FROM ANIMAL_INS I,
                ANIMAL_OUTS O
            WHERE 1=1 
                AND I.ANIMAL_ID = O.ANIMAL_ID
        
        )
	ORDER BY 1, 2 
        
        