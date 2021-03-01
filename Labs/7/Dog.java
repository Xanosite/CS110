// Blake Hershberger
// 28-Feb-2021
// Dog

public class Dog {
  // fields
  Double heightIn;
  int ageYears;
  String name;
  Boolean likesBarking;

  // setters
  public void setHeight(double height) {
    heightIn = height;
  }
  public void setAge(int age) {
    ageYears = age;
  }
  public void setName(String newName) {
    name = newName;
  }
  public void setLikesBarking(Boolean barks) {
    likesBarking = barks;
  }

  // getters
  public Double getHeight() {
    return heightIn;
  }
  public int getAge() {
    return ageYears;
  }
  public String getName() {
    return name;
  }
  public Boolean getLikesBarking() {
    return likesBarking;
  }
}
