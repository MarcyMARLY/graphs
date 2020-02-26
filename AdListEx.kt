package com.example.graphexamples

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Scanner

@RequiresApi(Build.VERSION_CODES.N)
fun main(args: Array<String>) {
    scanDirectedUnweightedGraph()
}

//0 2
//1 0
//1 2
//1 4
//3 2
@RequiresApi(Build.VERSION_CODES.N)
private fun scanDirectedUnweightedGraph() {
    val read = Scanner(System.`in`)

    println("Enter a number of edges")
    val edgesCnt = read.nextInt()

    val adList: HashMap<Int, MutableList<Int>> = hashMapOf()

    println("Enter the matrix")

    for (i in 1..edgesCnt) {
        val firstVertex = read.nextInt()
        val secondVertex = read.nextInt()

        val vertexList: MutableList<Int> = adList.getOrDefault(firstVertex, mutableListOf())
        vertexList.add(secondVertex)

        adList[firstVertex] = vertexList
    }

    for ((i, j ) in adList) {
        println("$i: $j")
    }
}