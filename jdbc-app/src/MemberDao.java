import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class MemberDao {
	
	private String url;
	private String dbid;
	private String dbpw;
	
	private void dbPropertiesInit() throws IOException {
		FileInputStream fin = new FileInputStream("D:\\db.properties");
		Properties pro = new Properties();
		pro.load(fin);
		this.url = pro.getProperty("url");
		this.dbid = pro.getProperty("dbid");
		this.dbpw = pro.getProperty("dbpw");
	}
	
	public Member selectMemberById(String id) throws ClassNotFoundException, SQLException, IOException {
		this.dbPropertiesInit();
		//properties db정보 가져옵니다(내부적으로 input....
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(this.url, this.dbid, this.dbpw);
		PreparedStatement pstmt = conn.prepareStatement("select ora_id, ora_pw, ora_level, ora_name, ora_email from oracle_member where ora_id=?");
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		Member m = new Member();
		if(rs.next()) {
			m.setId(rs.getString("ora_id"));
			m.setPw(rs.getString("ora_pw"));
			m.setLevel(rs.getString("ora_level"));
			m.setName(rs.getString("ora_name"));
			m.setEmail(rs.getString("ora_email"));
		}
		return m;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		MemberDao dao = new MemberDao();
		Member m = dao.selectMemberById("id001");
		System.out.println(m.getId() + m.getPw() + m.getLevel() + m.getName() + m.getEmail());
	}

}
