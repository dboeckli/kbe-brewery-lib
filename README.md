# kbe-brewery-lib

Pure Maven **library** project (`packaging=jar`, Spring Boot parent `4.1.1`, Java 25) that shares
DTOs and domain events across the kbe modules. There is no Spring Boot application, no main class,
and no Docker/Helm/K8s setup — this module only publishes reusable artifacts to GitHub Packages
(`maven.pkg.github.com`, `ch.dboeckli.springframeworkguru.kbe.lib:kbe-brewery-lib`).

## Contents

- **DTOs** (`ch.guru.springframework.kbe.lib.dto`): `BeerDto`, `BeerInventoryDto`, `BeerOrderDto`,
  `CustomerDto`, paged lists (`BeerPagedList`, `BeerOrderPagedList`, `CustomerPagedList`) and enums
  (`BeerStyleEnum`, `OrderStatusUpdate`)
- **Domain events** (`ch.guru.springframework.kbe.lib.events`): `BeerEvent`, `NewBeerOrderEvent`,
  `BrewBeerEvent`, `AllocationFailureEvent`, `NewInventoryEvent`, `AllocateBeerOrderRequest`/`Result`
  and the validation/allocation request/result types

## Requirements

- Java 25 (enforced by the maven-enforcer plugin)
- Maven 3.9+ (`./mvnw` wrapper included)

## Build & Test

```bash
./mvnw clean verify    # full build: format check (validate) + unit (*Test) + IT (*IT) tests
./mvnw test            # unit tests only (surefire, *Test)
./mvnw test -Dtest=BeerDtoTest#methodName   # single test method
./mvnw install         # install the jar into the local repo
./mvnw deploy          # publish to GitHub Packages (needs a PAT in ~/.m2/settings.xml)
./mvnw spotless:apply  # auto-fix pom/markdown/json/yaml/shell formatting
./mvnw spring-javaformat:apply             # auto-fix Java code style
```

> Formatting is enforced at build time and fails the `validate` phase. Run `spotless:apply` and
> `spring-javaformat:apply` if the build fails.

## Sandbox (local dev environment)

The sandbox is provisioned by the opencode-sandbox-kit and runs as a Docker container. It mounts
this repo, starts opencode, and connects the IntelliJ MCP server.

### Start the sandbox (opencode-sandbox-kit)

Allow the kit source (GitHub without cloning):

```powershell
sbx settings set kit.allowedSources --% "[\"docker.io/\",\"github.com/dboeckli/\"]"
```

Start a new sandbox:

```powershell
sbx run opencode --name kbe-brewery-lib --kit "git+https://github.com/dboeckli/opencode-sandbox-kit.git#dir=opencode-agent" "C:\development\projects\kbe-brewery-lib"
```

Apply the kit to an existing sandbox (restarts the sandbox, VM state is kept):

```powershell
sbx kit add kbe-brewery-lib "git+https://github.com/dboeckli/opencode-sandbox-kit.git#dir=opencode-agent"
```

