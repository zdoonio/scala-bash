package com.zedd2dev.scala.commands
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 15.04.19.
  */
class Cat(filename: String) extends Command {
  override def apply(state: State): State = {
    val wd = state.wd

    val dirEntry = wd.findEntry(filename)
    if (dirEntry == null || !dirEntry.isFile)
        state.setMessage(filename + ": no such file")
    else
      state.setMessage(dirEntry.asFile.contents)
  }
}
