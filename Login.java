/* This file process the user sign in
 * with ther username and password and 
 * check in database if their hydrogen/ethereum
 * address has been whitelisted and stored 'hydro_address_id'
 * otherwise call the whitelist method in Hydrogen class 
 */
 
 public class Login {
 
  private String username;
  private String password;
  private String address;
  
  // Process login method
  public boolean process(String username, String password){
    this.username = username;
    this.password = password;
    
    boolean credentials = checkUserDB(username, password);
    
    if(credentials){
      this.address = checkAddressDB(username, password);
      boolean whitelisted = isWhiteListed(this.address);

      if(!whitelisted){
        whitelistAddress(this.address);
      }
      return true;
    }else{
      return false;
    }
  }
  
  // Method checkUserDB
  private boolean checkUserDB(string uname, String pass){
    return DBUtil.checkRegistered(uname, pass);
  }
  
  // Method checkAddressDB
  private String checkUserDB(string uname, String pass){
    return DBUtil.checkETHAdress(uname, pass);
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
