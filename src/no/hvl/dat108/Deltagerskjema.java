package no.hvl.dat108;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

public class Deltagerskjema {

	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passordRep;
	private String kjonn;

	private String fMelding;
	private String eMelding;
	private String mMelding;
	private String pMelding;
	private String prMelding;
	private String kMelding;
	private String mChecked;
	private String kChecked;
	
	public Deltagerskjema() {
	}

	public Deltagerskjema(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passordRep = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}

	public Person nyPersonMedHash() {
		return null;
	}
	
	public Person nyPerson() {
		Hashing hashing = new Hashing("SHA-256");
		byte[] salt = hashing.getSalt();
		
		try {
			hashing.generateHashWithSalt(passord, salt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new Person(mobil,fornavn,etternavn,hashing.getPasswordHashinHex(),hashing.getPasswordSalt(),kjonn);
	}

	public void feilmeldinger() {

		if (!validFornavn()) {
			fornavn = "";
			fMelding = "Ugyldig fornavn";
		}
		if (!validEtternavn()) {
			etternavn = "";
			eMelding = "Ugyldig etternavn";
		}
		if (!validMobil()) {
			mobil = "";
			mMelding = "Ugyldig mobil";
		}
		if (!validPassord()) {
			passord = "";
			pMelding = "Ugyldig passord";
		}
		if (!validPassordRep()) {
			passordRep = "";
			prMelding = "Passordene må være like";
		}
		if (!validKjonn()) {
			kjonn = "";
			kMelding = "Du må oppgi kjønn";
		}
	}

	public void checker() {
		if (kjonn != null) {
			if (kjonn.equals("mann")) {
				mChecked = "checked";
			} else {
				kChecked = "checked";
			}
		}
	}

	public boolean validFornavn() {
		return fornavn.matches("^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå -]{1,19}$");
	}

	public boolean validEtternavn() {
		return etternavn.matches("^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå-]{1,19}$");
	}

	public boolean validMobil() {
		return mobil.matches("^[0-9]{8}$");
	}

	public boolean validPassord() {
		return passord.matches("^[A-ZÆØÅa-zæøå\\d]{8,}$");
	}

	public boolean validPassordRep() {
		return passordRep.equals(passord);
	}

	public boolean validKjonn() {
		if (kjonn != null) {
			checker();
			return true;
		} else {
			return false;
		}
	}

	public boolean validSkjema() {
		return validFornavn() && validEtternavn() && validMobil() && validPassord() && validPassordRep()
				&& validKjonn();
	}

	public String getFornavn() {
		return fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPassord() {
		return passord;
	}

	public String getPassordRep() {
		return passordRep;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getfMelding() {
		return fMelding;
	}

	public String geteMelding() {
		return eMelding;
	}

	public String getmMelding() {
		return mMelding;
	}

	public String getpMelding() {
		return pMelding;
	}

	public String getPrMelding() {
		return prMelding;
	}

	public String getkMelding() {
		return kMelding;
	}

	public String getmChecked() {
		return mChecked;
	}

	public String getkChecked() {
		return kChecked;
	}
}
