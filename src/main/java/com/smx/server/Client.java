package com.smx.server;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

import com.smx.GreetingService;

public class Client {

	public static void main(String[] args) throws TException {
		TSocket socket = new TSocket("127.0.0.1", 8080);
		socket.setTimeout(6000);
		TFramedTransport transport = new TFramedTransport(socket);
		transport.open();
		TProtocol protocol = new TJSONProtocol(transport);
		
		com.smx.GreetingService.Client client = new GreetingService.Client(protocol);
		String sayHello = client.sayHello("Pibitaaa");
		System.out.println(sayHello);
		
	}
}
