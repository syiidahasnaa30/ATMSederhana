package tabungan;

/**
 *
 * @author Ochii
 */
public class KartuATM extends Tabungan{
    private String pin;
    private String jenis;
    
    /**jenisny ada 3 :
     * Silver : max penarikan : 1 jt
     * Silver : max transfer : 5 jt
     * Gold : max penarikan : 3 jt
     * Gold : max transfer : 10jt
     * Platinum : max penarikan : 5jt
     * Platinum max transfer : 10 jt
     * @param saldoAwal
     * @param jenis
     * @param pin
     */
    public KartuATM(double saldoAwal,String jenis,String pin){
         super(saldoAwal);
         this.jenis=jenis;
         this.pin=pin;
    }
    public void setJenis(String jenis){
        this.jenis=jenis;
    }
    public String getJenis(){
        return this.jenis;
    }
    public void setPin(String pin){
        this.pin=pin;
    }
    public String getPin(){
        return this.pin;
    }
    @Override
    public boolean ambilUang(double jumlah){
        boolean cek=false;
        switch (this.jenis) {
            case "silver":
                if(jumlah< getSaldo() && jumlah <= 1000000){
                    setSaldo(getSaldo()-jumlah);
                    cek=true;
                }else{
                    System.out.println("Maaf kartu anda bertipe siver hanya mampu melakukan pengambilan maksimal 1 juta");
                }   break;
            case "gold":
                if(jumlah< getSaldo() && jumlah <= 3000000){
                    setSaldo(getSaldo()-jumlah);
                    cek=true;
                }else{
                    System.out.println("Maaf kartu anda bertipe Gold hanya mampu melakukan pengambilan maksimal 3 juta");
                }   break;
            default:
                if(jumlah< getSaldo() && jumlah <= 5000000){
                    setSaldo(getSaldo()-jumlah);
                    cek=true;
                }else{
                    System.out.println("Maaf kartu anda bertipe platinum hanya mampu melakukan pengambilan maksimal 5 juta");
                }   break;
        }
        return cek;
    }
    @Override
    public boolean transfer(int noRekTujuan, double jumlah){
        boolean cek=false;
        //mencari noRekening tujuan
       if(Nasabah.cekRekening(noRekTujuan)==true){
            switch (this.jenis) {
                case "siver":
                    if(getSaldo()>jumlah && jumlah<=5000000){
                        setSaldo(getSaldo()-jumlah);
                        for(int i=0; i<Akun.totalUser();i++){
                            if(Akun.akun.get(i).getNoRekening()==noRekTujuan){
                                Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getTabungan().getSaldo()+jumlah);
                                try{
                                    Akun.akun.get(i).getKartuATM().setSaldo(Akun.akun.get(i).getKartuATM().getSaldo()+jumlah);
                                }catch(NullPointerException e){
                                    System.out.println("Kartu tujuan tidak memilki ATM");
                                }
                            }
                        }
                        cek=true;
                    }else{
                        System.out.println("Maaf saldo tidak cukup atau atm anda hanya mampu transfer maksimal 5 jt");
                    }   break;
                case "gold":
                    if(getSaldo()>jumlah && jumlah<=10000000){
                        setSaldo(getSaldo()-jumlah);
                        for(int i=0; i<Akun.totalUser();i++){
                            if(Akun.akun.get(i).getNoRekening()==noRekTujuan){
                                Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getTabungan().getSaldo()+jumlah);
                                try{
                                    Akun.akun.get(i).getKartuATM().setSaldo(Akun.akun.get(i).getKartuATM().getSaldo()+jumlah);
                                }catch(NullPointerException e){
                                    System.out.println("Kartu tujuan tidak memilki ATM");
                                }
                            }
                        }
                        cek=true;
                    }else{
                        System.out.println("Maaf saldo tidak cukup atau atm anda hanya mampu transfer maksimal 5 jt");
                    }   break;
                default:
                    if(getSaldo()>jumlah && jumlah<=10000000){
                        setSaldo(getSaldo()-jumlah);
                        for(int i=0; i<Akun.totalUser();i++){
                            if(Akun.akun.get(i).getNoRekening()==noRekTujuan){
                                Akun.akun.get(i).getTabungan().setSaldo(Akun.akun.get(i).getTabungan().getSaldo()+jumlah);
                                try{
                                    Akun.akun.get(i).getKartuATM().setSaldo(Akun.akun.get(i).getKartuATM().getSaldo()+jumlah);
                                }catch(NullPointerException e){
                                    System.out.println("Kartu tujuan tidak memilki ATM");
                                }
                            }
                        }
                        cek=true;
                    }else{
                        System.out.println("Maaf saldo tidak cukup atau atm anda hanya mampu transfer maksimal 10 jt");
                    }   break;
            }
       }else{
           System.out.println("Rekening tujuan tidak ditemukan");
       }
        return cek;
    }
    
}
