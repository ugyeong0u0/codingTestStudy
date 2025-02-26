-- 코드를 입력하세요
SELECT FLAVOR
    FROM (SELECT H.FLAVOR,
          SUM(H.TOTAL_ORDER) 
             FROM FIRST_HALF H,
                 ICECREAM_INFO I
                WHERE 1=1 
                    AND H.FLAVOR = I.FLAVOR
                    AND H.TOTAL_ORDER > 3000
                    AND I.INGREDIENT_TYPE = 'fruit_based'
                GROUP BY H.FLAVOR 
                ORDER BY 2 DESC
         )
 