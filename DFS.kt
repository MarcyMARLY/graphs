package com.example.graphexamples

import java.util.Scanner

val colors: MutableList<Color> = mutableListOf()

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)

    println("Enter a number of vertex")
    val vertexCnt = read.nextInt()

    println("Enter a number of edges")
    val edgesCnt = read.nextInt()

    (0 until vertexCnt).forEach { adjList.add(mutableListOf()) }
    (0 until vertexCnt).forEach { colors.add(Color.WHITE) }

    for (i in 1..edgesCnt) {
        val firstVertex = read.nextInt()
        val secondVertex = read.nextInt()

        adjList[firstVertex].add(secondVertex)
        adjList[secondVertex].add(firstVertex)
    }

    var numComponents = 0
    (0 until vertexCnt).forEach {
        if (colors[it] == Color.WHITE) {
            println("Component ${++numComponents}")
            dfs(it)
            println()
        }
    }
    println("There are $numComponents connected components")
}

private fun dfs(u: Int) {
    colors[u] = Color.BLACK
    println(u)

    adjList[u].forEach {
        if (colors[it] == Color.WHITE) {
            dfs(it)
        }
    }
}