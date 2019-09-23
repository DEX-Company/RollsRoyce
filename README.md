# Ocean Protocol Demonstration: Rolls-Royce Blockchain Innovation Challenge 

- Slide Deck (https://drive.google.com/open?id=1IzOo0RbE8SSPnG8O8Y-HL483AE2nXYBk)

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

`http://localhost:8080/`

