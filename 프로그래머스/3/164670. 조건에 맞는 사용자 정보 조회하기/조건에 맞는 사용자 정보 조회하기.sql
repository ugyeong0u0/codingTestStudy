-- 코드를 입력하세요
SELECT DISTINCT US.USER_ID,
        US.NICKNAME,
        US.CITY ||' ' || US.STREET_ADDRESS1|| ' ' || US.STREET_ADDRESS2	AS 전체주소,
        SUBSTR(US.TLNO,1,3 ) || '-' || SUBSTR(US.TLNO,4,4 ) || '-'|| SUBSTR(US.TLNO,8,4 ) AS 전화번호
    FROM USED_GOODS_BOARD BO,
        USED_GOODS_USER US
    WHERE 1=1 
        AND BO.WRITER_ID = US.USER_ID
        AND US.USER_ID IN (
        
            SELECT WRITER_ID
            FROM USED_GOODS_BOARD
            WHERE 1=1 
            GROUP BY WRITER_ID HAVING COUNT(*)>= 3
            
        
        
        )
      
        ORDER BY 1 DESC