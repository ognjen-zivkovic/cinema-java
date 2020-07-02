package dao;

import beans.Korisnik;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface KorisnikDao
{
    boolean korisnikExists(String email);
    int insertKorisnik(Korisnik korisnik);
    Korisnik korisnikAuthentication(String email, String lozinka);
    int updateKorisnik(Korisnik korisnik);
    Korisnik getById(int id);
    List<Korisnik> getAll();
    int deleteKorisnik(int korisnikId);
    int updatePoeni(int korisnikId,int brojPoena);
    int resetPoeni(int korisnikId);
    int setKlub(int klubId, int korisnikId);
    
}
