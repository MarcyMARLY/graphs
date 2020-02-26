package com.example.graphexamples

import java.util.*

enum class Color {
    WHITE,
    BLACK
}

data class Node(var color: Color, var distance: Int = Int.MAX_VALUE, var parent: Int = -1)

val adjList: MutableList<MutableList<Int>> = mutableListOf()
val nodes: MutableList<Node> = mutableListOf()

//9
//8
//0 1
//0 2
//1 4
//1 3
//2 5
//2 6
//6 8
//6 7
fun main(args: Array<String>) {
    val read = Scanner(System.`in`)

    println("Enter a number of vertex")
    val vertexCnt = read.nextInt()

    println("Enter a number of edges")
    val edgesCnt = read.nextInt()

    (0 until vertexCnt).forEach { adjList.add(mutableListOf()) }
    (0 until vertexCnt).forEach { nodes.add(Node(Color.WHITE)) }

    for (i in 1..edgesCnt) {
        val firstVertex = read.nextInt()
        val secondVertex = read.nextInt()

        adjList[firstVertex].add(secondVertex)
        adjList[secondVertex].add(firstVertex)
    }

    bfs(0)
}

private fun bfs(u: Int) {
    val queue: Queue<Int> = ArrayDeque<Int>()
    nodes[u].distance = 0
    queue.add(u)

    while (!queue.isEmpty()) {
        val current = queue.peek()
        queue.remove()
        println(current)

        if (nodes[current].color == Color.WHITE) {
            nodes[current].color = Color.BLACK
            adjList[current].forEach {
                if (nodes[it].distance == Int.MAX_VALUE) {
                    nodes[it].distance = nodes[current].distance + 1
//                    nodes[it].parent = it
                    queue.add(it)
                }
            }
        }
    }
}