package com.example.graphexamples

import java.util.Scanner

fun main(args: Array<String>) {
    scanWeightedGraph()
}

//0 2 1
//1 0 1
//1 2 1
//1 4 1
//3 2 1
private fun scanWeightedGraph() {
    val read = Scanner(System.`in`)

    println("Enter a number of vertex")
    val vertexCnt = read.nextInt()

    println("Enter a number of edges")
    val edgesCnt = read.nextInt()

    val adMatrixForUndirectedGraph: Array<IntArray> = Array(vertexCnt) { IntArray(vertexCnt) }
    val adMatrixForDirectedGraph: Array<IntArray> = Array(vertexCnt) { IntArray(vertexCnt) }

    println("Enter the matrix")

    for (i in 1..edgesCnt) {
        val firstVertex = read.nextInt()
        val secondVertex = read.nextInt()
        val weight = read.nextInt()

        //Undirected
        adMatrixForUndirectedGraph[firstVertex][secondVertex] = weight
        adMatrixForUndirectedGraph[secondVertex][firstVertex] = weight

        //Directed
        adMatrixForDirectedGraph[firstVertex][secondVertex] = weight
    }

    println("Matrix for Undirected Graph with Weights")
    printMatrix(adMatrixForUndirectedGraph)

    println("Matrix for Directed Graph with Weights")
    printMatrix(adMatrixForDirectedGraph)
}

private fun printMatrix(adMatrix: Array<IntArray>) {
    for (i in 0 until adMatrix.size) {
        for (j in 0 until adMatrix.size) {
            print(adMatrix[i][j])
        }
        println()
    }
}