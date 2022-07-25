package shift2dgrid;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Shift2DGridSolutionLeticia {
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
