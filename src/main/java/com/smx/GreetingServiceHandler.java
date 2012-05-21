package com.smx;

import org.apache.thrift.TException;

import com.smx.GreetingService.Iface;

public class GreetingServiceHandler implements Iface {

	@Override
	public String sayHello(String name) throws TException {
		System.out.println("Say hello to " + name);
		return "Hello " + name;
	}

}
