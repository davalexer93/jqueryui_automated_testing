# jQuery UI Automated Testing

Este proyecto contiene una suite de automatización de pruebas funcionales para la demo del datepicker de jQuery UI, implementada con Java, Cucumber, Serenity BDD y el patrón Screenplay. El objetivo es validar escenarios de interacción con componentes de calendario de forma legible, mantenible y escalable.

## Descripción general

La automatización está enfocada en pruebas de aceptación sobre la interfaz de jQuery UI, cubriendo escenarios como abrir la página del datepicker, interactuar con los componentes de mes/año y seleccionar fechas específicas. La implementación separa claramente la definición de escenarios, las acciones del usuario y la identificación de elementos de la interfaz.

## Arquitectura del proyecto

La arquitectura está organizada en capas simples y coherentes con el patrón Screenplay:

```text
Features (Gherkin)
   ↓
Step Definitions (Cucumber)
   ↓
Tasks (acciones de negocio del usuario)
   ↓
Targets / UI Objects (localizadores y elementos de la página)
   ↓
Serenity BDD + WebDriver + Browser
```

Esta estructura permite mantener los escenarios de negocio en un nivel alto, mientras que las interacciones concretas con la UI quedan encapsuladas en componentes reutilizables.

## Estructura del proyecto

- `src/test/resources/features`: archivos `.feature` con los escenarios Gherkin.
- `src/test/java/stepdefinitions`: clases que traducen los pasos de Gherkin a acciones de Screenplay.
- `src/test/java/co/sqasa/task`: tareas reutilizables que representan acciones del usuario (abrir la página, seleccionar fechas, validar el calendario, etc.).
- `src/test/java/co/sqasa/ui`: objetos de interfaz y `Target` con los selectores de la página.
- `src/test/resources/serenity.conf`: configuración de Serenity.
- `.github/workflows/test_integration.yml`: flujo de integración continua.

## Prerrequisitos

- Java 18.0.2.1
- Instalación recomendada con SDKMAN:
  - `sdk install java 18.0.2.1-tem`

## Cómo ejecutar las pruebas



Comando principal:
- `gradle build sonar --info`

Resultado esperado:
- Se ejecutan las pruebas automatizadas.
- Se genera el reporte HTML de Serenity en `target/site/serenity`.

> En este proyecto, el pipeline de integración continua usa el mismo comando para ejecutar la validación completa, incluyendo pruebas y análisis estático.

## Ver el reporte HTML

Después de una ejecución, puedes abrir el reporte generado en tu navegador:
- `target/site/serenity/index.html`

También es posible descargar el artefacto generado por GitHub Actions desde el pipeline, donde se adjunta el directorio `target/site/serenity` con retención de 3 días.

## Decisiones de diseño

### Patrón Screenplay

El proyecto sigue el patrón Screenplay de Serenity para separar claramente las responsabilidades:
- `Step Definitions`: traducen los pasos de negocio a acciones ejecutables.
- `Tasks`: agrupan secuencias de acciones que representan flujos completos del usuario.
- `Targets`: encapsulan los localizadores de la interfaz, evitando que las tareas dependan directamente de XPath/CSS en múltiples puntos.

### Estrategia de mapeo de objetos

Se utiliza una estrategia basada en `Target` para el mapeo de elementos de la interfaz, con la siguiente separación:
- `Targets` en `co.sqasa.ui` para definir locators y mantener centralizada la referencia a los elementos.
- `Tasks` en `co.sqasa.task` para encapsular acciones y comportamientos reutilizables.
- `Step Definitions` como punto de entrada entre Gherkin y la capa de automatización.

Esto mejora la mantenibilidad del framework, facilita la reutilización de pasos y reduce el impacto de cambios en la UI.

## Integración continua

La integración continua está definida en `.github/workflows/test_integration.yml`.

### Disparadores del workflow

El pipeline se ejecuta cuando:
- se realiza un `push` a las ramas `main` o `master` y, adicionalmente, a ramas `feature/*`;
- se dispara manualmente mediante `workflow_dispatch`;
- se cumple la programación cron: viernes a las 15:00 UTC.

### Ejecución del pipeline

El workflow realiza lo siguiente:
- configura Java Temurin 18.0.2;
- ejecuta `gradle build sonar --info` para correr las pruebas y enviar el análisis a SonarCloud;
- ejecuta `gradle clean test --info` para la ejecución explícita de la suite;
- sube el reporte Serenity como artefacto de GitHub Actions con `actions/upload-artifact`, conservándolo durante 3 días.

### Análisis estático con SonarCloud

El escaneo estático de código se realiza en el pipeline mediante SonarCloud al ejecutar `gradle build sonar --info`. El resultado puede validarse en la sección `ANALYSIS` de la ejecución del paso correspondiente en GitHub Actions.

## Autor

- davalexer93