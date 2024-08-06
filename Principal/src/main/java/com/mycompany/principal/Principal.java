/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.principal;

import java.util.Random;

/**
 *
 * @author diogo
 */
public class Principal {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Adicionando 100 números aleatórios
        arvore.gerarNumerosAleatorios(100);
        System.out.println("Árvore após adicionar 100 números aleatórios:");
        arvore.imprimirEmOrdem();

        // Balancear a árvore usando o algoritmo DSW
        arvore.balancear();
        System.out.println("Árvore balanceada após o primeiro balanceamento:");
        arvore.imprimirEmOrdem();

        // Adicionando 20 novos números aleatórios
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            arvore.adicionar(rand.nextInt(101));
        }
        System.out.println("Árvore após adicionar 20 novos números:");
        arvore.imprimirEmOrdem();

        // Balancear novamente após inserções
        arvore.balancear();
        System.out.println("Árvore balanceada após o segundo balanceamento:");
        arvore.imprimirEmOrdem();
    }
}

