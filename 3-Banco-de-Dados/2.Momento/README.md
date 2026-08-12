# 🕐 Momento — Atividade de MongoDB

Atividade prática utilizando o **MongoDB** como SGBD, realizando consultas e agregações sobre a base de dados da **Momento**, uma empresa fictícia de tecnologia e produtos temáticos de super-heróis e cultura pop, fundada em 1980 em Gotham City.

---

## 📌 Sobre o projeto

Este repositório contém a resolução dos exercícios propostos para explorar o banco de dados MongoDB da empresa **Momento**. O dataset simula um ambiente corporativo real, com departamentos (Tecnologia, Vendas, RH, Marketing, Financeiro, Dados), escritórios em diversos países, funcionários, suprimentos e vendas.

A atividade foi organizada em níveis progressivos — desde a inserção de novos registros e consultas básicas até agregações complexas com pipelines multi-estágio, análises financeiras e operações sobre arrays de suprimentos e subdocumentos.

---

## 🗂️ Estrutura do repositório

| Arquivo | Descrição |
| --- | --- |
| 📄 `Momento.md` | Resolução dos exercícios com as queries MongoDB implementadas |
| 📄 `README.md` | Documentação do repositório (este arquivo) |

---

## 📚 Níveis abordados

### 🟢 Nível 1 — Conhecendo a Empresa
Primeiros passos no banco: inserção do próprio registro na coleção `Funcionario` com `insertOne()`, contagem total de documentos com `countDocuments()`, listagem de departamentos e agregação dos escritórios agrupando países únicos com `$addToSet`.

### 🟢 Nível 2 — Análise Financeira Básica
Relatórios urgentes para o CFO: custo total de salários por departamento, média salarial da empresa (excluindo cargos C-level com `$nin`), média salarial do departamento de Tecnologia e identificação dos departamentos com maior e menor média salarial via `$group` + `$sort` + `$limit`.

### 🟢 Nível 3 — Recursos Humanos
Análise demográfica: contagem de funcionários com cônjuges e filhos (usando `$exists` em subdocumentos), ordenação por data de admissão para encontrar os colaboradores com mais e menos tempo de casa, filtragem por intervalo de datas da década de 90 e evolução da média salarial por ano de contratação usando `$substr`.

### 🟢 Nível 4 — Operações e Escritórios
Análise da coleção de suprimentos: uso do operador `$unwind` para "desembrulhar" arrays de suprimentos, cálculo de custo total por escritório (quantidade × preço unitário com `$multiply`), identificação do suprimento mais caro e cálculo do valor total do inventário da empresa.

### 🟢 Nível 6 — Produtos e Vendas
Análise do faturamento: listagem de produtos únicos com `distinct()`, identificação do produto mais e menos vendido, cálculo de receita total por produto, faturamento total da empresa, contagem de vendas em intervalo de datas (junho/2023 com `$gte` e `$lt`) e ranking dos vendedores por número de transações e receita gerada.

---

## 🧠 Conceitos MongoDB praticados

### Consultas básicas
- `insertOne()`, `find()`, `distinct()`, `countDocuments()`;
- Projeções e ordenação (`sort`, `limit`);
- Filtros com operadores: `$nin`, `$exists`, `$gte`, `$lt`.

### Agregações (pipeline)
- `$match`, `$group`, `$sort`, `$limit`, `$project`, `$unwind`;
- Acumuladores: `$sum`, `$avg`, `$addToSet`;
- Operadores aritméticos: `$multiply`;
- Operadores de string: `$substr`.

### Modelagem e relacionamentos
- Uso de `ObjectId` para referências entre coleções;
- Manipulação de arrays e subdocumentos (`dependentes.conjuge`, `dependentes.filhos`);
- "Unwinding" de arrays para análise item a item.

---

## 🛠️ Tecnologias utilizadas

- **[MongoDB](https://www.mongodb.com/)** — SGBD NoSQL utilizado na atividade;
- **[MongoDB Shell / Compass](https://www.mongodb.com/products/tools/compass)** — execução e visualização das consultas.

---

## ▶️ Como reproduzir

1. Importe o dataset da Momento no seu MongoDB (disponível no repositório de origem da atividade);
2. Abra o **MongoDB Shell** ou o **Compass**;
3. Execute as queries do arquivo `Momento.md` e explore os resultados.

---

## 🎯 Objetivos de aprendizado

- ✔️ Dominar consultas básicas e filtros em coleções;
- ✔️ Construir pipelines de agregação complexos;
- ✔️ Manipular arrays e subdocumentos (`$unwind`, `$exists`);
- ✔️ Realizar cálculos aritméticos e agregações ($multiply, $sum, $avg);
- ✔️ Aplicar boas práticas de consulta em bases corporativas simuladas.

---
