/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmgmt.dao;

import studentmgmt.dbutil.DBConnection;
import studentmgmt.pojo.StudentPojo;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import studentmgmt.pojo.CurrentUser;
import studentmgmt.pojo.UserPojo;

/**
 *
 * @author HP
 */
public class StudentDao {
    public static boolean addStudent(StudentPojo e)throws SQLException
    {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("Insert into students values(?,?,?,?,?,?)");
        ps.setInt(1,e.getEnrollNo());
        ps.setString(2,e.getStudName());
        ps.setString(3,e.getStudBranch());
        ps.setInt(4,e.getStudSemester());
        ps.setString(5,e.getStudPhoneNo());
        ps.setString(6,e.getStudCity());
        int result=ps.executeUpdate();
        
        return result==1;
    }
    public static StudentPojo findEmpByEmpNo(int enrollNo) throws SQLException
    {
        Connection con=DBConnection.getConnection();
        
        PreparedStatement ps=con.prepareStatement("select * from students where enrollno=?");
        ps.setInt(1,enrollNo);
        
        ResultSet rs=ps.executeQuery();
        
        StudentPojo e=null;
        
        if(rs.next()){
            e=new StudentPojo();
            e.setEnrollNo(enrollNo);
            e.setStudName( rs.getString(2));
            e.setStudBranch(rs.getString(3));
            e.setStudSemester(rs.getInt(4));
            e.setStudPhoneNo(rs.getString(5));
            e.setStudCity(rs.getString(6));
        }
        return e;
    }
    public static List<StudentPojo> getAllStudents()throws SQLException
    {
        Connection con=DBConnection.getConnection();
        
        Statement ps=con.createStatement();
        List<StudentPojo> studList=new ArrayList<>();
        ResultSet rs=ps.executeQuery("select * from students order by enrollno");
        while(rs.next())
        {
            StudentPojo e= new StudentPojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
            studList.add(e);
        }
        return studList;
    }
    public static boolean updateRecord(StudentPojo e)throws SQLException
    {
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("update students set sname= ?,sbranch= ? ,semester= ?, sphone= ?,scity= ? where enrollno=?");
        ps.setString(1,e.getStudName());
        ps.setString(2,e.getStudBranch());
        ps.setInt(3,e.getStudSemester());
        ps.setString(4,e.getStudPhoneNo());
        ps.setString(5,e.getStudCity());
        ps.setInt(6,e.getEnrollNo());
        int result=ps.executeUpdate();
         return result==1;
    }
    public static boolean deleteStudentByEnrollNo(int enrollno)throws SQLException
    {
         Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("delete from students where enrollno=?");
        ps.setInt(1,enrollno);
        int result=ps.executeUpdate();
         return result==1;
    }
     public static boolean validateUser(UserPojo user) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=?");
        ps.setString(1,user.getUserid());
        ps.setString(2,user.getPassword());
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            CurrentUser.setUserid(rs.getString(1));
            CurrentUser.setName(rs.getString(2));
            return true;
        }
        return false;
    }

}
