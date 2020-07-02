<%-- 
    Document   : editProfileModal
    Created on : Jun 6, 2020, 2:14:36 AM
    Author     : Ognjen Živković
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Edit Profile -->
<form method="POST" action="AzuriranjeKorisnika">
    <div class="modal fade" id="edit">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"><b>Ažuriraj nalog</b></h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>

                </div>
                <div class="modal-body">
                    <form class="form-horizontal" method="POST" action="profile_edit.php" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="firstname" class="col-sm-3 control-label">Ime</label>

                            <div class="">
                                <input required type="text" class="form-control" id="firstname" name="ime" value=${korisnik.ime} >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-sm-3 control-label">Prezime</label>

                            <div class="">
                                <input required type="text" class="form-control" id="lastname" name="prezime" value=${korisnik.prezime} >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Email</label>

                            <div class="">
                                <input required type="text" class="form-control" id="email" name="email" value=${korisnik.email} >
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-sm-3 control-label">Lozinka</label>
                            <div class="">
                                <input required type="password" class="form-control" id="password" name="lozinka" value=${korisnik.lozinka} >
                            </div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <p>Trenutna lozinka</p>

                            <div class="t">
                                <input type="password" class="form-control" id="curr_password" name="trenutnaLozinka" placeholder="Unesite Vašu lozinku kako bi sačuvali izmene" required>
                            </div>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-flat pull-left" data-dismiss="modal"><i class="fa fa-close"></i> Zatvori</button>
                    <button type="submit" class="btn btn-success btn-flat" name="edit"><i class="fa fa-check-square-o"></i> Ažuriraj</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</form>