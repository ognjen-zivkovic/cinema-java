<%-- 
    Document   : adminFilm
    Created on : Jun 25, 2020, 9:13:46 PM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/adminPanelHeadLinks.jsp"/>
        <c:if test="${korisnik == null || korisnik.nivo == 2}">
            <c:redirect url="index"></c:redirect>
        </c:if>

    </head>
    <header class="main-header">
        <a href="#" class="logo">
            <div class="user-panel">
                <div class="pull-left image">
                    <img style="border-radius:0; " src="img/logo.png"
                         class="img-circle">
                </div>
            </div>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button" style="color: #708090;">
                <span class="sr-only">Toggle navigation</span>
            </a>
              <a style="left: 25%;position: relative;width: 8%;" href="Logout" class="header__sign-in">
                <span>Odjavi se</span>
            </a>
        </nav>
    </header>
    <body class="hold-transition skin-blue sidebar-mini">


        <div class="wrapper">
            <aside class="main-sidebar">
                <section class="sidebar">
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">UPRAVLJANJE</li>
                        <li><a href="adminFilm"><i class="fa fa-film"></i> <span>Filmovi</span></a></li>
                        <li><a href="adminKorisnik"><i class="fa fa-users"></i> <span>Korisnici</span></a></li>
                        <li><a href="adminRezervacije"><i class="fa fa-ticket"></i> <span>Rezervacije</span></a></li>
                         <li><a href="adminProjekcije"><i class="fa fa-video-camera"></i> <span>Projekcije</span></a></li>

                    </ul>
                </section>
            </aside>
            <div class="content-wrapper">

                <section class="content-header">
                    <h1>
                        Filmovi
                    </h1>

                    <ol class="breadcrumb">
                        <li><a href="adminFilm.jsp"><i class="fa fa-dashboard"></i> Početna</a></li>
                        <li class="active">Filmovi</li>
                    </ol>
                </section>
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <a href="#addnew" data-toggle="modal" class="btn btn-primary btn-sm btn-flat"><i
                                            class="fa fa-plus"></i> Novi film</a>
                                </div>
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered" >

                                        <thead>
                                        <th data-sort-order="desc" >Poster</th>
                                        <th>Naziv</th>
                                        <th>Duzina trajanja</th>
                                        <th>Zanr</th>
                                        <th>Ocena</th>
                                        <th>Alati</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${filmovi}" var="film">
                                                <tr>
                                                    <td>
                                                        <img  src="/MovieAppResources/movieCovers/${film.slika}" height='35px' width='35px' id="'planeTableImg'+${film.filmId}"/>
                                                        <span class='pull-right'><a href='#edit_photo' class='photo'
                                                                                    data-toggle='modal'  data-id="${film.filmId}"><i
                                                                    class='fa fa-edit'></i></a></span>
                                                    </td>


                                                    <td>
                                                        <span class='pull-right'>${film.naziv}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${film.duzinaTrajanja}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${film.zanr}</span>
                                                    </td>

                                                    <td>
                                                        <span class='pull-right'>${film.ocena}</span>
                                                    </td>


                                                    <td>
                                                        <a href="#edit" data-id="${film.filmId}" data-toggle="modal" class="btn btn-success btn-sm edit btn-flat"><i
                                                                class="fa fa-edit"></i> Ažuriraj</a>

                                                        <a href="#delete" data-id="${film.filmId}" data-toggle="modal" class="btn btn-danger btn-sm delete btn-flat"><i
                                                                class="fa fa-trash"></i> Obriši</a>


                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>

                                    </table>
                                </div>

                            </div>

                        </div>

                    </div>
                    <!-- Add -->
                    <div class="modal" id="addnew">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" style="position: relative;
                                            left: 25%;" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" style="left: -70%; position: relative;"><b>Dodaj novi film</b></h4>
                                </div>
                                <br>
                                <form class="form-horizontal" method="POST" action="adminFilm" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="naziv" class="col-sm-3 control-label">Naziv</label>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="naziv" name="naziv" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="opis" class="col-sm-3 control-label">Opis</label>

                                        <div class="col-sm-9">
                                            <textarea class="form-control" id="opis" name="opis" required></textarea>                             
                                        </div>
                                    </div>
                                    <div class="form-group" >
                                        <label style="padding-right: 0px;" for="duzinaTrajanja" class="col-sm-3 control-label">Duzina trajanja</label>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="duzinaTrajanja" name="duzinaTrajanja" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="trejler" class="col-sm-3 control-label">Trejler</label>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control " id="trejler" name="trejler" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="zanr" class="col-sm-3 control-label">Žanr</label>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="zanr" name="zanr" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="ocena" class="col-sm-3 control-label">Ocena</label>

                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" id="ocena" name="ocena" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="slika" class="col-sm-3 control-label">Slika</label>

                                        <div class="col-sm-9">
                                            <input type="file" id="slika" name="slika">
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i
                                                class="fa fa-close"></i> Zatvori
                                        </button>
                                        <button type="submit" class="btn btn-primary btn-flat" name="add"><i class="fa fa-save"></i> Sačuvaj
                                        </button>
                                </form>
                            </div>
                        </div>
                    </div>
            </div>
            <!-- Add End -->

            <!-- Delete -->
            <div class="modal" id="delete">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button style="position: relative;
                                    left: 17%;" type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" style="position: relative;
                                left: -80%;"><b>Brisanje...</b></h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" method="POST" action="adminFilm">
                                <input type="hidden" class="filmId" name="filmId">
                                <div class="text-center">
                                    <p>Da li ste sigurni da želite da obrišete ovaj film?</p>
                                    <h2 class="bold"></h2>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i
                                    class="fa fa-close"></i> Zatvori
                            </button>
                            <button type="submit"  class="btn btn-danger btn-flat brisanjeFilma" name="delete"><i class="fa fa-trash"></i> Obriši
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Delete End -->

            <!-- Edit -->
            <div class="modal" id="edit">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button style="position: relative;
                                    left: 26%;" type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" style="position: relative;
                                left: -70%;"><b>Ažuriranje filma</b></h4>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal" method="POST" action="adminFilm">
                                <input type="hidden" class="filmId" name="filmId">
                                <input type="hidden" name="azuriranjeFilma" value="1`">
                                <div class="form-group">
                                    <label for="edit_naziv" class="col-sm-3 control-label">Naziv</label>

                                    <div class="col-sm-9">
                                        <input required type="text" class="form-control edit_naziv" id="edit_naziv" name="edit_naziv">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit_opis" class="col-sm-3 control-label">Opis</label>

                                    <div class="col-sm-9">
                                        <textarea rows="5" required class="form-control edit_opis" id="edit_opis" name="edit_opis"></textarea>                               
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit_duzinaTrajanja" class="col-sm-3 control-label">Duzina trajanja</label>

                                    <div class="col-sm-9">
                                        <input required type="text" class="form-control edit_duzinaTrajanja" id="edit_duzinaTrajanja"
                                               name="edit_duzinaTrajanja">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit_trejler" class="col-sm-3 control-label">Trejler</label>

                                    <div class="col-sm-9">
                                        <input required type="text" class="form-control edit_trejler" id="edit_trejler" name="edit_trejler">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit_zanr" class="col-sm-3 control-label">Zanr</label>

                                    <div class="col-sm-9">
                                        <input required type="text" class="form-control edit_zanr" id="edit_zanr" name="edit_zanr">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="edit_ocena" class="col-sm-3 control-label">Ocena</label>

                                    <div class="col-sm-9">
                                        <input required type="text" class="form-control edit_ocena" id="edit_ocena" name="edit_ocena">
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i
                                    class="fa fa-close"></i> Zatvori
                            </button>
                            <button type="submit" class="btn btn-success btn-flat" name="edit"><i class="fa fa-check-square-o"></i>
                                Ažuriraj
                            </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Edit End -->

            <!-- Update Images -->
            <div class="modal" id="edit_photo">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button style="position: relative; left: 22%;" type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <h4 style="position: relative; left: -75%;" class="modal-title"><b class="imageEditHeader">Ažuriraj sliku<span></span></b></h4>
                        </div>
                        <div class="modal-body" id="imageModal">
                            <form method="post" action="adminFilm" enctype="multipart/form-data">
                                <input type="hidden" value="1" name="azuriranjeSlike">
                                <input type="hidden" class="filmId" name="filmId">
                                <input type="file" name="slika" style="margin-bottom: 55px;border-bottom: none !important;">
                                <input class="btn btn-primary" type="submit" value="Ažuriraj">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Update Images End -->

                </section>

    </div>

</div>


<jsp:include page="includes/adminPanelScripts.jsp"/>
<c:if test="${uspesnoDodato ==true}">
    <script>toastr.success("Film uspesno dodat.");</script>
</c:if>

<c:if test="${neuspesnoDodato == true}">
    <script>toastr.error("Doslo je do greške.");</script>
</c:if>
<c:if test="${uspesnoAzurirano == true}">
    <script>toastr.success("Uspešno ažurirano.");</script>
</c:if>

   <c:if test="${slikaNijeAzurirana == true}">
    <script>toastr.error("Došlo je do greške.");</script>
</c:if> 
    
       <c:if test="${slikaAzurirana == true}">
    <script>toastr.success("Uspešno je ažurirana slika.");</script>
</c:if> 
    
    
    
    
<c:if test="${neuspesnoAzurirano == true}">
    <script>toastr.error("Došlo je do greške.");</script>
</c:if>
    
</body>
</html>
