-- SELECT 
--         PRODUCT_ID,
--         SALES_AMOUNT,
--         TO_CHAR(SALES_DATE,'YYYY-MM-DD') AS SALES_DATE ,
--         USER_ID
        
--         FROM (SELECT 
--                 PRODUCT_ID,
--                 SALES_AMOUNT,
--               SALES_DATE ,
--                 NULL AS USER_ID
             
--                 FROM OFFLINE_SALE
             
--         UNION
            
--               SELECT 
--                     PRODUCT_ID,
--                     SALES_AMOUNT,
--                     SALES_DATE ,
--                     USER_ID AS USER_ID
             
--                     FROM ONLINE_SALE)
                    
--         WHERE 1=1
--             AND TO_CHAR(SALES_DATE,'YYYY-MM')= '2022-03'
--         ORDER BY 3 ASC, 1 ASC, 4 ASC

-- 코드를 입력하세요
SELECT 
        TO_CHAR(SALES_DATE,'YYYY-MM-DD') AS SALES_DATE,
        PRODUCT_ID,
        USER_ID,
        SALES_AMOUNT
    FROM (
        
        SELECT 
            SALES_DATE,
            PRODUCT_ID,
            USER_ID,
            SALES_AMOUNT
        FROM  
            ONLINE_SALE
            
     
    UNION 
            
        
            SELECT 
                SALES_DATE,
                PRODUCT_ID,
                NULL AS USER_ID,
                SALES_AMOUNT
                
                FROM  
                    OFFLINE_SALE
                
        )
    WHERE 1=1 AND
        TO_CHAR(SALES_DATE,'YYYY-MM') = '2022-03'
    ORDER BY 1 ASC , 2 ASC, 3 ASC