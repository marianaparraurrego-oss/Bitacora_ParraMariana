
## 1. Arquitectura & Patrones de Diseño
###  Categorías Fundamentales
| Tipo | Propósito | Patrones Clave |
|------|-----------|----------------|
| **Creacionales** | Controlar la creación de objetos | `Singleton`, `Factory Method`, `Abstract Factory`, `Builder`, `Prototype` |
| **Estructurales** | Componer clases/objetos en estructuras mayores | `Adapter`, `Decorator`, `Facade`, `Proxy`, `Composite`, `Flyweight` |
| **Comportamiento** | Gestionar comunicación y responsabilidades | `Strategy`, `Observer`, `Command`, `Template Method`, `State`, `Chain of Responsibility` |

### ¿Cómo saber cuál usar? (Guía de Diagnóstico)
| Problema / Síntoma en el Código | Patrón Recomendado | Indicador Clave | Ejemplo en Spring |
|--------------------------------|-------------------|-----------------|-------------------|
| Necesito una única instancia global (config, conexión) | `Singleton` | `private static` + constructor privado | `@Configuration` (beans son singletons por defecto) |
| Creación compleja con muchos parámetros opcionales | `Builder` | Constructor telescópico o setters encadenados | Lombok `@Builder`, `StringBuilder` |
| Mismo contrato, diferentes implementaciones intercambiables | `Strategy` | `if/else` o `switch` gigantes por tipo de algoritmo | `PasswordEncoder` (`BCrypt`, `Argon2`) |
| Necesito añadir funcionalidad sin modificar clase original | `Decorator` | Clases que envuelven otras y extienden comportamiento | `HttpServletRequestWrapper`, filtros HTTP |
| Ocultar subsistema complejo tras interfaz simple | `Facade` | Cliente llama a 5+ clases para una sola operación | `@RestController` que orquesta Service→Repo→Mapper |
| Adaptar interfaz incompatible | `Adapter` | Métodos con nombres distintos pero misma lógica | Spring `MessageConverter`, `WebMvcConfigurer` |
| Ejecutar acciones diferidas o reversibles | `Command` | Necesitas undo/redo, colas de tareas, logs de operación | `@EventListener`, `TransactionTemplate` |
| Notificar múltiples objetos de un cambio | `Observer` | Listeners, callbacks manuales, polling ineficiente | `ApplicationEventPublisher`, `@EventListener` |
| Procesar petición por múltiples pasos en cadena | `Chain of Responsibility` | Validaciones secuenciales, middlewares | Spring `HandlerInterceptor`, `FilterChain` |

>  **Regla de Examen:** Si te piden "elegir patrón", identifica el **problema de diseño** (acoplamiento, rigidez, duplicación, creación compleja) y mapea al patrón que lo resuelve. Nunca elijas por "sonido técnico", elige por **intención**.

---

## 2. TDD & Principios SOLID (DIP)
###  TDD (Test-Driven Development)
- **Ciclo:** 🔴 **Red** (escribir prueba que falla) → 🟢 **Green** (código mínimo que pasa) → 🔵 **Refactor** (mejorar sin romper).
- **Principios FIRST:** `F`ast, `I`ndependent, `R`epeatable, `S`elf-validating, `T`imely.
- **Ventajas:** Diseño emergente, cobertura real, documentación ejecutable, menos deuda técnica.
- **Anti-patrones:** Tests acoplados a implementación, mocks excesivos, probar frameworks en vez de lógica.

