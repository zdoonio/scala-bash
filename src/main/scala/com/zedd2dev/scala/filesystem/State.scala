package com.zedd2dev.scala.filesystem

import com.zedd2dev.scala.files.Directory

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
class State(val root: Directory, val wd: Directory, val output: String) {

  def show: Unit =
    print("\n" + State.SHELL_TOKEN + " ")
    print(output)


  def setMessage(message: String): State =
    State(root, wd, message)

}

object State {
  val SHELL_TOKEN = "$"

  def apply(root: Directory, wd: Directory, output: String = ""): State =
    new State(root, wd, output)

}