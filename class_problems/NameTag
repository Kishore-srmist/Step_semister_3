class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] n = fullName.split(" ");
        firstName = n[0];
        lastName = n[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }
}

public class Main {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println(tag.getNickname());
    }
}
