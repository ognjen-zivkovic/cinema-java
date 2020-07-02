<%-- 
    Document   : loginModal
    Created on : Jun 5, 2020, 5:04:57 PM
    Author     : Ognjen Živković
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form method="POST" action="Login">
    <!-- Modal -->
    <div class="modal fade" id="LoginModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <img src="img/logo.png" alt="" id="registerLogo">

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button><br>
                </div>
                <div style="margin-left: 37%;"><h3>Prijava</h3></div><br>
                <div class="modal-body">
                    <i class="fa fa-envelope" aria-hidden="true" ></i>
                    <input type="email" class="form-control" id="exampleInputEmail1"  placeholder="E-mail" name="email"><br><br>
                    <i class="fa fa-lock" aria-hidden="true"></i>
                    <input style="padding-left: 10px;" type="password" class="form-control" id="exampleInputEmail1" placeholder="Lozinka" name="lozinka"><br><br>
                </div>
                <span style="margin-top: -15px;padding-left: 10%;padding-bottom: 5%;font-size: 90%;">Nemate nalog? <a href="" id="loginModalRegLink">Registruj se</a></span>  
                <br>

                <div class="modal-footer">
                    <button style="margin-bottom: 25px;" type="submit" class="btn btn-primary">Prijava</button>
                </div>
            </div>
        </div>
    </div>
</form>