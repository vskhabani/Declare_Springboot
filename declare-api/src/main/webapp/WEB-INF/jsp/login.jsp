<html>
<head>
</head>
<body>
<p style="color: red">${errorMessage}</p>
<form action="/login" method="POST">
        Email : <input name="mail" type="email" /> <br>
        
        Password : <input name="password" required type="password" /> <br>
        
        Re Enter Password: <input name="password1" required type="password" />
        <br>
        First Name: <input name="fname" type="text" />
        <br>
        Last Name: <input name="lname" type="text" />
        <br>
        
        
        
        <input type="submit" />
    </form>

</body>
</html>