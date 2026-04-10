# Plataforma de batallas Bakugan
### Requerimientos
| ID   | Requerimiento | Tipo | Prioridad | Depende de |
|------|--------------|------|-----------|------------|
| RF1  | El sistema debe permitir a los usuarios registrarse. | Funcional | Alta | - |
| RF2  | El sistema debe permitir a los usuarios iniciar sesión. | Funcional | Alta | RF1 |
| RF3  | El sistema debe permitir a los usuarios gestionar su colección de Bakugan. | Funcional | Alta | RF1, RF2 |
| RF4  | El sistema debe permitir agregar nuevas criaturas al inventario. | Funcional | Alta | RF3 |
| RF5  | El sistema debe permitir mejorar/evolucionar criaturas. | Funcional | Media | RF4 |
| RF6  | El sistema debe permitir visualizar estadísticas de cada criatura. | Funcional | Media | RF3 |
| RF7  | El sistema debe permitir a los usuarios enfrentarse en combates. | Funcional | Alta | RF3 |
| RF8  | El sistema debe gestionar combates no en tiempo real. | Funcional | Alta | RF7 |
| RF9  | El sistema debe calcular resultados de combate de forma consistente. | Funcional | Alta | RF7 |
| RF10 | El sistema debe emparejar jugadores para combates. | Funcional | Alta | RF2 |
| RF11 | El sistema debe garantizar emparejamientos justos. | Funcional | Alta | RF10, RF15 |
| RF12 | El sistema debe almacenar el historial de partidas. | Funcional | Alta | RF7 |
| RF13 | El sistema debe permitir consultar partidas anteriores. | Funcional | Media | RF12 |
| RF14 | El sistema debe gestionar habilidades de criaturas. | Funcional | Media | RF4 |
| RF15 | El sistema debe permitir la progresión del usuario (niveles, experiencia, etc.). | Funcional | Alta | RF7 |
| RF16 | El sistema debe permitir actualizar datos de usuario. | Funcional | Media | RF2 |
| RF17 | El sistema debe permitir autenticación segura. | Funcional | Alta | RF1 |
| RF18 | El sistema debe permitir persistencia de inventario y progreso. | Funcional | Alta | RF3 |

## Requerimientos no funcionales
| ID   | Requerimiento | Tipo | Justificación | Prioridad |
|------|--------------|------|--------------|-----------|
| RNF1 | El sistema debe garantizar consistencia en los resultados de combate. | No funcional | Define calidad y confiabilidad del sistema | Alta |
| RNF2 | El sistema debe ser escalable para futuras funcionalidades. | No funcional | Es una característica de arquitectura | Media |
| RNF3 | El sistema debe ser mantenible. | No funcional | Facilita modificaciones futuras | Media |
| RNF4 | El sistema debe tener alta disponibilidad. | No funcional | Garantiza acceso continuo al sistema | Alta |
| RNF5 | El sistema debe asegurar la integridad de los datos. | No funcional | Evita pérdida o corrupción de información | Alta |
| RNF6 | El sistema debe garantizar seguridad en la autenticación. | No funcional | Protege datos sensibles de usuarios | Alta |
| RNF7 | El sistema debe tener buen rendimiento en emparejamientos. | No funcional | Mejora experiencia del usuario | Media |
| RNF8 | El sistema debe permitir fácil evolución del sistema. | No funcional | Permite agregar nuevas funcionalidades | Media |
| RNF9 | El sistema debe manejar correctamente la concurrencia. | No funcional | Evita conflictos entre usuarios simultáneos | Alta |
| RNF10 | El sistema debe ser usable (interfaz clara para el usuario). | No funcional | Mejora la experiencia del usuario | Media |


## Matriz de trazabilidad
| ID | Tipo | Módulo | Prueba |
|----|------|--------|--------|
| RF1 | Funcional | Autenticación | Registro exitoso |
| RF2 | Funcional | Autenticación | Inicio de sesión válido |
| RF4 | Funcional | Inventario | Agregar criatura |
| RF7 | Funcional | Combate | Simulación de combate |
| RF9 | Funcional | Combate | Resultado consistente |
| RF10 | Funcional | Matchmaking | Emparejamiento correcto |
| RF12 | Funcional | Historial | Guardado de partidas |
| RF13 | Funcional | Historial | Consulta de partidas |
| RNF1 | No funcional | Combate | Resultados repetibles |
| RNF6 | No funcional | Seguridad | Validación de acceso |

## Ambigüedades e información incompleta

1. Emparejamiento justo
   No se define qué criterios determinan que un emparejamiento sea "justo".
   ¿Se basa en nivel, estadísticas, ranking o experiencia?
   Se requiere validación con el cliente.

2. Consistencia en los resultados de combate
   No se especifica si los combates deben ser determinísticos o incluir aleatoriedad.
   ¿El mismo combate siempre debe dar el mismo resultado?
   Se requiere aclaración.

3. Mecánica de combate
   No se detallan las reglas del combate:
- ¿Turnos?
- ¿Uso de habilidades?
- ¿Cálculo de daño?
  Esto impide definir correctamente la lógica del sistema.


### Caso de uso: Registrar usuario

**Entradas:**
| Campo | Tipo | Obligatorio |
|------|------|------------|
| correo | String | Sí |
| contraseña | String | Sí |
| nombre | String | Sí |

**Salidas:**
| Campo | Tipo |
|------|------|
| id_usuario | Integer |
| mensaje | String |

### Caso de uso: Consultar historial

**Entradas:**
| Campo | Tipo | Obligatorio |
|------|------|------------|
| id_usuario | Integer | Sí |

**Salidas:**
| Campo | Tipo |
|------|------|
| lista_partidas | Array |
| total_partidas | Integer |