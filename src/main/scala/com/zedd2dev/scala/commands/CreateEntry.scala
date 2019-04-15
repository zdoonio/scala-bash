package com.zedd2dev.scala.commands

import com.zedd2dev.scala.files.{DirEntry, Directory}
import com.zedd2dev.scala.filesystem.State

/**
  * Created by Dominik Zduńczyk on 15.04.19.
  */
abstract class CreateEntry(name: String) extends Command {


  override def apply(state: State): State = {
    val wd = state.wd
    if(wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")

    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " must not contain separators")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name!")
    } else {
      doCreateEntry(state, name)
    }
  }


  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doCreateEntry(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory = {
      if (path.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        val oldEntry = currentDirectory.findEntry(path.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, path.tail, newEntry))
      }

    }

    val wd = state.wd

    // 1. all the directories in the full path
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. create new directory entry in the wd
    // TODO implement this
    val newEntry: DirEntry = createSpecificEntry(state)

    // 3. update the whole directory structure starting from the root
    // (the directory structure is IMMUTABLE
    val newRoot = updateStructure(state.root, allDirsInPath, newEntry)

    // 4. find new working directroy INSTANCE fiven wd's full path, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)

  }

  def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
