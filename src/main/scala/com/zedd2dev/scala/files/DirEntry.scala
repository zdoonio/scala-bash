package com.zedd2dev.scala.files

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = {
    val separatorIfNessesary =
      if (Directory.ROOT_PATH.equals(parentPath)) ""
      else Directory.SEPARATOR

    parentPath + separatorIfNessesary + name
  }

  def asDirectory: Directory

  def asFile: File

  def isDirectory: Boolean

  def isFile: Boolean

  def getType: String
}
