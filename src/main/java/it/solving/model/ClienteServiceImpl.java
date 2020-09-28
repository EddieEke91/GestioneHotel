package it.solving.model;

public interface ClienteServiceImpl {

    public void insertCliente(String nome, String cognome);

    public Cliente selectCliente(int id);

    public boolean updateCliente(int id, String nome, String cognome);

    public boolean deleteCliente(int id);

}
