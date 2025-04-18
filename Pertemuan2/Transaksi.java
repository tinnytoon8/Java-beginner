public class Transaksi extends Account implements Bank {
    public Transaksi(double saldo, String pemilikRekening) {
        super(saldo, pemilikRekening);
    }

    public void menabung(double tb) {
        if (tb > 0) {
            setSaldo(getSaldo() + tb);
            System.out.println("Deposit berhasil: Rp." + tb + ",-");
        } else {
            System.out.println("Jumlah deposit harus lebih dari 0");
        }
    }

    public void menabung(double tb, String sumberDana) {
        if (tb > 0) {
            setSaldo(getSaldo() + tb);
            System.out.println("Deposit berhasil: Rp." + tb + ",-" + " dari " + sumberDana + " berhasil.");
        } else {
            System.out.println("Jumlah deposit harus lebih dari 0");
        }
    }

    public void transfer() {
        System.out.print("Rekening Tujuan: ");
        int rekeningTujuan = sc.nextInt();
        System.out.print("Nominal Transfer: Rp.");
        double nominalTF = sc.nextDouble();

        if (nominalTF > 0 && nominalTF <= getSaldo()) {
            setSaldo(getSaldo() - nominalTF);
            System.out.println("Transfer Berhasil!\nSaldo Anda: Rp." + getSaldo() + ",-");
        } else {
            System.out.println("Saldo Tidak cukup atau jumlah tidak valid!");
        }
    }

    public void menarik() {
        System.out.print("Jumlah uang yang ingin ditarik: Rp.");
        double tarik = sc.nextDouble();

        if (tarik > 0 && tarik <= getSaldo()) {
            setSaldo(getSaldo() - tarik);
        } else {
            System.out.println("Penarikan dana gagal! Saldo tidak cukup atau jumlah tidak valid!");
        }
    }
}
