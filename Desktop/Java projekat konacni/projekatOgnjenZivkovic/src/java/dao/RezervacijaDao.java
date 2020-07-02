package dao;

import beans.Rezervacija;
import dto.AdminRezervacijaDto;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface RezervacijaDao
{
    int insertIntoRezervacija(String status, int korisnikId, int projekcijaId, String cena);
    int getMaxId();
    int deleteByKorisnik(int korisnikId);
    List<Rezervacija> getAll();
    List<AdminRezervacijaDto> displayRezervacije();
    List<Integer> sedistaByRezervacija(int rezervacijaId);
    int deleteById(int rezervacijaId);
    int promeniStatus(int rezervacijaId, String status);

}
