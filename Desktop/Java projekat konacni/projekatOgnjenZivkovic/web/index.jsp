<%-- 
    Document   : index
    Created on : Jun 4, 2020, 6:02:25 PM
    Author     : Ognjen Živković
--%>
<%@ page isThreadSafe="false"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/headLinks.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
        <section class="home">
            <div class="owl-carousel home__bg">
                <div class="item home__cover" data-bg="img/movieCovers/cover.jpg"></div>		
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h1 class="home__title">NAJNOVIJI FILMOVI</h1>
                    </div>

                    <div class="col-12">
                        <div class="owl-carousel home__carousel">
                            <c:forEach items="${noviFilmovi}" var="film">
                                <div class="item">
                                    <!-- card -->
                                    <div class="card card--big">
                                        <div class="card__cover">
                                            <img src="/MovieAppResources/movieCovers/${film.slika}" alt="">
                                            <a href="detaljiFilma?filmId=${film.filmId}" class="card__play">
                                                <i style="margin-right: 5px;" class="fa fa-info-circle" aria-hidden="true"></i>
                                            </a>
                                        </div>
                                        <div class="card__content">
                                            <h3 class="card__title"><a href="#">${film.naziv}</a></h3>
                                            <span class="card__category">
                                                <a href="#">${film.zanr}</a>                     
                                            </span>
                                            <span class="card__rate"><i class="fa fa-star" aria-hidden="true"></i></i>${film.ocena}</span>
                                        </div>
                                    </div>
                                    <!-- end card -->
                                </div>
                            </c:forEach>          
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end home -->
























        <!-- content -->
        <section class="content">
            <div class="content__head">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <!-- content title -->
                            <h2 class="content__title">Naša ponuda filmova</h2>
                            <!-- end content title -->

                            <!-- content tabs nav -->
                            <ul class="nav nav-tabs content__tabs" id="content__tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">Akcioni</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">Romantični</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false">Horor</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tab-4" role="tab" aria-controls="tab-4" aria-selected="false">Animirani</a>
                                </li>
                            </ul>
                            <!-- end content tabs nav -->

                            <!-- content mobile tabs nav -->
                            <div class="content__mobile-tabs" id="content__mobile-tabs">
                                <div class="content__mobile-tabs-btn dropdown-toggle" role="navigation" id="mobile-tabs" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <input type="button" value="New items">
                                    <span></span>
                                </div>

                                <div class="content__mobile-tabs-menu dropdown-menu" aria-labelledby="mobile-tabs">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item"><a class="nav-link active" id="1-tab" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">Akcioni</a></li>

                                        <li class="nav-item"><a class="nav-link" id="2-tab" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">Romanticni</a></li>

                                        <li class="nav-item"><a class="nav-link" id="3-tab" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false">Horor</a></li>

                                        <li class="nav-item"><a class="nav-link" id="4-tab" data-toggle="tab" href="#tab-4" role="tab" aria-controls="tab-4" aria-selected="false">Animirani</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- end content mobile tabs nav -->
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <!-- content tabs -->
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="tab-1" role="tabpanel" aria-labelledby="1-tab">
                        <div class="row">
                            <c:forEach items="${akcioniFilmovi}" var="akcioniFilm">
                                <!-- card -->
                                <div class="col-6 col-sm-12 col-lg-6">
                                    <div class="card card--list">
                                        <div class="row">
                                            <div class="col-12 col-sm-4">
                                                <div class="card__cover">
                                                    <img src="/MovieAppResources/movieCovers/${akcioniFilm.slika}" alt="">
                                                    <a href="detaljiFilma?filmId=${akcioniFilm.filmId}" class="card__play">
                                                        <i style="margin-right: 5px;" class="fa fa-info-circle" aria-hidden="true"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-12 col-sm-8">
                                                <div class="card__content">
                                                    <h3 class="card__title"><a href="#">${akcioniFilm.naziv}</a></h3>
                                                    <span class="card__category">
                                                        <a href="#">${akcioniFilm.zanr}</a>
                                                    </span>

                                                    <div class="card__wrap">
                                                        <span class="card__rate"><i class="icon ion-ios-star"></i>${akcioniFilm.ocena}</span>

                                                        <ul class="card__list">
                                                            <li>HD</li>
                                                            <li>16+</li>
                                                        </ul>
                                                    </div>

                                                    <div class="card__description">
                                                        <p>${akcioniFilm.opis}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->         
                            </c:forEach>

                        </div>
                    </div>

                    <div class="tab-pane fade" id="tab-2" role="tabpanel" aria-labelledby="2-tab">
                        <div class="row">
                            <c:forEach items="${romanticniFilmovi}" var="romanticniFilm">
                                <!-- card -->
                                <div class="col-6 col-sm-12 col-lg-6">
                                    <div class="card card--list">
                                        <div class="row">
                                            <div class="col-12 col-sm-4">
                                                <div class="card__cover">
                                                    <img src="/MovieAppResources/movieCovers/${romanticniFilm.slika}" alt="">
                                                    <a href="detaljiFilma?filmId=${romanticniFilm.filmId}" class="card__play">
                                                        <i style="margin-right: 5px;" class="fa fa-info-circle" aria-hidden="true"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-12 col-sm-8">
                                                <div class="card__content">
                                                    <h3 class="card__title"><a href="#">${romanticniFilm.naziv}</a></h3>
                                                    <span class="card__category">
                                                        <a href="#">${romanticniFilm.zanr}</a>
                                                    </span>

                                                    <div class="card__wrap">
                                                        <span class="card__rate"><i class="icon ion-ios-star"></i>${romanticniFilm.ocena}</span>

                                                        <ul class="card__list">
                                                            <li>HD</li>
                                                            <li>16+</li>
                                                        </ul>
                                                    </div>

                                                    <div class="card__description">
                                                        <p>${romanticniFilm.opis}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->         
                            </c:forEach>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="tab-3" role="tabpanel" aria-labelledby="3-tab">
                        <div class="row">
                            <c:forEach items="${hororFilmovi}" var="hororFilm">
                                <!-- card -->
                                <div class="col-6 col-sm-12 col-lg-6">
                                    <div class="card card--list">
                                        <div class="row">
                                            <div class="col-12 col-sm-4">
                                                <div class="card__cover">
                                                    <img src="/MovieAppResources/movieCovers/${hororFilm.slika}" alt="">
                                                    <a href="detaljiFilma?filmId=${hororFilm.filmId}" class="card__play">
                                                        <i style="margin-right: 5px;" class="fa fa-info-circle" aria-hidden="true"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-12 col-sm-8">
                                                <div class="card__content">
                                                    <h3 class="card__title"><a href="#">${hororFilm.naziv}</a></h3>
                                                    <span class="card__category">
                                                        <a href="#">${hororFilm.zanr}</a>
                                                    </span>

                                                    <div class="card__wrap">
                                                        <span class="card__rate"><i class="icon ion-ios-star"></i>${hororFilm.ocena}</span>

                                                        <ul class="card__list">
                                                            <li>HD</li>
                                                            <li>16+</li>
                                                        </ul>
                                                    </div>

                                                    <div class="card__description">
                                                        <p>${hororFilm.opis}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->         
                            </c:forEach>
                        </div>
                    </div>

                    <div class="tab-pane fade" id="tab-4" role="tabpanel" aria-labelledby="4-tab">
                        <div class="row">
                            <c:forEach items="${animiraniFilmovi}" var="animiraniFilm">
                                <!-- card -->

                                <div class="col-6 col-sm-12 col-lg-6">
                                    <div class="card card--list">
                                        <div class="row">
                                            <div class="col-12 col-sm-4">
                                                <div class="card__cover">
                                                    <img src="/MovieAppResources/movieCovers/${animiraniFilm.slika}" alt="">
                                                    <a href="detaljiFilma?filmId=${hororFilm.filmId}" class="card__play">
                                                        <i style="margin-right: 5px;" class="fa fa-info-circle" aria-hidden="true"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-12 col-sm-8">
                                                <div class="card__content">
                                                    <h3 class="card__title"><a href="#">${animiraniFilm.naziv}</a></h3>
                                                    <span class="card__category">
                                                        <a href="#">${animiraniFilm.zanr}</a>
                                                    </span>

                                                    <div class="card__wrap">
                                                        <span class="card__rate"><i class="icon ion-ios-star"></i>${animiraniFilm.ocena}</span>

                                                        <ul class="card__list">
                                                            <li>HD</li>
                                                            <li>16+</li>
                                                        </ul>
                                                    </div>

                                                    <div class="card__description">
                                                        <p>testtttt${animiraniFilm.opis}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->         
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <!-- end content tabs -->
            </div>
        </div>
    </section>
    <!-- end content -->

    <jsp:include page="includes/registerModal.jsp"/>
    <jsp:include page="includes/loginModal.jsp"/>
    <jsp:include page="includes/footer.jsp"/> 
    ${polja != null ? "<script>toastr.error('Morate popuniti sva polja');$('#RegisterModalCenter').modal('show')</script>":""}
    ${korisnikPostoji != null ? "<script>toastr.info('Korisnik sa unetim podacima već postoji');$('#LoginModalCenter').modal('show')</script>":""}
    ${novKorisnik != null ? "<script>toastr.success('Uspešno ste kreirali nalog. Možete se ulogovati');$('#LoginModalCenter').modal('show')</script>":""}
    ${novKorisnikNeuspesno != null ? "<script>toastr.error('Doslo je do greške pokušajte ponovo');$('#RegisterModalCenter').modal('show')</script>":""}
    ${loginFormaPogresanUnos != null ? "<script>toastr.error('Sva polja su obavezna');$('#LoginModalCenter').modal('show')</script>":""}
    ${loginFormaNemaKorisnika != null ? "<script>toastr.error('Ne postoji korisnik sa unetim podacima');$('#LoginModalCenter').modal('show')</script>":""}
    ${uspesanLogin != null ? "<script>toastr.success('Dobrodošli');</script>":""}

</body>
</html>
