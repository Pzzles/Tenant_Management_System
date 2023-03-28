<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up Form </title>

         Font Icon 
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">

         Main css 
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        
        
        
          JS 
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">

    <script type="text/javascript">
        var status = document.getElementById("status").value;
        if (status == "success") {
            swal("Congratulations", "Account Created Successfully.", "success");
        }
    </script>

    </body>
</html>