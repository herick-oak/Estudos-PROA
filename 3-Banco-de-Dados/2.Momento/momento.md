# Momento

## Atividade de MongoDB 

### Link da atividade

<a href="https://github.com/gabaugusto/sample-databases/tree/main/Documentos/6_MOMENTO" target="_blank">Repositorio da Atividade</a>




## Exercicio 1

```python
db.Funcionario.insertOne({
  "nome": "Gabriel",
  "sobrenome": "Feio Augusto",
  "data_nascimento": "1950-01-01",
  "data_contratacao": "2020-01-01",
  "salario": 5000,
  "departamento": "Tecnologia",
  "cargo": "Professor",
  "escritorio": "São Paulo"
})

db.Funcionario.countDocuments()

db.Funcionario.countDocuments({
  departamento: "Tecnologia"
})

db.Departamento.countDocuments()

db.Departamento.find()

db.escritorios.aggregate([
  {
    $group: {
      _id: null,
      quantidadeEscritorios: { $sum: 1 },
      paises: { $addToSet: "$pais" }
    }
  }
])

```

## Exercicio 2

```python
db.Funcionario.countDocuments({
  departamento: ObjectId("85992103f9b3e0b3b3c1fe71")
})

db.Funcionario.aggregate([
  {
    $match: {
      departamento: ObjectId("85992103f9b3e0b3b3c1fe71")
    }
  },
  {
    $group: {
      _id: null,
      custoTotal: {
        $sum: "$salario"
      }
    }
  }
])

db.Funcionario.aggregate([
  {
    $match: {
      cargo: {
        $nin: ["CEO", "CMO", "CFO"]
      }
    }
  },
  {
    $group: {
      _id: null,
      mediaSalarial: {
        $avg: "$salario"
      }
    }
  }
])

db.Funcionario.aggregate([
  {
    $match: {
      departamento: "Tecnologia"
    }
  },
  {
    $group: {
      _id: null,
      mediaSalarial: {
        $avg: "$salario"
      }
    }
  }
])

db.Funcionario.aggregate([
  {
    $group: {
      _id: "$departamento",
      mediaSalarial: {
        $avg: "$salario"
      }
    }
  },
  {
    $sort: {
      mediaSalarial: -1
    }
  },
  {
    $limit: 1
  }
])

db.Funcionario.aggregate([
  {
    $group: {
      _id: "$departamento",
      totalFuncionarios: {
        $sum: 1
      }
    }
  },
  {
    $sort: {
      totalFuncionarios: 1
    }
  },
  {
    $limit: 1
  }
])

```

## Exercicio 3

```python
db.Funcionario.countDocuments({
  "dependentes.conjuge": { $exists: true }
})

db.Funcionario.countDocuments({
  "dependentes.filhos.0": { $exists: true }
})

db.Funcionario.find()
.sort({ dataAdmissao: 1 })
.limit(1)

db.Funcionario.find()
.sort({ dataAdmissao: -1 })
.limit(1)

db.Funcionario.find()
.sort({ dataAdmissao: 1 })
.limit(5)

db.Funcionario.countDocuments({
  dataAdmissao: {
    $gte: "1990-01-01",
    $lt: "2000-01-01"
  }
})

db.Funcionario.aggregate([
  {
    $group: {
      _id: {
        $substr: ["$dataAdmissao", 0, 4]
      },
      mediaSalarial: {
        $avg: "$salario"
      }
    }
  },
  {
    $sort: {
      _id: 1
    }
  }
])

```

## Exercicio 4

```python
db.escritorios.aggregate([
  { $unwind: "$suprimentos" },
  {
    $group: {
      _id: "$nome",
      custoTotal: {
        $sum: {
          $multiply: [
            "$suprimentos.quantidade",
            "$suprimentos.precoUnitario"
          ]
        }
      }
    }
  },
  { $sort: { custoTotal: -1 } }
])

db.escritorios.aggregate([
  {
    $unwind: "$suprimentos"
  },
  {
    $sort: {
      "suprimentos.precoUnitario": -1
    }
  },
  {
    $limit: 1
  },
  {
    $project: {
      _id: 0,
      escritorio: "$nome",
      pais: "$pais",
      produto: "$suprimentos.produto",
      precoUnitario: "$suprimentos.precoUnitario"
    }
  }
])

db.escritorios.aggregate([
  {
    $unwind: "$suprimentos"
  },
  {
    $sort: {
      "suprimentos.precoUnitario": -1
    }
  },
  {
    $limit: 1
  }
])

db.escritorios.aggregate([
  {
    $unwind: "$suprimentos"
  },
  {
    $project: {
      valorItem: {
        $multiply: [
          "$suprimentos.quantidade",
          "$suprimentos.precoUnitario"
        ]
      }
    }
  },
  {
    $group: {
      _id: null,
      valorTotalInventario: {
        $sum: "$valorItem"
      }
    }
  }
])

```

## Exercicio 6

```python
db.vendas.distinct("produto")

db.vendas.aggregate([
  {
    $group: {
      _id: "$produto",
      totalQuantidade: { $sum: "$quantidade" }
    }
  },
  {
    $sort: { totalQuantidade: -1 }
  },
  {
    $limit: 1
  }
])

db.vendas.aggregate([
  {
    $group: {
      _id: "$produto",
      totalQuantidade: { $sum: "$quantidade" }
    }
  },
  {
    $sort: { totalQuantidade: 1 }
  },
  {
    $limit: 1
  }
])

db.vendas.aggregate([
  {
    $project: {
      produto: 1,
      receita: {
        $multiply: ["$quantidade", "$precoUnitario"]
      }
    }
  },
  {
    $group: {
      _id: "$produto",
      totalReceita: { $sum: "$receita" }
    }
  },
  {
    $sort: { totalReceita: -1 }
  },
  {
    $limit: 1
  }
])

db.vendas.find().sort({ precoUnitario: -1 }).limit(1)

db.vendas.aggregate([
  {
    $project: {
      receita: {
        $multiply: ["$quantidade", "$precoUnitario"]
      }
    }
  },
  {
    $group: {
      _id: null,
      faturamentoTotal: { $sum: "$receita" }
    }
  }
])

db.vendas.countDocuments({
  dataVenda: {
    $gte: "2023-06-01",
    $lt: "2023-07-01"
  }
})

db.vendas.aggregate([
  {
    $group: {
      _id: "$vendedor",
      totalVendas: { $sum: 1 }
    }
  },
  {
    $sort: { totalVendas: -1 }
  },
  {
    $limit: 1
  }
])

db.vendas.aggregate([
  {
    $project: {
      vendedor: 1,
      receita: {
        $multiply: ["$quantidade", "$precoUnitario"]
      }
    }
  },
  {
    $group: {
      _id: "$vendedor",
      totalReceita: { $sum: "$receita" }
    }
  },
  {
    $sort: { totalReceita: -1 }
  },
  {
    $limit: 1
  }
])

```

