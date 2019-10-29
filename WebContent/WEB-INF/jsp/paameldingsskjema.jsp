<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<!-- Egen css for infobox og hover -->
<link rel = "stylesheet" type = "text/css" href = "infobox.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned" onsubmit="return confirmSubmit()">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="inputFornavn" type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<font color="red">${skjema.fMelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="inputEtternavn" type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<font color="red">${skjema.eMelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="inputMobil" type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<font id="feilMobil" color="red">${skjema.mMelding}</font>
			</div>
			<div class="tooltip">
				<div class="pure-control-group">
				<label for="password">Passord:</label> <input id="inputPassord" type="password"
					name="passord" value="${skjema.passord}" />
					<font color="red">${skjema.pMelding}</font>
			</div><span class="tooltiptext">Passordene blir vurdert på følgende måte:

				<font color="red">Svakt</font> - Mindre enn 8 tegn
				<font color="yellow">Middels</font> - 8 tegn eller mer som inneholder bokstaver eller tall
				<font color="green">Sterkt</font> - 8 tegn eller mer som inneholder store bokstaver, små bokstaver og tall
			</span>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="inputPassordRep"
					type="password" name="passordRepetert"
					value="${skjema.passordRep}" /> 
					<font color="red">${skjema.prMelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> <input id="inputKjonn" type="radio" name="kjonn"
					value="mann" ${skjema.mChecked}
					 />mann
				<input type="radio" name="kjonn" value="kvinne" ${skjema.kChecked}
					 />kvinne
				<font color="red">${skjema.kMelding}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	<p>
		Har du allerede meldt deg på? <a href="LogginnServlet">Klikk her</a>.
	</p>
	<script type="text/javascript" src="validering.js" defer></script>
</body>
</html>