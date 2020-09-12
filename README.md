# card-deck-challenge

## Setup
### Prerequisites

#### Supported Platforms

`drun` (Docker Run) is a light-weight utility I created for relaying arbritary commands into a short-lived docker container. Here it is primarily used for the mangement and distribution of a consistent portable isolated build environment. Currently only supported on the following platforms:

- Linux (most flavors, only tested on Centos7,Ubuntu14.04)
- OSX (10.10+)

Note: If running on an unsupported platform you will need to fallback to native utils, i.e the host installed `mvn`, `java`,....
  
#### Download/Install
* [Docker Engine](https://docs.docker.com/engine/install)
** docker daemon must be running!!
* Included a helper installation script to install `drun`, run:
```
./scripts/global/helper/install_drun.sh 
```

## Usage 

`drun` is a utility for providing consistent execution environments. Currently the options for configuring the execution environment are strictly limited to docker image specification, volume mounts, and configuring the working directory once a container is launched. It can easily be expanded for configuring networking and other options available through `docker run`.  All of this is configured through `drun.{$OS}.properties` you can see in the root of the workspace. A project can have multiple execution environments, limited to one per working directory. Simply drop properties file in subdirectory and configure the props file. `drun` will find nearest match from execution point so be sure to switch to that directory before execution.

Try it out:
```
$ drun java -version
```

### Building

For any maven command you would expect to run natively, you can expect to pass through to the exeuction environment:

##### Compile
```
$ drun mvn compile
```

##### Test

The proofs for `shuffle()` and `dealOneCard()` are in the few test cases I've included for the `Deck` class, and can be executed like: 
```
$ drun mvn test
```

##### Package
```
$ drun mvn package
```




