package com.zedd2dev.scala.commands
import com.zedd2dev.scala.files.DirEntry
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 14.04.19.
  */
class Ls extends Command {
  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOutput = createNiceOutput(contents)
    state.setMessage(niceOutput)
  }

  def createNiceOutput(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      "\n" + entry.name + "[" + entry.getType + "]" + createNiceOutput(contents.tail)

    }

  }

}
