package com.zedd2dev.scala.commands
import com.zedd2dev.scala.files.{DirEntry, File}
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 15.04.19.
  */
class Touch(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)
}
