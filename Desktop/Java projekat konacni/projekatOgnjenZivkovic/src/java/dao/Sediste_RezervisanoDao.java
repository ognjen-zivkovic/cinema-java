package dao;

import beans.Sediste;
import beans.Sediste_Rezervisano;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface Sediste_RezervisanoDao
{
    List<Sediste_Rezervisano> getAllByProjekcija(int projekcijaId);
    int insertIntoSedisteRezervisano(int rezervacijaId, int projekcijaId, int brojSedista, int brojSale, int bioskopId);
}
