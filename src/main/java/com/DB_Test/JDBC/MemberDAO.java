package com.DB_Test.JDBC;

import com.DB_Test.MySQL_Connection_Info;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    // 삽입
    public MemberDTO insert(MemberDTO member) {

        String sql = "INSERT INTO member(member_id, password, nickname, phone, email) VALUES(?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPwd());
            pstmt.setString(3, member.getNickname());
            pstmt.setString(4, member.getPhone());
            pstmt.setString(5, member.getEmail());
            int result = pstmt.executeUpdate();

            if (result > 0) {
                return member;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new IllegalStateException("삽입 : " + e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 조회
    public MemberDTO select(String member_id) {

        String sql = "SELECT * FROM member WHERE member_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member_id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("member_id"));
                member.setPwd(rs.getString("password"));
                member.setNickname(rs.getString("nickname"));
                member.setPhone(rs.getString("phone"));
                member.setEmail(rs.getString("email"));
                return member;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new IllegalStateException("조회 : " + e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 수정
    public MemberDTO update(MemberDTO member) {

        String sql = "UPDATE member SET password = ?, nickname = ?, phone = ?, email = ? WHERE member_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member.getPwd());
            pstmt.setString(2, member.getNickname());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getId());
            int result = pstmt.executeUpdate();

            if (result > 0) {
                return member;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new IllegalStateException("수정 : " + e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 삭제
    public String delete(String member_id) {

        String sql = "DELETE FROM member WHERE member_id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, member_id);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                return member_id;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new IllegalStateException("삭제 : " + e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 전체 조회
    public List<MemberDTO> findAll() {

        String sql = "SELECT * FROM member ORDER BY member_id ASC";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<MemberDTO> members = new ArrayList<>();

            while(rs.next()) {
                MemberDTO member = new MemberDTO();
                member.setId(rs.getString("member_id"));
                member.setPwd(rs.getString("password"));
                member.setNickname(rs.getString("nickname"));
                member.setPhone(rs.getString("phone"));
                member.setEmail(rs.getString("email"));
                members.add(member);
            }

            return members; // members List 반환

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() throws SQLException {
        MySQL_Connection_Info info = new MySQL_Connection_Info();
        return DriverManager.getConnection(
                info.getJDBC_URL(),
                info.getJDBC_USER(),
                info.getJDBC_PASSWORD());
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}