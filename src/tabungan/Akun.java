package tabungan;
/**
 *
 * @author Ochii
 */
import java.util.*;

public class Akun {
    public static  ArrayList<Nasabah> akun=new ArrayList();
    //public static HashMap<Integer, Nasabah> akun = new HashMap();
    public Akun(){
        buatAkunBawaan();
    }
    private static void buatAkunBawaan(){
         akun.add(new Nasabah("Hasnaa","Kediri","0857088XXX","hasnaa",112233,15000000,"silver"));//0
         akun.add(new Nasabah("Rosyii","Surabaya","085708899","rosyii",112244,15000000,"gold"));//1
         akun.add(new Nasabah("Laily","Jakarta","0857665544","laily",112255,15000000,"platinum"));//2
         akun.add(new Nasabah("Umar","Bogor","98725352","umar",112266,15000000,"silver"));//3
    }
    public static void buatAkun(Nasabah nasabah){
        akun.add(nasabah);
    }
    public static int totalUser(){
        return akun.size();
    }
    public static boolean cekAkun(String username,String password){
         boolean flag=false;
         for(int i=0; i < Akun.akun.size();i++){
             try{
                 if(Akun.akun.get(i).getKartuATM().getPin().equals(password)&&Akun.akun.get(i).getNama().equals(username))
                 flag=true;
             }catch(NullPointerException e){
                 flag=false;
             }
         }
         System.out.println(flag);
         return flag;
    }
    public static void main(String args[]){
        buatAkunBawaan();
        System.out.println(akun.isEmpty());
        akun.forEach(akun -> {
            System.out.println("Name : " + akun.getNama() + ", Pin: " + akun.getKartuATM().getPin());
        });
    }
}
