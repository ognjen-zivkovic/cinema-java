<%-- 
    Document   : korisnik_profil
    Created on : Jun 6, 2020, 1:00:41 AM
    Author     : Ognjen Živković
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil</title>
         <link rel="stylesheet" href="css/korisnik_profil.css">   
        <jsp:include page="includes/headLinks.jsp"/>
    </head>
    <body>
        <jsp:include page="includes/header.jsp"/>
       
                <div  style="background-color: #ecf0f5; width: 100%;height: 100%" class="wrapper">
                    <div class="content-wrapper">
                        <div class="container content">

                            <!-- Main content -->

                            <div class="row-table" style="height: 200px;">
                                <div>
                                    <div class="box box-solid" >
                                        <div class="box-body" >
                                            <div class="col-sm-3">
                                                <img src="img/logo.png" width="80%"> 
                                            </div>
                                            <div class="col-sm-9">							
                                                <div class="col-sm-3">
                                                    <h4>Ime i prezime:</h4>
                                                    <h4>Email:</h4>   
                                                    <h4 id="clan">Član od:</h4>
                                                    <h4 style="width: 400%;">Klub:<p style="display: inline-block;left: 90px; position: relative;">${korisnik_klub.naziv}</p></h4>
                                                </div>
                                                <div class="col-sm-9 rightCollumn" >
                                                    <h4>${korisnik.ime} ${korisnik.prezime}
                                                        <span class="pull-right">
                                                          <a href="#edit" class="btn btn-success btn-flat btn-sm" data-toggle="modal"><i class="fa fa-edit"></i> Edit</a>
                                                        </span>
                                                    </h4>
                                                    <h4>${korisnik.email}</h4>
                                                    <h4>${korisnik.nalogNapravljen}</h4>  
                                                    <h4>${korisnik.klubId ==0 ? "Trenutno nema klub":""}</h4>  
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>

			
                        </div>
                    </div>
                </div>
    </div>

    <jsp:include page="includes/editProfileModal.jsp"/>        
    <jsp:include page="includes/footer.jsp"/> 

    ${greska != null ? "<script>toastr.error('Došlo je do greške pokušajte ponovo');</script>
  ":""}
    ${pogresnaLozinka != null ? "<script>toastr.error('Pogrešna lozinka');</script>":""}
    ${uspesnoAzurirano != null ? "<script>toastr.success('Uspešno ažurirani podaci');</script>":""}

</body>
</html>
