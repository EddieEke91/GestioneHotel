package it.solving.model;

public interface StanzaServiceImpl {

    public void insertStanza(int nStanza);

    public Stanza selectStanza(int id);

    public boolean updateStanza(int id, int nStanza);

    public boolean deleteStanza(int id);

}
