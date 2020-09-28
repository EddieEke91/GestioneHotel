<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Indice</title>


</head>
<body>
Gestione Hotel
 <br>
<br>
<br>
    <form action="insertSta" method="get">
    <label>  Inserisci Stanza.   </label> 
    	
  	N.Stanza= <input type="number" name="nStanza" style="width: 3em">

    	

	<input type="submit" value="INSERISCI" ><br>
    </form>


    <form action="selectSta" method="get">
    <label>  Seleziona Stanza.   </label> 
    	
	id = <input type="number" name="id" style="width: 3em">
	<input type="submit" value="CERCA" ><br>
    </form>
    
     <form action="updateSta" method="get">
    <label>  Modifica Stanza.   </label> 
    id = <input type="number" name="id" style="width: 3em">
	nuovo N.Stanza = <input type="number" name="nStanza" style="width: 3em">
	<input type="submit" value="MODIFICA" ><br>
    </form>
    
       <form action="deleteSta" method="get">
    <label>  Elimina Stanza.   </label> 
    	
	id = <input type="number" name="id" style="width: 3em">
	<input type="submit" value="ELIMINA" ><br>
    </form>
    <br>
<br>
<br>
  




</body>
</html>