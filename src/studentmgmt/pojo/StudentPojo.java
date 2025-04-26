/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmgmt.pojo;

/**
 *
 * @author HP
 */
public class StudentPojo {

    public StudentPojo() {
    }

   public StudentPojo(int enrollNo, String studName, String StudBranch, int studSemester, String studPhoneNo, String studCity) {
        this.enrollNo = enrollNo;
        this.studName = studName;
        this.studBranch = StudBranch;
        this.studSemester = studSemester;
        this.studPhoneNo = studPhoneNo;
        this.studCity = studCity;
   }
    public int getEnrollNo() {
        return enrollNo;
    }

    public String getStudName() {
        return studName;
    }

    public String getStudBranch() {
        return studBranch;
    }

    public int getStudSemester() {
        return studSemester;
    }

    public String getStudPhoneNo() {
        return studPhoneNo;
    }

    public String getStudCity() {
        return studCity;
    }

    public void setEnrollNo(int enrollNo) {
        this.enrollNo = enrollNo;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public void setStudBranch(String StudBranch) {
        this.studBranch = StudBranch;
    }

    public void setStudSemester(int studSemester) {
        this.studSemester = studSemester;
    }

    public void setStudPhoneNo(String studPhoneNo) {
        this.studPhoneNo = studPhoneNo;
    }

    public void setStudCity(String studCity) {
        this.studCity = studCity;
    }


    private int enrollNo;
    private String studName;
    private String studBranch;
    private int studSemester;
    private String studPhoneNo;
    private String studCity;
}
