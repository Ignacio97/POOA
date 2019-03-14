package com.simulacion.ecosistema.hulk.code.server;

import java.io.Serializable;

public enum MessageType implements Serializable{
		
	GAME,
	LOG_IN_REQUEST,SIGN_IN_REQUEST,
	SIGN_IN_REJECTED,LOG_IN_REJECTED,
	SIGN_IN_APPROVED,LOG_IN_APPROVED
	
}
