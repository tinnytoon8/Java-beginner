package Alternaltif;

import java.util.Scanner;

class Mahasiswa {
    private String nama;
    private int uts;
    private int uas;
    private float rataRata;
    private String status;

    public Mahasiswa(String nama, int uts, int uas) {
        this.nama = nama;
        this.uts = uts;
        this.uas = uas;
        this.rataRata = hitungRataRata();
        this.status = tentukanStatus();
    }

    private float hitungRataRata() {
        return (uts + uas) / 2.0f;
    }

    private String tentukanStatus() {
        return rataRata >= 70 ? "Lulus" : "Tidak Lulus";
    }

    public void tampilkanData() {
        System.out.println("===============================");
        System.out.println("Nama Kamu       : " + nama);
        System.out.println("Nilai UTS Kamu  : " + uts);
        System.out.println("Nilai UAS Kamu  : " + uas);
        System.out.printf("Nilai Rata-Rata : %.1f\n", rataRata);
        System.out.println("Status Kamu     : " + status);
    }
}

public class DataMahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Masukkan Nama: ");
            String nama = sc.next();
            System.out.print("Masukkan Nilai UTS: ");
            int uts = sc.nextInt();
            System.out.print("Masukkan Nilai UAS: ");
            int uas = sc.nextInt();

            Mahasiswa mhs = new Mahasiswa(nama, uts, uas);
            mhs.tampilkanData();

            System.out.print("Apakah ingin mengulang? (y/n): ");
            char ulang = sc.next().charAt(0);

            if (ulang == 'n' || ulang == 'N') {
                System.out.println("Terima kasih!");
                break;
            }
        }
    }
}
