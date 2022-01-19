
package tabungan;
/**
 *
 * @author Ochii
 */
public class User {
    private String nama;
    private String alamat;
    private String noTelpon;
    
    public User(){ 
    }
    public User(String nama,String alamat,String noTelpon){
        this.nama=nama;
        this.alamat=alamat;
        this.noTelpon=noTelpon;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    public void setNoTelpon(String noTelpon){
        this.noTelpon=noTelpon;
    }
    public String getNama(){
        return this.nama;
    }
    public String getAlamat(){
        return this.alamat;
    }
    public String getNoTelpon(){
        return this.noTelpon;
    }
}
