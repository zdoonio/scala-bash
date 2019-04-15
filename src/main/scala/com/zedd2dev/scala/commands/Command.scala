package com.zedd2dev.scala.commands

import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
trait Command {

  def apply(state: State): State
}


object Command {

  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(name + " incomplete command")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")

    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else if (MKDIR.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Mkdir(tokens(1))
    } else if(LS.equals(tokens(0))) {
      new Ls
    } else if(PWD.equals(tokens(0))) {
      new Pwd
    } else if(TOUCH.equals(tokens(0))) {
      if (tokens.length < 2) incompleteCommand(MKDIR)
      else new Touch(tokens(1))
    }
    else
      new UnknownCommand
  }

}