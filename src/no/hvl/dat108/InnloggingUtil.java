package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {
	
	public static boolean erInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null;
	}
	
	public static void loggInn(HttpServletRequest request, Person person) {
		loggUt(request);
		HttpSession sesjon = request.getSession(true);
        request.getSession().setAttribute("fornavn", person.getFornavn());
        request.getSession().setAttribute("etternavn", person.getEtternavn());
        request.getSession().setAttribute("mobil", person.getMobil());
        request.getSession().setAttribute("passordhash", person.getPassordhash());
        request.getSession().setAttribute("passordsalt", person.getPassordsalt());
        request.getSession().setAttribute("kjonn", person.getKjonn());
	}
	
	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}
}
