<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/datepicker3.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <!--Custom Font-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
<br>
<br>
<br>
<br>
<br>
<div class="row">
    <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">Login</div>
            <div class="panel-body">
                <form action="/login" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    <fieldset>
                        <div class="form-group">
                            <input class="form-control" placeholder="Usuario" name="username" id="username" type="text"
                                   autofocus="">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Contraseña" name="password" id="password" type="password"
                                   value="">
                        </div>
                    </fieldset>
                    <div>
                        <button type="submit" class="btn btn-primary" name="submit" id="submit">Ingresar</button>
                    </div>
                </form>
            </div>
        </div>
    </div><!-- /.col-->
</div><!-- /.row -->
<#include "footer.ftl">