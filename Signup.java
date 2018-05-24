/* This file process the user registration and store
 * thier username and password with their hydrogen/ethereum
 * address. It also whitelist using the whitelist method in Hydrogen class
 *  and stored 'hydro_address_id' in the database. 
 */
 
 public class Signup {
  
  // Process login method
  public boolean process(String username, String password, String address){
    
    boolean available = checkUserDB(username, password);
    
    if(!available){
      boolean whitelisted = isWhiteListed(address);

      if(!whitelisted){
        whitelistAddress(address);
      }
      
      insertIntoDB(username, password, address);
      
      return true;
    }else{
      return false;
    }
  }
  
  // Method checkUserDB
  private boolean checkUserDB(string uname, String pass){
    return DBUtil.checkRegistered(uname, pass);
  }
  
  // Method insertIntoDB
  private void insertIntoDB(string uname, String pass, String address){
    DBUtil.insertIntoDB(uname, pass, address);
  }
  
  // Method to check if address is whitelisted
  private boolean isWhiteListed(string address){
    return DBUtil.isWhiteListed(address);
  }
  
  // Method to whitelist address
  private void whitelistAddress(string address){
    HydrogenAPI.whiteList(address);
  }
  
 }
