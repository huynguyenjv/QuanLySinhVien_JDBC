package com.edu.pro.test;

import com.edu.pro.DAO.Diemsv_DAO;
import com.edu.pro.DAO.Lop_DAO;
import com.edu.pro.DAO.Monhoc_DAO;
import com.edu.pro.DAO.SinhVien_DAO;
import com.edu.pro.db.JDBCtil;
import com.edu.pro.model.*;

import javax.swing.*;
import java.io.File;
import java.sql.Date;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
   private static Sinhvien sinhvien ;
    public static void setInformation() {

        System.out.print("Mssv : ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Ten sinh vien : ");
        String nameSv = scanner.nextLine();
        System.out.print("Ngay sinh : ");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Phai ");
        String gender = scanner.nextLine();
        System.out.print("Ma lop : ");
        String idLop = scanner.nextLine();

        Date dob = new Date(year-1900,month-1,day);
        sinhvien = new Sinhvien(id,nameSv,dob,gender,idLop);
    }
    public static void menuMain(){
        System.out.println("\t\t\t\t\t\t\t\t QUAN LY SINH VIEN JDBC ");
        System.out.println("\t\t\t\t+----------------------------------------------------------------+\n"+
                           "\t\t\t\t|  1. Quan ly                                                    |\n" +
                           "\t\t\t\t|  2. Tim kiem sinh vien                                         |\n" +
                           "\t\t\t\t|  3. Tong hop sinh vien                                         |\n" +
                           "\t\t\t\t|  4. Min, Max                                                   |\n" +
                           "\t\t\t\t|  5. Quit                                                       |\n" +
                           "\t\t\t\t+----------------------------------------------------------------+" );
    }
    public static void menuMainCaseOne(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Quan ly sinh vien                                          |\n" +
                           "|  2. Quan ly lop                                                |\n" +
                           "|  3. Quan ly diem                                               |\n" +
                           "|  4. Quan ly mon hoc                                            |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuEditSV(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Them thong tin cua sinh vien                               |\n" +
                           "|  2. Xoa sinh vien                                              |\n" +
                           "|  3. Cap nhat sinh vien                                         |\n" +
                           "|  4. Xuat danh sach sinh vien                                   |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuEditLop(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Them thong tin cua Lop                                     |\n" +
                           "|  2. Xoa Lop                                                    |\n" +
                           "|  3. Cap nhat Lop                                               |\n" +
                           "|  4. Xuat danh sach Lop                                         |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuEditMonHoc(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Them thong tin cua mon hoc                                 |\n" +
                           "|  2. Xoa mon hoc                                                |\n" +
                           "|  3. Cap nhat mon hoc                                           |\n" +
                           "|  4. Xuat danh sach mon hoc                                     |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuEditDiem(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Them thong tin cua diem                                    |\n" +
                           "|  2. Xoa diem                                                   |\n" +
                           "|  3. Cap nhat diem                                              |\n" +
                           "|  4. Xuat danh sach diem                                        |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuOfCaseOne(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. File có sẵn                                                |\n" +
                           "|  2. File nguoi dung nhap                                       |\n" +
                           "|  3. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuUpdate(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Cap nhat tat ca                                            |\n" +
                           "|  2. Cap nhat theo dieu kien                                    |\n" +
                           "|  3. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuTypeOfUpdateSV(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Cap nhat ho ten                                            |\n" +
                           "|  2. Cap nhat ngay sinh                                         |\n" +
                           "|  3. Cap nhat phai                                              |\n" +
                           "|  4. Cap nhat ma lop                                            |\n" +
                           "|  5. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void menuTypeOfUpdateLop(){
        System.out.println("+----------------------------------------------------------------+\n"+
                           "|  1. Cap nhat ten lop                                           |\n" +
                           "|  2. Cap nhat siso                                              |\n" +
                           "|  3. Quit                                                       |\n" +
                           "+----------------------------------------------------------------+" );
    }
    public static void main(String[] args) {
        int select;
        ArrayList<Sinhvien> danhsachsinhvien = new ArrayList<Sinhvien>();
        ArrayList<Lop> danhsachlop = new ArrayList<Lop>();
        ArrayList<Monhoc> danhsachmonhoc = new ArrayList<Monhoc>();
        ArrayList<Diemsv> danhsachdiemsv = new ArrayList<Diemsv>();
        QuanlySinhVien quanlySinhVien = new QuanlySinhVien(danhsachsinhvien);

        do {
            menuMain();
            System.out.print("Moi ban chon lua chon : ");
            select = scanner.nextInt();

            switch (select) {
                // quan ly
                case 1 : {
                    menuMainCaseOne();
                    System.out.print("Moi ban chon lua chon : ");
                    select = scanner.nextInt();
                    scanner.nextLine();
                    switch (select) {
                        // chinh sua sinh vien
                        case 1 : {
                            menuEditSV();
                            System.out.print("Moi ban chon lua chon : ");
                            select = scanner.nextInt();
                            scanner.nextLine();
                            switch (select) {
                                case 1:{
                                    menuOfCaseOne();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (select) {
                                        case 1 : {
                                            quanlySinhVien.insertSV("P:\\Dev\\Source\\Java\\JDBC\\QuanLySinhVien_JDBC\\src\\com\\edu\\file\\files\\danhsachC6.txt");
                                            danhsachsinhvien = quanlySinhVien.getDanhSach_Sinhvien();
                                            for(Sinhvien sinhvien : danhsachsinhvien){

                                                SinhVien_DAO.getInstance().insert(sinhvien);
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            // path : "P:\\Dev\\Source\\Java\\JDBC\\QuanLySinhVien_JDBC\\src\\com\\edu\\file\\files\\danhsachC6.txt"
                                            System.out.println("FilePath : ");
                                            String filePath = scanner.nextLine();
                                            quanlySinhVien.insertSV(filePath);
                                            danhsachsinhvien = quanlySinhVien.getDanhSach_Sinhvien();
                                            for(Sinhvien sinhvien : danhsachsinhvien){

                                                SinhVien_DAO.getInstance().insert(sinhvien);
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.exit(0);
                                            break;
                                        } default:{
                                            System.out.println("Khong hop le !!");
                                            System.exit(0);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2:{
                                    System.out.print("Mssv cua sinh vien can xoa : ");
                                    long mssv_remove = scanner.nextLong();
                                    danhsachsinhvien = SinhVien_DAO.getInstance().selectAll();

                                    for(int i = 0 ; i < danhsachsinhvien.size() ; i++){
                                        if(danhsachsinhvien.get(i).getId() == mssv_remove){
                                            SinhVien_DAO.getInstance().remove(danhsachsinhvien.get(i));
                                        }
                                    }
                                    break;
                                }
                                case 3:{
                                    menuUpdate();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (select){
                                        case 1 :{
                                            System.out.println("Nhap thong tin cap nhat cua sinh vien : ");
                                            setInformation();
                                            System.out.print("mssv cua sinh vien can cap nhap la : " + sinhvien.getId());

                                            danhsachsinhvien =  SinhVien_DAO.getInstance().selectAll();;
                                            for(Sinhvien sv : danhsachsinhvien ){
                                                if(sv.getId() == sinhvien.getId()){
                                                    SinhVien_DAO.getInstance().update(sinhvien);
                                                }
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            menuTypeOfUpdateSV();
                                            System.out.print("Moi ban chon lua chon : ");
                                            select = scanner.nextInt();
                                            scanner.nextLine();
                                            switch (select){
                                                case 1 :{
                                                    String condition = "ten=?";
                                                    System.out.println("Nhap thong tin cap nhat cua sinh vien : ");
                                                    System.out.println("Mssv : ");
                                                    long mssv = scanner.nextLong();
                                                    scanner.nextLine();
                                                    System.out.print("Ten sinh vien thay doi : ");
                                                    String name = scanner.nextLine();

                                                    sinhvien.setName(name);


                                                    danhsachsinhvien =  SinhVien_DAO.getInstance().selectAll();;
                                                    for(Sinhvien sv : danhsachsinhvien ){
                                                        if(sv.getId() == sinhvien.getId()){
                                                            SinhVien_DAO.getInstance().updateByCondition(sinhvien,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2 :{
                                                    String condition = "ngaysinh=?";
                                                    System.out.println("Nhap thong tin cap nhat cua sinh vien : ");
                                                    System.out.println("Mssv : ");
                                                    long mssv = scanner.nextLong();

                                                    System.out.print(" Ngay sinh  : ");
                                                    int day = scanner.nextInt();
                                                    int month = scanner.nextInt();
                                                    int year = scanner.nextInt();
                                                    Date dob = new Date(year,month,day);
                                                    sinhvien.setDob(dob);


                                                    danhsachsinhvien =  SinhVien_DAO.getInstance().selectAll();;
                                                    for(Sinhvien sv : danhsachsinhvien ){
                                                        if(sv.getId() == sinhvien.getId()){
                                                            SinhVien_DAO.getInstance().updateByCondition(sinhvien,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 3 :{
                                                    String condition = "phai=?";
                                                    System.out.println("Nhap thong tin cap nhat cua sinh vien : ");
                                                    System.out.println("Mssv : ");
                                                    long mssv = scanner.nextLong();

                                                    System.out.print(" Phai  : ");
                                                    String phai = scanner.nextLine();
                                                    sinhvien.setGender(phai);


                                                    danhsachsinhvien =  SinhVien_DAO.getInstance().selectAll();;
                                                    for(Sinhvien sv : danhsachsinhvien ){
                                                        if(sv.getId() == sinhvien.getId()){
                                                            SinhVien_DAO.getInstance().updateByCondition(sinhvien,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 4 :{
                                                    String condition = "malop=?";
                                                    System.out.println("Nhap thong tin cap nhat cua sinh vien : ");
                                                    System.out.println("Mssv : ");
                                                    long mssv = scanner.nextLong();

                                                    System.out.print(" malop  : ");
                                                    String malop = scanner.nextLine();
                                                    sinhvien.setId_lop(malop);

                                                    danhsachsinhvien =  SinhVien_DAO.getInstance().selectAll();;
                                                    for(Sinhvien sv : danhsachsinhvien ){
                                                        if(sv.getId() == sinhvien.getId()){
                                                            SinhVien_DAO.getInstance().updateByCondition(sinhvien,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 5 :{
                                                    System.exit(0);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        case 3:{
                                            System.exit(0);
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 4 :{
                                    SinhVien_DAO.getInstance().printData();
                                    break;
                                }
                                case 5 :{
                                    System.exit(0);
                                    break;
                                }
                            }
                            break;
                        }
                        // Chinh sua Lop
                        case 2 : {
                            menuEditLop();
                            System.out.print("Moi ban chon lua chon : ");
                            select = scanner.nextInt();
                            scanner.nextLine();
                            switch (select){
                                case 1 : {
                                    menuOfCaseOne();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (select){
                                        case 1 : {
                                            quanlySinhVien.insertLop("P:\\Dev\\Source\\Java\\JDBC\\QuanLySinhVien_JDBC\\src\\com\\edu\\file\\files\\danhsachlop.txt");
                                            danhsachlop = quanlySinhVien.getDanhSach_Lop();
                                            for(Lop lop : danhsachlop){
                                                Lop_DAO.getInstance().insert(lop);
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            System.out.print("Filepath : ");
                                            String filePath = scanner.nextLine();
                                            quanlySinhVien.insertLop(filePath);

                                            danhsachlop = quanlySinhVien.getDanhSach_Lop();
                                            for(Lop lop : danhsachlop){
                                                Lop_DAO.getInstance().insert(lop);
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2 : {
                                    System.out.print(" Ma lop : ");
                                    String malop_remove = scanner.nextLine();
                                    danhsachlop = Lop_DAO.getInstance().selectAll();
                                    for(int i = 0 ; i < danhsachlop.size() ;  i++){
                                        if(danhsachlop.get(i).getId().equals(malop_remove)){

                                            Lop_DAO.getInstance().remove(danhsachlop.get(i));

                                        }
                                    }
                                    break;
                                }
                                case 3 : {
                                    menuUpdate();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch(select){
                                        case 1 : {
                                            System.out.print("Ma lop can cap nhat : ");
                                            String malop_capnhat = scanner.nextLine();
                                            System.out.print("Ten lop : ");
                                            String tenlop = scanner.nextLine();
                                            System.out.print("Siso : ");
                                            int numbers = scanner.nextInt();

                                            Lop lop = new Lop(malop_capnhat,tenlop,numbers);
                                            danhsachlop = Lop_DAO.getInstance().selectAll();

                                            for(Lop lp : danhsachlop){
                                                if(lp.getId().equals(malop_capnhat)){
                                                    Lop_DAO.getInstance().update(lop);
                                                }
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            menuTypeOfUpdateLop();
                                            System.out.print("Moi ban chon lua chon : ");
                                            select = scanner.nextInt();
                                            scanner.nextLine();
                                            switch(select){
                                                case 1 : {
                                                    String condition = "tenlop=?";
                                                    System.out.print("Ma lop can cap nhat : ");
                                                    String malop_capnhat = scanner.nextLine();
                                                    System.out.print("Ten lop : ");
                                                    String tenlop = scanner.nextLine();

                                                    Lop lop = new Lop();
                                                    lop.setName(tenlop);

                                                    danhsachlop = Lop_DAO.getInstance().selectAll();

                                                    for(Lop lp : danhsachlop){
                                                        if(lp.getId().equals(malop_capnhat)){
                                                            Lop_DAO.getInstance().updateByCondition(lop,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                                case 2 : {
                                                    String condition = "siso=?";
                                                    System.out.print("Ma lop can cap nhat : ");
                                                    String malop_capnhat = scanner.nextLine();
                                                    System.out.print("Ten lop : ");
                                                    int numbers = scanner.nextInt();

                                                    Lop lop = new Lop();
                                                    lop.setNumbers(numbers);

                                                    danhsachlop = Lop_DAO.getInstance().selectAll();

                                                    for(Lop lp : danhsachlop){
                                                        if(lp.getId().equals(malop_capnhat)){
                                                            Lop_DAO.getInstance().updateByCondition(lop,condition);
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 4 : {
                                    Lop_DAO.getInstance().printData();
                                    break;
                                }
                                case 5 : {
                                    System.exit(0);
                                    break;
                                }
                            }
                            break;
                        }
                        // chinh sua mon hoc
                        case 3 : {
                            menuEditMonHoc();
                            System.out.print("Moi ban chon lua chon : ");
                            select = scanner.nextInt();
                            scanner.nextLine();
                            switch (select){
                                case 1 : {
                                    menuOfCaseOne();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (select){
                                        case 1 : {
                                            quanlySinhVien.insertMonhoc("P:\\Dev\\Source\\Java\\JDBC\\QuanLySinhVien_JDBC\\src\\com\\edu\\file\\files\\danhsachmonhoc.txt");
                                            danhsachmonhoc = quanlySinhVien.getDanhSach_Monhoc();
                                            for(Monhoc monhoc : danhsachmonhoc){
                                                Monhoc_DAO.getInstance().insert(monhoc);
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            System.out.print("Filepath : ");
                                            String filePath = scanner.nextLine();
                                            quanlySinhVien.insertMonhoc(filePath);

                                            danhsachmonhoc = quanlySinhVien.getDanhSach_Monhoc();
                                            for(Monhoc monhoc : danhsachmonhoc){
                                                Monhoc_DAO.getInstance().insert(monhoc);
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2 : {
                                    System.out.print("Nhap id cua mon hoc can xoa : ");
                                    String id_remove = scanner.nextLine();
                                    Monhoc monhoc_remove = new Monhoc();
                                    monhoc_remove.setId(id_remove);
                                    Monhoc delete = Monhoc_DAO.getInstance().selectById(monhoc_remove);
                                    Monhoc_DAO.getInstance().remove(delete);
                                    break;
                                }
                                case 3 : {
                                    System.out.print("Nhap id cua mon hoc ban can update : ");
                                    String id_update = scanner.nextLine();
                                    Monhoc monhoc_update = new Monhoc();
                                    monhoc_update.setId(id_update);
                                    Monhoc update = Monhoc_DAO.getInstance().selectById(monhoc_update);
                                    if(update == null){
                                        System.out.println("Mon hoc khong ton tai");
                                    }else{
                                        Monhoc_DAO.getInstance().update(update);
                                    }
                                    break;
                                }
                                case 4 : {
                                    Monhoc_DAO.getInstance().printData();
                                    break;
                                }
                                case 5 : {
                                    System.exit(0);
                                    break;
                                }
                            }
                            break;
                        }
                        // chinh sua diem
                        case 4 : {
                            menuEditDiem();
                            System.out.print("Moi ban chon lua chon : ");
                            select = scanner.nextInt();
                            scanner.nextLine();
                            switch (select){
                                case 1 : {
                                    menuOfCaseOne();
                                    System.out.print("Moi ban chon lua chon : ");
                                    select = scanner.nextInt();
                                    scanner.nextLine();
                                    switch (select){
                                        case 1 : {
                                            quanlySinhVien.insertDiemSv("P:\\Dev\\Source\\Java\\JDBC\\QuanLySinhVien_JDBC\\src\\com\\edu\\file\\files\\danhsachdiemsv.txt");
                                            danhsachdiemsv = quanlySinhVien.getDanhSach_Diemsv();
                                            for(Diemsv diemsv : danhsachdiemsv){
                                                Diemsv_DAO.getInstance().insert(diemsv);
                                            }
                                            break;
                                        }
                                        case 2 : {
                                            System.out.print("Filepath : ");
                                            String filePath = scanner.nextLine();
                                            quanlySinhVien.insertDiemSv(filePath);

                                            danhsachdiemsv = quanlySinhVien.getDanhSach_Diemsv();
                                            for(Diemsv diemsv : danhsachdiemsv){
                                                Diemsv_DAO.getInstance().insert(diemsv);
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2 : {
                                    System.out.print("Nhap mssv cua sinh vien can xoa : ");
                                    long mssv_remove = scanner.nextLong();
                                    System.out.print("Nhap mon hoc cua sinh vien "+mssv_remove+" can xoa : " );
                                    String mamh_remove = scanner.nextLine();

                                    danhsachdiemsv = Diemsv_DAO.getInstance().selectAll();
                                    for(Diemsv diemsv :danhsachdiemsv){
                                        if(diemsv.getId_sinhvien() == mssv_remove && diemsv.getId_monhon().equals(mamh_remove)){
                                            Diemsv_DAO.getInstance().remove(diemsv);
                                            System.out.println("Remove complete!");
                                        }else{
                                            System.out.println("Khong co sinh vien nao !");
                                            System.out.println("Remove failure ");
                                        }
                                    }
                                    break;
                                }
                                case 3 : {
                                    System.out.print("Nhap mssv : ");
                                    long mssv_update = scanner.nextLong();
                                    System.out.print("Nhap id cua mon hoc ban can update : ");
                                    String id_update = scanner.nextLine();
                                    Diemsv diemsv_update = new Diemsv();
                                    diemsv_update.setId_sinhvien(mssv_update);
                                    diemsv_update.setId_monhon(id_update);
                                    Diemsv update = Diemsv_DAO.getInstance().selectById(diemsv_update);
                                    if(update == null){
                                        System.out.println("khong ton tai");
                                    }else{
                                        Diemsv_DAO.getInstance().update(update);
                                    }
                                    break;
                                }
                                case 4 : {
                                    Diemsv_DAO.getInstance().printData();
                                    break;
                                }
                                case 5 : {
                                    System.exit(0);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
                // Tim kiem
                case 2 : {

                    break;
                }
                // Tong hop
                case 3 : {
                    break;
                }
            }
        } while (true);
    }
}