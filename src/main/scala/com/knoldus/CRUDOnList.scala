package com.knoldus
import scala.annotation.tailrec

class CRUDOnList[A] extends CRUDOperation[A] {
  var list: List[A] = List[A]()

  override def create(element: A): List[A] = {
    list = element :: list
    list
  }

  def read(dataToFind: A): Int = {
    @tailrec
    def readHelper(dataToFind: A, index: Int): Int = {
      if (index == list.size - 1 && dataToFind != list(index))
        throw new IndexOutOfBoundsException("data not found in list!!") // handled in test class
      else if (dataToFind == list(index)) index
      else readHelper(dataToFind, index + 1)
    }

    readHelper(dataToFind, 0)
  }

  def update(indexToUpdate: Int, dataToAdd: A): List[A] = {
    if (indexToUpdate >= list.size)
      throw new IndexOutOfBoundsException("Invalid index provide!!") // handled in test class
    else {
      list.zipWithIndex.map {
        case (element, index) => if (index == indexToUpdate) dataToAdd else element
      }
    }
  }

  def delete(dataToDelete: A): List[A] = {
    if (list.contains(dataToDelete)) {
      list = list.filterNot(_ == dataToDelete)
      list
    } else throw new NoSuchElementException("Data not present in the List!")

  }
}

