SELECT * FROM sungjuk
;

-- �̸��� ? ���ڰ� ���Ե� ���� �����Ͻÿ�
DELETE FROM sungjuk
WHERE uname LIKE '%?%'
;

DELETE FROM sungjuk
WHERE sno=6
;

--���߰�
INSERT INTO sungjuk(uname, kor, eng, mat, regdt)
VALUES('�迬��', 88, 55, 44, now())
;

