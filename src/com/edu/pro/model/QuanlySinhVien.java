package com.edu.pro.model;

import com.edu.pro.DAO.SinhVien_DAO;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ListIterator;

public class QuanlySinhVien  {
    private ArrayList<Sinhvien> danhSach_Sinhvien = new ArrayList<Sinhvien>();
    private ArrayList<Lop> danhSach_Lop = new ArrayList<Lop>();
    private ArrayList<Monhoc> danhSach_Monhoc = new ArrayList<Monhoc>();
    private ArrayList<Diemsv> danhSach_Diemsv = new ArrayList<Diemsv>();
    private String nameFile;


    public QuanlySinhVien(ArrayList<Sinhvien> danhSach_Sinhvien, ArrayList<Lop> danhSach_Lop,
                          ArrayList<Monhoc> danhSach_Monhoc, ArrayList<Diemsv> danhSach_Diemsv, String nameFile) {

        this.danhSach_Sinhvien = danhSach_Sinhvien;
        this.danhSach_Lop = danhSach_Lop;
        this.danhSach_Monhoc = danhSach_Monhoc;
        this.danhSach_Diemsv = danhSach_Diemsv;
        this.nameFile = nameFile;
    }

    public QuanlySinhVien(ArrayList<Sinhvien> danhSach_SinhVien ){
        this.danhSach_Sinhvien = danhSach_SinhVien;
    }

    public QuanlySinhVien(){
        this.danhSach_Sinhvien = null;
    }

    public ArrayList<Sinhvien> getDanhSach_Sinhvien() {
        return danhSach_Sinhvien;
    }

    public void setDanhSach_Sinhvien(ArrayList<Sinhvien> danhSach_Sinhvien) {
        this.danhSach_Sinhvien = danhSach_Sinhvien;
    }

    public ArrayList<Lop> getDanhSach_Lop() {
        return danhSach_Lop;
    }

    public void setDanhSach_Lop(ArrayList<Lop> danhSach_Lop) {
        this.danhSach_Lop = danhSach_Lop;
    }

    public ArrayList<Monhoc> getDanhSach_Monhoc() {
        return danhSach_Monhoc;
    }

    public void setDanhSach_Monhoc(ArrayList<Monhoc> danhSach_Monhoc) {
        this.danhSach_Monhoc = danhSach_Monhoc;
    }

    public ArrayList<Diemsv> getDanhSach_Diemsv() {
        return danhSach_Diemsv;
    }

    public void setDanhSach_Diemsv(ArrayList<Diemsv> danhSach_Diemsv) {
        this.danhSach_Diemsv = danhSach_Diemsv;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }


    //             SINH VIEN
    // Insert - remove - update
    public ArrayList<Sinhvien> insertSV(String filePath){

        ArrayList<String> dataInFile = loadFile(filePath);

        for(String data : dataInFile ){
            String[] information =  data.split(",");

            String[] date = information[2].split("-");
            int day = Integer.parseInt(date[2]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[0]);

            Date dob = new Date(year-1900,month-1,day);

            this.danhSach_Sinhvien.add( new Sinhvien(Long.parseLong(information[0]),information[1],dob,information[3],information[4]));
        }
        return this.danhSach_Sinhvien;
    }
    public void remove(Sinhvien sinhvien){
        this.danhSach_Sinhvien.remove(sinhvien);
    }
    public void update(Sinhvien sinhvien){
        for(Sinhvien sv : this.danhSach_Sinhvien){
            if(sv.getId() == sinhvien.getId()){
                sv.setName(sinhvien.getName());
                sv.setDob(sinhvien.getDob());
                sv.setGender(sinhvien.isGender());
                sv.setId_lop(sinhvien.getId_lop());

                SinhVien_DAO.getInstance().update(sinhvien);
            }
        }
    }


    // check - find
    public boolean checkExists(Sinhvien sinhvien){
        if(!this.danhSach_Sinhvien.contains(sinhvien))
            return false;
        return true;
    }
    public ArrayList<Sinhvien> findByGender(String isGender){
        ArrayList<Sinhvien> res = new ArrayList<Sinhvien>();
        for(Sinhvien sv : danhSach_Sinhvien ){
            if(sv.isGender().equals(isGender)){
                long id = sv.getId();
                String name = sv.getName();
                String gender = sv.isGender();
                Date date = sv.getDob();
                String id_lop = sv.getId_lop();

                Sinhvien sinhvien = new Sinhvien(id,name,date,gender,id_lop);

                res.add(sinhvien);
            }
        }
        return res;
    }

    //                LOP
    // insert - update  - remove
    public ArrayList<Lop> insertLop(String filePath){

        ArrayList<String> dataInFile = loadFile(filePath);

        for(String data : dataInFile ){
            String[] information =  data.split(",");
            this.danhSach_Lop.add(new Lop(information[0],information[1],Integer.parseInt(information[2])));
        }

        return this.danhSach_Lop;
    }

    public void update(Lop lop){
        for(Lop lp : this.danhSach_Lop){
            if(lp.getId().equals(lop.getId())){
                lp.setName(lop.getName());
                lp.setNumbers(lop.getNumbers());
            }
        }
    }
    public void remove(Lop lop){
        this.danhSach_Lop.remove(lop);
    }


    //               Mon Hoc
    // insert -update - remove

    public ArrayList<Monhoc> insertMonhoc(String filePath){

        ArrayList<String> dataInFile = loadFile(filePath);

        for(String data : dataInFile ){
            String[] information =  data.split(",");
            this.danhSach_Monhoc.add(new Monhoc(information[0],information[1]));
        }

        return this.danhSach_Monhoc;
    }

    public void update(Monhoc monhoc){
        for(Monhoc mh : this.danhSach_Monhoc){
            if(mh.getId().equals(monhoc.getId())) {
                mh.setName(monhoc.getName());
            }
        }
    }
    public void remove(Monhoc monhoc){
        this.danhSach_Lop.remove(monhoc);
    }

    // insert - remove - update (Diem sinh vien)
    public ArrayList<Diemsv> insertDiemSv(String filePath){
        ArrayList<String> dataInFile = loadFile(filePath);

        for(String data : dataInFile ){
            String[] information =  data.split(",");
            this.danhSach_Diemsv.add(new Diemsv(Long.parseLong(information[0]),information[1],Float.parseFloat(information[2])));
        }

        return this.danhSach_Diemsv;
    }

    public void remove(Diemsv diemsv){
        this.danhSach_Diemsv.remove(diemsv);
    }

    public void update(Diemsv diemsv){
        for(Diemsv diem : this.danhSach_Diemsv){
            if(diem.getId_sinhvien() == diemsv.getId_sinhvien()){
                diem.setId_monhon(diemsv.getId_monhon());
                diem.setScore(diemsv.getScore());
            }
        }
    }

    // load files (sinhvien - lop - monhoc - diem)
    public ArrayList<String>  loadFile(String filePath){
        String data = "";
        ArrayList<String> list = new ArrayList<>();

        try{
            FileReader reader = new FileReader(filePath);
            BufferedReader buff = new BufferedReader(reader);

            while((data = buff.readLine()) != null){
                list.add(data);
            }

            reader.close();
            buff.close();

        }catch( Exception e){
            e.printStackTrace();
        }
        return list;
    }


}
