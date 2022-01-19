
package tabungan;
/**
 *
 * @author Ochii
 */
public class Nasabah extends User{
    private int noRekening;
    private Tabungan tabungan;
    private KartuATM kartu;
    //konstraktor Nasabah
    public Nasabah(){
        
    }
    public Nasabah(String nama, String alamat, String noTelpon,int noRek, double saldo){
        super(nama,alamat,noTelpon);
        this.noRekening=noRek;
        this.tabungan=new Tabungan(saldo);
        this.kartu=null;
    }
    public Nasabah(String nama,String alamat,String noTelpon,String password,int noRek,double saldo,String jenisKartu){
        super(nama,alamat,noTelpon);
        this.noRekening=noRek;
        this.tabungan=new Tabungan(saldo);
        this.kartu=new KartuATM(saldo,jenisKartu,password);
    }
    //mengatur no Rekening nasabah
    public void setNoRekening(int noRek){
        this.noRekening=noRek;
    }
    //mengembalikan nilai dari noRekening
    public int getNoRekening(){
        return this.noRekening;
    }
    public Tabungan getTabungan(){
        return this.tabungan;
    }
    public KartuATM getKartuATM(){
        return this.kartu;
    }
    public void setKartuATM(double saldoAwal,String jenis,String pin){
        this.kartu =new KartuATM(saldoAwal,jenis,pin);
    }
    public static boolean cekRekening(int noRekening){
        boolean flag=false;
        for(int i=0; i < Akun.akun.size();i++){
            if(noRekening == Akun.akun.get(i).getNoRekening())
                flag=true;
        }
        return flag;
    }
    
}
