# 🗄️ 3 Banco de Dados

Repositório central dos meus estudos de **banco de dados** com o SGBD **MongoDB**, parte do curso **PROA**. Aqui está registrada a minha evolução: de consultas simples em bases reais até pipelines complexos de higienização, normalização e modelagem de dados NoSQL.

---

## 📌 Sobre o projeto

Este espaço reúne as três atividades práticas do módulo de banco de dados. Cada uma simula um cenário diferente do mundo real, aumentando o nível de complexidade a cada etapa:

1. **Oscar** 🏆 — análise de uma base histórica real de premiações;
2. **Momento** 🕐 — rotina de uma empresa com relatórios de negócio (RH, financeiro, vendas e operações);
3. **Multiverso** 🌌 — o desafio final: higienizar e normalizar uma base completamente caótica.

Todas as atividades foram propostas pelo meu professor, com o objetivo de dominar consultas, agregações e boas práticas de manipulação de dados em um SGBD NoSQL.

---

## 🗂️ Estrutura do repositório

| Repositório | Cenário | Foco principal |
| --- | --- | --- |
| 📁 [1.Oscar](./1.Oscar) | 🏆 Base histórica do Oscar (1928–2024) | Consultas básicas e agregações de análise |
| 📁 [2.Momento](./2.Momento) | 🕐 Empresa fictícia de cultura pop | Relatórios de negócio, arrays e `$unwind` |
| 📁 [3.Multiverso](./3.Multiverso) | 🌌 Multiverso nerd em colapso | Higienização, normalização e `$lookup` |

---

## 📚 Jornada de aprendizado

### 🏆 1.Oscar — Análise de dados reais
- Consultas com `find()`, `countDocuments()`, `distinct()`, `sort()`, `skip()` e `limit()`;
- Agregações com `$group`, `$sort`, `$limit`, `$cond` e `$addToSet`;
- Filtros com expressões regulares (`/DIRECTING/`, `/Toy Story/i`);
- **Bônus:** parte das análises também resolvida em Python com **pandas**. 🐼

### 🕐 2.Momento — Rotina corporativa
- Relatórios de RH, financeiro, vendas e suprimentos;
- Inserção e atualização de registros (`insertOne`, updates);
- Cálculos aritméticos em pipelines (`$multiply`, `$avg`, `$sum`);
- Manipulação de arrays e subdocumentos (`$unwind`, `$exists`);
- Relacionamentos com `ObjectId` e filtros por intervalo de datas.

### 🌌 3.Multiverso — O desafio final
- Higienização completa: `$trim`, `$toLower`, `$toUpper`, `$toInt`, `$ifNull`, `$split`;
- Unificação de valores com `$switch` + `$regexMatch` e deduplicação com `$group`;
- Criação de coleções relacionais (`characters`, `universes`, `species`, `equipment`, `movies`);
- Relacionamentos entre coleções com `$lookup` — o "PROCV do MongoDB";
- Exportação da coleção limpa para JSON.

---

## 🔄 Evolução da complexidade

| Etapa | Atividade | Habilidades desenvolvidas |
| --- | --- | --- |
| 🥇 | Oscar | Explorar e analisar uma base pronta |
| 🥈 | Momento | Responder perguntas de negócio e manipular dados |
| 🥉 | Multiverso | Consertar, modelar e relacionar dados caóticos |

---

## 🧠 Conceitos dominados ao longo do módulo

- ✔️ Consultas básicas e projeções em coleções NoSQL;
- ✔️ Pipelines de agregação (`$match`, `$group`, `$sort`, `$project`, `$unwind`, `$out`);
- ✔️ Acumuladores (`$sum`, `$avg`, `$min`, `$max`, `$addToSet`, `$first`);
- ✔️ Operadores de string, tipo e condição (`$substr`, `$toInt`, `$cond`, `$switch`);
- ✔️ Filtros avançados (`$exists`, `$nin`, `$gte`, `$lt`, regex);
- ✔️ Operações de escrita (`insertOne`, updates e remoções);
- ✔️ Modelagem e relacionamentos NoSQL (`$lookup`, IDs de referência);
- ✔️ Higienização e normalização de dados reais.

---

## 🛠️ Tecnologias utilizadas

- **[MongoDB](https://www.mongodb.com/)** — SGBD NoSQL utilizado em todas as atividades;
- **[MongoDB Shell / Compass](https://www.mongodb.com/products/tools/compass)** — execução e visualização das consultas;
- **[Python](https://www.python.org/) + [pandas](https://pandas.pydata.org/)** — análises bônus no projeto Oscar.

---

## 🔗 Jornada conectada

Este repositório faz parte da minha trilha de estudos:

| Fase | Repositório | Foco |
| --- | --- | --- |
| 1️⃣ | Lógica de Programação | Fundamentos com Portugol e Kotlin |
| 2️⃣ | Android Studio | Apps mobile com Kotlin e Jetpack Compose |
| 3️⃣ | **Banco de Dados** | MongoDB: consultas, agregações e modelagem |

---