# 🌌 Multiverso — Atividade de MongoDB

Atividade prática de **higienização e normalização de dados** utilizando o **MongoDB** como SGBD. O desafio consistiu em restaurar a ordem no banco de dados do "Multiverso Nerd", que entrou em colapso após a abertura de portais entre universos, misturando personagens de franquias diferentes em uma base completamente desorganizada.

---

## 📌 Sobre o projeto

O **Conselho Supremo da Galáxia** (ou seja, eu 👀) foi convocado para reconstruir o equilíbrio nerd do universo dos dados.

O repositório original continha **75 registros** de personagens, criaturas e heróis do mundo nerd (Marvel, DC, Star Wars, Harry Potter, Halo, Senhor dos Anéis...) com inconsistências graves:

- Campos duplicados com nomes diferentes (`Name`, `nome`, `char_name`);
- Capitalização variada (`"tOny stark"`, `"bat man"`, `"Darth vader"`);
- Tipos de dados misturados (`powerLevel` como string `"85"` ou número `85`);
- Listas como strings (`"lightsaber, armor, force"`) ou arrays;
- Valores nulos, vazios e `"N/A"`;
- Universos duplicados (`"marvel studios"`, `"MARVEL COMICS"`, `"Marvel"`);
- Personagens duplicados (`"Batman"` e `"bat man"`).

O desafio foi dividido em **duas etapas**: higienização (limpeza dos dados) e normalização (organização em coleções relacionais).

---

## 🗂️ Estrutura do repositório

| Arquivo | Descrição |
| --- | --- |
| 📄 `Multiverso.md` | Resolução completa com todas as queries MongoDB implementadas |
| 📄 `nerd_universe_clean.json` | Coleção limpa e exportada após a etapa de higienização |
| 📄 `README.md` | Documentação do repositório (este arquivo) |

---

## 🧹 Etapa 1 — Higienização de Dados

Pipeline de agregação completo para transformar os registros caóticos em uma coleção limpa chamada `nerd_universe_clean`.

### Tratamentos aplicados

- **Padronização de nomes de campos**: unificação de `Name`, `nome`, `char_name` em um único campo `name` usando `$ifNull` aninhado;
- **Capitalização e espaços**: remoção de espaços extras com `$trim` e aplicação de Title Case via `$concat` + `$toUpper` + `$substr`;
- **Conversão de tipos**: `powerLevel` e `debut_year` convertidos de string para inteiro com `$toInt` e tratamento de `"N/A"` via `$cond`;
- **Normalização de universos**: uso de `$switch` + `$regexMatch` para unificar `"marvel studios"`, `"MARVEL COMICS"`, `"Marvel"` em um único `"Marvel"`;
- **Arrays padronizados**: strings separadas por vírgula transformadas em arrays reais com `$split`, e tratamento condicional com `$isArray`;
- **Deduplicação**: agrupamento por nome com `$group` + `$first` para remover duplicatas (ex.: Batman e bat man);
- **Exportação**: uso do operador `$out` para persistir a coleção limpa e, posteriormente, exportada para JSON.

---

## 🗄️ Etapa 2 — Normalização

A partir da coleção `nerd_universe_clean`, os dados foram reorganizados em **5 coleções relacionais**, seguindo princípios de modelagem de banco:

| Coleção | Conteúdo |
| --- | --- |
| 🧑 `characters` | Informações principais dos personagens (nome, universo, espécie, poder, ano de estreia) |
| 🌍 `universes` | Universos cadastrados com nome, tipo e origem |
| 🧬 `species` | Espécies registradas com nome e descrição |
| 🛠️ `equipment` | Equipamentos icônicos (extraídos via `$unwind`) |
| 🎬 `movies` | Obras em que o personagem aparece (extraídas via `$unwind`) |

### Relacionamentos

Aplicação do operador **`$lookup`** — o "PROCV do MongoDB" — para cruzar informações entre coleções, permitindo consultas como "listar todos os personagens com os dados completos do seu universo".

---

## 🧠 Conceitos MongoDB praticados

### Operadores de string
- `$trim`, `$toLower`, `$toUpper`, `$substr`, `$strLenCP`, `$concat`, `$split`

### Operadores de tipo
- `$toInt`, `$isArray`, `$ifNull`

### Operadores condicionais e lógicos
- `$cond`, `$switch`, `$regexMatch`, `$and`, `$ne`

### Operadores de pipeline
- `$addFields`, `$project`, `$group`, `$unwind`, `$replaceRoot`, `$out`

### Relacionamento entre coleções
- `$lookup` (inner join-like entre coleções NoSQL)

### Agregações
- `$first`, `$root`, deduplicação via `$group`

---

## 🎯 Objetivos de aprendizado

- ✔️ Identificar e corrigir inconsistências em bases de dados reais;
- ✔️ Construir pipelines complexos de agregação com múltiplos estágios;
- ✔️ Aplicar técnicas de deduplicação e unificação de dados;
- ✔️ Transformar estruturas desnormalizadas em modelos relacionais NoSQL;
- ✔️ Usar `$lookup` para realizar joins entre coleções;
- ✔️ Exportar coleções limpas para consumo externo (JSON).

---

## 🛠️ Tecnologias utilizadas

- **[MongoDB](https://www.mongodb.com/)** — SGBD NoSQL utilizado na atividade;
- **[MongoDB Shell / Compass](https://www.mongodb.com/products/tools/compass)** — execução e visualização dos pipelines;
- **[GitHub](https://github.com/)** — repositório de origem do dataset.

---

## ▶️ Como reproduzir

1. Clone o dataset original do [repositório da atividade](https://github.com/gabaugusto/sample-databases/tree/main/Documentos/7_MULTIVERSO);
2. Importe os arquivos para uma coleção chamada `personagens` no MongoDB;
3. Execute o pipeline da **Etapa 1** para gerar `nerd_universe_clean`;
4. Execute os pipelines da **Etapa 2** para criar as coleções relacionais;
5. Teste o `$lookup` para validar os relacionamentos.

---

> 🌠 "Com grandes dados, vêm grandes responsabilidades de higienização." — Tio Ben (provavelmente)