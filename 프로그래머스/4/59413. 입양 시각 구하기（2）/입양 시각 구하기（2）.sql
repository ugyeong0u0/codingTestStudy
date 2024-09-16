-- 코드를 입력하세요
SELECT 
    B.HOUR
    ,COUNT(A.ANIMAL_ID) AS COUNT
    FROM ANIMAL_OUTS A
    RIGHT OUTER JOIN
   (
            SELECT LEVEL -1 AS HOUR
            FROM DUAL
            CONNECT BY LEVEL <=24
    
        )B      
        
    ON
        TO_CHAR(A.DATETIME,'HH24') = B.HOUR
    GROUP BY 
        HOUR
    ORDER BY 
        1 ASC
    