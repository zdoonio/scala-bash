package com.zedd2dev.scala.filesystem

import java.util.Scanner

import com.zedd2dev.scala.commands.Command
import com.zedd2dev.scala.files.Directory

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
object Filesystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }

  //  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
  //    currentState.show
  //    Command.from(newLine).apply(currentState)
  //  })


}
