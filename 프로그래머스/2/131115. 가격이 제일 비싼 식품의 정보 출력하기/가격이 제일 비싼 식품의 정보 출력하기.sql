-- 코드를 입력하세요

SELECT *
FROM(
SELECT PRODUCT_ID,	PRODUCT_NAME,	PRODUCT_CD,	CATEGORY, PRICE AS PRICE
    FROM FOOD_PRODUCT
    ORDER BY PRICE DESC)
    WHERE ROWNUM<2