#!/usr/bin/env python

import sys
sys.path.append('gen-py')

from com.smx import GreetingService

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol   

 
# Talk to a server via TCP sockets, using a binary protocol
transport = TSocket.TSocket("localhost", 8080)
transport = TTransport.TFramedTransport(transport)
protocol = TBinaryProtocol.TBinaryProtocol(transport)
    
# Use the service we already defined
service = GreetingService.Client(protocol)
transport.open()


result = service.sayHello("Diegooo")
print result
