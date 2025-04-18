public class Act1 {
    public static void main(String[] args) {
        System.out.println("Terjadi Kesalahan: Masukkan 2 angka sebagai argumen!");

        int angka1 = Integer.parseInt(args[0]);
        int angka2 = Integer.parseInt(args[1]);

        int hasil = angka1 / angka2;
        System.out.println("Hasil Pembagian: " + hasil);
    }

}