public class Task1 {
    public static void main(String[] args) {
    String input = "Your Input String Here!";
    int upperCaseCount = 0;
    int lowerCaseCount = 0;
    int specialCharCount = 0;
    int spaceCount = 0;
    int digitCount = 0;

    for (char ch : input.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            upperCaseCount++;
        } else if (Character.isLowerCase(ch)) {
            lowerCaseCount++;
        } else if (Character.isDigit(ch)) {
            digitCount++;
        } else if (Character.isWhitespace(ch)) {
            spaceCount++;
        } else {
            specialCharCount++;
        }
    }

    System.out.println("Upper case letters: " + upperCaseCount);
    System.out.println("Lower case letters: " + lowerCaseCount);
    System.out.println("Digits: " + digitCount);
    System.out.println("Spaces: " + spaceCount);
    System.out.println("Special characters: " + specialCharCount);
}
}