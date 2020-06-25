public interface Person {
    String getName();
    boolean isMan();
    boolean marry(Person person);
    boolean divorce();
    Person getSpouse();
    void setSpouse(Person person);
}
