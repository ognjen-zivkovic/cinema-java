<%-- 
    Document   : rezervacijaFilma
    Created on : Jun 17, 2020, 12:25:54 AM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/rezervacijaFilma.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <jsp:include page="includes/headLinks.jsp"/>

        <style>
            .home2{
                background-image: url("img/pozadinaRezervacija.jpg");
                background-size: cover;
                margin-top: -5%;
            }
            .home .container{
                min-height: 0;
            }
            .dropdown-toggle
            {
                margin-right: 250px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
        <section class="home" style="padding: 0;">

            <div class="content-wrapper home2">

                <h1 style="padding-top: 2%;">sdfsdf</h1>
                <div class="container">

                    <div class="w3ls-reg">
                        <!-- input fields -->
                        <div class="inputForm">
                            <h2 style="display: inline-block;">Biranje sedišta</h2>
                            <h5 style="display: inline-block; color: #ff9800; right: -15%; position: relative;">Film: ${film.naziv}</h5><br>
                            <h5 id="total" style="display: inline-block; color: #ff9800; right: -77%; position: relative;">Cena karte: 0 RSD</h5>
                        </div>

                        <ul class="seat_w3ls">
                            <li class="smallBox greenBox">Izabrana sedišta</li>

                            <li class="smallBox redBox">Rezervisana sedišta</li>

                            <li class="smallBox emptyBox">Prazna sedišta</li>
                        </ul>

                        <div class="seatStructure txt-center" style="overflow-x:auto;">
                            <table id="seatsBlock" class="container2">
                                <p id="notification"></p>
                                <tr>
                                    <td></td>
                                    <td>1</td>
                                    <td>2</td>
                                    <td>3</td>
                                    <td>4</td>
                                    <td>5</td>
                                    <td></td>
                                    <td>6</td>
                                    <td>7</td>
                                    <td>8</td>
                                    <td>9</td>
                                    <td>10</td>
                                    <td>11</td>
                                    <td>12</td>
                                </tr>
                                <tr>
                                    <c:set var="letter" scope="page" value="66"></c:set>

                                        <td class="rowLetter">A</td>

                                    <c:forEach items="${ispisSedista}" var="sediste">
                                        <c:if test="${sediste.key.brojSedista ==6}">
                                            <c:set var="count" value="0" scope="page" />
                                            <td></td>
                                        </c:if>
                                        <c:if test="${count != null}">

                                            <c:if test="${count==12}">
                                                <c:set var="count" value="0" scope="page" />
                                                <td></td>
                                            </c:if>
                                            <c:set var="count" value="${count + 1}" scope="page"/>
                                        </c:if>
                                        <c:if test="${sediste.key.tipSedistaId == 1}">
                                            <!--zauzeto-->
                                            <c:if test="${sediste.value == true}">
                                                <td>
                                                    <input type="checkbox" class="seats" value="${sediste.key.brojSedista}" name="test" disabled>
                                                    <span class="material-icons" class="icon" style="color:red;">
                                                        event_seat
                                                    </span>
                                                </td>
                                            </c:if>
                                            <!--zauzeto -kraj-->
                                            <!--slobodno-->
                                            <c:if test="${!sediste.value}">
                                                <td>
                                                    <input type="checkbox" class="seats" value="${sediste.key.brojSedista}" name="test" onclick="tst()" data-sediste="${sediste.key.tipSedistaId}">
                                                    <span class="material-icons" class="icon">
                                                        event_seat
                                                    </span>
                                                </td>
                                            </c:if>
                                            <!--slobodno -kraj-->
                                            <c:if test="${(sediste.key.brojSedista%12) == 0}">
                                            </tr><tr>
                                                <c:if test="${sediste.key.brojSedista<ukupanBrojSedista}">
                                                    <td class="rowLetter"><%=Character.toChars(Integer.parseInt(pageContext.getAttribute("letter").toString()))%></td>
                                                    <c:set var="letter" value="${letter + 1}" scope="page"></c:set>
                                                </c:if>

                                            </c:if>
                                        </c:if>
                                        <c:if test="${sediste.key.tipSedistaId == 2}">
                                            <!--zauzeto-->
                                            <c:if test="${sediste.value == true}">
                                                <td>
                                                    <input type="checkbox" class="seats" value="${sediste.key.brojSedista}" name="test" onclick="tst()" data-sediste="${sediste.key.tipSedistaId}" disabled>
                                                    <span class="material-icons" class="icon" style="color: red;">
                                                        weekend
                                                    </span>
                                                </td>
                                            </c:if>
                                            <!--zauzeto - kraj-->
                                            <!--slobodno-->
                                            <c:if test="${sediste.value == false}">
                                                <td>
                                                    <input type="checkbox" class="seats" value="${sediste.key.brojSedista}" name="test" onclick="tst()" data-sediste="${sediste.key.tipSedistaId}">
                                                    <span class="material-icons" class="icon">
                                                        weekend
                                                    </span>
                                                </td>
                                            </c:if>
                                            <!--slobodno - kraj-->

                                            <c:if test="${(sediste.key.brojSedista%12) == 0}">

                                            </tr><tr>
                                                <c:if test="${sediste.key.brojSedista<ukupanBrojSedista}">
                                                    <td class="rowLetter"><%=Character.toChars(Integer.parseInt(pageContext.getAttribute("letter").toString()))%></td>
                                                    <c:set var="letter" value="${letter + 1}" scope="page"></c:set>
                                                </c:if>

                                            </c:if>
                                        </c:if>

                                    </c:forEach>

                                </tr>                              
                            </table>

                            <div class="screen">
                                <h2 class="wthree">Platno</h2>
                            </div>
                            <a href="#" class="header__sign-in rezervacija" style="left: 30%;position: relative; color: black;">Potvrda izbora</a>
                        </div>               
                    </div>
                </div>
                <br>
                <script>
                    document.addEventListener('DOMContentLoaded', () => {
                        $(document).on('click', '.rezervacija', function (e) {
                            e.preventDefault();
                            var checkboxes = document.getElementsByName('test');
                            var total = 0;
                            var sedista = [];
                            for (var i = 0, n = checkboxes.length; i < n; i++)
                            {
                                if (checkboxes[i].checked)
                                {
                                    sedista.push(checkboxes[i].value);
                                    if ($(checkboxes[i]).data("sediste") == 1)
                                    {
                                        total += ${projekcija.cena};
                                    } else
                                    {
                                        total += ${projekcija.cena} * 1.2;
                                    }
                                }
                            }
                            if (total>0)
                            {
                                if (${korisnik != null})
                                {
                                    if (confirm("Ukupna cena:" + total + " RSD. Da li želite da kreirate rezervaciju."))
                                    {
                                        $.ajax({
                                            type: 'POST',
                                            url: 'rezervacijaFilma',
                                            data: {projekcijaId:${projekcijaId}, sedista: sedista, cena: total},
                                            dataType: 'json',
                                            success: function (response) {
                                                toastr.success("Uspešno ste rezervisali karte. Bićete preusmereni za nekoliko sekundi.");
                                                setTimeout(function () {
                                                    window.location.replace('index');
                                                }, 2500);
                                            }
                                        });
                                    }
                                } else
                                {
                                    alert("Morate da budete ulogovani da biste rezervisali kartu");
                                }
                            }
                            else
                            {
                            toastr.error("Izaberite sedista");
                            }

                        });
                    });



                    /////////////////////////////////////////////
                    function tst()
                    {
                        var checkboxes = document.getElementsByName('test');
                        var total = 0;
                        for (var i = 0, n = checkboxes.length; i < n; i++)
                        {
                            if (checkboxes[i].checked)
                            {

                                if ($(checkboxes[i]).data("sediste") == 1)
                                {
                                    total += ${projekcija.cena};
                                } else
                                {
                                    total += ${projekcija.cena} * 1.2;
                                }
                            }
                        }
                        $('#total').text('Cena karte: ' + total + ' RSD');
                    }
                </script>
            </div>
            <jsp:include page="includes/registerModal.jsp"/>
            <jsp:include page="includes/loginModal.jsp"/>
            <jsp:include page="includes/footer.jsp"/>
        </section>
    </body>
</html>
