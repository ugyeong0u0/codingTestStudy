-- 코드를 작성해주세요



SELECT QUARTER,
    COUNT(*) AS  ECOLI_COUNT
    FROM(
        SELECT
            case 
                WHEN  DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN('01','02','03') THEN '1Q'
                when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN('04','05','06') THEN '2Q'
                when DATE_FORMAT(DIFFERENTIATION_DATE, '%m') IN('07','08','09') THEN '3Q'
                ELSE '4Q'
                END as  QUARTER
            FROM ECOLI_DATA ) as aa
    
    GROUP BY QUARTER
    order by 1 asc
    
    