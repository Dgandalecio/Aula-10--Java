package com.mycompany.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    // Método para adicionar um nó na árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private No adicionarRecursivo(No raiz, int valor) {
        if (raiz == null) {
            return new No(valor);
        }

        if (valor < raiz.valor) {
            raiz.esquerda = adicionarRecursivo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = adicionarRecursivo(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para realizar o algoritmo DSW para balancear a árvore
    public void balancear() {
        raiz = balancear(raiz);
    }

    private No balancear(No raiz) {
        if (raiz == null) {
            return null;
        }

        // Primeiro, transformamos a árvore em uma lista de nós.
        List<No> lista = new ArrayList<>();
        inorder(raiz, lista);

        // Depois, usamos o algoritmo DSW para balancear a árvore
        return construirArvoreBalanceada(lista, 0, lista.size() - 1);
    }

    private void inorder(No raiz, List<No> lista) {
        if (raiz != null) {
            inorder(raiz.esquerda, lista);
            lista.add(raiz);
            inorder(raiz.direita, lista);
        }
    }

    private No construirArvoreBalanceada(List<No> lista, int inicio, int fim) {
        if (inicio > fim) {
            return null;
        }

        int meio = (inicio + fim) / 2;
        No raiz = lista.get(meio);
        raiz.esquerda = construirArvoreBalanceada(lista, inicio, meio - 1);
        raiz.direita = construirArvoreBalanceada(lista, meio + 1, fim);
        return raiz;
    }

    // Método para gerar números aleatórios e adicionar na árvore
    public void gerarNumerosAleatorios(int quantidade) {
        Random rand = new Random();
        for (int i = 0; i < quantidade; i++) {
            adicionar(rand.nextInt(101));
        }
    }

    // Método para imprimir a árvore em ordem
    public void imprimirEmOrdem() {
        imprimirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void imprimirEmOrdemRecursivo(No raiz) {
        if (raiz != null) {
            imprimirEmOrdemRecursivo(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            imprimirEmOrdemRecursivo(raiz.direita);
        }
    }
}
