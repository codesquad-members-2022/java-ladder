import utils.Validator;

public class Player {

  private static final int MAX_LENGTH_NAME = 5;
  private String name;

  public Player(String name) {
    Validator.isLength(name, MAX_LENGTH_NAME);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
