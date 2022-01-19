package tabungan;
/**
 *
 * @author Ochii
 */
public class Pembayaran {
    protected String  noPelanggan;
    protected double jumlah;
 
    public void setNoPelanggan(String noPelanggan){
        this.noPelanggan=noPelanggan;
    }
    public String getNoPelanggan(){
        return this.noPelanggan;
    }
    public void setJumlah(double jumlah){
        this.jumlah=jumlah;
    }
    public double getJumlah(){
        return this.jumlah;
    }
    public boolean bayar(int noRekening,String noPelangggan,double jumlah){
        boolean cek=false;
        //looping pada collection akun
        for(int i=0; i<Akun.totalUser(); i++){
            //mengecek akun yang akan berkurang saldonya
            if(Akun.akun.get(i).getNoRekening()==noRekening){
                //mengecek apakah akun tersebut saldonya masih cukup untuk melakukan transaksi
                if(Akun.akun.get(i).getKartuATM().getSaldo()>jumlah){
                    //mengurangi saldo pada akun terkait
                    Akun.akun.get(i).getKartuATM().setSaldo(Akun.akun.get(i).getKartuATM().getSaldo()-jumlah);
                    //mengurangi saldo pada tabungan
                    Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getTabungan().getSaldo()-jumlah);
                    cek=true;
                }
            }
        }
        return cek;
    }
}
