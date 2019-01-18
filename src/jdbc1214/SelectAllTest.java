package jdbc1214;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectAllTest {

	public static void main(String[] args) {
		// MySQL �����ͺ��̽� - JDBC
		// MySQL DB ���� ����
		String url = "jdbc:mysql://localhost:3306/soldesk?useUnicode=true&characterEncoding=euckr";
		String user = "root";
		String password = "1234";
		String driver = "org.gjt.mm.mysql.Driver";
		//mysql-connector-java-5.1.47.jar	library����
		//D:\java1113\setup\mysql-connector-java-5.1.47\src\org\gjt\mm\mysql
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			
			StringBuilder sql = new StringBuilder();
			//sql.append(" INSERT INTO sungjuk(uname,kor,eng,mat,regdt) ");
			//sql.append(" VALUES(?, ?, ?, ?, now()) ");
			sql.append(" SELECT sno, uname,kor,eng,mat,tot, aver, regdt ");
			sql.append(" FROM sungjuk ");
			sql.append(" ORDER BY sno ");
			
			//5) SQL�� ��ȯ
			pstmt = con.prepareStatement(sql.toString());
			
			//6) SQL�� ����
			rs = pstmt.executeQuery();	//table rs�� ����
			if(rs.next()) {	//cursor �����ϴ���?
				System.out.println("�ڷ� ����");
				do {
					System.out.print(rs.getInt("sno")+" ");
					System.out.print(rs.getString("uname")+" ");
					System.out.print(rs.getInt("kor")+" ");
					System.out.print(rs.getInt("eng")+" ");
					System.out.print(rs.getInt("mat")+" ");
					System.out.print(rs.getInt("tot")+" ");
					System.out.print(rs.getInt("aver")+" ");
					System.out.print(rs.getInt("regdt")+" ");
					System.out.println();
				}while(rs.next());
			}else {
				System.out.println("�ڷ� ����");
			}//if end
			
		}catch (Exception e) {
			System.out.println("MySQL DB ���� ����"+e);
		}finally {
			try {
				if(rs!=null) {rs.close();}
			}catch (Exception e) {}
			
			try {
				if(pstmt!=null) {pstmt.close();}
			}catch (Exception e) {}
			
			try {
				if(con!=null) {con.close();}
			}catch (Exception e) {}
		}//try end

	}//main() end
}//class end
