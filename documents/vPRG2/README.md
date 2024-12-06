# Refactorización a OO

|Objetivos|Decisiones técnicas|Consideraciones didácticas|
|-|-|-|
|Transformar código estructurado a OO|Mantener arrays inicialmente|Mostrar el proceso de creación
|Mantener funcionalidad original|Separar UI de lógica|Explicar cada decisión
|Mejorar mantenibilidad|Encapsular comandos|Comparar con versión estructurada
|Facilitar futuras extensiones|Evitar dependencias estáticas|Evidenciar beneficios OO

## Fases

1. Análisis del código original
   1. Identificar responsabilidades
   1. Detectar dependencias
   1. Localizar áreas mejorables
2. Diseño OO inicial
   1. Definir clases core
   1. Establecer relaciones
   1. Aplicar patrón Command
3. Implementación por capas
   1. Core (Editor, Document)
   1. UI
   1. Comandos
4. Refactorizaciones posteriores
   1. Estructuras de datos
   1. Manejo de errores
   1. Testing

## Propuesta de diseño

<div align=center>

|![](/images/src/vPRG2/DdC-Base.svg)
|:-:
Propuesta (clic [**aquí**](DdC-Detallado.md) para ver el detalle)

</div>
