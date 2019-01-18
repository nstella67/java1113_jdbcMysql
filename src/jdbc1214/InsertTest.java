package jdbc1214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {

	public static void main(String[] args) {
		// MySQL 데이터베이스 - JDBC
		// MySQL DB 관련 정보
		String url = "jdbc:mysql://localhost:3306/soldesk?useUnicode=true&characterEncoding=euckr";
		String user = "root";
		String password = "1234";
		String driver = "org.gjt.mm.mysql.Driver";
		//mysql-connector-java-5.1.47.jar	library선택
		//D:\java1113\setup\mysql-connector-java-5.1.47\src\org\gjt\mm\mysql
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			StringBuilder sql = new StringBuilder();
			//sql.append(" INSERT INTO sungjuk(uname,kor,eng,mat,regdt) ");
			//sql.append(" VALUES(?, ?, ?, ?, now()) ");
			
			sql.append(" INSERT INTO sungjuk(sno, uname,kor,eng,mat,regdt) ");
			sql.append(" VALUES( (SELECT ifnull(max(sno),0)+1 FROM sungjuk AS tb)" );
			sql.append(" , ?, ?, ?, ?, now()) ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, "손흥민");	//이름
			pstmt.setInt(2, 99);				//kor
			pstmt.setInt(3, 97);				//eng
			pstmt.setInt(4, 95);				//mat
			
			int result = pstmt.executeUpdate();
			if(result==0) {
				System.out.println("행추가 실패");
			}else {
				System.out.println("행추가 성공");
			}
		}catch (Exception e) {
			System.out.println("MySQL DB 연결 실패"+e);
		}finally {
			try {
				if(pstmt!=null) {pstmt.close();}
			}catch (Exception e) {}
			
			try {
				if(con!=null) {con.close();}
			}catch (Exception e) {}
		}//try end

	}//main() end
}//class end
