# 🏆 Oscar — Atividade de MongoDB

Atividade prática utilizando o **MongoDB** como SGBD, realizando consultas e agregações sobre uma base de dados histórica dos premiados e indicados ao **Oscar (Academy Awards)**.

---

## 📌 Sobre o projeto

Este repositório contém a resolução de uma atividade de MongoDB na qual um dataset real de cerimônias do Oscar (de 1928 até 2024) é explorado por meio de **consultas NoSQL** e **pipelines de agregação**.

A atividade é organizada em 6 exercícios que evoluem de consultas simples até agregações avançadas, respondendo perguntas como: quem mais recebeu indicações, quais artistas nunca venceram, qual foi a primeira melhor atriz, quantos prêmios cada filme conquistou e muito mais.

Como bônus, parte das análises também foi resolvida em **Python com pandas** (arquivo `Brincadeira.py`), lendo o JSON diretamente — sem usar o banco. 🐼

---

## 🗂️ Estrutura do repositório

| Arquivo | Descrição |
| --- | --- |
| 📄 `AtividadeOscar.md` | Resolução completa da atividade com todas as consultas MongoDB e respostas |
| 📄 `OSCAR.json` | Dataset do Oscar utilizado para importar no MongoDB |
| 🐍 `Brincadeira.py` | Bônus: análises exploratórias do JSON com pandas |

---

## 🧾 Sobre o dataset

O arquivo `OSCAR.json` reúne registros de indicações e vitórias do Oscar, com campos como:

- `year_ceremony` — ano da cerimônia;
- `ceremony` — número da edição da cerimônia;
- `category` — categoria da premiação (ACTOR, ACTRESS, DIRECTOR, BEST PICTURE...);
- `name` — nome da pessoa indicada;
- `film` — filme relacionado à indicação;
- `winner` — se venceu ou não (`true` / `false`).

**Coleções utilizadas nas consultas:** `Filme`, `oscar_indicados` e `oscar`.

---

## 📚 Conteúdos abordados

### Consultas básicas
- `find()` e `findOne()` com filtros e projeções;
- `countDocuments()` e `distinct()`;
- `sort()`, `skip()` e `limit()`;
- Expressões regulares em filtros (`/DIRECTING/`, `/ACTOR|ACTRESS/`, `/Toy Story/i`).

### Agregações (pipeline)
- `$match`, `$group`, `$sort`, `$limit`, `$project` e `$count`;
- Acumuladores: `$sum`, `$min`, `$max`, `$first`, `$addToSet` e `$size`;
- Condicionais com `$cond`;
- Agrupamentos aninhados (group dentro de group).

---

## 🏅 Resumo dos exercícios

| Exercício | Foco | Destaques das respostas |
| --- | --- | --- |
| 1 | Primeiros passos | 10.889 registros; categorias únicas; cerimônia mais recente (2024) |
| 2 | Explorando categorias | DIRECTOR lidera indicações (469); categorias com "DIRECTING" |
| 3 | Perfis de artistas | Natalia Portman, Viola Davis, Amy Adams e Denzel Washington |
| 4 | Vencedores | Primeira ACTRESS: Janet Gaynor (1928, *7th Heaven*); primeiro ACTOR: Emil Jannings (1928, *The Last Command*) |
| 5 | Agregações avançadas | Meryl Streep: 21 indicações; indicados que nunca venceram; ano com mais pessoas (1944) |
| 6 | Estudos de caso | *Toy Story* (vitórias em 2011 e 2020); *Crash* (BEST PICTURE 2006); *Central do Brasil* não existe na base |

---

## 🐼 Bônus: pandas

No arquivo `Brincadeira.py`, parte da atividade também foi resolvida em Python com **pandas**, lendo o `OSCAR.json` diretamente via `pd.read_json()` e utilizando `value_counts()`, `loc`, `head/tail` e outros métodos para responder às mesmas perguntas.

> 💡 Nota divertida: o ideal seria usar um notebook `.ipynb`, mas como não tinha um instalado, a brincadeira aconteceu no `.py` mesmo — e funcionou! 😄

---

## ▶️ Como reproduzir

1. Importe o dataset para o MongoDB:

```
mongoimport --db oscar --collection Filme --file OSCAR.json --jsonArray
```

2. Abra o **MongoDB Shell** ou o **Compass**;
3. Execute as consultas do arquivo `AtividadeOscar.md` e compare as respostas.

---

## 🛠️ Ferramentas utilizadas

- **[MongoDB](https://www.mongodb.com/)** — SGBD NoSQL utilizado na atividade;
- **[MongoDB Shell / Compass](https://www.mongodb.com/products/tools/compass)** — execução e visualização das consultas;
- **[Python](https://www.python.org/) + [pandas](https://pandas.pydata.org/)** — análises bônus do JSON.

---
