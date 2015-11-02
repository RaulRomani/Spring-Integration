package com.cjava.spring.util;

/**
 * Clase utilitaria para la aplicacion.
 * @author Jean Ramal Alvarez
 * @since 31 August 2012
 * @version 1.0
 *
 */

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtil {

	private WebUtil() {
	}

	public static void keepMessages() {
		getFacesContextCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);
	}

	/**
	 * Metodo que obtiene una instancia de FacesContext.
	 * 
	 * @return FacesContext.
	 * */
	public static FacesContext getFacesContextCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	/**
	 * Metodo que obtiene el request de la instancia de FacesContext.
	 * 
	 * @return HttpServletRequest.
	 * */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getFacesContextCurrentInstance()
				.getExternalContext().getRequest();
	}

	/**
	 * Metodo que obtiene el response de la instancia de FacesContext.
	 * 
	 * @return HttpServletResponse.
	 * */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getFacesContextCurrentInstance()
				.getExternalContext().getResponse();
	}

	/**
	 * Metodo que obtiene la direccion ip.
	 * 
	 * @return String.
	 * */
	public static String getRemoteAddr() {
		return ((HttpServletRequest) getFacesContextCurrentInstance()
				.getExternalContext().getRequest()).getRemoteAddr();
	}

	/**
	 * Metodo que obtiene la direccion ip.
	 * 
	 * @return String.
	 * */
	public static String getRemoteHost() {
		return ((HttpServletRequest) getFacesContextCurrentInstance()
				.getExternalContext().getRequest()).getRemoteHost();
	}

	/**
	 * Metodo que obtiene un objeto de la session.
	 * 
	 * @param objectName
	 *            nombre del objeto, tipo String.
	 * @return Object.
	 * 
	 * */
	public static Object getAttribute(String objectName) {
		return getRequest().getSession(false).getAttribute(objectName);
	}

	/**
	 * Metodo que elimina la sesion.
	 * */
	public static void invalidate() {
		((HttpSession) getFacesContextCurrentInstance().getExternalContext()
				.getSession(false)).invalidate();
	}

	/**
	 * Metodo que obtiene el mensaje en base al codigo.
	 * 
	 * @param key
	 *            codigo del mensaje, tipo String.
	 * @param args
	 *            argumentos , tipo String.
	 * @return mensaje.
	 * */
	public static String getMensaje(String key, String... args) {
		try {
			FacesContext context = getFacesContextCurrentInstance();
			ResourceBundle res = context.getApplication().getResourceBundle(
					context, "mensaje");
			MessageFormat format = new MessageFormat(
					(String) res.getObject(key));
			return format.format(args);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
