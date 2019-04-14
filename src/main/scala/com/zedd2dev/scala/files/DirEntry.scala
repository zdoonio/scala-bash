package com.zedd2dev.scala.files

/**
  * Created by Dominik Zduńczyk on 12.04.19.
  */
abstract class DirEntry(val parentPath: String, val name: String) {

  def path: String = parentPath + Directory.SEPARATOR + name

  def asDirectory: Directory

  def getType: String
}
