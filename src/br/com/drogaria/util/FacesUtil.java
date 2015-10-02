package br.com.drogaria.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	
	public static void adicionarMensagemInfo(String msg) {
		FacesMessage facesMensagens = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		facesContext.addMessage(null, facesMensagens);
		
	}
	
	public static void adicionarMensagemErro(String msg) {
		FacesMessage facesMensagens = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		facesContext.addMessage(null, facesMensagens);
	}
}
