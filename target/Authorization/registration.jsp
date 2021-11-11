<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>

<h1>Post request</h1>


    <form action='registration' method='post'>
        <label>
            <input type='text' name='username'/>
        </label>
        <br><br>
        <label>
            <input type='password' name='password'/>
        </label>
        <br><br>
        <input type='submit' name='sign up'/>
    </form>

    <h1>Get request</h1>

    <form action='registration' method='get'>
        <label>
            <input type='text' name='username'/>
        </label>
        <br><br>
        <label>
            <input type='password' name='password'/>
        </label>
        <br><br>
        <input type='submit' name='sign up'/>
    </form>

</body>
</html>