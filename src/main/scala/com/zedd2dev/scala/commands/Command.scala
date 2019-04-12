package com.zedd2dev.scala.commands

import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
trait Command {

  def apply(state: State): State
}


object Command {

  def from(input: String): Command =
    new UnknownCommand

}