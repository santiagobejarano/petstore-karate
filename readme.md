# 📘 Proyecto de Automatización de API con Karate - PetStore

Este proyecto implementa pruebas automatizadas para la API pública de **PetStore** usando **Karate Framework**. Incluye ejecución de pruebas con **Gradle**, soporte para **JUnit5**, y generación de **reportes HTML profesionales** mediante **Masterthought Cucumber Reports**.

---

## ✅ 1. Prerrequisitos

Antes de ejecutar el proyecto asegúrate de tener instalado y configurado lo siguiente en tu máquina local:

- **Sistema operativo:** Windows 10 (probado en Windows, pero también funciona en Linux/Mac).
- **IDE recomendado:** IntelliJ IDEA (versión 2023.1 o superior).
- **Gradle:** versión 7.6.1 (no necesitas instalarlo manualmente si usas el wrapper `./gradlew`).
- **JDK:** versión 11 o 17 (configurada en la variable de entorno `JAVA_HOME`).
- **Conexión a Internet:** necesaria para descargar dependencias desde Maven Central.

---

## ⚙️ 2. Instalación de dependencias

Dentro del directorio del proyecto ejecuta:

```bash
# Descarga todas las dependencias
./gradlew clean build --refresh-dependencies
```

Esto descargará:
- **Karate Framework** (v1.4.1)
- **Masterthought Cucumber Reporting** (v5.7.4)
- **Apache Commons IO** (para manejo de archivos)

---

## ▶️ 3. Ejecución de las pruebas

### Comando principal
Ejecuta las pruebas con:

```bash
./gradlew test
```

### Escenarios cubiertos
Las pruebas verifican el flujo completo sobre la API **PetStore**:

1. **Añadir una mascota a la tienda** → `POST /pet`
2. **Consultar la mascota ingresada (por ID)** → `GET /pet/{id}`
3. **Actualizar el nombre y estatus de la mascota a `sold`** → `PUT /pet`
4. **Consultar la mascota modificada por estatus** → `GET /pet/findByStatus`
5. **Eliminar mascota** → `DELETE /pet/{id}`

### Ubicación de archivos clave
- **Features:** `src/test/resources/features/petstore.feature`
- **Datos JSON:** `src/test/resources/data/new-pet.json`
- **Runner principal:** `src/test/java/com/santiago/runners/PetStoreRunner.java`
- **Reporte avanzado:** `src/test/java/com/santiago/runners/ManagementTest.java`

---

## 📊 4. Reportes generados

Tras ejecutar las pruebas, se generan automáticamente **reportes HTML** en:

```
build/cucumber-html-reports/
```

### Archivos principales del reporte
- `overview-features.html` → Resumen general de todas las features.
- `overview-failures.html` → Detalles de fallos (si los hubiera).
- `overview-steps.html` → Resumen de todos los pasos.
- `overview-tags.html` → Resumen agrupado por tags.
- `report-feature_xxxxxx.html` → Reporte detallado de cada feature.

### Cómo abrirlos
Abre en tu navegador el archivo principal:
```
build/cucumber-html-reports/overview-features.html
```

Verás un dashboard con:
- ✅ Estadísticas generales
- 📈 Gráficos de éxito/fallo
- 🔍 Detalles por escenario
- 🕒 Tiempo de ejecución
- 📂 Clasificaciones (ej: Platform: Windows, Branch: main)

---

## ℹ️ 5. Información adicional

- El archivo `karate-config.js` gestiona la configuración global del proyecto, como la URL base (`https://petstore.swagger.io/v2`).
- Las pruebas están organizadas siguiendo buenas prácticas de automatización: separación de **features**, **datos**, y **runners**.
- El reporte se genera automáticamente al ejecutar `./gradlew test`, por lo que no requiere pasos adicionales.

---

👨‍💻 Autor: **Santiago Bejarano**  
📅 Fecha: Septiembre 2025
