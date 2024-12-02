-- 코드를 입력하세요
SELECT CAR_ID
    FROM (
        SELECT A.CAR_ID
        FROM CAR_RENTAL_COMPANY_CAR A,
            CAR_RENTAL_COMPANY_RENTAL_HISTORY B 
        WHERE 1=1 
            AND A.CAR_ID = B.CAR_ID
            AND CAR_TYPE= '세단'
            AND TO_CHAR(START_DATE,'MM') = '10'
    )
    GROUP BY CAR_ID
    ORDER BY 1 DESC