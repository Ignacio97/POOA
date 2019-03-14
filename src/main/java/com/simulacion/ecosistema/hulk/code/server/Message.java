package com.simulacion.ecosistema.hulk.code.server;

import java.io.Serializable;

public class Message<T> implements Serializable{
	
	private MessageType type;
	private T  value;

	public Message(MessageType type, T value) {
		this.type = type;
		this.value = value;
	}

	public Message(MessageType type) {
		this(type,null);
	}
	

	public MessageType getType() {
		return type;
	}



	public T getValue() {
		return value;
	}
	
	
		 
		 
	}
	
	

