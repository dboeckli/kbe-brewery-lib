# AGENTS.md

Pure Maven **library** project `kbe-brewery-lib` (`packaging=jar`, Spring Boot parent `4.1.1`) on
**Java 25** (enforced by the maven-enforcer plugin). No Spring Boot application, no main class, no
Docker/Helm/K8s — this module only publishes shared DTOs and domain events. Package
`ch.guru.springframework.kbe.lib`.

## Build & test commands

- Full build: `./mvnw clean verify` — runs the format checks (spring-javaformat + Spotless, validate
  phase) plus unit tests (`*Test`, surefire) and integration tests (`*IT`, failsafe).
- Unit tests only: `./mvnw test`. Single test: `./mvnw test -Dtest=BeerDtoTest#methodName`.
- `./mvnw install` installs the jar into the local repo. `./mvnw deploy` publishes it to GitHub
  Packages (`maven.pkg.github.com`, `distributionManagement`) and needs a PAT in `~/.m2/settings.xml`
  (server id `github`).
- `./mvnw validate` runs only the format checks (spring-javaformat + Spotless).

After changing code, always verify: run the relevant Maven goal above and report its output
(evidence, not just "done").

## Formatting is enforced (fails the `validate` phase)

- Java: Spring Java Format (`spring-javaformat-maven-plugin`, `validate` goal) → fix with
  `./mvnw spring-javaformat:apply`.
- pom.xml (`sortPom`), markdown (`**/*.md` except `AGENTS.md`/`CLAUDE.md`, flexmark), json (prettier,
  `.github/**` excluded), yaml (`application*.yaml`, prettier) and shell (`**/*.sh`, shfmt `3.13.1`):
  Spotless (`check` goal) → fix with `./mvnw spotless:apply`.
- Spotless flexmark also formats markdown, so `README.md` (and any other `.md`) edits must stay
  flexmark-clean; run `./mvnw spotless:apply` after editing markdown.

## Sandbox build quirk (background)

This sandbox mounts the repo via filesystem passthrough, which blocks symlinks — Spotless's
`npm install` (prettier, used for json/yaml) would fail with `EPERM` unless npm skips bin links. The
sandbox kit sets `npm_config_bin_links=false` globally (`spec.yaml` → `environment.variables`), so no
manual export is needed here. In this library Spotless's prettier path never runs (json is excluded
via `.github/**`, no `application*.yaml` files exist) and the shell step uses shfmt (a Go binary).

## Test conventions

- Naming matters: `*Test` = unit (surefire), `*IT` = integration (failsafe). Currently only
  `*Test` classes exist.

## Deploy / CI

- CI (`.github/workflows/`): `maven-build.yml` builds + deploys snapshots to GitHub Packages and
  runs SonarCloud analysis in the `analyze` job; `release.yml` runs
  `mvn release:prepare release:perform` on main/master only (version must be `-SNAPSHOT`).
- Dependency updates are managed via `.github/dependabot.yml` and `.github/renovate.json`; validate
  changes with `renovate-config-validator .github/renovate.json`.
