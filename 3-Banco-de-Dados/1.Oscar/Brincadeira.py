import pandas as pd

## Estava brincando com pandas, então fiz uma parte da atividade nele, o ideal era usar.ipynb, mas como não tinha instalado, fiz no .py mesmo.

df_oscar = pd.read_json(r"C:\Users\Herick\Desktop\Oscar-Proa\OSCAR.json")


# 1.1 Quantos registros existem na coleção de indicados ao Oscar?

# respsota = print(df_oscar.shape)


# 1.2 Quais são as diferentes categorias de premiação que existem no banco de dados? Liste todas as categorias únicas.

df_oscar_categorias = df_oscar[['categoria']].value_counts()

# resposta = print(df_oscar_categorias.count())

# 1.3 Qual foi o primeiro ano de cerimônia do Oscar registrado na base?

df_oscar_ano_filmagem = df_oscar["ano_filmagem"]

# resposta = print(df_oscar_ano_filmagem.head(1))

# 1.4 Qual foi o último ano de cerimônia registrado na base?

# resposta = print(df_oscar_ano_filmagem.tail(1))

# 1.5 Quantas cerimônias do Oscar estão registradas no total?

cerimonia = df_oscar['ano_filmagem'].value_counts()

# resposta = print(cerimonia.count())


# 1.6 Atualize os registros da coleção com os dados do Oscar 2025 e 2026 (pesquise os vencedores e adicione-os). ahhhh meow

# Nível 2: Explorando Categorias

# 2.1 Quantas indicações existem para cada categoria? Agrupe por categoria e ordene da mais frequente para a menos frequente.

df_cat = df_oscar['categoria']

# resposta = print(df_cat.value_counts())

# 2.2 Qual categoria teve mais indicações ao longo da história do Oscar?

# resposta = print(df_cat.value_counts().head(1))

# 2.3 Qual categoria teve menos indicações ao longo da história?

# resposta = print(df_cat.value_counts().tail(4))

# 2.4 A partir de que ano a categoria "ACTRESS" deixou de existir? (Dica: procure a última cerimônia com essa categoria)

# resposta = print(df_oscar.loc[df_oscar['categoria'] == "ACTRESS"].head(1))

#--

# 2.5 Quais categorias existiam na primeira cerimônia (1928) e não existem mais hoje?

# 2.6 Liste todas as categorias que contêm a palavra "DIRECTING" no nome.
