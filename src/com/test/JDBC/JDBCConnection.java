package com.test.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.test.exam03.Member;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JDBCConnection {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String url = "jdbc:mariadb://localhost:3306/webdev";
        String userid = "webmaster";
        String userpw = "12345";
        String query = "SELECT userid, username, age FROM tbl_test ORDER BY userid";
        
        // Hikari - Connection Pool
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("org.mariadb.jdbc.Driver");
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(userid);
        hikariConfig.setPassword(userpw);
        hikariConfig.setConnectionInitSql("SELECT NOW() FROM DUAL");
        hikariConfig.setMaximumPoolSize(20);
        hikariConfig.setLeakDetectionThreshold(3000);
        hikariConfig.setPoolName("mariaDB-HikariCP");

        Connection con; // SQL문을 실행하는 Statement 객체 생성 및 JDBC 연결 종료
        Statement stmt; // SQL문을 실행해서 ResultSet 객체를 생성
        ResultSet rs; // SQL문 실행 결과를 얻어 오는 객체로 현재 데이터의 행(레코드 위치)의 위치를 나타내는 커서(cursor)를 관리

        HikariDataSource ds = new HikariDataSource(hikariConfig);

        con = ds.getConnection();

        // Class.forName("org.mariadb.jdbc.Driver"); // JDBC 드라이버 로딩
        // con = DriverManager.getConnection(url, userid, userpw);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
        List<Member> list = new ArrayList<>(); // DTO
        
        while(rs.next()) {

            list.add(new Member(rs.getString("userid"),
                                rs.getString("username"),
                                rs.getInt("age")));

        }

        if(rs != null) {
            rs.close();
        }
        if(stmt != null) {
            stmt.close();
        }
        if(con != null) {
            con.close();
        }
        // // if(ds != null) {
        // //     ds.close();
        // // }
        
        for(Member member:list) {
            System.out.println("아이디 = " + member.getUserId() + "\t"
                             + "이름 = " + member.getUserName() + "\t"
                             + "나이 = " + member.getAge());
        }
        
    }
}
