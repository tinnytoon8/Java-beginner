package Alternaltif;

public class Lingkaran {
    // Atribut dengan access modifier private
    private double jariJari;

    // Constructor untuk inisialisasi jari-jari
    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    // Method untuk menghitung luas
    public double hitungLuas() {
        return 3.14 * jariJari * jariJari;
    }

    // Method untuk menampilkan informasi
    public void tampilkanLuas() {
        System.out.println("Jari-jari: " + jariJari);
        System.out.println("Luas lingkaran: " + hitungLuas());
    }

    // Method main untuk membuat objek dan menjalankan program
    public static void main(String[] args) {
        // Membuat objek Lingkaran dengan jari-jari 7
        Lingkaran lingkaran1 = new Lingkaran(7);
        lingkaran1.tampilkanLuas();

        // Contoh objek lain
        Lingkaran lingkaran2 = new Lingkaran(10);
        lingkaran2.tampilkanLuas();
    }
}
