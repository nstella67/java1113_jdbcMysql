SELECT * FROM sungjuk
;

-- 이름에 ? 글자가 포함된 행을 삭제하시오
DELETE FROM sungjuk
WHERE uname LIKE '%?%'
;

DELETE FROM sungjuk
WHERE sno=6
;

--행추가
INSERT INTO sungjuk(uname, kor, eng, mat, regdt)
VALUES('김연아', 88, 55, 44, now())
;

