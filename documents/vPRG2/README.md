# Refactorización a OO

|Objetivos|Decisiones técnicas|Consideraciones didácticas|
|-|-|-|
|Transformar código estructurado a OO|Mantener arrays inicialmente|Mostrar el proceso de creación
|Mantener funcionalidad original|Separar UI de lógica|Explicar cada decisión
|Mejorar mantenibilidad|Encapsular comandos|Comparar con versión estructurada
|Facilitar futuras extensiones|Evitar dependencias estáticas|Evidenciar beneficios OO

## Refactorización

### Fases

1. Análisis del código original
   1. Identificar responsabilidades
   1. Detectar dependencias
   1. Localizar áreas mejorables
2. Diseño OO inicial
   1. Definir clases core
   1. Establecer relaciones
   1. Aplicar [patrón Command](https://en.wikipedia.org/wiki/Command_pattern)
3. Implementación por capas
   1. Core (Editor, Document)
   1. UI
   1. Comandos
4. Refactorizaciones posteriores
   1. Estructuras de datos
   1. Manejo de errores
   1. Testing

### Propuesta de diseño

<div align=center>

|![](/images/documents/vPRG2/DdC-Base.svg)|
|:-:|
|Propuesta (clic [**aquí**](DdC-Detallado.md) para ver el detalle)|

---

||[Editor.java](/src/vPRG2/Editor.java)||
|:-:|:-:|:-:|
|[Command.java](/src/vPRG2/Command.java)|[Document.java](/src/vPRG2/Document.java)|[UserInterface.java](/src/vPRG2/UserInterface.java)|
|[EditCommand.java](/src/vPRG2/EditCommand.java)
|[ExchangeCommand.java](/src/vPRG2/ExchangeCommand.java)
|[DeleteCommand.java](/src/vPRG2/DeleteCommand.java)
|[SetActiveLineCommand.java](/src/vPRG2/SetActiveLineCommand.java)
|[ExitCommand.java](/src/vPRG2/ExitCommand.java)

</div>

## Implementación de persistencia

### Plan de ataque

> Utilizando [FileManager.java](/src/vPRG2/FileManager.java)

|||
|-|-|
|Partiendo del código estructurado anteriormente, en el que usamos una interfaz para encapsular las operaciones de edición, aplicaremos el mismo principio para la persistencia: separamos la serialización (conversión de Document a String) del almacenamiento físico, de modo que cada aspecto podrá evolucionar de modo independiente.|El uso de un intermediario entre FileManager y Editor evitando que detalles de implementación de FileManager contaminen el modelo del dominio, mientras que la inyección de dependencias en Editor mantiene el sistema flexible y desacoplado.|

<div align=center>

|||
|-|-|
|**Abstracciones**|`interface DocumentStorage`|
||`interface DocumentSerializer`|
|**Implementaciones**|`class FileManagerAdapter`|
||`class SimpleSerializer`|
|**Integración**|Ajustes en Editor|
||Nuevos Commands para persistencia|
|**UI**|Nuevas opciones menú|
||Mensajes al usuario|

</div>

### Propuesta de diseño

<div align=center>

|![](/images/documents/vPRG2/DdC-Base-v2-Simplificado.svg)|
|:-:|
|Propuesta (clic [**aquí**](DdC-Detallado-v2.md) para ver el detalle)|

---

|||[Editor.java](/src/vPRG2/Editor.java)|||
|:-:|:-:|:-:|:-:|:-:|
|[Command.java](/src/vPRG2/Command.java)|[Document.java](/src/vPRG2/Document.java)|[UserInterface.java](/src/vPRG2/UserInterface.java)|DocumentStorage|DocumentSerializer
|[EditCommand.java](/src/vPRG2/EditCommand.java)|||FileManagerAdapter|SimpleSerializer|
|[ExchangeCommand.java](/src/vPRG2/ExchangeCommand.java)|||[FileManager](/src/vPRG2/FileManager.java)||
|[DeleteCommand.java](/src/vPRG2/DeleteCommand.java)|||||
|[SetActiveLineCommand.java](/src/vPRG2/SetActiveLineCommand.java)|||||
|[ExitCommand.java](/src/vPRG2/ExitCommand.java)|||||
|LoadCommand.java
|SaveCommand.java

</div>

### Implementación

Durante la implementación surgieron detalles:

- Tener serializer en Editor/UI exponía detalles de implementación, por lo que se movió a Document donde encapsula mejor la funcionalidad
- Al implementar LoadCommand, crear un nuevo Document rompía referencias, llevando a introducir updateFrom para actualizar el existente
- La implementación inicial de SaveCommand estaba accediendo directamente al estado interno de Document (lines), lo que motivó mover la serialización allí
- Los comandos Save/Load inicialmente no tenían UI, pero necesitaban pedir nombre de archivo, revelando una dependencia oculta

Con esto la arquitectura final quedó:

<div align=center>

|![](/images/documents/vPRG2/DdC-Base-v3.svg)|
|:-:|
|Propuesta (clic [**aquí**](DdC-Detallado-v3.md) para ver el detalle)|

---

|||[Editor.java](/src/vPRG2/Editor.java)|||
|:-:|:-:|:-:|:-:|:-:|
|[Command.java](/src/vPRG2/Command.java)|[Document.java](/src/vPRG2/Document.java)|[UserInterface.java](/src/vPRG2/UserInterface.java)|[DocumentStorage](/src/vPRG2/DocumentStorage.java)|[DocumentSerializer](/src/vPRG2/DocumentSerializer.java)
|[EditCommand.java](/src/vPRG2/EditCommand.java)|||[FileManagerAdapter](/src/vPRG2/FileManagerAdapter.java)|[SimpleSerializer](/src/vPRG2/SimpleSerializer.java)|
|[ExchangeCommand.java](/src/vPRG2/ExchangeCommand.java)|||[FileManager](/src/vPRG2/FileManager.java)||
|[DeleteCommand.java](/src/vPRG2/DeleteCommand.java)|||||
|[SetActiveLineCommand.java](/src/vPRG2/SetActiveLineCommand.java)|||||
|[ExitCommand.java](/src/vPRG2/ExitCommand.java)|||||
|[LoadCommand.java](/src/vPRG2/LoadCommand.java)
|[SaveCommand.java](/src/vPRG2/SaveCommand.java)

</div>
