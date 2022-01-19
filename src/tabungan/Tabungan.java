
package tabungan;
/**
 *
 * @author Ochii
 */
public class Tabungan {
    private double saldo;
    public Tabungan(double saldoAwal){
        this.saldo=saldoAwal;
    }
    public void setSaldo(double saldo){
        this.saldo=saldo;
    }
    public double getSaldo(){
       return this.saldo;
    }
    public boolean transfer(int noRekTujuan,double jumlah){  
       boolean flag=false;
       //mencari noRekening tujuan
       if(Nasabah.cekRekening(noRekTujuan)==true){
           if(saldo>jumlah){
               setSaldo(saldo-jumlah);
               for(int i=0; i<Akun.totalUser();i++){
                   if(Akun.akun.get(i).getNoRekening()==noRekTujuan){
                       Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getTabungan().getSaldo()+jumlah);
                       try{
                            Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getKartuATM().getSaldo()+jumlah);
                       }catch(NullPointerException e){
                           System.out.println("maaf noRekening ini tidak memiliki kartu atm");
                       }
                   }
               }
               flag=true;
           }else{
               System.out.println("Maaf saldo tidak cukup");
           }
       }else{
           System.out.println("Rekening tujuan tidak ditemukan");
       }
       return flag;
    }
    public boolean ambilUang(double jumlah){
        boolean flag=false;
        if(getSaldo()>jumlah){
            setSaldo(getSaldo()-jumlah);
            flag=true;
        }
        return flag;
    }
    public void simpanUang(double jumlah){
        setSaldo(getSaldo()+jumlah);
    }
    
}
