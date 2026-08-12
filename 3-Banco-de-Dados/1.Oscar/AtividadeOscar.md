# Oscar

## Atividade de MongoDB 


### Link da atividade

<a href="https://github.com/gabaugusto/sample-databases/blob/main/Documentos/5_OSCAR/README.md" target="_blank">Repositorio da Atividade</a>


## Exercicio 1

```python
//1.1
//R= 10889
db.Filme.countDocuments()

//1.2
//R= ACTOR, ACTRESS, DIRECTOR, WRITER
db.Filme.distinct("category")

//1.3
//R= 96
db.Filme.find().skip(15).limit(1).sort({year_ceremony: -1})

//1.4
//R= 2024
db.Filme.find({}, { year_ceremony: 1, _id: 0 }).sort({ year_ceremony: -1 }).limit(1);

//1.5
//R= 96
db.Filme.distinct("ceremony").length
```

## Exercicio 2

```python
//2.1
//R= DIRECTOR: 469, ACTOR IN SUPPORTING ROLE: 440, FILM EDITING: 450
db.oscar_indicados.aggregate([
  { $group: { _id: "$category", total_indicacoes: { $sum: 1 } } },
  { $sort: { total_indicacoes: -1 } }
]);

//2.2
//R= DIRECTOR : 469
db.Filme.aggregate([
  { $group: { _id: "$category", total_indicacoes: { $sum: 1 } } },
  { $sort: { total_indicacoes: -1 } },
  { $limit: 1 }
]);

//2.3
//R= GORDON E. SAWYER AWARD: 1
db.Filme.aggregate([
  { $group: { _id: "$category", total_indicacoes: { $sum: 1 } } },
  { $sort: { total_indicacoes: 1 } },
  { $limit: 1 }
]);

//2.4
//R= 1976
db.Filme.find(
  { category: "ACTRESS" },
  { year_ceremony: 1, _id: 0 }
).sort({ year_ceremony: -1 }).limit(1)

//2.5
//R= WRITING (Adaptation), UNIQUE AND ARTISTIC PICTURE, ART DIRECTION
db.Filme.aggregate([
  {
    $group: {
      _id: "$category",
      min_year: { $min: "$year_ceremony" },
      max_year: { $max: "$year_ceremony" }
    }
  }
])

//2.6
//R= categorias com DIRECTING
db.oscar_indicados.distinct("category", { category: /DIRECTING/ });
```

## Exercicio 3

```python
//3.1
//R= 3
db.Filme.countDocuments({name: "Natalia Portman"})

//3.2
//R= 1
db.Filme.countDocuments({name: "Natalia Portman", winner: true})

//3.3
//R= Closer (2005), Black Swan (2011), Jackie (2017)
db.Filme.find({name: "Natalia Portman"}, {year_ceremony: 1, film: 1, _id: 0})

//3.4
db.Filme.find(
  {name: "Natalia Portman"},
  {year_ceremony: 1, category: 1, film: 1, winner: 1, _id: 0}
)

//3.5
//R= 4
db.Filme.countDocuments({name: "Viola Davis"})

//3.6
//R= 1
db.Filme.countDocuments({name: "Viola Davis", winner: true})

//3.7
db.Filme.find({name: "Viola Davis"}, { film: 1, _id: 0})

//3.8
//R= 0
db.Filme.countDocuments({ name: "Amy Adams", winner: true });

//3.9
//R= 6
db.Filme.countDocuments({ name: "Amy Adams"});

//3.10
//R= 2
db.Filme.countDocuments({name: "Denzel Washington", winner: true})

//3.11
//R= 9
db.Filme.countDocuments({name: "Denzel Washington"})

//3.12
db.Filme.find(
  {name: "Denzel Washington"},
  {year_ceremony: 1, category: 1, film: 1, winner: 1, _id: 0}
)
```
## Exercicio 4

