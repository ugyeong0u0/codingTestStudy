-- -- 코드를 입력하세요
-- SELECT 
--     T.APNT_NO,
--     NT.PT_NAME,
--     NT.PT_NO,
--     R.MCDP_CD,
--     R.DR_NAME,
--     TO_CHAR (T.APNT_YMD,'YYYY-MM-DD HH24:MI:SS.FF6')AS apnt_ymd
    
--     FROM PATIENT NT,
--         DOCTOR R,
--         APPOINTMENT T
--     WHERE 1=1 
--         AND NT.PT_NO = T.PT_NO
--         AND T.MDDR_ID = R.DR_ID
--         AND T.APNT_CNCL_YN ='N'
--         AND T.MCDP_CD= 'CS'
--         AND TO_CHAR(T.APNT_YMD, 'YYYY-MM-DD') = '2022-04-13'
--     ORDER BY APNT_YMD
SELECT 
    C.APNT_NO,
    A.PT_NAME,
    A.PT_NO,
    C.MCDP_CD,
    B.DR_NAME,
    C.APNT_YMD
FROM 
    PATIENT A, 
    DOCTOR B, 
    APPOINTMENT C
WHERE
    TO_CHAR(C.APNT_YMD, 'YYYYMMDD') = '20220413'
AND APNT_CNCL_YN = 'N'
AND C.MCDP_CD = 'CS'
AND A.PT_NO = C.PT_NO
AND C.MDDR_ID = B.DR_ID
ORDER BY APNT_YMD