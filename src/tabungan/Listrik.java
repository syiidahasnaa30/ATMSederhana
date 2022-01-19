
package tabungan;
import java.util.*;
/**
 *
 * @author Ochii
 */
public class Listrik extends Pembayaran{
    public static HashMap pelanggan= new HashMap();
    public Listrik() {
        dataPelanggan();
    }
    public static void dataPelanggan(){
        pelanggan.put("887711",300000.0);
        pelanggan.put("887722",200000.0);
        pelanggan.put("887733",250000.0);
    }
    @Override
    public double getJumlah(){
        double total;
        total=(double)pelanggan.get(super.noPelanggan);
        return total;
    }
}
