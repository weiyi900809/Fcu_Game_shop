package demo2.model;

public class account {

    private int account_ID = 1 ;
    private String user_name;
    private String user_password;

    public account(int account_ID, String user_name, String user_password) {
        this.account_ID = account_ID;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public account(){

    }
    public int getID() {
        return account_ID;
    }
    public void setID(int ID) {
        this.account_ID = ID;
    }

    public String getUName() {
        return user_name;
    }
    public void setUName(String name) {
        this.user_name = name;
    }

    public String getPassword() {return user_password;}
    public void setPassword(String password) {this.user_password = password;}

}
