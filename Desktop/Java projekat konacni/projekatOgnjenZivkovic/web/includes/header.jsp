<%-- 
    Document   : navbar
    Created on : Jun 4, 2020, 6:01:01 PM
    Author     : Ognjen Živković
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- header -->
<header class="header">
    <div class="header__wrap">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="header__content">
                        <!-- header logo -->
                        <a href="index" class="header__logo">
                            <img id="logo" src="img/logo.png" alt="">
                        </a>
                        <!-- end header logo -->


                        <!-- header nav -->
                        <ul class="header__nav">
                            <!-- dropdown -->
                            <li class="header__nav-item">
                                <a class="header__nav-link" href="index"  id="dropdownMenuHome" aria-expanded="false">Početna</a>
                            </li>
                            <!-- end dropdown -->
                            <!-- dropdown -->
                            <li class="header__nav-item">
                                <a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuCatalog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Članstvo</a>

                                <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuCatalog">
                                    <li><a href="KlubServlet?klubId=3">Porodični film klub</a></li>
                                    
                                </ul>
                            </li>
                            <!-- end dropdown -->

                            <c:if test="${korisnik != null}">


                                <!-- user profile tab -->
                                <li class="header__nav-item" style="left: 59%;">
                                    <a href="#" data-toggle="dropdown">
                                        <img src="img/userIcon.png" class="user-image">
                                        <span class="hidden-xs">${korisnik.ime} ${korisnik.prezime}</span>
                                    </a>
                                    <div style="width: 37vh;">
                                        <ul class="dropdown-menu" id="user" style="width: 100%;">
                                            <!-- User image -->
                                            <li class="user-header">
                                                <img src="img/logo.png" class="img-circle" alt="User Image">
                                                <br>
                                                <p>

                                                    ${korisnik.ime} ${korisnik.prezime}<br>
                                                    <small>Član od: ${korisnik.nalogNapravljen}</small>
                                                </p>
                                            </li>
                                            <div class="user-footer">
                                                <li>
                                                    <div class="pull-left">
                                                        <a href="korisnik_profil.jsp" class="btn btn-default btn-flat">Moj profil</a>
                                                    </div>
                                                    <div class="pull-right">
                                                        <a href="Logout" class="btn btn-default btn-flat">Odjavi se</a>
                                                    </div>
                                                </li>
                                            </div>
                                        </ul>
                                    </div>
                                </li>

                                <!-- end user profile tab -->
                            </c:if>

                        </ul>
                        <!-- end header nav -->

                        <!-- header auth -->
                        <div class="header__auth">
                          <!--  <button class="header__search-btn" type="button">
                                <ion-icon name="search-outline"></ion-icon>
                            </button>-->
                            <c:if test="${korisnik == null}">                                                         
                                <a href="" class="header__sign-in" data-toggle="modal" data-target="#LoginModalCenter">
                                    <i class="icon ion-ios-log-in"></i>
                                    <span>prijava</span>
                                </a>
                            </c:if>
                        </div>
                        <!-- end header auth -->

                        <!-- header menu btn -->
                        <button class="header__btn" type="button">
                            <span></span>
                            <span></span>
                            <span></span>
                        </button>
                        <!-- end header menu btn -->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- header search -->
    <form action="#" class="header__search">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="header__search-content">
                        <input type="text" placeholder="Pretraga">
                        <button type="button">pretraži</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- end header search -->







</header>
<!-- end header -->
