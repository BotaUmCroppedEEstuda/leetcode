# 1260. Shift 2D Grid

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

- Element at grid[i][j] moves to grid[i][j + 1].
- Element at grid[i][n - 1] moves to grid[i + 1][0].
- Element at grid[m - 1][n - 1] moves to grid[0][0].
- Return the 2D grid after applying shift operation k times.

### Example 1:
- Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
- Output: [[9,1,2],[3,4,5],[6,7,8]]

### Example 2:
- Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
- Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

### Example 3:
- Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
- Output: [[1,2,3],[4,5,6],[7,8,9]]


### Constraints:

- m == grid.length
- n == grid[i].length
- 1 <= m <= 50
- 1 <= n <= 50
- -1000 <= grid[i][j] <= 1000
- 0 <= k <= 100

## resposta leticia
```bash
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> response = new ArrayList<>();

        if (grid.length == 0) {
            return response;
        }
        Deque<Integer> lista = new LinkedList<>();

        for (int [] linha : grid) {
            for (int elemento : linha) {
                lista.add(elemento);
            }
        }

        while (k != 0) {
            if (k > 0) {
                Integer elemento = lista.getLast();
                lista.addFirst(elemento);
                lista.removeLast();
                k--;
            } else {
                Integer elemento = lista.getFirst();
                lista.addLast(elemento);
                lista.removeFirst();
                k++;
            }
        }

        List<Integer> listaResposta = new ArrayList<>();
        listaResposta.addAll(lista);

        int tamanhoInicialLista = 0;
        int quantidadeItensLinha = grid[0].length;
        int tamanhoFinalLista = quantidadeItensLinha;

        while (tamanhoFinalLista <= grid.length * quantidadeItensLinha) {
            response.add(listaResposta.subList(tamanhoInicialLista, tamanhoFinalLista));
            tamanhoInicialLista = tamanhoFinalLista;
            tamanhoFinalLista = tamanhoFinalLista + quantidadeItensLinha;
        }
        
        return response;
    }
}
```

## resposta karen
```bash
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
   
    List<List<Integer>> newGrid = new ArrayList<>();

    Deque<Integer> auxQueue = new LinkedList<>();
    for (int[] line : grid) {
      for (int element : line) {
        auxQueue.add(element);
      }
    }
    while (k != 0) {
      if (k < 0) {
        auxQueue.addLast(auxQueue.pollFirst());
        k++;
      } else {
        auxQueue.addFirst(auxQueue.pollLast());
        k--;
      }
    }
    for (int line = 0; line < grid.length; line++) {
      List<Integer> returnLines = new ArrayList<>();
      for (int column = 0; column < grid[line].length; column++) {
        returnLines.add(auxQueue.pollFirst());
      }
      newGrid.add(returnLines);
    }
    return newGrid;
}}
```
