public class PersonImpl implements Person {
    private Person spouse = null;
    private final boolean man;
    private final String name;

    public PersonImpl(boolean man, String name) {
        this.man = man;
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isMan() {
        return this.man;
    }

    @Override
    public boolean marry(Person person) {
        if (this.man != person.isMan()) {
            if (this.spouse == null && person.getSpouse() == null) {
                this.spouse = person;
                person.setSpouse(this);
                return true;
            }
            System.out.println("They are already married");
            return false;
        }
        return false;
    }

    @Override
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse.setSpouse(null);
            this.setSpouse(null);
            return true;
        }
        return false;
    }

    @Override
    public Person getSpouse() {
        return this.spouse;
    }

    @Override
    public void setSpouse(Person person) {
        this.spouse = person;
    }
}
