"# dijkstra-in-java" 

# Aqui um resumo de todas as possibilidades de manipulação de array com retornos diferentes com um mesmo grafo

Grafo de teste
int[][] grafo1 = { { 0, 1, 4, 0, 0, 0, 0, 0 },   
                   { 1, 0, 2, 9, 0, 0, 0, 2 },  
                   { 4, 2, 0, 1, 3, 0, 0, 0 },  
                   { 0, 9, 1, 0, 1, 3, 1, 0 },  
                   { 0, 0, 3, 1, 0, 1, 0, 0 },  
                   { 0, 0, 0, 3, 1, 0, 6, 0 },  
                   { 0, 0, 0, 1, 0, 6, 0, 14 },  
                   { 0, 2, 0, 0, 0, 0, 14, 0 } };
		 
---
    
### Situação de melhor caminho entre 2 pontos, com um array onde você escolhe as nomeclaturas dos pontos

```
ResultadoDijkstra vertices = new Dijkstra(grafo1, "S", "T", "U", "V", "W", "X", "Y", "Z").melhorCaminho("X", "S");
System.out.println(vertices);
```

Obs: *Neste caso você tambem poderia passar as nomeclaturas por uma variavel de array*
```
String[] nomesGrafo1 = {"S", "T", "U", "V", "W", "X", "Y", "Z"};
ResultadoDijkstra vertices = new Dijkstra(grafo1, nomesGrafo1).melhorCaminho("X", "S");
System.out.println(vertices);
```

Resultado no console com base no método toString();

Da vertice X ao S o caminho de menor custo foi: [X, W, V, U, T, S] com custo 6

---

### Situação de melhor caminho onde não exista um ponto final **sem nomeclatura** das vertices (retorna todas as vertices e os pontos de cada)

OBS: *Você pode deixar de passar as nomeclaturas do seu algoritmo, quando fizer isso, elas ficaram ordenada da esquerda pra direita com numeros de 0 a n*.

```
List<Vertice> vertices2 = new Dijkstra(grafo1, "0").getVertices();
for (int i = 0; i < vertices2.size(); i++) {
    System.out.println(i + vertices2.get(i).toString());
}
```

Resultado no console com base no método toString();  
Onde ele retorna o indice da vertice, nome(nomeclatura), o indice da vertice que fez a conexão com o vertice atual, e o custo até o local.

0		 nome: 0 		 pai: 0		 custo: 0  
1		 nome: 1 		 pai: 0		 custo: 1  
2		 nome: 2 		 pai: 1		 custo: 3  
3		 nome: 3 		 pai: 2		 custo: 4  
4		 nome: 4 		 pai: 3		 custo: 5  
5		 nome: 5 		 pai: 4		 custo: 6  
6		 nome: 6 		 pai: 3		 custo: 5  
7		 nome: 7 		 pai: 1		 custo: 3

---

### Situação de melhor caminho onde não exista um ponto final **com nomeclatura** das vertice (retorna todas as vertices e os pontos de cada)

```
List<Vertice> vertices3 = new Dijkstra(grafo1, "S", "T", "U", "V", "W", "X", "Y", "Z").calcule("S").getVertices();
for (int i = 0; i < vertices3.size(); i++) {
    System.out.println(i + vertices3.get(i).toString());
}
```

Obs: *Neste caso você tambem poderia passar as nomeclaturas por uma variavel de array*
```
String[] nomesGrafo1 = {"S", "T", "U", "V", "W", "X", "Y", "Z"};
ResultadoDijkstra vertices = new Dijkstra(grafo1, nomesGrafo1).melhorCaminho("X", "S");
System.out.println(vertices);
```

Resultado no console com base no método toString();  
Onde ele retorna o indice da vertice, nome(nomeclatura), o indice da vertice que fez a conexão com o vertice atual, e o custo até o local.

0		 nome: S 		 pai: 0		 custo: 0  
1		 nome: T 		 pai: 0		 custo: 1  
2		 nome: U 		 pai: 1		 custo: 3  
3		 nome: V 		 pai: 2		 custo: 4  
4		 nome: W 		 pai: 3		 custo: 5  
5		 nome: X 		 pai: 4		 custo: 6  
6		 nome: Y 		 pai: 3		 custo: 5  
7		 nome: Z 		 pai: 1		 custo: 3