###  Principio de Inversión de Dependencias (DIP)
- **Definición:** Módulos de alto nivel **NO** deben depender de bajo nivel. Ambos deben depender de **abstracciones**. Las abstracciones no deben depender de detalles; los detalles deben depender de abstracciones.
- **Ejemplo:**
  ```java
  //  Mal: Alto nivel depende de bajo nivel
  class PedidoService {
      private MySQLRepository repo = new MySQLRepository();
  }
  //  Bien: Ambos dependen de interfaz
  interface RepositorioPedidos { void guardar(Pedido p); }
  class PedidoService { 
      private final RepositorioPedidos repo; 
      public PedidoService(RepositorioPedidos repo) { this.repo = repo; } 
  }

🆚 DIP vs IoC vs DI:
DIP: Principio arquitectónico (SOLID).
IoC: Patrón donde el framework controla el flujo de ejecución.
DI: Mecanismo práctico de IoC (inyección por constructor/setter/campo).
3. Inversión de Control (IoC) & Spring Framework
   🌱 Spring como Contenedor IoC
   Contenedor: Gestiona ciclo de vida de beans (@Component, @Service, etc.).
   Autoconfiguración: Spring Boot escanea classpath y configura beans automáticamente (spring.factories / META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports).
   @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan.
   📦 Ciclo de Vida de un Bean
   Instanciación → 2. Inyección de dependencias → 3. @PostConstruct → 4. Uso → 5. @PreDestroy → 6. Destrucción.
   Scopes: singleton (default), prototype (nueva instancia por request), request, session, application.
4. MVC & Flujo de Peticiones
   Model: Lógica de negocio + persistencia (@Service, @Repository, Entidades).
   View: Representación (JSON en APIs, Thymeleaf en web tradicional).
   Controller: Coordina, valida, delega y retorna response (@RestController).
   Flujo Spring MVC:
   DispatcherServlet → HandlerMapping → @Controller → @Service → @Repository → DB → HttpMessageConverter → JSON/XML → Cliente.
5. Spring Boot: Anotaciones, Jerarquías & Lombok
   🏷️ Jerarquía de Stereotipos
   1234
   🛠️ Project Lombok
   @Data → @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
   @Builder, @Slf4j, @NoArgsConstructor, @AllArgsConstructor, @NonNull
   ⚠️ Advertencia JPA: @Data en @Entity genera equals/hashCode por campos. Si cambian, rompe Set/HashMap de Hibernate. Usa @EqualsAndHashCode(onlyExplicitlyIncluded = true) o basado en @Id.
6. APIs REST: Idempotencia, Versionamiento & Documentación
   🌐 Idempotencia & Métodos HTTP
   Método
   Idempotente
   Seguro
   

   GET idempotente
   Recuperar sin efectos secundarios

   HEAD
   Metadatos de GET
   OPTIONS
   Descubrir capacidades

   PUT idempotente

   Reemplazar recurso completo (debe existir o crearlo)

   DELETE idempotente
   Eliminar (múltiples llamadas = mismo estado final)

   POST no idenmpotente
   
   Crear recurso nuevo o acción no idempotente

   PATCH no
   
   Modificación parcial (depende de implementación)
   🔑 En examen: PUT y DELETE son idempotentes. POST NO lo es. Esto es crítico para retries y carga balanceada.
   🔢 Versionamiento API & Semántico
   Estrategias: URI (/api/v1/users), Header (Accept: application/vnd.app.v2+json), Query (?v=2), Content Negotiation.
   SemVer: MAJOR.MINOR.PATCH
   MAJOR: Cambios incompatibles (rompe contratos)
   MINOR: Nuevas features compatibles (backward compatible)
   PATCH: Correcciones sin cambiar funcionalidad
   Deprecación: @Deprecated, headers Sunset, documentación clara, periodo de transición ≥ 6 meses.
   📖 Swagger UI & OpenAPI 3.x
   OpenAPI: Especificación YAML/JSON del contrato.
   SpringDoc: springdoc-openapi-starter-webmvc-ui
   Anotaciones clave: @Operation(summary), @ApiResponse(code, content), @Schema(example), @Tag
   Endpoint UI: /swagger-ui.html | JSON: /v3/api-docs
7. DTOs, Records, Enums & MapStruct
   📦 DTOs vs Entidades
   Nunca exponer @Entity en API. Usa DTOs para:
   Ocultar campos sensibles (password, internalId)
   Reducir payload (no serializar relaciones Lazy)
   Validar reglas de negocio distintas a persistencia
   🧊 Java Records (Java 14+)
   Inmutables por diseño, equals/hashCode/toString automáticos.
   Ideales para DTOs, respuestas API, configuración.
   public record UsuarioDTO(Long id, String email, Rol rol) {}
   🔢 Enums
   Valores fijos y seguros. Usar @Enumerated(EnumType.STRING) en JPA (mejor que ORDINAL para refactor).
   🗺️ MapStruct
   Mapeo en tiempo de compilación (sin reflexión en runtime → más rápido y seguro).
   @Mapper(componentModel = "spring")
   @Mapping(target = "campoDestino", source = "campoOrigen")
   Genera implementación automática en target/generated-sources/annotations.
8. Manejo de Errores (Spring MVC & Boot)
   🛡️ @ControllerAdvice + @ExceptionHandler
   java
   123456789101112131415
   ✅ Retornar 4xx para errores cliente, 5xx para servidor.
   ✅ Nunca exponer stacktrace en producción.
   ✅ Usar formato estandarizado (RFC 7807 Problem Details recomendado).
   -2xx
   Éxito
   200 OK, 201 Created, 204 No Content
   Operación completada correctamente

   -4xx
   Error del Cliente
   400 Bad Request (sintaxis/validación)
   401 Unauthorized (no autenticado)
   403 Forbidden (sin permisos)
   404 Not Found (recurso inexistente)
   405 Method Not Allowed
   409 Conflict (estado incompatible)
   422 Unprocessable Entity (validación semántica)
   El cliente envió datos inválidos, falta auth, recurso no existe o acción prohibida

   -5xx
   Error del Servidor
   500 Internal Server Error (fallo inesperado)
   502 Bad Gateway (respuesta inválida de upstream)
   503 Service Unavailable (sobrecarga/mantenimiento)
   504 Gateway Timeout
   Fallo interno del servidor, dependencias caídas, mantenimiento planificado
9. Seguridad Web: CSRF, XSS, Clickjacking, DoS & OWASP Top 10
   Ataque
   Mecanismo
   Mitigación en Spring/HTTP
   CSRF
   Ataque cruzado usa sesión autenticada para ejecutar acciones no deseadas
   Tokens CSRF (csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())), SameSite=Strict/Lax en cookies, métodos GET sin estado
   XSS
   Inyección de scripts ejecutados en navegador de víctima
   Escape de salida, CSP (default-src 'self'), HttpOnly + Secure en cookies, sanitización de inputs
   Clickjacking
   UI redressing via iframes invisibles
   X-Frame-Options: DENY o SAMEORIGIN, CSP frame-ancestors 'none'
   DoS/DDoS
   Saturación de CPU, memoria, conexiones o ancho de banda
   Rate limiting (Bucket4j, Redis), timeouts, WAF, CDN, escalado horizontal, circuit breakers
   🛡️ OWASP Top 10 (2021/2024) + Mitigaciones Spring
   Broken Access Control → @PreAuthorize, validación de ownership, RBAC/ABAC.
   Cryptographic Failures → HTTPS obligatorio, BCrypt/Argon2, no almacenar secretos en código.
   Injection → Prepared statements (JPA), validación de inputs, sanitización.
   Insecure Design → Threat modeling, principios least privilege, defensa en profundidad.
   Security Misconfiguration → Desactivar actuator sensible, headers seguros, perfiles prod sin debug.
   Vulnerable & Outdated Components → Dependabot/Snyk, actualizaciones regulares.
   Identification & Auth Failures → MFA, bloqueo por intentos, JWT corto + refresh, rate limit login.
   Software & Data Integrity Failures → Firmas CI/CD, verificación de integridad, no confiar en inputs externos.
   Security Logging & Monitoring → Log4j2/SLF4J, alertas, trazabilidad de accesos.
   SSRF → Validar URLs, allowlist, no hacer requests con credenciales de servidor.
10. Persistencia: ER, ACID, JPA/Hibernate & NoSQL/MongoDB
    🗃️ ACID
    Atomicidad: Todo o nada (COMMIT/ROLLBACK).
    Consistencia: Transición entre estados válidos (constraints, triggers).
    Aislamiento: Concurrencia sin interferencia (READ UNCOMMITTED, READ COMMITTED, REPEATABLE READ, SERIALIZABLE).
    Durabilidad: Persistencia tras fallo (WAL, fsync).
    📌 Relacional = ACID. NoSQL = BASE (Basically Available, Soft state, Eventual consistency).
    📐 Diagrama Entidad-Relación (ER)
    Entidades (rectángulo), Atributos (óvalo), Relaciones (rombo).
    Cardinalidad: 1:1, 1:N, N:M.
    Claves: PK (única, no nula), FK (integridad referencial), Compuesta.
    Normalización: Eliminar redundancia, dependencias transitivas.
    💾 JPA & Hibernate Annotations
    java
    123456789101112
    CascadeType: ALL, PERSIST, MERGE, REMOVE, REFRESH.
    Problema N+1: Múltiples queries por relación LAZY. Solución: JOIN FETCH, @EntityGraph, spring.jpa.properties.hibernate.default_batch_fetch_size.
    🍃 MongoDB & NoSQL
    Criterio
    Documento Embebido
    Documento Referenciado
    Uso
    Datos leídos juntos, fuerte cohesión
    Datos reutilizados, crecimiento ilimitado, acceso independiente
    Tamaño
    < 16MB (límite doc MongoDB)
    Ilimitado
    Consistencia
    Atómica en un solo doc
    eventual (transacciones multi-doc disponibles pero costosas)
    Ejemplo
    Direccion en Usuario
    Pedidos separados de Usuario
    ✅ Regla de decisión: Si el subdocumento crece sin control o se consulta frecuentemente de forma aislada → Referenciar. Si siempre viaja junto y es pequeño → Embeber.
    🔗 Metamodelo Unificado (Spring Data)
    Abstracción común (Repository<T, ID>) que funciona sobre JPA, MongoDB, Redis, etc.
    Permite cambiar motor de persistencia con mínimo cambio en código de negocio.
    CrudRepository, PagingAndSortingRepository, JpaRepository, MongoRepository.
11. Autenticación & Autorización: OAuth2, OIDC, SSO & JWT
    🔐 OAuth2 & OpenID Connect
    OAuth2: Autorización (delegar acceso a recursos).
    OIDC: Capa de autenticación sobre OAuth2 (devuelve id_token).
    Roles: Client, Resource Owner, Authorization Server, Resource Server.
    Flujo recomendado: Authorization Code + PKCE (web/móvil seguros).
    SSO: Un login → múltiples dominios/apps. Habilitado por OIDC + cookies compartidas o token central.
    🎫 JWT (JSON Web Token)
    Estructura: Header.Payload.Signature (Base64Url).
    Claims: iss, sub, exp, iat, aud, roles, scope.
    Stateless: No requiere sesión en servidor.
    Validación crítica: Firma (RS256/HS256), exp, iss, aud.
    Revocación: No nativa. Estrategias: short expiry + refresh tokens, blacklist (Redis), rotación de claves.
    Spring Security Flow:
    Request → OncePerRequestFilter → extrae Bearer <token> → JwtDecoder → valida → crea UsernamePasswordAuthenticationToken → SecurityContextHolder → FilterChain.
12. DevOps, CI/CD, Ambientes & Kubernetes
    🔄 CI/CD Pipeline
    12
    Entregables: Artefacto versionado, imagen Docker, logs, métricas.
    Herramientas: GitHub Actions, GitLab CI, Jenkins, ArgoCD (GitOps).
    🌍 Gestión de Ambientes
    dev → qa → staging/uat → prod
    Configuración externa: application-{profile}.yml, variables de entorno, Vault/Secrets Manager.
    Promoción: Mismo artefacto, diferente configuración.
    ☸️ Kubernetes & Orquestación
    Recurso
    Propósito
    Pod
    Unidad mínima ejecutable (1+ contenedores)
    Deployment
    Gestión de Pods: escalado, rollout, rollback, self-healing
    ReplicaSet
    Garantiza número deseado de réplicas
    Service
    Descubrimiento & balanceo interno (ClusterIP, NodePort, LoadBalancer)
    Ingress
    Routing HTTP/HTTPS externo + TLS
    ConfigMap
    Configuración no sensible
    Secret
    Credenciales (base64, encriptado en etcd)
    Namespace
    Aislamiento lógico por equipo/entorno
    📌 Kubernetes es declarativo: defines el estado deseado en YAML → kubectl apply -f → controlador reconcilia.
13. Diagrama de Despliegue (UML)
    Propósito: Mostrar arquitectura física/lógica de ejecución.
    Elementos:
    Nodo (servidor, VM, contenedor, dispositivo) → «node»
    Artefacto (archivo ejecutable, librería, DB, config)
    Componente (módulo lógico)
    Conexión (protocolo: HTTP, JDBC, gRPC, TCP)
    Notación: Rectángulos con pestaña (nodos), cilindros (DB), flechas con etiquetas de protocolo.
    Uso en examen: Dibujar cómo interactúan frontend, API, DB, cache, broker, K8s cluster, balanceadores.
14. 📊 Matrices de Decisión & Checklist Final
    🧭 Matriz Rápida: ¿Qué tecnología/patrón uso?
    Escenario
    Solución Recomendada
    Necesito intercambiar algoritmos en runtime
    Strategy + inyección por constructor
    API debe soportar múltiples versiones
    URI versioning + semver + deprecación clara
    Mapear Entidad ↔ DTO eficientemente
    MapStruct (@Mapper)
    Prevenir ataques cruzados en formularios

    CSRF Token + SameSite cookies
    Autenticar SPA/Móvil de forma segura

    OAuth2 Authorization Code + PKCE
    Escalar microservicios automáticamente

    Kubernetes Deployment + HPA
    Evitar N+1 en relaciones JPA

    @EntityGraph o JOIN FETCH
    Almacenar subdatos que crecen indefinidamente
    MongoDB referenciado (colección separada)