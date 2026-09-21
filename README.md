# Vintage Editor

Projeto académico (ISCTE-IUL) de um editor de imagem em Java, construído sobre a biblioteca de apoio `greyditor`, que aplica filtros, efeitos e operações a uma imagem em escala de cinzentos.

Desenvolvido em três fases incrementais:

**Fase 1 — Filtros e efeitos básicos**
- `Brightness`, `Contrast`, `Grain` (filtros por pixel)
- `Horizontal Flip`, `Vertical Flip`, `Margin`, `Vignette` (efeitos sobre a imagem)

**Fase 2 — Operações geométricas e novos filtros**
- `Crop`, `Expand`, `Rotate` (operações sobre a área selecionada)
- `Posterize`, `Blur` (novos filtros/efeitos)
- `Old`, `Retro` (combinações que dão um aspeto vintage à imagem)

**Fase 3 — Gestão de memória/histórico**
- `Copy`, `Cut`, `Paste`, `Undo`, implementados em `Memory.java` com um histórico de estados da imagem

## Estrutura
- `src/Main.java` — configuração do editor e registo de todas as operações
- `src/Filters.java` — filtros aplicados pixel a pixel
- `src/Effect.java` — efeitos aplicados sobre a imagem inteira
- `src/Operations.java` — operações geométricas e de edição
- `src/Memory.java` — clipboard e histórico (undo)
- `monalisa.jpg` — imagem de teste usada pelo editor
- `Projeto - Vintage Editor.pdf` — enunciado do projeto

## Autor
Luís Fernandes — ISCTE-IUL
