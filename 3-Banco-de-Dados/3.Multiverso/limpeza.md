# Multiverso

## Atividade de MongoDB 

### Link da atividade

<a href="https://github.com/gabaugusto/sample-databases/tree/main/Documentos/7_MULTIVERSO" target="_blank">Repositorio da Atividade</a>




## Etapa 1

```python

db.personagens.aggregate([

  {
    $addFields: {
      name: {
        $trim: {
          input: {
            $ifNull: [
              "$name",
              { $ifNull: ["$Name", { $ifNull: ["$char_name", "$nome"] }] }
            ]
          }
        }
      },

      universe: {
        $trim: {
          input: {
            $toLower: {
              $ifNull: ["$universe", "$Universe"]
            }
          }
        }
      },

      powerLevel: {
        $toInt: {
          $cond: [
            { $and: [{ $ne: ["$powerLevel", null] }, { $ne: ["$powerLevel", "N/A"] }] },
            "$powerLevel",
            {
              $cond: [
                { $ne: ["$power_level", null] },
                "$power_level",
                0
              ]
            }
          ]
        }
      },

      species: {
        $trim: {
          input: { $toLower: "$species" }
        }
      },

      debut_year: {
        $toInt: {
          $cond: [
            { $ne: ["$debut_year", null] },
            "$debut_year",
            0
          ]
        }
      },

      equipment: {
        $cond: [
          { $isArray: "$equipment" },
          "$equipment",
          {
            $split: ["$equipment", ", "]
          }
        ]
      },

      movies: {
        $cond: [
          { $isArray: "$movies" },
          "$movies",
          {
            $cond: [
              { $ne: ["$movies", null] },
              { $split: ["$movies", ", "] },
              []
            ]
          }
        ]
      }
    }
  },

  {
    $addFields: {
      name: {
        $concat: [
          { $toUpper: { $substr: ["$name", 0, 1] } },
          { $substr: ["$name", 1, { $strLenCP: "$name" }] }
        ]
      }
    }
  },

  {
    $addFields: {
      universe: {
        $switch: {
          branches: [
            { case: { $regexMatch: { input: "$universe", regex: /marvel/ } }, then: "Marvel" },
            { case: { $regexMatch: { input: "$universe", regex: /dc/ } }, then: "DC" },
            { case: { $regexMatch: { input: "$universe", regex: /star/ } }, then: "Star Wars" }
          ],
          default: { $toUpper: "$universe" }
        }
      }
    }
  },

  {
    $group: {
      _id: "$name",
      doc: { $first: "$$ROOT" }
    }
  },

  {
    $replaceRoot: { newRoot: "$doc" }
  },

  {
    $out: "nerd_universe_clean"
  }

])



```

## Etapa 2

```python

db.nerd_universe_clean.aggregate([
  {
    $project: {
      name: 1,
      universe: 1,
      species: 1,
      powerLevel: 1,
      debut_year: 1
    }
  },
  {
    $out: "characters"
  }
])
``


```

### Universes

```python
db.nerd_universe_clean.aggregate([
  {
    $group: {
      _id: "$universe"
    }
  },
  {
    $project: {
      name: "$_id",
      type: "unknown",
      origin: "unknown"
    }
  },
  {
    $out: "universes"
  }
])


```


## species

```python

db.nerd_universe_clean.aggregate([
  {
    $group: {
      _id: "$species"
    }
  },
  {
    $project: {
      name: "$_id",
      descricao: "unknown"
    }
  },
  {
    $out: "species"
  }
])


```

## equipment

```python

db.nerd_universe_clean.aggregate([
  {
    $unwind: "$equipment"
  },
  {
    $group: {
      _id: "$equipment"
    }
  },
  {
    $project: {
      name: "$_id"
    }
  },
  {
    $out: "equipment"
  }
])
``


```

## movies

```python

db.nerd_universe_clean.aggregate([
  {
    $unwind: "$movies"
  },
  {
    $group: {
      _id: "$movies"
    }
  },
  {
    $project: {
      title: "$_id"
    }
  },
  {
    $out: "movies"
  }
])

```

## Relacioanmentos com o procv do mongo

```python


db.characters.aggregate([
  {
    $lookup: {
      from: "universes",
      localField: "universe",
      foreignField: "name",
      as: "universe_info"
    }
  }
])



```


