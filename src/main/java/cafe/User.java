/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe;

/**
 *
 * @author Acer
 */
public class User {

    private String manv; // Mã nhân viên
    private String tennhanvien; // Tên nhân viên
    private String chucvu; // Chức vụ
    private String sodienthoai; // Số điện thoại
    private String taikhoan; // Tài khoản
    private String matkhau; // Mật khẩu

    // Constructor không tham số
    public User() {
    }

    // Constructor có tham số
    public User(String manv, String tennhanvien, String chucvu, String sodienthoai, String taikhoan, String matkhau) {
        this.manv = manv;
        this.tennhanvien = tennhanvien;
        this.chucvu = chucvu;
        this.sodienthoai = sodienthoai;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
    }

    // Getter và Setter cho từng thuộc tính
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    // Phương thức để hiển thị thông tin người dùng
    @Override
    public String toString() {
        return "User{"
                + "manv='" + manv + '\''
                + ", tennhanvien='" + tennhanvien + '\''
                + ", chucvu='" + chucvu + '\''
                + ", sodienthoai='" + sodienthoai + '\''
                + ", taikhoan='" + taikhoan + '\''
                + ", matkhau='" + matkhau + '\''
                + '}';
    }
}
