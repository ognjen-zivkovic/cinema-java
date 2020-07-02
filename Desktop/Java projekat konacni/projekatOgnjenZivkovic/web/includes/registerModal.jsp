<%-- 
    Document   : registerModal
    Created on : Jun 4, 2020, 11:05:04 PM
    Author     : Ognjen Živković
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form method="POST" action="Register">
<!-- Modal -->
<div class="modal fade" id="RegisterModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <img src="img/logo.png" alt="" id="registerLogo">

                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button><br>
            </div>
            <div style="margin: 0 auto;"><h3>Registracija</h3></div><br>
            <div class="modal-body">
                <i class="fa fa-user" aria-hidden="true"></i>
                <input style=" width: 35%; margin-right: 5px;" type="text" class="form-control" id="exampleInputEmail1"  placeholder="Ime" name="ime">
                <input style="width: 44%;" type="text" class="form-control" id="exampleInputEmail1" placeholder="Prezime" name="prezime"><br><br>
                <i class="fa fa-envelope" aria-hidden="true" ></i>
                <input type="email" class="form-control" id="exampleInputEmail1"  placeholder="E-mail" name="email"><br><br>
                <i class="fa fa-lock" aria-hidden="true"></i>
                <input type="password" class="form-control" id="exampleInputEmail1" placeholder="Lozinka" name="lozinka"><br><br>
            </div>
            <span style="margin-top: -15px;padding-left: 10%;padding-bottom: 5%;font-size: 90%;">Već imate nalog?  <a href="" id="registerModalLoginLink">Prijavi se</a></span>
            <br>
            
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Potvrda</button>
            </div>
        </div>
    </div>
</div>
</form>