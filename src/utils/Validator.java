package utils;

public class Validator {

  public static void isLength(String value, int length) throws IllegalArgumentException {
    if (value.length() > length) {
      throw new IllegalArgumentException(ErrorMessage.INVALID_STRING_LENGTH);
    }
  }


}
