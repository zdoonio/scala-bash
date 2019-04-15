package com.zedd2dev.scala.commands

import com.zedd2dev.scala.files.{DirEntry, Directory}
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 14.04.19.
  */
class Mkdir(name: String) extends CreateEntry(name) {
  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)

}
