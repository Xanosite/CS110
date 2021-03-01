// Blake Hershberger
// 28-FEB-2021
// Dog stuff

public class DogKennel {
  public static void main(String[] args) {
    // greet user
    System.out.println("Welcome to the dog kennel");

    // make dogs
    Dog dog1 = new Dog();
    Dog dog2 = new Dog();
    Dog dog3 = new Dog();

    // populate dog fields
    dog1.setAge(8);
    dog1.setHeight(13.5);
    dog1.setName("Igor");
    dog1.setLikesBarking(true);

    dog2.setAge(5);
    dog2.setHeight(8.2);
    dog2.setName("Lev");
    dog2.setLikesBarking(false);

    dog3.setAge(6);
    dog3.setHeight(15.1);
    dog3.setName("Tatsie");
    dog3.setLikesBarking(true);

    // display cumulative age
    int cumAge = dog1.getAge() + dog2.getAge() + dog3.getAge();
    System.out.println("The sum of the dogs' ages is " + cumAge);

    // display cumulative height
    Double cumHeight = dog1.getHeight() + dog2.getHeight() + dog3.getHeight();
    System.out.println("The sum of the dogs' height is " + cumHeight);

    // display dog names
    System.out.println("The dogs names are " + dog1.getName() + ", " +
      dog2.getName() + ", and " + dog3.getName() + ".");

    // disply number of noisy dogs, lazy
    int noisy = 0;
    if (dog1.getLikesBarking()) { noisy += 1; }
    if (dog2.getLikesBarking()) { noisy += 1; }
    if (dog3.getLikesBarking()) { noisy += 1; }
    System.out.println(noisy + " dogs like barking.");
  }
}
