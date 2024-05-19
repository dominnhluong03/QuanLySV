
package oop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachSV {
    private ArrayList<QuanLySV> danhSach;
    private Scanner sc;
    
    public DanhSachSV(){
       danhSach = new ArrayList<>();
       sc = new Scanner(System.in);
    }
    public void themSV(){
        System.out.println("Nhap thong tin sinh vien:");
        System.out.print("Ma SV: ");
        String maSV = sc.nextLine();
        System.out.print("Ho ten: ");
        String hoTen = sc.nextLine();
        System.out.print("Dia chi: ");
        String diaChi = sc.nextLine();
        System.out.print("Gioi tinh: ");
        String gioiTinh = sc.nextLine();
        System.out.print("Khoa: ");
        String Khoa = sc.nextLine();
        System.out.print("Que quan: ");
        String queQuan = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Diem 1: ");
        double diem1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Diem 2: ");
        double diem2 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Diem 3: ");
        double diem3 = sc.nextDouble();
        sc.nextLine();
        QuanLySV sv = new QuanLySV(maSV, hoTen, diaChi, gioiTinh, Khoa, queQuan, email, diem1, diem2, diem3);
        danhSach.add(sv);
    }
    public void tinhDiemTBDS(){
        double diemTBDS = 0;
        for (QuanLySV sv : danhSach){
            diemTBDS += sv.getDiemTb();
        }
        diemTBDS /= danhSach.size();
        System.out.println("Diem trung binh danh sach sinh vien: " + diemTBDS);
    }
    public void sapXepTTTTD(){
        Collections.sort(danhSach, (t1, t2) -> t1.getHoTen().compareToIgnoreCase(t2.getHoTen()));
        System.out.println("Danh sach sinh vien da duoc sap xep thoe thu tu tu dien.");
    }
    public void inDSKT(){
        System.out.println("Danh sach sinh vien khen thuong: ");
        for(QuanLySV sv : danhSach){
            if(sv.getDiemTb() > 8.0 && !sv.isCoDiemDuoi7()){
                sv.inTT();
            }
        }
    }
    private boolean isCoDiemDuoi7(QuanLySV sv){
        return sv.getDiem1() < 7 || sv.getDiem2() < 7 || sv.getDiem3() < 7;
    }
    public void sinhVienNamDiemCaoNhatKhoaDienTu(){
        QuanLySV sinhVienNamDiemCaoNhat = null;
        for (QuanLySV sv : danhSach){
            if(sv.getGioiTinh().equalsIgnoreCase("Nam") && sv.getKhoa().equalsIgnoreCase("Dien Tu")){
                if(sinhVienNamDiemCaoNhat == null || sinhVienNamDiemCaoNhat.getDiemTb() < sv.getDiemTb()){
                    sinhVienNamDiemCaoNhat = sv;
                }
            }
        }
        if(sinhVienNamDiemCaoNhat != null){
            System.out.println("Nam sinh vien co diem cao nhat khoa dien tu: ");
            sinhVienNamDiemCaoNhat.inTT();
        }else{
            System.out.println("ko co nam sinh vien nao! ");
        }
    }
    public void menu(){
        while (true){
            System.out.println("\n -- Menu quan ly sinh vien -- ");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Tinh diem trung binh ds");
            System.out.println("3. Sap xep theo thu tu tu dien");
            System.out.println("4. Danh sach khen thuong");
            System.out.println("5. Sinh vien nam diem cao nhat khoa dien tu");
            System.out.println("0. Thoat");
            
            System.out.println("Lua chon cua ban: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1:
                    themSV();
                    break;
                case 2:
                    tinhDiemTBDS();
                    break;
                case 3:
                    sapXepTTTTD();
                    break;
                case 4:
                    inDSKT();
                    break;
                case 5:
                   sinhVienNamDiemCaoNhatKhoaDienTu();
                   break;
                case 0:
                    System.out.println("Thoat chuong trinh!");
                    return;
                default:
                    System.out.println("Lua chon cua ban ko hop le! Vui long nhap lai.");
            }
        }
    }
}
