package com.zedd2dev.scala.commands
import com.zedd2dev.java.TextEditor
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 16.04.19.
  */
class Javpad extends Command {
  override def apply(state: State): State =
    state.setMessage("javapad v.0.1")
    TextEditor.createNewWindow()
}
