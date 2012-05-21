package com.smx.server;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.smx.GreetingService;
import com.smx.GreetingService.Processor;
import com.smx.GreetingServiceHandler;

public class Server {

	public static void main(String[] args) throws TTransportException {
		
		Args serverArgs = new Args(new TServerSocket(8080));
		serverArgs.processor(new Processor<GreetingService.Iface>(new GreetingServiceHandler()));
		serverArgs.transportFactory(new TFramedTransport.Factory());
		serverArgs.protocolFactory(new TBinaryProtocol.Factory());
		
		TSimpleServer tSimpleServer = new TSimpleServer(serverArgs);
		tSimpleServer.serve();
		
		
	}
}
