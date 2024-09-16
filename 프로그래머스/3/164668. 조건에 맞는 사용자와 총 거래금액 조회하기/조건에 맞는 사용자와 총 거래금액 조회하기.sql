-- 코드를 입력하세요
SELECT * 
    FROM (
        SELECT U.USER_ID,
                U.NICKNAME,
                SUM(B.PRICE) AS TOTAL_SALES
            FROM 
                USED_GOODS_BOARD B,
                USED_GOODS_USER  U
            WHERE 1=1 AND
                B.WRITER_ID= U.USER_ID AND 
                B.STATUS = 'DONE'
            GROUP BY 
                USER_ID,
                U.NICKNAME
    )
WHERE TOTAL_SALES>=700000
ORDER BY TOTAL_SALES ASC