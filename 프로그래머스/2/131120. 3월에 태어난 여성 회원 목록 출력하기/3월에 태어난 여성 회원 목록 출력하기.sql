-- 코드를 입력하세요
-- SELECT * 
--     FROM MEMBER_PROFILE

SELECT MEMBER_ID,
    MEMBER_NAME,
    GENDER,
    TO_CHAR(DATE_OF_BIRTH,'YYYY-MM-DD')
    FROM MEMBER_PROFILE
    WHERE 1=1 AND
        TO_CHAR(DATE_OF_BIRTH, 'MM') ='03'
        AND TLNO IS NOT NULL 
        AND GENDER = 'W'
    ORDER BY 1 ASC
        
    