package dao;

import beans.Projekciona_Sala;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface Projekciona_SalaDao
{
    Projekciona_Sala getByIdAndBioskop(int brojSale, int bioskopId);
    List<Integer> getByBioskop(int bioskopId);
}
