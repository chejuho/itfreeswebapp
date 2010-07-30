package board;

public class User {
  private String userId;
  private String name;
  public User() {}

  public User(String userId,String name) {
    this.userId = userId;
	this.name = name;
  }		

  public String getUserId() {
    return userId;
  } 

  public String getName() {
    return name;
  }

  public String toString() {
    return userId;
  } 
}