package com.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "xe_dap")
@Entity
@Getter
@Setter
public class XeDap implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia")
    private BigDecimal gia;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "nguoi_tao_ban_ghi")
    private String nguoiTaoBanGhi;

    @Column(name = "thoi_diem_tao")
    private Date thoiDiemTao;

    @Column(name = "nguoi_thay_doi_cuoi")
    private String nguoiThayDoiCuoi;

    @Column(name = "thoi_diem_thay_doi_cuoi")
    private Date thoiDiemThayDoiCuoi;

    @Column(name="da_xoa")
    private boolean daXoa;

    @Column(name = "hang")
    private String hang;

    @Column(name = "dong")
    private String dong;

    public XeDap() {
    }

    public XeDap(String ten, String moTa, BigDecimal gia, Integer soLuong, String nguoiTaoBanGhi, Date thoiDiemTao, String nguoiThayDoiCuoi, Date thoiDiemThayDoiCuoi, boolean daXoa, String hang, String dong) {
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nguoiTaoBanGhi = nguoiTaoBanGhi;
        this.thoiDiemTao = thoiDiemTao;
        this.nguoiThayDoiCuoi = nguoiThayDoiCuoi;
        this.thoiDiemThayDoiCuoi = thoiDiemThayDoiCuoi;
        this.daXoa = daXoa;
        this.hang = hang;
        this.dong = dong;
    }

    public XeDap(Long id, String ten, String moTa, BigDecimal gia, Integer soLuong, String nguoiTaoBanGhi, Date thoiDiemTao, String nguoiThayDoiCuoi, Date thoiDiemThayDoiCuoi, boolean daXoa, String hang, String dong) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nguoiTaoBanGhi = nguoiTaoBanGhi;
        this.thoiDiemTao = thoiDiemTao;
        this.nguoiThayDoiCuoi = nguoiThayDoiCuoi;
        this.thoiDiemThayDoiCuoi = thoiDiemThayDoiCuoi;
        this.daXoa = daXoa;
        this.hang = hang;
        this.dong = dong;
    }

    public XeDap(Long id,String ten, String moTa, BigDecimal gia, Integer soLuong, String nguoiThayDoiCuoi, Date thoiDiemThayDoiCuoi, boolean daXoa, String hang, String dong) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nguoiThayDoiCuoi = nguoiThayDoiCuoi;
        this.thoiDiemThayDoiCuoi = thoiDiemThayDoiCuoi;
        this.daXoa = daXoa;
        this.hang = hang;
        this.dong = dong;
    }
}
