package com.zedd2dev.scala.files

import java.nio.file.FileSystemException

/**
  * Created by Dominik Zduńczyk on 15.04.19.
  */
class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory =
    throw new FileSystemException("A file cannot be converted to a directory")

  def asFile: File = this

  def isDirectory: Boolean = false

  def isFile: Boolean = true

  override def getType: String = "File"
}

object File {

  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}
