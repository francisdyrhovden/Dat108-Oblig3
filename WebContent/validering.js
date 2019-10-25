"use strict"
// Starte med stor bokstav, kan inneholde mellomrom og bindestrek, lengde 2 til 20
let fornavnReg = /^[A-ZÆØÅ]{1}[a-zæøå -]{1,19}$/u;

// Starte med stor bokstav, kan inneholde bindestrek, lengde 2 til 20
let etternavnReg = /^[A-ZÆØÅ]{1}[a-zæøå-]{1,19}$/u;

// eksakt 8 siffer
let mobilReg = /^[0-9]{8}$/;

// Må inneholde bokstaver eller tall, lengde minimum 8
let passordMiddelsReg = /^[A-ZÆØÅa-zæøå\d]{8,}$/u;

//Må inneholde en stor bokstav, liten bokstav, nummer, og har lengde minimum 8
let passordSterkReg = /^(?=.*[a-zæøå])(?=.*[A-ZÆØÅ])(?=.*\d)[a-zæøåA-ZÆØÅ\d]{8,}$/u;



let fornavnInput = document.getElementById("inputFornavn");
let etternavnInput = document.getElementById("inputEtternavn");
let mobilInput = document.getElementById("inputMobil");
let passordInput = document.getElementById("inputPassord");
let passordRepInput = document.getElementById("inputPassordRep");
let kjonnInput = document.getElementById("inputKjonn");


addEventListener("change", validerMobil);
addEventListener("change", validerFornavn);
addEventListener("change", validerEtternavn);
addEventListener("input", validerPassord);
addEventListener("input", validerPassordRep);

function validerFornavn() {
    let fornavn = fornavnInput.value;
    if (fornavnReg.test(fornavn)) {
        fornavnInput.setAttribute("style", "border-color: green");
    } else if (fornavn === "") {
        fornavnInput.setAttribute("style", "border-color: null")
    } else {
        fornavnInput.setAttribute("style", "border-color: red");
    }
}
function validerEtternavn() {
    let etternavn = etternavnInput.value;
    if (etternavnReg.test(etternavn)) {
        etternavnInput.setAttribute("style", "border-color: green");
    } else if (etternavn === "") {
        etternavnInput.setAttribute("style", "border-color: null")
    } else {
        etternavnInput.setAttribute("style", "border-color: red");
    }
}
function validerMobil() {
    let mobNr = mobilInput.value;
    if (mobilReg.test(mobNr)) {
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
        if (passordSterkReg.test(passord)){
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