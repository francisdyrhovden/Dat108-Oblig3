package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;



public class ValidatorTest {

	//Kopierer over regex uttrykk fra Deltagerskjema klassen
	String fornavnRegex = "^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå -]{1,19}$";
	String etternavnRegex = "^[A-ZÆØÅ]{1}[A-ZÆØÅa-zæøå-]{1,19}$";
	String mobilRegex = "^[0-9]{8}$";
	String passordRegex = "^[A-ZÆØÅa-zæøå\\d]{8,}$";
	
	
	 @Test
	    public void fornavnCheck() {
		 assertFalse("per".matches(fornavnRegex));
		 assertFalse("P3r".matches(fornavnRegex));
		 assertFalse("Per$$".matches(fornavnRegex));
		 assertFalse("P".matches(fornavnRegex));
		 assertFalse("Pereeeeeeeeeeeeeeeeee".matches(fornavnRegex));
		 assertTrue("Per".matches(fornavnRegex));
		 assertTrue("Per-Arne".matches(fornavnRegex));
		 assertTrue("Per Arne".matches(fornavnRegex));
		 
	 }
	 
	 @Test
	    public void etternavnCheck() {
		 assertFalse("olsen".matches(etternavnRegex));
		 assertFalse("Olsen1".matches(etternavnRegex));
		 assertFalse("Olsen$$".matches(etternavnRegex));
		 assertFalse("O".matches(etternavnRegex));
		 assertFalse("Olseneeeeeeeeeeeeeeeeee".matches(etternavnRegex));
		 assertFalse("Olsen Pedersen".matches(etternavnRegex));
		 assertTrue("Olsen-Pedersen".matches(etternavnRegex));
		 assertTrue("Olsen".matches(etternavnRegex));
	 }
	 
	 @Test
	    public void mobilCheck() {
		 assertFalse("123456789".matches(mobilRegex));
		 assertFalse("1234567a".matches(mobilRegex));
		 assertFalse("1".matches(mobilRegex));
		 assertFalse("$1234567".matches(mobilRegex));
		 assertTrue("98989898".matches(mobilRegex));
	 }
	 
	 @Test
	    public void passordCheck() {
		 assertFalse("katt123".matches(passordRegex));
		 assertFalse("katt123&".matches(passordRegex));
		 assertFalse("katt 123".matches(passordRegex));
		 assertTrue("KATT1234".matches(passordRegex));
		 assertTrue("katt1234".matches(passordRegex));
	 }
	
}
