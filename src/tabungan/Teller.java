
package tabungan;

import java.util.*;
/**
 * @author Ochii
 */
public class Teller extends User{
    private int noPegawai;
    private String pin;
    
    public static ArrayList<Teller> teller = new ArrayList();
    
    public Teller(){
        akunTeller();
    }
    public Teller(String nama, String alamat, String noTelpon, int noPegawai, String pin){
        super(nama,alamat,noTelpon);
        this.noPegawai=noPegawai;
        this.pin=pin;
    }
    public static void akunTeller(){
        teller.add(new Teller("Nana","Surabaya","82372326",111111,"nana"));
        teller.add(new Teller("Dodo","Bogor","2382728",222222,"dodo"));
    }
    public int getNoPegawai(){
        return this.noPegawai;
    }
    public String getPin(){
        return this.pin;
    }
    public static int totalTeller(){
        return teller.size();
    }
    public static boolean loginTeller(String username, String pin){
        boolean cek=false;
        for(int i=0; i<teller.size(); i++){
            if(Teller.teller.get(i).getNama().equals(username) && Teller.teller.get(i).getPin().equals(pin)){
                cek=true;
            }
        }
        return cek;
    }
}
