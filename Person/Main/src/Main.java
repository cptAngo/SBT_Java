public class Main {
    public static void main(String[] args) {
        Person dima = new PersonImpl(true,"dima");
        Person sveta = new PersonImpl(false,"sveta");
        dima.marry(sveta);
        System.out.println(dima.getSpouse().getName());
        System.out.println(sveta.getSpouse().getName());
        dima.divorce();
        System.out.println(dima.getSpouse());
        System.out.println(sveta.getSpouse());

        Person alex = new PersonImpl(true,"alex");
        Person ann = new PersonImpl(false,"ann");
        Person nikita = new PersonImpl(true,"nikita");
        Person julia = new PersonImpl(false,"julia");
        alex.marry(ann);
        System.out.println(alex.getSpouse().getName());
        System.out.println(ann.getSpouse().getName());

        alex.marry(julia);
        System.out.println(alex.getSpouse().getName());
        System.out.println(julia.getSpouse());
        System.out.println(ann.getSpouse());

        ann.marry(nikita);
        System.out.println(nikita.getSpouse());
        System.out.println(ann.getSpouse().getName());


        alex.marry(ann);
        System.out.println(alex.getSpouse().getName());
        System.out.println(ann.getSpouse().getName());
        System.out.println(nikita.getSpouse());
        System.out.println(julia.getSpouse());
    }
}
