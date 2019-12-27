package ar.com.hibernate.custom;

import java.util.List;

public interface Dialect {
    public List<Person> obtener(Class<Person> clazz);
    public Person obtener(Class<Person> clazz, Long id);
    public void salvar(Person p);
}
