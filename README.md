# Ocean Protocol Demonstration

This repo provides a demonstration of DEX / Ocean Protocol technology using:

- The DEP Standards (https://github.com/DEX-Company/DEPs)
- The Starfish client library for Clojure (https://github.com/DEX-Company/starfish-clj)
- The Surfer Agent (https://github.com/DEX-Company/surfer)

This combination of tools enables the assembly of flexible Data Supply Lines, allowing the
exchange and processing of Data Assets between collaborating organisations.

## Server Setup

This demo requires a running instance of Surfer.

Please follow the instructions in the Surfer repository to install and run a surfer instance
in your environment.

We recommend running surfer locally in server mode. This requires Apache Maven. Once installed, 
surfer can be launched with the following Maven command.

`mvn exec:java`

The surfer server process can be stopped and restarted safely. When running, it is possible to
inspect and interact with the Surfer APIs at the following URL:

`http://localhost:8080/api-docs/index.html`

The default username is "Aladdin" with password "OpenSesame". It is recommended to
change this default before deploying on a public server.


## Interactive REPL Setup

The file `src/main/clojure/rollsroyce/demo.clj` contains example code for working with data assets and services.
This represent the kind of instructions a data scientist or analyst might execute while
working with data.

These commands can be executed at an interactive Clojure REPL 
(see: https://clojure.org/guides/repl/introduction)

Business users would not usually use such an interface directly, instead they would use GUI tools

- The DEX Admiral user interface (currently in development) provides a comprehensive interactive
GUI workbench for managing data assets and services
- A user-friendly Web GUI can easily be created to support a specific use cases

