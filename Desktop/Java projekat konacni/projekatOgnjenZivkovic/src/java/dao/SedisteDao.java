package dao;

import beans.Sediste;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface SedisteDao
{
    List<Sediste> getAllByBrojSaleAndBioskop( int brojSale, int bioskopId);
}
