package com.skplanet.comet;

import javax.websocket.server.ServerEndpointConfig.Configurator;

public class ServerEndPointConfigurator extends Configurator {
	private static WebSocketEndpoint webSocket = new WebSocketEndpoint();

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEndpointInstance(Class<T> endpointClass) throws InstantiationException {
		return (T) webSocket;
	}
	
	
}
