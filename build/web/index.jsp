
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Popup Form | By Code Info</title>
        <link rel="stylesheet" href="style.css">

        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

            body{
                font-family: 'Poppins', sans-serif;
                background: linear-gradient(to right, #20002c,
                    #cbb4d4);
            }
            .show-btn{
                padding: 10px 20px;
                font-size: 20px;
                font-weight: 500;
                color: white;
                cursor: pointer;
                background: rgba(255, 255, 255, 0.25);
            }

            .show-btn{
                position: absolute;
                top: 45%;
                left: 30%;
                transform: translate(-50%, -50%);
            }

            input[type="checkbox"]{

                vertical-align: middle;
            }

            #show:checked ~ .container{
                display: block;
            }

            .container{
                display: none;
                width: 350px;
                padding: 20px;
                border-radius: 4px;
                background: rgba(255, 255, 255, 0.25);
                border: 1px solid rgba(255, 255, 255, 0.18);

            }
            .container{
                position: absolute;
                top: 50%;
                left: 60%;
                transform: translate(-50%, -50%)
            }
            .container .close-btn{
                position: absolute;
                right: 20px;
                top: 15px;
                font-size: 25px;
                cursor: pointer;
            }

            .close-btn:hover{
                color: red;
            }

            h1{
                text-align: center;
                color: white;
                text-transform: uppercase;
            }

            form{
                margin: 20px;
            }
            label{
                display: block;
                color: white;
                font-size: 18px;
                margin-top: 10px;
            }

            input{
                display: block;
                width: 90%;
                background: transparent;
                border: none;
                outline: none;
                border-bottom: 1px solid white;
                padding: 10px;
                color: white;
            }

            button{
                display: block;
                width: 95%;
                padding: 8px;
                border: none;
                outline: none;
                background: linear-gradient(to right, #cbb4d4, 
                    #20002c);
                color: white;
                font-size: 18px;
                cursor: pointer;
                margin-top: 20px;

            }

            a{
                text-decoration: none;
                color: #20002c;

            }

            .link{
                margin-top: 30px;
                text-align: center;
                color:white;
            }

            a:hover{
                text-decoration: underline;
            }

        </style>
        
    </head>
    <body>

        <input type="checkbox" id="show" style="display: none">
        <label for="show" class="show-btn">View Form</label>


        <div class="container">
            <label for="show" class="close-btn" title="close">×</label>
            <h1>Welcome</h1>
            <form method="post" action="LoginServlet">
                <div>
                    <label for="adminCheck" style="word-wrap: break-word">
                        <input id="adminCheck" type="checkbox" name="adminCheck" value="checked" />Admin Login
                    </label>

                </div>
                <div class="txt_field">
                    <label>Username</label>
                    <input type="email" name="Email" required/>
                </div>
                <div class="txt_field">
                    <label>Password</label>
                    <input type="text" name="password" required/>
                </div>
                <a href="#">Forgot Password?</a>
                <button type="submit" name="login" value="Login">Login</button>
                <div class="signup_link">
                    Not registered? <a href="RegisterServlet">Register</a>
                </div>
                <closeform>

                </closeform>
            </form>
        </div>
    </body>
</html>
