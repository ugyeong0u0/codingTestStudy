  
SELECT 
    A.AUTHOR_ID,
    AUTHOR_NAME,
    B.CATEGORY,
    SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
    FROM 
        BOOK B,
        AUTHOR A,
        BOOK_SALES BS
    WHERE 
        1=1 AND
        B.AUTHOR_ID	= A.AUTHOR_ID AND
        B.BOOK_ID = BS.BOOK_ID AND
        TO_CHAR( BS.SALES_DATE ,'YYYY-MM') = '2022-01'
     GROUP BY
        A.AUTHOR_ID,
        AUTHOR_NAME,
        B.CATEGORY
     
     ORDER BY
        1 ASC, 
        3 DESC