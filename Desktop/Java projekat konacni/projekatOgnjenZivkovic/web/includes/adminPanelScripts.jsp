<%-- 
    Document   : adminPanelScripts
    Created on : Jun 25, 2020, 10:12:31 PM
    Author     : Ognjen Živković
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/toastr.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap.min.js"></script>
<script src="js/adminPanelScripts.js"></script>

<script>
    var id;
    $(document).on('click', '.delete', function (e) {
        e.preventDefault();
        $('#delete').modal('show');
        var id = $(this).data('id');
        $('.filmId').val(id);

    });

    $(document).on('click', '.photo', function (e) {
        e.preventDefault();
        $('#edit_photo').modal('show');
        var id = $(this).data('id');
        $('.filmId').val(id);

    });

    $(document).on('click', '.edit', function (e) {
        e.preventDefault();
        $('#edit').modal('show');
        var id = $(this).data('id');
        $('.filmId').val(id);
        $.ajax({
            type: 'POST',
            url: 'adminFilm',
            data: {popuniAzuriranje: $('.filmId').val()},
            dataType: 'json',
            success: function (response) {
                $('.filmId').val(response.filmId);
                $('.edit_naziv').val(response.naziv);
                $('.edit_opis').val(response.opis);
                $('.edit_duzinaTrajanja').val(response.duzinaTrajanja);
                $('.edit_trejler').val(response.trailer);
                $('.edit_zanr').val(response.zanr);
                $('.edit_ocena').val(response.ocena);


            }, error: function () {

            }
        });

    });

    $(document).on('click', '.brisanjeFilma', function (e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'adminFilm',
            data: {brisanjeFilmId: $('.filmId').val()},
            dataType: 'json',
            success: function (response) {

            }, error: function () {
                toastr.success('Uspešno obrisano.');
                window.location.href = "adminFilm";
            }
        });
    });

    $(document).on('click', '.delete-korisnik', function (e) {
        e.preventDefault();
        $('#delete').modal('show');
        var id = $(this).data('id');
        $('.korisnikId').val(id);

    });

    $(document).on('click', '.delete-projekcija', function (e) {
        e.preventDefault();
        $('#delete').modal('show');
        var id = $(this).data('id');
        $('.projekcijaId').val(id);

    });

    $(document).on('click', '.delete-rezervacija', function (e) {
        e.preventDefault();
        $('#delete').modal('show');
        var id = $(this).data('id');
        $('.rezervacijaId').val(id);

    });

    $(document).on('click', '.promenaStatusa', function (e) {
        e.preventDefault();
        var id = $(this).data('status');
        $.ajax({
            type: 'POST',
            url: 'adminRezervacije',
            data: {promenaStatusa: id},
            dataType: 'json',
            success: function (response) {
                window.location.href = "adminRezervacije";
            }, error: function () {

            }
        });

    });

















    $(document).on('click', '.novaProjekcija', function (e) {
        e.preventDefault();
        $.ajax({
            type: 'POST',
            url: 'adminProjekcije',
            data: {novaProjekcija: true},
            dataType: 'json',
            success: function (response) {
                var data1 = response[0], data2 = response[1];
                $('#filmSelect').html('');
                $.each(data1, function (index, value) {
                    $('#filmSelect').append($('<option/>', {
                        value: value.filmId,
                        text: value.naziv
                    }));
                });
                $('#bioskopSelect').html('');
                $('#bioskopSelect').append(' <option selected disabled>Izaberite bioskop</option>');
                $.each(data2, function (index, value) {
                    $('#bioskopSelect').append($('<option/>', {
                        value: value.bioskopId,
                        text: "Koloseum - " + value.gradNaziv
                    }));
                });
            }, error: function () {

            }
        });

    });

    $('.bioskop-select').on('change', function () {
        var bioskopId = this.value;
        $.ajax({
            type: 'POST',
            url: 'adminProjekcije',
            data: {popuniSelect: bioskopId},
            dataType: 'json',
            success: function (response) {
                $('#brojSaleSelect').html('');
                $.each(response, function (index, value) {
                    $('#brojSaleSelect').append($('<option/>', {
                        value: value,
                        text: value
                    }));
                });
            }, error: function () {

            }
        });
    });


</script>
