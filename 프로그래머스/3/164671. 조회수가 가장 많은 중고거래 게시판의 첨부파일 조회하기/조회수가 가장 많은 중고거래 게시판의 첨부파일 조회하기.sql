-- 코드를 입력하세요
SELECT '/home/grep/src/' || BOARD_ID  || '/' ||  FILE_ID || FILE_NAME || FILE_EXT AS FILE_PATH
    FROM (
        SELECT B.FILE_ID,
            B.FILE_EXT,
            B.FILE_NAME,
            B.BOARD_ID
        FROM USED_GOODS_BOARD A ,
            USED_GOODS_FILE B
        WHERE 1=1
            AND A.BOARD_ID= B.BOARD_ID
            AND A.VIEWS = (
                SELECT MAX(VIEWS)
                FROM USED_GOODS_BOARD
            ) 
        
        ORDER BY 1 DESC
    )