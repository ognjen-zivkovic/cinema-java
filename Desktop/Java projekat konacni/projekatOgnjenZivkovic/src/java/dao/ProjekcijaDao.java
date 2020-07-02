package dao;

import beans.Projekcija;
import dto.AdminProjekcijaDto;
import java.util.Date;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface ProjekcijaDao
{
    List<Projekcija> getAllByMovieAndTheater(int bioskopId, int filmId, String datumProjekcije);
    Projekcija getById(int id);
    List<AdminProjekcijaDto> getAllByBioskop(int bioskopId);
    int deleteById(int projekcijaId);
    int addProjekcija(int filmId, int bioskopId, int brojSale, double cena, String vremePocetka);

}
