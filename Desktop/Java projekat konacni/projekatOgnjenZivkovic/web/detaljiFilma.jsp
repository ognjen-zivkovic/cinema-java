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
        <title>detalji</title>
        <link rel="stylesheet" href="css/movieAvailableForm.css"> 
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
                        <h1 class="details__title">${film.naziv}</h1>
                    </div>
                    <!-- end title -->

                    <!-- content -->
                    <div class="col-12 col-xl-6">
                        <div class="card card--details">
                            <div class="row">
                                <!-- card cover -->
                                <div class="col-12 col-sm-4 col-md-4 col-lg-3 col-xl-5">
                                    <div class="card__cover">
                                        <img src="/MovieAppResources/movieCovers/${film.slika}" alt="">
                                    </div>
                                </div>
                                <!-- end card cover -->

                                <!-- card content -->
                                <div class="col-12 col-sm-8 col-md-8 col-lg-9 col-xl-7">
                                    <div class="card__content">
                                        <div class="card__wrap">
                                            <span class="card__rate"><i class="icon ion-ios-star"></i>${film.ocena}</span>

                                            <ul class="card__list">
                                                <li>HD</li>
                                                <li>16+</li>
                                            </ul>
                                        </div>

                                        <ul class="card__meta">
                                            <li><span>Žanr:</span><p>${film.zanr}</p>
                                            <li><span>Dužina trajanja:</span><p>${film.duzinaTrajanja}</p></li>
                                            <li ><span>Trejler:</span><p>Pogledajte na sledećem <a href="${film.trailer}" style="background-image: -webkit-linear-gradient(0deg, #ff1a1a 0%, #f81717 100%);">linku</a></p></li>
                                        </ul>

                                        <div class="card__description card__description--details">
                                            ${film.opis}
                                        </div>
                                    </div>
                                </div>
                                <!-- end card content -->
                            </div>
                        </div>
                    </div>
                    <!-- end content -->

                    <!-- begin form -->
                    <div class="col-12 col-xl-6">
                        <div id="booking" class="section">
                            <div class="section-center">
                                <div class="container">
                                    <div class="row">
                                        <div class="booking-form">
                                            <div class="form-header">
                                                <h2 style="color: white;">Rezervišite kartu</h2>
                                            </div>
                                            <form method="POST" action="detaljiFilma" name="rezervacijaForma">                               
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <input type="hidden" value="${film.filmId}" name="filmId"/>
                                                            <select class="form-control" name="bioskop" required>
                                                                <option value="" disabled selected>Bioskop</option>
                                                                <c:forEach items="${bioskopi}" var="bioskop">
                                                                    <option value="${bioskop.bioskopId}">Koloseum-${bioskop.gradNaziv}</option> 
                                                                </c:forEach>                   
                                                            </select>
                                                            <span class="select-arrow"></span>

                                                        </div>
                                                    </div>     
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <input required class="form-control" type="text" placeholder="Datum projekcije" onfocus="(this.type = 'date')" name="datumProjekcije" id="datumProjekcije">            
                                                        </div>
                                                    </div>    

                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <c:if test="${projekcije != null}">                                          
                                                                <fmt:parseDate value="${izabranDatum}" var="parsedDate"
                                                                               pattern="yyyy-MM-dd" />
                                                                <script>
                                                                    document.addEventListener("DOMContentLoaded", function (e) {
                                                                        document.forms['rezervacijaForma'].elements['bioskop'].value = ${izabranBioskop};
                                                                        $("#datumProjekcije").val('<fmt:formatDate value="${parsedDate }" type = "date"/>');
                                                                    });
                                                                </script>
                                                                <select class="form-control" name="projekcija" required>
                                                                    <option value="" disabled selected>Izaberite vreme</option>
                                                                    <c:forEach items="${projekcije}" var="projekcija">
                                                                        <fmt:parseDate value="${projekcija.vremePocetka}" var="dateObject"
                                                                                       pattern="yyyy-MM-dd HH:mm:ss" />
                                                                        <option value="${projekcija.projekcijaId}"><b><fmt:formatDate value="${dateObject }" pattern="HH:mm" /></b></option>                                                            
                                                                        </c:forEach>
                                                                </select>
                                                                <span class="select-arrow" style="bottom: 25px;"></span>
                                                                <br>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                </div>      
                                                <c:choose>
                                                    <c:when test="${projekcije == null}">
                                                        <div class="form-btn">
                                                            <button class="submit-btn" type="submit">Proverite raspoloživost</button>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="form-btn">
                                                            <button class="submit-btn" type="submit" name="rezervacijaBtn">Rezervišite kartu</button>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <!-- end form -->    

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
    </body>
    <c:if test="${nemaProjekcije == true}">
    <script>toastr.error("Nema projekcije za traženi datum.");</script>
</c:if>
</html>
