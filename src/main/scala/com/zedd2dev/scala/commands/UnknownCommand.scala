package com.zedd2dev.scala.commands
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found!")
}
