package medical_declaration_management.model;

public class Declaration {
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String country;
    private String idCard;
    private String phuongTien;
    private String tenPhuongTien;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String tinhDaDen;

    public Declaration() {
    }

    public Declaration(int id, String name, String birthday, String gender, String country, String idCard, String phuongTien,
                       String tenPhuongTien, String soGhe, String ngayKhoiHanh, String ngayKetThuc, String tinhDaDen) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.phuongTien = phuongTien;
        this.tenPhuongTien = tenPhuongTien;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.tinhDaDen = tinhDaDen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhuongTien() {
        return phuongTien;
    }

    public void setPhuongTien(String phuongTien) {
        this.phuongTien = phuongTien;
    }

    public String getTenPhuongTien() {
        return tenPhuongTien;
    }

    public void setTenPhuongTien(String tenPhuongTien) {
        this.tenPhuongTien = tenPhuongTien;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTinhDaDen() {
        return tinhDaDen;
    }

    public void setTinhDaDen(String tinhDaDen) {
        this.tinhDaDen = tinhDaDen;
    }
}
