"use strict"
// Må inneholde bokstaver eller tall, lengde minimum 8
let passordMiddelsReg = /^[A-ZÆØÅa-zæøå\d]{8,}$/;

// Må inneholde en stor bokstav, liten bokstav, nummer, og har lengde minimum 8
let passordSterkReg = /^(?=.*[a-zæøå])(?=.*[A-ZÆØÅ])(?=.*\d)[a-zæøåA-ZÆØÅ\d]{8,}$/;

let fornavnInput = document.getElementById("inputFornavn");
let etternavnInput = document.getElementById("inputEtternavn");
let mobilInput = document.getElementById("inputMobil");
let passordInput = document.getElementById("inputPassord");
let passordRepInput = document.getElementById("inputPassordRep");
let kjonnInput = document.getElementById("inputKjonn");

fornavnInput.addEventListener("change", validerFornavn);
etternavnInput.addEventListener("change", validerEtternavn);
mobilInput.addEventListener("change", validerMobil);
passordInput.addEventListener("input", validerPassord);
passordRepInput.addEventListener("input", validerPassordRep);

function validerFornavn() {
	let fornavn = fornavnInput.value;
	if (fornavn.length >= 2 && fornavn.length <= 20) {
		fornavnInput.setAttribute("style", "border-color: green");
	} else if (fornavn === "") {
		fornavnInput.setAttribute("style", "border-color: null")
	} else {
		fornavnInput.setAttribute("style", "border-color: red");
	}
}
function validerEtternavn() {
	let etternavn = etternavnInput.value;
	if (etternavn.length >= 2 && etternavn.length <= 20) {
		etternavnInput.setAttribute("style", "border-color: green");
	} else if (etternavn === "") {
		etternavnInput.setAttribute("style", "border-color: null")
	} else {
		etternavnInput.setAttribute("style", "border-color: red");
	}
}
function validerMobil() {
	let mobNr = mobilInput.value;
	if (mobil.length === 8) {
		mobilInput.setAttribute("style", "border-color: green");
	} else if (mobNr === "") {
		mobilInput.setAttribute("style", "border-color: null")
	} else {
		mobilInput.setAttribute("style", "border-color: red");
	}
}
function validerPassord() {
	let passord = passordInput.value;
	if (passordMiddelsReg.test(passord)) {
		if (passordSterkReg.test(passord)) {
			passordInput.setAttribute("style", "border-color: green");
		} else {
			passordInput.setAttribute("style", "border-color: yellow");
		}
	} else if (passord === "") {
		passordInput.setAttribute("style", "border-color: null")
	} else {
		passordInput.setAttribute("style", "border-color: red");
	}
}
function validerPassordRep() {
	let passordRep = passordRepInput.value;
	let passord = passordInput.value;
	if (passordRep === "") {
		passordRepInput.setAttribute("style", "border-color: null");
	} else if (passordRep === passord) {
		passordRepInput.setAttribute("style", "border-color: green");
	} else {
		passordRepInput.setAttribute("style", "border-color: red");
	}
}

function confirmSubmit() {
	if (confirm("Send info til tjener!")) {
		return true;
	} else {
		alert("Du trykket avbryt");
		return false;
	}
}