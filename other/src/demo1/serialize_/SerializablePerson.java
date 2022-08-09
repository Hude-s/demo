package demo1.serialize_;

import java.io.*;

public class SerializablePerson {
    public static void main(String[] args) {
        SerializablePerson s = new SerializablePerson();
        s.serializablePerson();
        s.unSerializablePerson();
    }

    public void unSerializablePerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person = (Person) ois.readObject();
            System.out.println(person);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void serializablePerson(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setAge(18);
            person.setName("bai");
            person.setGender('男');
            person.setHobby("睡觉");

            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
