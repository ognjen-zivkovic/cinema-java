<%-- 
    Document   : adminFilmHeadLinks
    Created on : Jun 25, 2020, 10:02:42 PM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="css/adminPanel.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/main.css">   
<link href="css/toastr.css" rel="stylesheet"/>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://use.fontawesome.com/37ac8fd460.js"></script>    

<style>
    div.gallery {
        margin: 5px;
        border: 1px solid #ccc;
        float: left;
        width: 180px;
        position: relative;

    }

    div.gallery:hover {
        border: 1px solid #777;
    }

    div.gallery img {
        width: 100%;
        height: auto;
        display: block;
    }

    .minus{
        position: absolute !important;
        left: 90% !important;
        bottom:82% !important;
        font-size: 27px !important;
        color: red;

    }
    .modal-body{
        min-height: 30vh;
        display: flow-root;
    }
    #image{
        margin-top: 60px;
        margin-bottom: -15px;
    }
</style>



