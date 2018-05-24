/* Database Utility file */
import data.db.*

public class DBUtil extends DAO implements DataStore {

  DataProcess dataProcess = new DataProcess(this);
  
  public static boolean checkRegistered(String uname, String pass){
    return dataProcess.performRead(uname, "username", pass, "password");
  }
  
  public static String checkETHAdress(String uname, String pass){
    return dataProcess.getAddress(uname, pass);
  }
  
  public static boolean isWhiteListed(String address){
    return dataProcess.isWhiteListed(address);
  }
  
  public static void insertIntoDB(uname, pass, address){
    dataProcess.performAdd(uname, "username", pass, "password", address, "ETHaddress");
  }

}
