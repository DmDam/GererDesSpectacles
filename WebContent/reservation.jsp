<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container">
<div class="row">
<div class="col-lg-12" align="center">
		<fieldset>
			<legend>R�server un spectacle</legend>
			
			    <br />
                <label for="nom">Spectacle</label>
                <select name="spectacle">
                <option value="">bdd en attente</option>
                </select>
                <br />

				<br />
                <label for="nom">Nom </label>
                <input type="text" id="nom" name="nom" value="" size="40" maxlength="40" />
                <br />
                
                <br />
                <label for="nom">Prenom </label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="20" />
                <br />
                
                <br />
                <label for="email">Adresse email </label>
                <input type="text" id="email" name="email" value="" size="30" maxlength="30" />
                <br />
                
                <br />
                <input type="submit" value="R�server" class="sansLabel" />
                <br />
                
		</fieldset>
</div>
</div>
</div>

</body>
</html>