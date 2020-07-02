package dao;

import beans.Film;
import java.util.List;

/**
 *
 * @author SakiOgi
 */
public interface FilmDao
{
    List<Film> noviFilmovi();
    List<Film> akcioniFilmovi();
    List<Film> hororFilmovi();
    List<Film> animiraniFilmovi();
    List<Film> romanticniFilmovi();
    Film getById(int id);
    List<Film> getAllFilmovi();
    int insertIntoFilm(String naziv,String opis,String duzinaTrajanja,String slika,String trailer,String zanr,String ocena);
    int deleteFilm(int filmId);
    int updateFilm(int filmId,String naziv,String opis,String duzinaTrajanja,String trailer,String zanr,String ocena);
    int updateSlika(int filmId, String slika);
}
