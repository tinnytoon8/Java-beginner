import java.util.Scanner;

public class Account {
    private double saldo;
    private String pemilikRekening;
    protected Scanner sc = new Scanner(System.in);

    // Constructor Account untuk menampung jumalah saldo dan pemilik rekening
    public Account(double saldo, String pemilikRekening) {
        this.saldo = saldo;
        this.pemilikRekening = pemilikRekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo tidak boleh di bawah 0");
        }
    }

    public String getPemilikRekening() {
        return pemilikRekening;
    }

    public void setPemilikRekening(String pemilikRekening) {
        this.pemilikRekening = pemilikRekening;
    }

    public void cekSaldo() {
        System.out.println("Pemilik Rekening " + pemilikRekening);
        System.out.println("Saldo Anda: Rp." + saldo + ",-");
    }
}
