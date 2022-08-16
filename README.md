# LMS (1.o)
System that can decentralise manage devices in WIFI local network.

The system is based on the communication of computers in a local network. Each computer has a server and a client. And at the same time it can receive and send requests.

# ModelAPI
The communication in system is defined by the ModelAPI, which is a list of commands that obeys the protocol. Realisation of commands is custom.

Messages are divided into messages from the sender and replies from the recipient.

Each message contains the execution status, and the recipient's response is also a tape, which is the result of communication.

The ModelAPI is fully customizable and easily modifiable. You must add your own commands in addition to the standard ones provided.

# Current problems
* The system does not yet check whether the computers included in the system have run the program, so be careful and run the program on all computers.

* Also, the system is not yet thread-safe. If two computers want the same resource at the same time, then you will need to synchronize it through the ModelAPI.

* All computers should use same port which is defined in MessageSenderManager
