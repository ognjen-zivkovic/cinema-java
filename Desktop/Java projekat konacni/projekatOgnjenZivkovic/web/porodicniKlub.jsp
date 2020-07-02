<%-- 
    Document   : detaljiFilma
    Created on : Jun 21, 2020, 8:55:34 PM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/headLinks.jsp"/>

    </head>
    <body class="body">
        <jsp:include page="includes/header.jsp"/>
        <!-- details -->
        <section class="section details">
            <!-- details background -->
            <div class="details__bg" data-bg="img/movieCovers/home__bg.jpg"></div>
            <!-- end details background -->

            <!-- details content -->
            <div class="container">
                <div class="row">
                    <!-- title -->
                    <div class="col-12">
                        <h1 class="details__title">${klub.naziv}</h1>
                    </div>
                    <!-- end title -->

                    <!-- content -->
                    <div class="col-12 col-xl-6">
                        <div class="card card--details">
                            <div class="row">
                                <!-- card cover -->
                                <div class="col-12 col-sm-4 col-md-4 col-lg-3 col-xl-5">
                                    <div class="card__cover">
                                        <img src="img/porodicniFilmKlub.jpg" alt="" style="width: 200%; max-width: none;">
                                    </div>
                                </div>
                                <!-- end card cover -->

                                <!-- card content -->
                                <div class="col-12 col-sm-8 col-md-8 col-lg-9 col-xl-7" style="right: -45%;">
                                    <div class="card__content">
                                        <div class="card__wrap">                     
                                        </div>

                                        <ul class="card__meta">
                                            <li><span>Popust na karte: 25 %</span><p></p>
                                            <li><span>Odlične pogodnosti za sve članove</span><p></p></li>
                                        </ul>

                                        <div class="card__description card__description--details">
                                            Besplatno članstvo
                                            Besplatna članska kartica (dostupna na blagajni bioskopa!)
                                            Snižena cena karte za članove kluba*
                                            MENI po fantastičnoj ceni od 200 dinara u bioskopima Koloseuma - Beograd, i Koloseum - Subotica i
                                            Redovno informisanje o najaktuelnijim filmovima i događajima u bioskopu
                                            Snižena cena karte za roditelje ili pratioce dece, članova Porodičnog film kluba**
                                            Karticu je moguće koristiti u svim Koloseum bioskopima u Srbiji 
                                        </div>
                                    </div>
                                </div>
                                <!-- end card content -->
                                <form method="GET" action="KlubServlet">
                                    <input type="hidden" name="uclanjenje" value="${klub.klubId}">
                                    <button type="submit" style="left: 30%;position: relative;width:100%;" href="" class="header__sign-in">
                                    <span>Učlanite se</span>
                                </button>
                                    </form>
                            </div>
                        </div>
                    </div>
                    <!-- end content -->



                    </div>
                    <!-- end player -->

                    <div class="col-12">
                        <div class="details__wrap">
                            <!-- share -->
                            <div class="details__share">
                                <span class="details__share-title">Podelite sa prijateljima:</span>

                                <ul class="details__share-list">
                                    <li class="facebook"><a href="www.facebook.com"><i class="fa fa-facebook"></i></a></li>
                                    <li class="instagram"><a href="www.instagram.com"><i class="fa fa-instagram"></i></a></li>
                                    <li class="twitter"><a href="www.twitter.com"><i class="fa fa-twitter"></i></a></li>
                                </ul>
                            </div>
                            <!-- end share -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- end details content -->
        </section>
        <!-- end details -->


        <jsp:include page="includes/registerModal.jsp"/>
        <jsp:include page="includes/loginModal.jsp"/>
        <jsp:include page="includes/footer.jsp"/> 
        
        ${logovanje != null ? "<script>toastr.error('Morate biti ulogovani da biste se učlanili u klub.');</script>
  ":""}
          ${greska != null ? "<script>toastr.error('Došlo je do greške.');</script>
  ":""}
            ${uspesno != null ? "<script>toastr.success('Uspešno ste se učlanili u klub.');</script>
  ":""}
    </body>
</html>
