package dao;

import java.util.List;

public interface DaoInterface<Referencias> {

    public boolean insertar(Referencias r, String email);

    public boolean modificar(String id, Referencias r);

    public boolean eliminar(Object k);

    public Referencias leer(Object k);

    public List<Referencias> leerTodos();

}
