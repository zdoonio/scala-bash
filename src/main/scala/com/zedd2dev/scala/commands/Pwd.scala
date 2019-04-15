package com.zedd2dev.scala.commands
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 15.04.19.
  */
class Pwd extends Command {
  override def apply(state: State): State =
    state.setMessage(state.wd.path)
}