```python
//4.1
//R= Janet Gaynor - 1928 - 7th Heaven
db.oscar_indicados.find(
  { category: "ACTRESS", winner: true }, 
  { name: 1, year_ceremony: 1, film: 1, _id: 0 }
).sort({ year_ceremony: 1 }).limit(1);

//4.2
//R= Emil Jannings - 1928 - The Last Command
db.Filme.find(
  { category: "ACTOR", winner: true }, 
  { name: 1, year_ceremony: 1, film: 1, _id: 0 }
).sort({ year_ceremony: 1 }).limit(1);

//4.3
//R= 2455
db.oscar_indicados.countDocuments({ winner: true });

//4.4
db.oscar_indicados.find(
  { 
    category: { $in: ["OUTSTANDING PICTURE", "BEST PICTURE"] },
    winner: true 
  },
  { year_ceremony: 1, category: 1, film: 1, _id: 0 }
);

//4.5
//R= 1328
db.oscar_indicados.distinct("film", { winner: true }).length;
```

## Exercicio 5


```python
//5.1
db.Filme.aggregate([
  { $match: { category: /ACTOR|ACTRESS/} },
  { $group: { _id: "$name", total_indicacoes: { $sum: 1 } } },
  { $match: { total_indicacoes: { $gt: 1 } } },
  { $sort: { total_indicacoes: -1 } }
]);

//5.2
//R= Meryl Streep: 21
db.Filme.aggregate([
  { $match: { category: /ACTOR|ACTRESS/} },
  { $group: { _id: "$name", total_indicacoes: { $sum: 1 } } },
  { $sort: { total_indicacoes: -1 } },
  { $limit: 1 }
]);

//5.3
db.Filme.aggregate([
  { $match: { category: /ACTOR|ACTRESS/ } },
  {
    $group: {
      _id: "$name",
      total_indicacoes: { $sum: 1 },
      total_vitorias: { $sum: { $cond: ["$winner", 1, 0] } }
    }
  },
  { $match: { total_vitorias: 0 } },
  { $sort: { total_indicacoes: -1 } }
]);

//5.4
db.Filme.aggregate([
  {
    $group: {
      _id: "$name",
      categorias: { $addToSet: "$category" }
    }
  },
  {
    $project: {
      categorias: 1,
      qtdCategorias: { $size: "$categorias" }
    }
  },
  { $match: { qtdCategorias: { $gt: 1 } } }
]);

//5.5
//R= 5622
db.Filme.aggregate([
  {
    $group: {
      _id: "$name",
      totalIndicacao: { $sum: 1 }
    }
  },
  { $match: { totalIndicacao: 1 } },
  { $count: "qtdIndicadosCom1Indicacao" }
]);

//5.6
//R= 1944 com 164 pessoas
db.oscar.aggregate([
  {
    $group: {
      _id: {
        ano: "$year_ceremony",
        nome: "$name"
      }
    }
  },
  {
    $group: {
      _id: "$_id.ano",
      totalPessoas: { $sum: 1 }
    }
  },
  { $sort: { totalPessoas: -1 } },
  { $limit: 1 }
]);
```
## Exercicio 6


```python
//6.1
//R= 2011 e 2020
db.Filme.aggregate([
  { $match: { film: /Toy Story/i, winner: true } },
  { $group: { _id: "$year_ceremony" } },
  { $sort: { _id: 1 } }
]);

//6.2
//R= 11
db.Filme.aggregate([
  { $match: { film: /Toy Story/i } },
  { $count: "totalIndicacoes" }
]);

//6.3
db.Filme.aggregate([
  { $match: { film: /Toy Story/i } },
  { $group: { _id: "$category" } },
  { $sort: { _id: 1 } }
]);

//6.4
//R= 2006 (cerimônia 78)
db.Filme.aggregate([
  { $match: { film: "Crash" } },
  {
    $group: {
      _id: "$ceremony",
      anoCeremony: { $first: "$year_ceremony" }
    }
  }
]);

//6.5
//R= 6
db.Filme.aggregate([
  { $match: { film: "Crash" } },
  { $count: "totalIndicacoes" }
]);

//6.6
//R= Ganhou melhor filme em 2006
db.Filme.find({
  film: "Crash",
  category: "BEST PICTURE",
  winner: true
})

//6.7
//R= Não existe
db.Filme.findOne({ film: "Central do Brasil" })

//6.8
//R= Não existe
```